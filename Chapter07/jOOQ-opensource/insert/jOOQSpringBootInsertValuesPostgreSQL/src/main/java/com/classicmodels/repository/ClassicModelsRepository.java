package com.classicmodels.repository;

import com.classicmodels.pojo.SalePart;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import static jooq.generated.Routines.getAvgSale;
import static jooq.generated.Sequences.ORDER_SEQ;
import static jooq.generated.Sequences.SALE_SEQ;
import jooq.generated.enums.RateType;
import jooq.generated.enums.VatType;
import static jooq.generated.tables.Department.DEPARTMENT;
import static jooq.generated.tables.Manager.MANAGER;
import jooq.generated.tables.Order;
import static jooq.generated.tables.Order.ORDER;
import static jooq.generated.tables.Payment.PAYMENT;
import static jooq.generated.tables.Sale.SALE;
import jooq.generated.tables.pojos.Department;
import jooq.generated.tables.pojos.Sale;
import jooq.generated.tables.records.SaleRecord;
import static jooq.generated.udt.EvaluationCriteria.EVALUATION_CRITERIA;
import jooq.generated.udt.records.EvaluationCriteriaRecord;
import org.jooq.DSLContext;
import org.jooq.InsertQuery;
import static org.jooq.impl.DSL.choose;
import static org.jooq.impl.DSL.coalesce;
import static org.jooq.impl.DSL.default_;
import static org.jooq.impl.DSL.inline;
import static org.jooq.impl.DSL.rand;
import static org.jooq.impl.DSL.round;
import static org.jooq.impl.DSL.select;
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
    public void insertOrderAutoGenKey() {

        /*
        insert into "public"."order" (
          "order_id", "order_date", "required_date", 
          "shipped_date", "status", "comments", 
          "customer_number"
        ) 
        values 
          (
            nextval('"public"."order_seq"'), 
            cast(? as date), 
            cast(? as date), 
            cast(? as date), 
            ?, ?, ?
          ) on conflict do nothing        
         */
        System.out.println("EXAMPLE 1.1 (affected rows): "
                + ctx.insertInto(ORDER) // InsertSetStep<OrderRecord>
                        .values(ORDER_SEQ.nextval(), // primary key is auto-generated
                                LocalDate.of(2003, 2, 12), LocalDate.of(2003, 3, 1),
                                LocalDate.of(2003, 2, 27), "Shipped",
                                "New order inserted ...", 363L)
                        .onDuplicateKeyIgnore()
                        .execute()
        );

        /*
        insert into "public"."order" (
          "comments", "order_date", "required_date", 
          "shipped_date", "status", "customer_number"
        ) 
        values 
          (
            ?, 
            cast(? as date), 
            cast(? as date), 
            cast(? as date), 
            ?, 
            ?
          ) on conflict do nothing        
         */
        System.out.println("EXAMPLE 1.2 (affected rows): "
                + // InsertValuesStep6<OrderRecord, String, LocalDate, LocalDate, LocalDate, String, Long>
                ctx.insertInto(ORDER, ORDER.COMMENTS, ORDER.ORDER_DATE, ORDER.REQUIRED_DATE,
                        ORDER.SHIPPED_DATE, ORDER.STATUS, ORDER.CUSTOMER_NUMBER)
                        .values("New order inserted ...", LocalDate.of(2003, 2, 12),
                                LocalDate.of(2003, 3, 1), LocalDate.of(2003, 2, 27), "Shipped", 363L)
                        .onDuplicateKeyIgnore()
                        .execute()
        );

        System.out.println("EXAMPLE 1.3 (affected rows): "
                + ctx.insertInto(ORDER) // InsertSetStep<OrderRecord>
                        .columns(ORDER.COMMENTS, ORDER.ORDER_DATE, ORDER.REQUIRED_DATE,
                                ORDER.SHIPPED_DATE, ORDER.STATUS, ORDER.CUSTOMER_NUMBER)
                        .values("New order inserted ...", LocalDate.of(2003, 2, 12),
                                LocalDate.of(2003, 3, 1), LocalDate.of(2003, 2, 27), "Shipped", 363L)
                        .onDuplicateKeyIgnore()
                        .execute()
        );

        // example 1.3 expressed via InsertQuery API
        InsertQuery iq = ctx.insertQuery(ORDER);
        iq.addValue(ORDER.COMMENTS, "New order inserted ...");
        iq.addValue(ORDER.ORDER_DATE, LocalDate.of(2003, 2, 12));
        iq.addValue(ORDER.REQUIRED_DATE, LocalDate.of(2003, 3, 1));
        iq.addValue(ORDER.SHIPPED_DATE, LocalDate.of(2003, 2, 27));
        iq.addValue(ORDER.STATUS, "Shipped");
        iq.addValue(ORDER.CUSTOMER_NUMBER, 363L);
        iq.onDuplicateKeyIgnore(true);

        System.out.println("EXAMPLE 1.4 (affected rows): "
                + iq.execute()
        );
    }

    // EXAMPLE 2
    /*
    insert into "public"."order" (
      "order_id", "order_date", "required_date", 
      "shipped_date", "status", "comments", 
      "customer_number"
    ) 
    values 
      (
        ?, 
        cast(? as date), 
        cast(? as date), 
        cast(? as date), 
        ?, ?, ?
      ) on conflict do nothing 
     */
    public void insertOrderManualKey() {

        System.out.println("EXAMPLE 2.1 (affected rows): "
                + ctx.insertInto(ORDER) // InsertSetStep<OrderRecord>
                        .values(Math.round(Math.random() * 1000), // random primary key
                                LocalDate.of(2003, 2, 12), LocalDate.of(2003, 3, 1),
                                LocalDate.of(2003, 2, 27), "Shipped",
                                "New order inserted ...", 363L)
                        .onDuplicateKeyIgnore()
                        .execute()
        );

        System.out.println("EXAMPLE 2.2 (affected rows): "
                + // InsertValuesStep7<OrderRecord, Long, String, LocalDate, LocalDate, LocalDate, String, Long>
                ctx.insertInto(ORDER, ORDER.ORDER_ID, ORDER.COMMENTS, ORDER.ORDER_DATE, ORDER.REQUIRED_DATE,
                        ORDER.SHIPPED_DATE, ORDER.STATUS, ORDER.CUSTOMER_NUMBER)
                        .values(Math.round(Math.random() * 1000), // random primary key
                                "New order inserted ...", LocalDate.of(2003, 2, 12),
                                LocalDate.of(2003, 3, 1), LocalDate.of(2003, 2, 27), "Shipped", 363L)
                        .onDuplicateKeyIgnore()
                        .execute()
        );

        System.out.println("EXAMPLE 2.3 (affected rows): "
                + ctx.insertInto(ORDER) // InsertSetStep<OrderRecord>
                        .columns(ORDER.ORDER_ID, ORDER.COMMENTS, ORDER.ORDER_DATE, ORDER.REQUIRED_DATE,
                                ORDER.SHIPPED_DATE, ORDER.STATUS, ORDER.CUSTOMER_NUMBER)
                        .values(Math.round(Math.random() * 1000), // random primary key
                                "New order inserted ...", LocalDate.of(2003, 2, 12),
                                LocalDate.of(2003, 3, 1), LocalDate.of(2003, 2, 27), "Shipped", 363L)
                        .onDuplicateKeyIgnore()
                        .execute()
        );
    }

    // EXAMPLE 3
    /*
    insert into "public"."order" (
      "order_id", "order_date", "required_date", 
      "shipped_date", "status", "comments", 
      "customer_number"
    ) 
    values 
      (
        nextval('"public"."order_seq"'), 
        cast(? as date), 
        cast(? as date), 
        cast(? as date), 
        ?, ?, ?
      ), 
      (
        nextval('"public"."order_seq"'), 
        cast(? as date), 
        cast(? as date), 
        cast(? as date), 
        ?, ?, ?
      ), 
      (
        nextval('"public"."order_seq"'), 
        cast(? as date), 
        cast(? as date), 
        cast(? as date), 
        ?, ?, ?
      ) on conflict do nothing    
     */
    public void insertMultipleOrderAutoGenKey() {

        System.out.println("EXAMPLE 3.1 (affected rows): "
                + ctx.insertInto(ORDER) // InsertSetStep<OrderRecord>
                        .values(ORDER_SEQ.nextval(), // primary key is auto-generated
                                LocalDate.of(2004, 10, 22), LocalDate.of(2004, 10, 23),
                                LocalDate.of(2004, 10, 23), "Shipped",
                                "New order inserted ...", 363L)
                        .values(ORDER_SEQ.nextval(),
                                LocalDate.of(2003, 12, 2), LocalDate.of(2003, 1, 3),
                                LocalDate.of(2003, 2, 26), "Resolved",
                                "Important order ...", 128L)
                        .values(ORDER_SEQ.nextval(),
                                LocalDate.of(2005, 12, 12), LocalDate.of(2005, 12, 23),
                                LocalDate.of(2005, 12, 22), "On Hold",
                                "Order of client ...", 181L)
                        .onDuplicateKeyIgnore()
                        .execute()
        );

        System.out.println("EXAMPLE 3.2 (affected rows): "
                + // InsertValuesStep6<OrderRecord, String, LocalDate, LocalDate, LocalDate, String, Long>
                ctx.insertInto(ORDER, ORDER.COMMENTS, ORDER.ORDER_DATE, ORDER.REQUIRED_DATE,
                        ORDER.SHIPPED_DATE, ORDER.STATUS, ORDER.CUSTOMER_NUMBER)
                        .values("New order inserted ...", LocalDate.of(2004, 10, 22),
                                LocalDate.of(2004, 10, 23), LocalDate.of(2004, 10, 23), "Shipped", 363L)
                        .values("Important order ...", LocalDate.of(2003, 12, 2),
                                LocalDate.of(2003, 1, 3), LocalDate.of(2003, 2, 26), "Resolved", 128L)
                        .values("Order of client ...", LocalDate.of(2005, 12, 12),
                                LocalDate.of(2005, 12, 23), LocalDate.of(2005, 12, 22), "On Hold", 181L)
                        .onDuplicateKeyIgnore()
                        .execute()
        );

        System.out.println("EXAMPLE 3.3 (affected rows): "
                + ctx.insertInto(ORDER) // InsertSetStep<OrderRecord>
                        .columns(ORDER.COMMENTS, ORDER.ORDER_DATE, ORDER.REQUIRED_DATE,
                                ORDER.SHIPPED_DATE, ORDER.STATUS, ORDER.CUSTOMER_NUMBER)
                        .values("New order inserted ...", LocalDate.of(2004, 10, 22),
                                LocalDate.of(2004, 10, 23), LocalDate.of(2004, 10, 23), "Shipped", 363L)
                        .values("Important order ...", LocalDate.of(2003, 12, 2),
                                LocalDate.of(2003, 1, 3), LocalDate.of(2003, 2, 26), "Resolved", 128L)
                        .values("Order of client ...", LocalDate.of(2005, 12, 12),
                                LocalDate.of(2005, 12, 23), LocalDate.of(2005, 12, 22), "On Hold", 181L)
                        .onDuplicateKeyIgnore()
                        .execute()
        );
    }

    // EXAMPLE 4
    /*
    insert into "public"."order" (
      "order_id", "order_date", "required_date", 
      "shipped_date", "status", "comments", 
      "customer_number"
    ) 
    values 
      (
        ?, 
        cast(? as date), 
        cast(? as date), 
        cast(? as date), 
        ?, ?, ?
      ), 
      (
        ?, 
        cast(? as date), 
        cast(? as date), 
        cast(? as date), 
        ?, ?, ?
      ), 
      (
        ?, 
        cast(? as date), 
        cast(? as date), 
        cast(? as date), 
        ?, ?, ?
      ) on conflict do nothing    
     */
    public void insertMultipleOrderManualKey() {

        System.out.println("EXAMPLE 4.1 (affected rows): "
                + ctx.insertInto(ORDER) // InsertSetStep<OrderRecord>
                        .values(Math.round(Math.random() * 100),
                                LocalDate.of(2004, 10, 22), LocalDate.of(2004, 10, 23),
                                LocalDate.of(2004, 10, 23), "Shipped",
                                "New order inserted ...", 363L)
                        .values(Math.round(Math.random() * 1000),
                                LocalDate.of(2003, 12, 2), LocalDate.of(2003, 1, 3),
                                LocalDate.of(2003, 2, 26), "Resolved",
                                "Important order ...", 128L)
                        .values(Math.round(Math.random() * 10000),
                                LocalDate.of(2005, 12, 12), LocalDate.of(2005, 12, 23),
                                LocalDate.of(2005, 12, 22), "On Hold",
                                "Order of client ...", 181L)
                        .onDuplicateKeyIgnore()
                        .execute()
        );

        System.out.println("EXAMPLE 4.2 (affected rows): "
                + // InsertValuesStep6<OrderRecord, String, LocalDate, LocalDate, LocalDate, String, Long>
                ctx.insertInto(ORDER, ORDER.ORDER_ID, ORDER.COMMENTS, ORDER.ORDER_DATE, ORDER.REQUIRED_DATE,
                        ORDER.SHIPPED_DATE, ORDER.STATUS, ORDER.CUSTOMER_NUMBER)
                        .values(Math.round(Math.random() * 100),
                                "New order inserted ...", LocalDate.of(2004, 10, 22),
                                LocalDate.of(2004, 10, 23), LocalDate.of(2004, 10, 23), "Shipped", 363L)
                        .values(Math.round(Math.random() * 1000),
                                "Important order ...", LocalDate.of(2003, 12, 2),
                                LocalDate.of(2003, 1, 3), LocalDate.of(2003, 2, 26), "Resolved", 128L)
                        .values(Math.round(Math.random() * 10000),
                                "Order of client ...", LocalDate.of(2005, 12, 12),
                                LocalDate.of(2005, 12, 23), LocalDate.of(2005, 12, 22), "On Hold", 181L)
                        .onDuplicateKeyIgnore()
                        .execute()
        );

        System.out.println("EXAMPLE 4.3 (affected rows): "
                + ctx.insertInto(ORDER) // InsertSetStep<OrderRecord>
                        .columns(ORDER.ORDER_ID, ORDER.COMMENTS, ORDER.ORDER_DATE, ORDER.REQUIRED_DATE,
                                ORDER.SHIPPED_DATE, ORDER.STATUS, ORDER.CUSTOMER_NUMBER)
                        .values(Math.round(Math.random() * 100),
                                "New order inserted ...", LocalDate.of(2004, 10, 22),
                                LocalDate.of(2004, 10, 23), LocalDate.of(2004, 10, 23), "Shipped", 363L)
                        .values(Math.round(Math.random() * 1000),
                                "Important order ...", LocalDate.of(2003, 12, 2),
                                LocalDate.of(2003, 1, 3), LocalDate.of(2003, 2, 26), "Resolved", 128L)
                        .values(Math.round(Math.random() * 10000),
                                "Order of client ...", LocalDate.of(2005, 12, 12),
                                LocalDate.of(2005, 12, 23), LocalDate.of(2005, 12, 22), "On Hold", 181L)
                        .onDuplicateKeyIgnore()
                        .execute()
        );
    }

    // EXAMPLE 5
    /*
    insert into "public"."payment" (
      "customer_number", "check_number", 
      "caching_date", "payment_date", 
      "invoice_amount"
    ) 
    values 
      (
        ?, 
        ?, 
        cast(
          ? as timestamp(6)
        ), 
        cast(
          ? as timestamp(6)
        ), 
        ?
      ) on conflict do nothing    
     */
    public void insertPaymentCompositeKey() {

        System.out.println("EXAMPLE 5 (affected rows): "
                + ctx.insertInto(PAYMENT)
                        .columns(PAYMENT.CUSTOMER_NUMBER, PAYMENT.CHECK_NUMBER, // composite primary key
                                PAYMENT.CACHING_DATE, PAYMENT.PAYMENT_DATE, PAYMENT.INVOICE_AMOUNT)
                        .values(103L, "HQ336338",
                                LocalDateTime.of(2004, 11, 17, 12, 30, 15),
                                LocalDateTime.of(2004, 10, 19, 12, 30, 15),
                                BigDecimal.valueOf(5433.22))
                        .onDuplicateKeyIgnore()
                        .execute()
        );
    }

    // EXAMPLE 6    
    public void insertOneSaleRecord() {

        /*
        insert into "public"."sale" (
          "sale_id", "fiscal_year", "sale", 
          "employee_number", "hot", "rate", 
          "vat", "trend"
        ) 
        values 
          (
            ?, ?, ?, ?, ?, ? :: "public"."rate_type", 
            ? :: "public"."vat_type", ?
          ) on conflict do nothing       
         */
        System.out.println("EXAMPLE 6.1 (affected rows): "
                + ctx.insertInto(SALE)
                        .values(
                                new SaleRecord()
                                        .value1(ctx.select(SALE_SEQ.nextval()).fetchOneInto(Long.class))
                                        .value2(2005)
                                        .value3(3223.12)
                                        .value4(1504L)
                                        .valuesRow().fields()
                        )
                        .onDuplicateKeyIgnore()
                        .execute()
        );

        /*
        insert into "public"."sale" (
          "sale_id", "fiscal_year", "sale", 
          "employee_number", "hot", "rate", 
          "vat", "trend"
        ) 
        values 
          (
            ?, ?, ?, ?, ?, ? :: "public"."rate_type", 
            ? :: "public"."vat_type", ?
          ) on conflict do nothing        
         */
        System.out.println("EXAMPLE 6.2 (affected rows): "
                + ctx.insertInto(SALE)
                        .values(new SaleRecord()
                                .values(ctx.select(SALE_SEQ.nextval()).fetchOneInto(Long.class),
                                        2004, 143.31, 1370L, null, RateType.SILVER, VatType.MAX, null)
                                .valuesRow().fields())
                        .onDuplicateKeyIgnore()
                        .execute()
        );

        /* create a SaleRecord via constructor */
        // SaleRecord sr = new SaleRecord(null, 2003, 3443.22, 1370L,
        //         null, RateType.SILVER, VatType.MAX, null);
        /* or, creare a SaleRecord via constructor and setters */
        SaleRecord sr = new SaleRecord();
        sr.setSaleId(Math.round(Math.random() * 10000));    // or, sr.set(SALE.SALE_ID, Math.round(Math.random() * 10000));
        sr.setFiscalYear(2003);                             // or, sr.set(SALE.FISCAL_YEAR, 2003);
        sr.setSale(3443.22);                                // or, sr.set(SALE.SALE_, 3443.22);        
        sr.setEmployeeNumber(1370L);                        // or, sr.set(SALE.EMPLOYEE_NUMBER, 1370L);                   

        /*
        insert into "public"."sale" (
          "sale_id", "fiscal_year", "sale", 
          "employee_number", "hot", "rate", 
          "vat", "trend"
        ) 
        values 
          (
            ?, ?, ?, ?, ?, ? :: "public"."rate_type", 
            ? :: "public"."vat_type", ?
          ) on conflict do nothing        
         */
        System.out.println("EXAMPLE 6.3 (affected rows): "
                + ctx.insertInto(SALE)
                        .values(sr.valuesRow().fields())
                        .onDuplicateKeyIgnore()
                        .execute()
        );

        sr.setSaleId(Math.round(Math.random() * 10000));
        System.out.println("EXAMPLE 6.4 (affected rows): "
                + ctx.insertInto(SALE)
                        .values(sr.getSaleId(), sr.getFiscalYear(), sr.getSale(), sr.getEmployeeNumber(),
                                default_(), RateType.SILVER, VatType.MAX, default_())
                        .onDuplicateKeyIgnore()
                        .execute()
        );

        sr.setSaleId(Math.round(Math.random() * 10000));
        System.out.println("EXAMPLE 6.5 (affected rows): "
                + ctx.insertInto(SALE)
                        .values(sr.value1(), sr.value2(), sr.value3(), sr.value4(),
                                default_(), RateType.SILVER, VatType.MAX, default_())
                        .onDuplicateKeyIgnore()
                        .execute()
        );

        sr.setSaleId(Math.round(Math.random() * 10000));
        System.out.println("EXAMPLE 6.6 (affected rows): "
                + ctx.insertInto(SALE, sr.field4(), sr.field3(), sr.field2(), sr.field1())
                        .values(sr.value4(), sr.value3(), sr.value2(), sr.value1())
                        .onDuplicateKeyIgnore()
                        .execute()
        );

        sr.setSaleId(Math.round(Math.random() * 10000));
        System.out.println("EXAMPLE 6.7 (affected rows): "
                + ctx.insertInto(SALE, sr.fields())
                        .values(sr.valuesRow().fields())
                        .onDuplicateKeyIgnore()
                        .execute()
        );

        sr.setSaleId(Math.round(Math.random() * 10000));
        System.out.println("EXAMPLE 6.8 (affected rows): "
                + ctx.insertInto(SALE, sr.fieldsRow().fields())
                        .values(sr.valuesRow().fields())
                        .onDuplicateKeyIgnore()
                        .execute()
        );
    }

    // EXAMPLE 7
    /*
    insert into "public"."sale" (
      "sale_id", "fiscal_year", "sale", 
      "employee_number", "hot", "rate", 
      "vat", "trend"
    ) 
    values 
      (
        ?, ?, ?, ?, ?, ? :: "public"."rate_type", 
        ? :: "public"."vat_type", ?
      ), 
      (
        ?, ?, ?, ?, ?, ? :: "public"."rate_type", 
        ? :: "public"."vat_type", ?
      ) on conflict do nothing    
     */
    public void insertTwoSaleRecord() {

        Long nextId1 = ctx.select(SALE_SEQ.nextval()).fetchOneInto(Long.class);
        Long nextId2 = ctx.select(SALE_SEQ.nextval()).fetchOneInto(Long.class);

        // Record8<Long, Integer, Double, Long, Boolean, RateType, VatType, String>
        SaleRecord sr1 = new SaleRecord(nextId1, 2003, 3443.22, 1370L,
                null, RateType.SILVER, VatType.MAX, null);
        SaleRecord sr2 = new SaleRecord(nextId2, 2005, 1221.12, 1504L,
                null, RateType.SILVER, VatType.MAX, null);

        System.out.println("EXAMPLE 7 (affected rows): "
                + ctx.insertInto(SALE)
                        .values(sr1.valuesRow().fields())
                        .values(sr2.valuesRow().fields())
                        .onDuplicateKeyIgnore()
                        .execute()
        );
    }

    // EXAMPLE 8  
    /*
    insert into "public"."sale" (
      "sale_id", "fiscal_year", "sale", 
      "employee_number", "hot", "rate", 
      "vat", "trend"
    ) 
    values 
      (
        ?, ?, ?, ?, ?, ? :: "public"."rate_type", 
        ? :: "public"."vat_type", ?
      ), 
      (
        ?, ?, ?, ?, ?, ? :: "public"."rate_type", 
        ? :: "public"."vat_type", ?
      ), 
      (
        ?, ?, ?, ?, ?, ? :: "public"."rate_type", 
        ? :: "public"."vat_type", ?
      )    
     */
    public void insertCollectionOfSaleRecord() {

        // consider this collection of SaleRecord
        Collection<SaleRecord> listOfRecord
                = List.of(new SaleRecord(Math.round(Math.random() * 10000), 2003, 3443.22, 1370L,
                        null, RateType.SILVER, VatType.MAX, null),
                        new SaleRecord(Math.round(Math.random() * 10000), 2005, 1221.12, 1504L,
                                null, RateType.SILVER, VatType.MAX, null),
                        new SaleRecord(Math.round(Math.random() * 10000), 2005, 1221.12, 1504L,
                                null, RateType.SILVER, VatType.MAX, null));

        /* First Approach */
        // InsertValuesStepN<SaleRecord>
        var insert1 = ctx.insertInto(SALE, SALE.fields());
        for (SaleRecord sr : listOfRecord) {
            insert1.values(sr.valuesRow().fields());
        }
        System.out.println("EXAMPLE 8.1 (affected rows): "
                + insert1.execute()
        );

        /* Second Approach */
        // InsertValuesStep4<SaleRecord, Long, Integer, Double, Long>
        var insert2 = ctx.insertInto(SALE, SALE.SALE_ID, SALE.FISCAL_YEAR, SALE.SALE_, SALE.EMPLOYEE_NUMBER);
        for (SaleRecord sr : listOfRecord) {
            insert2.values(sr.getSaleId(), sr.getFiscalYear(), sr.getSale(), sr.getEmployeeNumber());
        }
        insert2.onDuplicateKeyIgnore();
        System.out.println("EXAMPLE 8.2 (affected rows): "
                + insert2.execute()
        );

        /* Third Approach (inspired from https://github.com/jOOQ/jOOQ/issues/6604) */
        System.out.println("EXAMPLE 8.3 (affected rows): "
                + Optional.of(ctx.insertInto(SALE, SALE.fields()))
                        .map(s -> {
                            listOfRecord.forEach((sr) -> {
                                s.values(sr.valuesRow().fields());
                            });
                            s.onDuplicateKeyIgnore();
                            return s.execute();
                        })
        );

        // jOOQ 3.15 (valuesOfRows(), valuesOfRecords()) 
        // https://github.com/jOOQ/jOOQ/issues/6604
        // This example is WIP
    }

    // EXAMPLE 9
    /*
    insert into "public"."sale" (
      "fiscal_year", "sale", "employee_number"
    ) 
    values 
      (?, ?, ?) returning "public"."sale"."sale_id" // only for 9.1, 9.2, and 9.4
     */
    public void insertNewRecord() {

        System.out.println("EXAMPLE 9.1 (affected rows): "
                + ctx.newRecord(SALE.FISCAL_YEAR, SALE.SALE_, SALE.EMPLOYEE_NUMBER)
                        .values(2004, 1233.2, 1370L)
                        .into(SALE)
                        .insert()
        );

        // This is the Sale POJO generated by jOOQ
        Sale sale = new Sale(Math.round(Math.random() * 10000), 2005, 343.22, 1504L,
                null, RateType.SILVER, VatType.MAX, null);
        System.out.println("EXAMPLE 9.2 (affected rows): "
                + ctx.newRecord(SALE, sale).insert()
        );

        SaleRecord sr = new SaleRecord();
        sr.from(sale);
        sr.setSaleId(Math.round(Math.random() * 10000)); // set a new id
        System.out.println("EXAMPLE 9.3 (affected rows): "
                + ctx.insertInto(SALE)
                        .values(sr.valuesRow().fields())
                        .execute()
        );
        
        sr.setSaleId(Math.round(Math.random() * 10000)); // set a new id
        sr.attach(ctx.configuration()); // attach the record to the current configuration
        System.out.println("EXAMPLE 9.4 (affected rows): "
                +sr.insert()
        );

        // this is user-define SalePart POJO (it contains only a part of fields)
        SalePart salePart = new SalePart(5644.32, 1370L);
        System.out.println("EXAMPLE 9.5 (affected rows): "
                + ctx.newRecord(SALE)
                        .values(Math.round(Math.random() * 10000), 2004,
                                salePart.getSale(), salePart.getEmployeeNumber(),
                                null, RateType.SILVER, VatType.MAX, null)
                        .insert()
        );

        SaleRecord srp = new SaleRecord();
        srp.from(salePart);      // get the available fields from SalePart        
        srp.setFiscalYear(2004); // fiscal_year cannot be null and doesn't have a default value
        srp.setSaleId(Math.round(Math.random() * 10000));
        System.out.println("EXAMPLE 9.6 (affected rows): "
                + ctx.insertInto(SALE)
                        .values(srp.valuesRow().fields())
                        .execute()
        );

        srp.reset(SALE.SALE_ID);
        System.out.println("EXAMPLE 9.7 (affected rows): "
                + ctx.executeInsert(srp)
        );
    }

    // EXAMPLE 10
    /*
    insert into "public"."sale" (
      "sale_id", "fiscal_year", "sale", 
      "employee_number", "hot", "rate", 
      "vat", "trend"
    ) 
    values 
      (
        ?, ?, ?, ?, ?, ? :: "public"."rate_type", 
        ? :: "public"."vat_type", ?
      ) returning "public"."sale"."sale_id"
     */
    public void insertRecordAfterResettingPK() {

        Sale sale = new Sale(1L, 2005, 343.22, 1504L, null, RateType.SILVER, VatType.MAX, null);
        var record = ctx.newRecord(SALE, sale);
        
        // reset the current ID and allow DB to generate one
        record.changed(SALE.SALE_ID, false);
                
        // resets both changed flag that tracks record changes and value
        // record.reset(SALE.SALE_ID); 
        
        record.setSaleId(ctx.select(SALE_SEQ.nextval()).fetchOneInto(Long.class));
        System.out.println("EXAMPLE 10.1 (affected rows): "
                + record.insert()
        );

        SaleRecord sr = new SaleRecord();
        sr.from(sale);
        
        // resets both changed flag that tracks record changes and value
        sr.reset(SALE.SALE_ID); 
        
        sr.setSaleId(ctx.select(SALE_SEQ.nextval()).fetchOneInto(Long.class));
        System.out.println("EXAMPLE 10.2 (affected rows): "
                + ctx.insertInto(SALE)
                        .values(sr.valuesRow().fields())
                        .execute()
        );
    }

    // EXAMPLE 11    
    public void usingFunctionsInInsert() {

        /*
        insert into "public"."sale" (
          "sale_id", "fiscal_year", "sale", 
          "employee_number", "hot", "rate", 
          "vat", "trend"
        ) 
        values 
          (
            (
              random() * ?
            ), 
            ?, 
            round(?), 
            ?, 
            default, 
            ? :: "public"."rate_type", 
            ? :: "public"."vat_type", 
            default
          ) on conflict do nothing        
         */
        System.out.println("EXAMPLE 11.1 (affected rows): "
                + ctx.insertInto(SALE)
                        .values(rand().mul(1000), 2004, round(21112.23), 1504L,
                                default_(), RateType.SILVER, VatType.MAX, default_())
                        .onDuplicateKeyIgnore()
                        .execute()
        );

        /*
        insert into "public"."sale" (
          "sale_id", "fiscal_year", "sale", 
          "employee_number", "hot", "rate", 
          "vat", "trend"
        ) 
        values 
          (
            (
              random() * ?
            ), 
            ?, 
            "public"."get_avg_sale"("len_from" := ?, "len_to" := ?), 
            ?, 
            default, 
            ? :: "public"."rate_type", 
            ? :: "public"."vat_type", 
            default
          ) on conflict do nothing        
         */
        System.out.println("EXAMPLE 11.2 (affected rows): "
                + ctx.insertInto(SALE)
                        .values(rand().mul(1000), 2005, getAvgSale(1000, 5000), 1370,
                                default_(), RateType.SILVER, VatType.MAX, default_())
                        .onDuplicateKeyIgnore()
                        .execute()
        );

    }

    // EXAMPLE 12
    /*
    insert into "public"."department" (
      "name", "phone", "code", "office_code"
    ) 
    values 
      (
        ?, 
        coalesce(
          case when ? is null then '+40 080 000' else ? end, 
          '+40 080 000'
        ), 
        ?, 
        ?
      )    
     */
    public void insertDepartment() {

        Department department = new Department(); // jOOQ POJO
        department.setName("IT");
        department.setOfficeCode("2");
        department.setCode((short) 44);

        department.setPhone("+03 331 443");

        System.out.println("EXAMPLE 12 (affected rows): "
                + ctx.insertInto(DEPARTMENT, DEPARTMENT.NAME,
                        DEPARTMENT.PHONE, DEPARTMENT.CODE, DEPARTMENT.OFFICE_CODE)
                        .values(val(department.getName()),
                                coalesce(
                                        choose().when(val(department.getPhone()).isNull(), inline("+40 080 000"))
                                                .otherwise(department.getPhone()),
                                        inline("+40 080 000")),
                                val(department.getCode()), val(department.getOfficeCode())
                        )
                        .execute()
        );
    }

    // EXAMPLE 13
    /*
    insert into "public"."order" (
      "order_date", "required_date", "shipped_date", 
      "status", "comments", "customer_number"
    ) 
    select 
      cast(? as date), 
      cast(? as date), 
      cast(? as date), 
      ?, 
      ?, 
      ? 
    where 
      not exists (
        select 
          "public"."order"."order_id", 
          "public"."order"."order_date", 
          "public"."order"."required_date", 
          "public"."order"."shipped_date", 
          "public"."order"."status", 
          "public"."order"."comments", 
          "public"."order"."customer_number" 
        from 
          "public"."order" 
        where 
          (
            (
              cast(? as date) between "public"."order"."order_date" 
              and "public"."order"."shipped_date" 
              or cast(? as date) between "public"."order"."order_date" 
              and "public"."order"."shipped_date"
            ) 
            and ? = "public"."order"."customer_number"
          )
      )
     */
    public void insertOrderBetweenDates() {

        Order o = ORDER;

        System.out.println("EXAMPLE 13 (affected rows): "
                + ctx.insertInto(o)
                        .columns(o.ORDER_DATE, o.REQUIRED_DATE, o.SHIPPED_DATE,
                                o.STATUS, o.COMMENTS, o.CUSTOMER_NUMBER)
                        .select(
                                select(val(LocalDate.of(2010, 10, 10)), val(LocalDate.of(2010, 11, 1)),
                                        val(LocalDate.of(2010, 11, 5)), val("Shipped"), val(""), val(103L))
                                        .whereNotExists(
                                                selectFrom(o)
                                                        .where(val(LocalDate.of(2010, 10, 10)).between(o.ORDER_DATE).and(o.SHIPPED_DATE)
                                                                .or(val(LocalDate.of(2010, 11, 5)).between(o.ORDER_DATE).and(o.SHIPPED_DATE)))
                                                        .and(val(103L).eq(o.CUSTOMER_NUMBER))
                                        )
                        )
                        .execute()
        );
    }

    // EXAMPLE 14
    /*
    insert into "public"."office" (
      "office_code","location","phone","address_line_first","address_line_second","postal_code","territory")
    values
      (?, row(?, ?, ?), ?, ?, ?, ?, ?) 
    on conflict do nothing
     */
    public void insertAndUDTRecord() {

        EvaluationCriteriaRecord ec = new EvaluationCriteriaRecord(55, 67, 34, 98);
        System.out.println("EXAMPLE 14 (affected rows): "
                + ctx.insertInto(MANAGER)
                        .values(default_(),
                                "Farel Ugg", default_(), ec)
                        .onDuplicateKeyIgnore()
                        .execute()
        );

        // creating a UDT record alternatives
        EvaluationCriteriaRecord r1 = EVALUATION_CRITERIA.newRecord();
        // r1.setCommunicationAbility(56); ...

        EvaluationCriteriaRecord r2 = ctx.newRecord(EVALUATION_CRITERIA);
        // r2.setCommunicationAbility(56); ...
    }
}
