package com.classicmodels.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import javax.management.Query;
import jooq.generated.Keys;
import static jooq.generated.tables.Customer.CUSTOMER;
import static jooq.generated.tables.Department.DEPARTMENT;
import static jooq.generated.tables.Office.OFFICE;
import static jooq.generated.tables.Order.ORDER;
import static jooq.generated.tables.Payment.PAYMENT;
import static jooq.generated.tables.Product.PRODUCT;
import static jooq.generated.tables.Sale.SALE;
import jooq.generated.tables.records.PaymentRecord;
import org.flywaydb.core.internal.database.base.Table;
import org.jooq.DSLContext;
import org.jooq.Query;
import org.jooq.Table;
import static org.jooq.impl.DSL.selectFrom;
import static org.jooq.impl.DSL.val;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ClassicModelsRepository {

    private final DSLContext ctx;

    public ClassicModelsRepository(DSLContext ctx) {
        this.ctx = ctx;
    }

    // EXAMPLE 1
    /*
    merge into [classicmodels].[dbo].[payment] using (
      select
        1 [one]
      ) t on (
      (
        [classicmodels].[dbo].[payment].[customer_number] = ?
          and [classicmodels].[dbo].[payment].[check_number] = ?
      )
        or [classicmodels].[dbo].[payment].[check_number] = ?
    )
    when not matched then
    insert
     (
       [customer_number], [check_number], [payment_date], [invoice_amount], [caching_date]
     )
     values
       (?, ?, ?, ?, ?);
     */
    public void insertPaymentOnDuplicateKeyIgnore() {

        System.out.println("EXAMPLE 1 (affected rows): "
                + ctx.insertInto(PAYMENT)
                        .values(103L, "HQ336336",
                                LocalDateTime.of(2005, 11, 9, 12, 10, 11), 123.32,
                                LocalDateTime.of(2005, 11, 11, 14, 25, 21))
                        .onDuplicateKeyIgnore()
                        .execute()
        );
    }

    // EXAMPLE 2
    /*
    merge into [classicmodels].[dbo].[payment] using (
      select
        1 [one]
      ) t on (
      (
        [classicmodels].[dbo].[payment].[customer_number] = ?
          and [classicmodels].[dbo].[payment].[check_number] = ?
      )
      or [classicmodels].[dbo].[payment].[check_number] = ?
    )
    when not matched then
    insert
      (
        [customer_number], [check_number], [payment_date], [invoice_amount], [caching_date]
      )
    values
        (?, ?, ?, ?, ?);
     */
    public void insertPaymentOnConflictDoNothing() {

        System.out.println("EXAMPLE 2 (affected rows): "
                + ctx.insertInto(PAYMENT)
                        .values(103L, "HQ336336",
                                LocalDateTime.of(2005, 11, 9, 12, 10, 11), 123.32,
                                LocalDateTime.of(2005, 11, 11, 14, 25, 21))
                        .onConflictDoNothing()
                        .execute()
        );
    }

    // EXAMPLE 3
    /*
    merge into [classicmodels].[dbo].[payment] using (
      select
        1 [one]
    ) t on [classicmodels].[dbo].[payment].[check_number] = ?
    when not matched then
    insert
     (
       [customer_number], [check_number], [payment_date], [invoice_amount], [caching_date]
     )
    values
       (?, ?, ?, ?, ?);
     */
    public void insertPaymentOnDuplicateCheckNumberDoNothing() {

        System.out.println("EXAMPLE 3 (affected rows): "
                + ctx.insertInto(PAYMENT)
                        .values(100L, "HQ336336",
                                LocalDateTime.of(2005, 11, 9, 12, 10, 11), 123.32,
                                LocalDateTime.of(2005, 11, 11, 14, 25, 21))
                        .onConflict(PAYMENT.CHECK_NUMBER)
                        .doNothing()
                        .execute()
        );
    }

    // EXAMPLE 4
    /*
    merge into [classicmodels].[dbo].[payment] using (
    select
      1 [one]
    ) t on [classicmodels].[dbo].[payment].[check_number] = ?
    when not matched then
    insert
     (
       [customer_number], [check_number], [payment_date], [invoice_amount], [caching_date]
     )
    values
       (?, ?, ?, ?, ?);
     */
    public void insertPaymentOnConflictOnConstraintDoNothing() {

        System.out.println("EXAMPLE 4 (affected rows): "
                + ctx.insertInto(PAYMENT)
                        .values(103L, "HQ336336",
                                LocalDateTime.of(2005, 11, 9, 12, 10, 11), 123.32,
                                LocalDateTime.of(2005, 11, 11, 14, 25, 21))
                        .onConflictOnConstraint(Keys.PAYMENT__UNIQUE_CHECK_NUMBER)
                        .doNothing()
                        .execute()
        );
    }

    // EXAMPLE 5
    /*
    merge into [classicmodels].[dbo].[payment] using (
    select
      1 [one]
    ) t on (
      (
        [classicmodels].[dbo].[payment].[customer_number] = ?
          and [classicmodels].[dbo].[payment].[check_number] = ?
      )
    or [classicmodels].[dbo].[payment].[check_number] = ?
    )
    when matched then
    update
    set
     [classicmodels].[dbo].[payment].[invoice_amount] = ?,
     [classicmodels].[dbo].[payment].[caching_date] = ?
    when not matched then
    insert
     (
       [customer_number], [check_number], [payment_date], [invoice_amount], [caching_date]
     )
    values
       (?, ?, ?, ?, ?);
     */
    public void insertPaymentOnDuplicateKeyUpdateIt() {

        System.out.println("EXAMPLE 5.1 (affected rows): "
                + ctx.insertInto(PAYMENT)
                        .values(103L, "HQ336336",
                                LocalDateTime.of(2005, 11, 9, 12, 10, 11), 123.32,
                                LocalDateTime.of(2005, 11, 11, 14, 25, 21))
                        .onDuplicateKeyUpdate()
                        .set(PAYMENT.INVOICE_AMOUNT, BigDecimal.valueOf(123.32))
                        .set(PAYMENT.CACHING_DATE, LocalDateTime.now())
                        .execute()
        );

        System.out.println("EXAMPLE 5.2 (affected rows): "
                + ctx.insertInto(PAYMENT)
                        .set(PAYMENT.CUSTOMER_NUMBER, 103L)
                        .set(PAYMENT.CHECK_NUMBER, "HQ336336")
                        .set(PAYMENT.PAYMENT_DATE, LocalDateTime.of(2005, 11, 9, 12, 10, 11))
                        .set(PAYMENT.INVOICE_AMOUNT, BigDecimal.valueOf(123.32))
                        .set(PAYMENT.CACHING_DATE, LocalDateTime.of(2005, 11, 11, 14, 25, 21))
                        .onDuplicateKeyUpdate()
                        .set(PAYMENT.INVOICE_AMOUNT, BigDecimal.valueOf(123.32))
                        .set(PAYMENT.CACHING_DATE, LocalDateTime.now())
                        .execute()
        );

        // check this: https://github.com/jOOQ/jOOQ/issues/1818
        /*
        SET IDENTITY_INSERT [order] ON
        
        merge into [classicmodels].[dbo].[order] using (
        select
          1 [one]
        ) t on [classicmodels].[dbo].[order].[order_id] = 10101
        when matched then
        update
        set
          [classicmodels].[dbo].[order].[order_date] = cast('2003-02-12' as date),
          [classicmodels].[dbo].[order].[required_date] = cast('2003-03-01' as date),
          [classicmodels].[dbo].[order].[shipped_date] = cast('2003-02-27' as date),
          [classicmodels].[dbo].[order].[status] = 'Shipped'
        when not matched then
        insert
          (
            [order_id], [order_date], [required_date], [shipped_date], [status], [comments], [customer_number]
          ) 
        values
          (
            10101, cast('2003-02-12' as date), cast('2003-03-01' as date), cast('2003-02-27' as date),
            'Shipped', 'New order inserted ...', 363
          );
        
        SET IDENTITY_INSERT [order] OFF
         */
        Query q1 = ctx.query("SET IDENTITY_INSERT [order] ON");
        Query q2 = ctx.insertInto(ORDER)
                .values(10101L, LocalDate.of(2003, 2, 12), LocalDate.of(2003, 3, 1),
                        LocalDate.of(2003, 2, 27), "Shipped", "New order inserted ...", 363L)
                .onDuplicateKeyUpdate()
                .set(ORDER.ORDER_DATE, LocalDate.of(2003, 2, 12))
                .set(ORDER.REQUIRED_DATE, LocalDate.of(2003, 3, 1))
                .set(ORDER.SHIPPED_DATE, LocalDate.of(2003, 2, 27))
                .set(ORDER.STATUS, "Shipped");
        Query q3 = ctx.query("SET IDENTITY_INSERT [order] OFF");

        System.out.println("EXAMPLE 5.3 (affected rows): "
                + Arrays.toString(
                        ctx.batch(q1, q2, q3).execute()
                )
        );
    }

    // EXAMPLE 6
    /*
    merge into [classicmodels].[dbo].[payment] using (
    select
      1 [one]
    ) t on [classicmodels].[dbo].[payment].[check_number] = ?
    when matched then
    update
    set
      [classicmodels].[dbo].[payment].[invoice_amount] = ?,
      [classicmodels].[dbo].[payment].[caching_date] = ?
    when not matched then
    insert
      (
        [customer_number],[check_number],[payment_date],[invoice_amount],[caching_date]
      )
    values
        (?, ?, ?, ?, ?);
     */
    public void insertPaymentOnConflictUpdateIt() {

        System.out.println("EXAMPLE 6 (affected rows): "
                + ctx.insertInto(PAYMENT)
                        .values(103L, "HQ336336",
                                LocalDateTime.of(2005, 11, 9, 12, 10, 11), 123.32,
                                LocalDateTime.of(2005, 11, 11, 14, 25, 21))
                        .onConflict(PAYMENT.CHECK_NUMBER)
                        .doUpdate()
                        .set(PAYMENT.INVOICE_AMOUNT, BigDecimal.ZERO)
                        .setNull(PAYMENT.CACHING_DATE)
                        .execute()
        );
    }

    // EXAMPLE 7
    /*
    merge into [classicmodels].[dbo].[payment] using (
    select
       1 [one]
    ) t on (
       (
         [classicmodels].[dbo].[payment].[customer_number] = ?
         and [classicmodels].[dbo].[payment].[check_number] = ?
       )
    or [classicmodels].[dbo].[payment].[check_number] = ?
    )
    when matched then
    update
    set
      [classicmodels].[dbo].[payment].[customer_number] = ?,
      [classicmodels].[dbo].[payment].[check_number] = ?,
      [classicmodels].[dbo].[payment].[payment_date] = ?,
      [classicmodels].[dbo].[payment].[invoice_amount] = ?,
      [classicmodels].[dbo].[payment].[caching_date] = ?
    when not matched then
    insert
      (
         [customer_number],[check_number],[payment_date],[invoice_amount],[caching_date]
      )
    values
      (?, ?, ?, ?, ?);
     */
    public void insertPaymentRecordOnDuplicateKeyUpdateIt() {

        PaymentRecord pr = new PaymentRecord(103L, "HQ336336",
                LocalDateTime.of(2005, 11, 9, 12, 10, 11), BigDecimal.valueOf(123.32),
                LocalDateTime.of(2005, 11, 11, 14, 25, 21));

        System.out.println("EXAMPLE 7 (affected rows): "
                + ctx.insertInto(PAYMENT)
                        .set(pr) // or, values(pr)                
                        .onDuplicateKeyUpdate()
                        .set(pr)
                        .execute()
        );
    }

    // EXAMPLE 8
    /*
    merge into [classicmodels].[dbo].[payment] using (
    select
      1 [one]
    ) t on [classicmodels].[dbo].[payment].[check_number] = ?
    when matched then
    update
    set
      [classicmodels].[dbo].[payment].[invoice_amount] = ?,
      [classicmodels].[dbo].[payment].[caching_date] = ?
    when not matched then
    insert
     (
       [customer_number], [check_number], [payment_date], [invoice_amount], [caching_date]
     )
    values
     (?, ?, ?, ?, ?);
     */
    public void insertPaymentRecordOnConflictUpdateIt() {
        PaymentRecord pr = new PaymentRecord(103L, "HQ336336",
                LocalDateTime.of(2005, 11, 9, 12, 10, 11), BigDecimal.valueOf(123.32),
                LocalDateTime.of(2005, 11, 11, 14, 25, 21));

        System.out.println("EXAMPLE 8 (affected rows): "
                + ctx.insertInto(PAYMENT)
                        .set(pr) // or, values(pr)                
                        .onConflict(PAYMENT.CHECK_NUMBER)
                        .doUpdate()
                        .set(PAYMENT.INVOICE_AMOUNT, BigDecimal.ZERO)
                        .setNull(PAYMENT.CACHING_DATE)
                        .execute()
        );
    }

    /* MERGE INTO EXAMPLES */
    // EXAMPLE 9
    /*    
    merge into [classicmodels].[dbo].[product] using (
    select 
      1 [one]
    ) t on [classicmodels].[dbo].[product].[product_name] = ? when matched then 
    update 
    set 
      [classicmodels].[dbo].[product].[product_name] = ? 
    when not matched then insert 
      ([product_name]) 
    values 
      (?);
     */
    public void updateProductNameElseInsertProduct() {

        System.out.println("EXAMPLE 9 (affected rows): "
                + ctx.mergeInto(PRODUCT)
                        .usingDual() // or, (ctx.selectOne())
                        .on(PRODUCT.PRODUCT_NAME.eq("1952 Alpine Renault 1300"))
                        .whenMatchedThenUpdate()
                        .set(PRODUCT.PRODUCT_NAME, "1952 Alpine Renault 1600")
                        .whenNotMatchedThenInsert(PRODUCT.PRODUCT_NAME)
                        .values("1952 Alpine Renault 1600")
                        .execute()
        );
    }

    // EXAMPLE 10
    /*
    merge into [classicmodels].[dbo].[customer] using (
    select 
      1 [one]
    ) t on (
      [classicmodels].[dbo].[customer].[contact_first_name] = ? 
      and [classicmodels].[dbo].[customer].[contact_last_name] = ?
    ) when matched then 
    update 
    set 
      [classicmodels].[dbo].[customer].[contact_first_name] = ? 
    when not matched then insert (
      [customer_name], [contact_first_name], 
      [contact_last_name], [phone], [sales_rep_employee_number], 
      [credit_limit]
    ) 
    values 
      (?, ?, ?, ?, ?, ?);
     */
    public void updateCustomerFirstNameElseInsertCustomer() {

        System.out.println("EXAMPLE 10 (affected rows): "
                + ctx.mergeInto(CUSTOMER)
                        .usingDual() //or, using(ctx.selectOne())
                        .on(CUSTOMER.CONTACT_FIRST_NAME.eq("Alejandra")
                                .and(CUSTOMER.CONTACT_LAST_NAME.eq("Camino")))
                        .whenMatchedThenUpdate()
                        .set(CUSTOMER.CONTACT_FIRST_NAME, "Alexandra")
                        .whenNotMatchedThenInsert(CUSTOMER.CUSTOMER_NAME, CUSTOMER.CONTACT_FIRST_NAME,
                                CUSTOMER.CONTACT_LAST_NAME, CUSTOMER.PHONE, CUSTOMER.SALES_REP_EMPLOYEE_NUMBER,
                                CUSTOMER.CREDIT_LIMIT)
                        .values("Atelier One", "Camino", "Alexandra", "(91) 745 6555", 1401L, BigDecimal.ZERO)
                        .execute()
        );
    }

    // EXAMPLE 11
    /*
    merge into [classicmodels].[dbo].[department] 
    using [classicmodels].[dbo].[office] 
    on [classicmodels].[dbo].[department].[office_code] = [classicmodels].[dbo].[office].[office_code]
    when matched then
    update
    set
      [classicmodels].[dbo].[department].[phone] = [classicmodels].[dbo].[office].[phone]
    when not matched then
    insert
      ([name], [code], [office_code], [phone])
    values
      (
        ?, ?, [classicmodels].[dbo].[office].[office_code], [classicmodels].[dbo].[office].[phone]
      ); 
     */
    public void updateDepartmentPhoneElseInsertDepartment() {

        System.out.println("EXAMPLE 11 (affected rows): "
                + ctx.mergeInto(DEPARTMENT)
                        .using(OFFICE)
                        .on(DEPARTMENT.OFFICE_CODE.eq(OFFICE.OFFICE_CODE))
                        .whenMatchedThenUpdate()
                        .set(DEPARTMENT.PHONE, OFFICE.PHONE)
                        .whenNotMatchedThenInsert(DEPARTMENT.NAME, DEPARTMENT.CODE,
                                DEPARTMENT.OFFICE_CODE, DEPARTMENT.PHONE)
                        .values(val("Management"), val((short) 34332), OFFICE.OFFICE_CODE, OFFICE.PHONE)
                        .execute()
        );
    }

    // EXAMPLE 12
    /*
    merge into [classicmodels].[dbo].[department] 
    using [classicmodels].[dbo].[office] 
    on [classicmodels].[dbo].[department].[office_code] = [classicmodels].[dbo].[office].[office_code]
    when matched then delete
    when not matched then
    insert
      ([name], [code], [office_code], [phone])
    values
      (
        ?, ?, [classicmodels].[dbo].[office].[office_code], [classicmodels].[dbo].[office].[phone]
      );
     */
    public void deleteDepartmentElseInsertDepartment() {

        System.out.println("EXAMPLE 12 (affected rows): "
                + ctx.mergeInto(DEPARTMENT)
                        .using(OFFICE)
                        .on(DEPARTMENT.OFFICE_CODE.eq(OFFICE.OFFICE_CODE))
                        .whenMatchedThenDelete()
                        .whenNotMatchedThenInsert(DEPARTMENT.NAME, DEPARTMENT.CODE,
                                DEPARTMENT.OFFICE_CODE, DEPARTMENT.PHONE)
                        .values(val("Management"), val((short) 34332), OFFICE.OFFICE_CODE, OFFICE.PHONE)
                        .execute()
        );
    }

    // EXAMPLE 13
    /*
    merge into [classicmodels].[dbo].[department] 
    using [classicmodels].[dbo].[office] 
    on (
      [classicmodels].[dbo].[department].[office_code] = [classicmodels].[dbo].[office].[office_code]
      and [classicmodels].[dbo].[department].[name] = ?
    )
    when matched then delete
    when not matched then
    insert
     ([name], [code], [office_code], [phone])
    values
     (
       ?, ?, [classicmodels].[dbo].[office].[office_code], [classicmodels].[dbo].[office].[phone]
     );
     */
    public void deleteDepartmentAccountingElseInsertDepartment() {

        System.out.println("EXAMPLE 13 (affected rows): "
                + ctx.mergeInto(DEPARTMENT)
                        .using(OFFICE)
                        .on(DEPARTMENT.OFFICE_CODE.eq(OFFICE.OFFICE_CODE)
                                .and(DEPARTMENT.NAME.eq("Accounting")))
                        .whenMatchedThenDelete()
                        .whenNotMatchedThenInsert(DEPARTMENT.NAME, DEPARTMENT.CODE,
                                DEPARTMENT.OFFICE_CODE, DEPARTMENT.PHONE)
                        .values(val("Management"), val((short) 34332), OFFICE.OFFICE_CODE, OFFICE.PHONE)
                        .execute()
        );
    }

    // EXAMPLE 14
    /*
    merge into [classicmodels].[dbo].[sale] using (
      select 
        1 [one]
    ) t on [classicmodels].[dbo].[sale].[fiscal_year] = ? when matched 
    and [classicmodels].[dbo].[sale].[sale] > ? then 
    update 
    set 
      [classicmodels].[dbo].[sale].[sale] = (
        [classicmodels].[dbo].[sale].[sale] * ?
      ) when matched 
      and (
        not (
          [classicmodels].[dbo].[sale].[sale] > ?
        ) 
        and [classicmodels].[dbo].[sale].[sale] < ?
      ) then delete;
    */
    public void updateSaleThenDeleteViaWhenMatchedAnd() {

        System.out.println("EXAMPLE 14 (affected rows): "
                + ctx.mergeInto(SALE)
                        .usingDual()
                        .on(SALE.FISCAL_YEAR.eq(2003))
                        .whenMatchedAnd(SALE.SALE_.gt(2000.0))
                        .thenUpdate()
                        .set(SALE.SALE_, SALE.SALE_.mul(0.50))
                        .whenMatchedAnd(SALE.SALE_.lt(2000.0))
                        .thenDelete()
                        .execute()
        );
    }

    // EXAMPLE 15
    /*
    merge into [classicmodels].[dbo].[department] 
    using [classicmodels].[dbo].[office] 
    on [classicmodels].[dbo].[department].[office_code] = [classicmodels].[dbo].[office].[office_code]
    when matched
      and [classicmodels].[dbo].[department].[name] = ? then delete
    when matched
      and (
        not ([classicmodels].[dbo].[department].[name] = ?)
        and [classicmodels].[dbo].[department].[name] = ?
      ) then
    update
    set
      [classicmodels].[dbo].[department].[name] = ?
    when not matched then
    insert
      ([name], [code], [office_code], [phone])
    values
     (
       ?, ?, [classicmodels].[dbo].[office].[office_code], [classicmodels].[dbo].[office].[phone]
     ); 
     */
    public void deleteDepartmentElseUpdateElseInsert() {

        System.out.println("EXAMPLE 15 (affected rows): "
                + ctx.mergeInto(DEPARTMENT)
                        .using(OFFICE)
                        .on(DEPARTMENT.OFFICE_CODE.eq(OFFICE.OFFICE_CODE))
                        .whenMatchedAnd(DEPARTMENT.NAME.eq("Accounting"))
                        .thenDelete()
                        .whenMatchedAnd(DEPARTMENT.NAME.eq("Finance"))
                        .thenUpdate()
                        .set(DEPARTMENT.NAME, "Economics")
                        .whenNotMatchedThenInsert(DEPARTMENT.NAME, DEPARTMENT.CODE,
                                DEPARTMENT.OFFICE_CODE, DEPARTMENT.PHONE)
                        .values(val("Management"), val((short) 34332), OFFICE.OFFICE_CODE, OFFICE.PHONE)
                        .execute()
        );
    }

    // EXAMPLE 16
    /*
    merge into [classicmodels].[dbo].[department] 
    using (
            (
              select 
                [classicmodels].[dbo].[office].[office_code], 
                [classicmodels].[dbo].[office].[city], 
                [classicmodels].[dbo].[office].[phone], 
                [classicmodels].[dbo].[office].[address_line_first], 
                [classicmodels].[dbo].[office].[address_line_second], 
                [classicmodels].[dbo].[office].[state], 
                [classicmodels].[dbo].[office].[country], 
                [classicmodels].[dbo].[office].[postal_code], 
                [classicmodels].[dbo].[office].[territory] 
              from 
                [classicmodels].[dbo].[office] 
              where 
                [classicmodels].[dbo].[office].[city] = ?
            )
          ) [t] 
    on [classicmodels].[dbo].[department].[office_code] = [t].[office_code] 
    when matched then delete 
    when not matched then insert (
      [name], [code], [office_code], [phone]
    ) 
    values 
    (
      ?, ?, [t].[office_code], [t].[phone]
    );
     */
    public void deleteParisDepartmentElseInsert() {

        Table<?> table = selectFrom(OFFICE)
                .where(OFFICE.CITY.eq("Paris")).asTable("t");

        System.out.println("EXAMPLE 16 (affected rows): "
                + ctx.mergeInto(DEPARTMENT)
                        .using(table)
                        .on(DEPARTMENT.OFFICE_CODE.eq(table.field(OFFICE.OFFICE_CODE)))
                        .whenMatchedThenDelete()
                        .whenNotMatchedThenInsert(DEPARTMENT.NAME, DEPARTMENT.CODE,
                                DEPARTMENT.OFFICE_CODE, DEPARTMENT.PHONE)
                        .values(val("Management"), val((short) 34332),
                                table.field(OFFICE.OFFICE_CODE),
                                table.field(OFFICE.PHONE))
                        .execute()
        );
    }

    // EXAMPLE 17
    /*
    merge into [classicmodels].[dbo].[sale] using (
      select 
        1 [one]
    ) t on [classicmodels].[dbo].[sale].[fiscal_year] = ? when matched 
    and [classicmodels].[dbo].[sale].[sale] < ? then delete when matched 
    and not (
      [classicmodels].[dbo].[sale].[sale] < ?
    ) then 
    update 
    set 
      [classicmodels].[dbo].[sale].[sale] = (
        [classicmodels].[dbo].[sale].[sale] * ?
      );
    */
    public void updateSaleThenDeleteViaDeleteWhere() {

        System.out.println("EXAMPLE 17 (affected rows): "
                + ctx.mergeInto(SALE)
                        .usingDual()
                        .on(SALE.FISCAL_YEAR.eq(2003))
                        .whenMatchedThenUpdate()
                        .set(SALE.SALE_, SALE.SALE_.mul(0.50))
                        .deleteWhere(SALE.SALE_.lt(2000.0))
                        .execute()
        );
    }

    // EXAMPLE 18
    /*
    merge into [classicmodels].[dbo].[payment] using [classicmodels].[dbo].[customer] 
    on [classicmodels].[dbo].[customer].[customer_number] = [classicmodels].[dbo].[payment].[customer_number] 
    when matched 
    and [classicmodels].[dbo].[payment].[invoice_amount] > ? then delete when matched 
    and not (
      [classicmodels].[dbo].[payment].[invoice_amount] > ?
    ) then 
    update 
    set 
      [classicmodels].[dbo].[payment].[invoice_amount] = (
        [classicmodels].[dbo].[payment].[invoice_amount] + [classicmodels].[dbo].[customer].[credit_limit]
      );
    */
    public void updatePaymentBeforeDelete() {

        System.out.println("EXAMPLE 18 (affected rows): "
                + ctx.mergeInto(PAYMENT)
                        .using(CUSTOMER)
                        .on(CUSTOMER.CUSTOMER_NUMBER.eq(PAYMENT.CUSTOMER_NUMBER))
                        .whenMatchedThenUpdate()
                        .set(PAYMENT.INVOICE_AMOUNT, PAYMENT.INVOICE_AMOUNT.plus(CUSTOMER.CREDIT_LIMIT))
                        .deleteWhere(PAYMENT.INVOICE_AMOUNT.gt(BigDecimal.valueOf(100000)))
                        .execute()
        );
    }

    // EXAMPLE 19
    /*
    merge into [classicmodels].[dbo].[payment] using [classicmodels].[dbo].[customer] 
    on [classicmodels].[dbo].[customer].[customer_number] = [classicmodels].[dbo].[payment].[customer_number] when matched 
    and [classicmodels].[dbo].[customer].[credit_limit] > ? then delete when matched 
    and not (
      [classicmodels].[dbo].[customer].[credit_limit] > ?
    ) then 
    update 
    set 
      [classicmodels].[dbo].[payment].[invoice_amount] = (
        [classicmodels].[dbo].[payment].[invoice_amount] + [classicmodels].[dbo].[customer].[credit_limit]
      );
    */
    public void deletePaymentBeforeUpdate() {

        System.out.println("EXAMPLE 19 (affected rows): "
                + ctx.mergeInto(PAYMENT)
                        .using(CUSTOMER)
                        .on(CUSTOMER.CUSTOMER_NUMBER.eq(PAYMENT.CUSTOMER_NUMBER))
                        .whenMatchedThenUpdate()
                        .set(PAYMENT.INVOICE_AMOUNT, PAYMENT.INVOICE_AMOUNT.plus(CUSTOMER.CREDIT_LIMIT))
                        .deleteWhere(CUSTOMER.CREDIT_LIMIT.gt(BigDecimal.valueOf(100000)))
                        .execute()
        );
    }
}