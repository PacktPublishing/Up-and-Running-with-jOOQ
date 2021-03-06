package com.classicmodels.repository;

import java.math.BigInteger;
import java.util.Map;
import static jooq.generated.tables.Customer.CUSTOMER;
import static jooq.generated.tables.Employee.EMPLOYEE;
import static jooq.generated.tables.Office.OFFICE;
import static jooq.generated.tables.Order.ORDER;
import static jooq.generated.tables.Orderdetail.ORDERDETAIL;
import static jooq.generated.tables.Payment.PAYMENT;
import static jooq.generated.tables.Product.PRODUCT;
import static jooq.generated.tables.Productline.PRODUCTLINE;
import static jooq.generated.tables.Sale.SALE;
import org.jooq.Comparator;
import org.jooq.DSLContext;
import org.jooq.SelectQuery;
import static org.jooq.impl.DSL.asterisk;
import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.nvl;
import static org.jooq.impl.DSL.select;
import static org.jooq.impl.DSL.table;
import org.springframework.stereotype.Repository;
 
@Repository
public class ClassicModelsRepository {

    private final DSLContext ctx;
 
    public ClassicModelsRepository(DSLContext ctx) {
        this.ctx = ctx;
    }

    // EXAMPLE 1
    // if all you need is a sub-set of columns then 
    // avoid (or, at least pay attention to) these approaches 
    // since they (may) fetches too much data (all columns)
    public void findOrderAllFields() {

        /*
        select 
          "SYSTEM"."ORDER"."ORDER_ID", 
          "SYSTEM"."ORDER"."ORDER_DATE", 
          "SYSTEM"."ORDER"."REQUIRED_DATE", 
          "SYSTEM"."ORDER"."SHIPPED_DATE", 
          "SYSTEM"."ORDER"."STATUS", 
          "SYSTEM"."ORDER"."COMMENTS", 
          "SYSTEM"."ORDER"."CUSTOMER_NUMBER" 
        from 
          "SYSTEM"."ORDER" 
        where 
          "SYSTEM"."ORDER"."ORDER_ID" = ?
        */
        System.out.println("EXAMPLE 1.1\n" +
                ctx.select()
                        .from(ORDER)
                        .where(ORDER.ORDER_ID.eq(10101L))
                        .fetch()
        );
        
        System.out.println("EXAMPLE 1.2\n" +
                ctx.selectFrom(ORDER)
                        .where(ORDER.ORDER_ID.eq(10101L))
                        .fetch()
        );        

        System.out.println("EXAMPLE 1.3\n" +
                ctx.select(ORDER.fields())
                        .from(ORDER)
                        .where(ORDER.ORDER_ID.eq(10101L))
                        .fetch()
        );
        
        /*
        select 
          * 
        from 
          "SYSTEM"."ORDER" 
        where 
          "SYSTEM"."ORDER"."ORDER_ID" = ?        
        */
        System.out.println("EXAMPLE 1.4\n" +
                ctx.select(asterisk())
                        .from(ORDER)
                        .where(ORDER.ORDER_ID.eq(10101L))
                        .fetch()
        );
        
        /*
        select 
          "SYSTEM"."ORDER"."ORDER_ID", 
          "SYSTEM"."ORDER"."ORDER_DATE", 
          "SYSTEM"."ORDER"."REQUIRED_DATE", 
          "SYSTEM"."ORDER"."SHIPPED_DATE", 
          "SYSTEM"."ORDER"."STATUS", 
          "SYSTEM"."ORDER"."COMMENTS", 
          "SYSTEM"."ORDER"."CUSTOMER_NUMBER", 
          "SYSTEM"."ORDERDETAIL"."QUANTITY_ORDERED" 
        from 
          "SYSTEM"."ORDER" 
          join "SYSTEM"."ORDERDETAIL" on "SYSTEM"."ORDER"."ORDER_ID" = "SYSTEM"."ORDERDETAIL"."ORDER_ID" 
        where 
          "SYSTEM"."ORDER"."ORDER_ID" = ?        
        */
        System.out.println("EXAMPLE 1.5\n"
                + ctx.select(ORDER.fields())
                        .select(ORDERDETAIL.QUANTITY_ORDERED)
                        .from(ORDER)
                        .innerJoin(ORDERDETAIL)
                        .on(ORDER.ORDER_ID.eq(ORDERDETAIL.ORDER_ID))
                        .where(ORDER.ORDER_ID.eq(10101L))
                        .fetch()
        );
        
        /*
        select 
          "alias_3062530".* 
        from 
          (
            "SYSTEM"."ORDER" 
            join "SYSTEM"."CUSTOMER" "alias_3062530" 
             on "SYSTEM"."ORDER"."CUSTOMER_NUMBER" = "alias_3062530"."CUSTOMER_NUMBER"
          ) 
        where 
          "SYSTEM"."ORDER"."ORDER_ID" = ?        
        */
        System.out.println("EXAMPLE 1.6\n"
                + ctx.select(ORDER.customer().asterisk())                        
                        .from(ORDER)
                        .where(ORDER.ORDER_ID.eq(10101L))
                        .fetch()
        );
    }

    // EXAMPLE 2    
    // list only the columns (fields) that are needed
    /*
    select 
      "SYSTEM"."ORDER"."ORDER_ID", 
      "SYSTEM"."ORDER"."ORDER_DATE", 
      "SYSTEM"."ORDER"."REQUIRED_DATE", 
      "SYSTEM"."ORDER"."SHIPPED_DATE", 
      "SYSTEM"."ORDER"."CUSTOMER_NUMBER" 
    from 
      "SYSTEM"."ORDER" 
    where 
      "SYSTEM"."ORDER"."ORDER_ID" = ?    
    */
    public void findOrderExplicitFields() {

        System.out.println("EXAMPLE 2\n" +
                ctx.select(ORDER.ORDER_ID, ORDER.ORDER_DATE,
                        ORDER.REQUIRED_DATE, ORDER.SHIPPED_DATE, ORDER.CUSTOMER_NUMBER)
                        .from(ORDER)
                        .where(ORDER.ORDER_ID.eq(10101L))
                        .fetch()
        );
    }

    // EXAMPLE 3
    // list the columns (fields) that should be skipped
    /*
    select 
      "SYSTEM"."ORDER"."ORDER_ID", 
      "SYSTEM"."ORDER"."ORDER_DATE", 
      "SYSTEM"."ORDER"."REQUIRED_DATE", 
      "SYSTEM"."ORDER"."SHIPPED_DATE", 
      "SYSTEM"."ORDER"."CUSTOMER_NUMBER" 
    from 
      "SYSTEM"."ORDER" 
    where 
      "SYSTEM"."ORDER"."ORDER_ID" = ?    
    */
    public void findOrderAsteriskExcept() {

        System.out.println("EXAMPLE 3\n" +
                ctx.select(asterisk().except(ORDER.COMMENTS, ORDER.STATUS))
                        .from(ORDER)
                        .where(ORDER.ORDER_ID.eq(10101L))
                        .fetch()
        );
    }

    // EXAMPLE 4
    /*
    select 
      "SYSTEM"."EMPLOYEE"."FIRST_NAME", 
      "SYSTEM"."EMPLOYEE"."LAST_NAME", 
      "SYSTEM"."SALE".* 
    from 
      "SYSTEM"."EMPLOYEE" 
      join "SYSTEM"."SALE" on "SYSTEM"."EMPLOYEE"."EMPLOYEE_NUMBER" = "SYSTEM"."SALE"."EMPLOYEE_NUMBER"    
    */
    public void findOrderAndSale() {

        System.out.println("EXAMPLE 4\n" +
                ctx.select(EMPLOYEE.FIRST_NAME, EMPLOYEE.LAST_NAME, SALE.asterisk())
                        .from(EMPLOYEE)
                        .join(SALE)
                        .on(EMPLOYEE.EMPLOYEE_NUMBER.eq(SALE.EMPLOYEE_NUMBER))
                        .fetch()
        );
    }

    // EXAMPLE 5
    /*
    select 
      "SYSTEM"."EMPLOYEE"."LAST_NAME", 
      "SYSTEM"."EMPLOYEE"."FIRST_NAME", 
      "SYSTEM"."EMPLOYEE"."EXTENSION", 
      "SYSTEM"."EMPLOYEE"."EMAIL", 
      "SYSTEM"."EMPLOYEE"."SALARY", 
      "SYSTEM"."EMPLOYEE"."REPORTS_TO", 
      "SYSTEM"."EMPLOYEE"."JOB_TITLE", 
      "SYSTEM"."SALE".* 
    from 
      "SYSTEM"."EMPLOYEE" 
      join "SYSTEM"."SALE" on "SYSTEM"."EMPLOYEE"."EMPLOYEE_NUMBER" = "SYSTEM"."SALE"."EMPLOYEE_NUMBER"   
    */
    public void findOrderExceptAndSale() {

        System.out.println("EXAMPLE 5\n" +
                ctx.select(EMPLOYEE.asterisk().except(EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.OFFICE_CODE),
                        SALE.asterisk())
                        .from(EMPLOYEE)
                        .join(SALE)
                        .on(EMPLOYEE.EMPLOYEE_NUMBER.eq(SALE.EMPLOYEE_NUMBER))
                        .fetch()
        );
    }                          

    // EXAMPLE 6
    /*
    select 
      "SYSTEM"."OFFICE"."CITY" "location", 
      "SYSTEM"."OFFICE"."OFFICE_CODE", 
      "SYSTEM"."OFFICE"."PHONE", 
      "SYSTEM"."OFFICE"."ADDRESS_LINE_FIRST", 
      "SYSTEM"."OFFICE"."ADDRESS_LINE_SECOND", 
      "SYSTEM"."OFFICE"."STATE", 
      "SYSTEM"."OFFICE"."COUNTRY", 
      "SYSTEM"."OFFICE"."POSTAL_CODE", 
      "SYSTEM"."OFFICE"."TERRITORY" 
    from 
      "SYSTEM"."OFFICE"    
    */
    public void findOfficeUseAliasForCity() {

        System.out.println("EXAMPLE 6\n"
                + ctx.select(OFFICE.CITY.as("location"),
                        OFFICE.asterisk().except(OFFICE.CITY))
                        .from(OFFICE)
                        .fetch()
        );
    }
    
    // EXAMPLE 7
    /*
    select 
      nvl("SYSTEM"."OFFICE"."CITY", ?), 
      "SYSTEM"."OFFICE"."OFFICE_CODE", 
      "SYSTEM"."OFFICE"."PHONE", 
      "SYSTEM"."OFFICE"."ADDRESS_LINE_FIRST", 
      "SYSTEM"."OFFICE"."ADDRESS_LINE_SECOND", 
      "SYSTEM"."OFFICE"."STATE", 
      "SYSTEM"."OFFICE"."COUNTRY", 
      "SYSTEM"."OFFICE"."POSTAL_CODE", 
      "SYSTEM"."OFFICE"."TERRITORY" 
    from 
      "SYSTEM"."OFFICE"        
    */
    public void findOfficeUseNvlForCity() {

        System.out.println("EXAMPLE 7\n"
                + ctx.select(nvl(OFFICE.CITY, "N/A"),
                        OFFICE.asterisk().except(OFFICE.CITY))
                        .from(OFFICE)
                        .fetch()
        );
    } 
    
    // EXAMPLE 8
    /*
    select 
      case when "SYSTEM"."SALE"."SALE" > ? then 1 when not ("SYSTEM"."SALE"."SALE" > ?) 
         then 0 end "saleGt5000", 
      "SYSTEM"."SALE"."SALE_ID", 
      "SYSTEM"."SALE"."FISCAL_YEAR", 
      "SYSTEM"."SALE"."EMPLOYEE_NUMBER" 
    from 
      "SYSTEM"."SALE"    
    */
    public void findSaleGt5000() {
        
        System.out.println("EXAMPLE 8\n"
                + ctx.select(field(SALE.SALE_.gt(5000.0)).as("saleGt5000"),                        
                        SALE.asterisk().except(SALE.SALE_))
                        .from(SALE)
                        .fetch()
        );
    }
    
    // EXAMPLE 9
    /*
    select 
      ("SYSTEM"."SALE"."SALE" * ?) "saleMul025", 
      "SYSTEM"."SALE"."SALE_ID", 
      "SYSTEM"."SALE"."FISCAL_YEAR", 
      "SYSTEM"."SALE"."EMPLOYEE_NUMBER" 
    from 
      "SYSTEM"."SALE"    
    */
    public void findSaleMul025() {
        
        System.out.println("EXAMPLE 9\n"
                + ctx.select(field(SALE.SALE_.mul(0.25)).as("saleMul025"),                        
                        SALE.asterisk().except(SALE.SALE_))
                        .from(SALE)
                        .fetch()
        );
    }
    
    // EXAMPLE 10
    /*
    select 
      "SYSTEM"."OFFICE"."CITY", 
      "SYSTEM"."OFFICE"."COUNTRY", 
      "SYSTEM"."OFFICE"."OFFICE_CODE" 
    from 
      "SYSTEM"."OFFICE" 
    where 
      "SYSTEM"."OFFICE"."CITY" in (?, ?, ?) 
    order by 
      case "SYSTEM"."OFFICE"."CITY" when ? then 0 when ? then 1 when ? then 2 end asc    
    */
    // Consider reading: https://blog.jooq.org/2014/05/07/how-to-implement-sort-indirection-in-sql/
    public void findOfficeInCityByCertainSort() {

        String[] citiesArr = {"Paris", "Tokyo", "Boston"};
        System.out.println("EXAMPLE 10.1\n"
                + ctx.select(OFFICE.CITY, OFFICE.COUNTRY, OFFICE.OFFICE_CODE)
                        .from(OFFICE)
                        .where(OFFICE.CITY.in(citiesArr))
                        .orderBy(OFFICE.CITY.sortAsc(citiesArr)) 
                        .fetch()
        );
        
        Map<String, Integer> citiesMap = Map.of("Paris", 1, "Tokyo", 3, "Boston", 2);
        System.out.println("EXAMPLE 10.2\n"
                + ctx.select(OFFICE.CITY, OFFICE.COUNTRY, OFFICE.OFFICE_CODE)
                        .from(OFFICE)
                        .where(OFFICE.CITY.in(citiesMap.keySet()))
                        .orderBy(OFFICE.CITY.sort(citiesMap)) 
                        .fetch()
        );      
    }
    
    // EXAMPLE 11
    /*
    select 
      "SYSTEM"."EMPLOYEE"."EMPLOYEE_NUMBER", 
      "SYSTEM"."EMPLOYEE"."LAST_NAME", 
      "SYSTEM"."EMPLOYEE"."FIRST_NAME", 
      "SYSTEM"."EMPLOYEE"."EXTENSION", 
      "SYSTEM"."EMPLOYEE"."EMAIL", 
      "SYSTEM"."EMPLOYEE"."OFFICE_CODE", 
      "SYSTEM"."EMPLOYEE"."SALARY", 
      "SYSTEM"."EMPLOYEE"."REPORTS_TO", 
      "SYSTEM"."EMPLOYEE"."JOB_TITLE" 
    from 
      "SYSTEM"."EMPLOYEE" 
    where 
      "SYSTEM"."EMPLOYEE"."SALARY" in (
        select 
          "SYSTEM"."EMPLOYEE"."SALARY" 
        from 
          "SYSTEM"."EMPLOYEE" 
        where 
          "SYSTEM"."EMPLOYEE"."SALARY" < ?
      ) 
    order by 
      "SYSTEM"."EMPLOYEE"."SALARY"    
     */
    public void findEmployeeSalary60000(boolean isSaleRep) {

        System.out.println("EXAMPLE 11\n"
                + ctx.select()
                        .from(EMPLOYEE)
                        .where(EMPLOYEE.SALARY.compare(isSaleRep ? Comparator.IN : Comparator.NOT_IN,
                                select(EMPLOYEE.SALARY).from(EMPLOYEE).where(EMPLOYEE.SALARY.lt(BigInteger.valueOf(60000)))))
                        .orderBy(EMPLOYEE.SALARY)
                        .fetch()
        );
    }
    
    // EXAMPLE 12
    /*
    select 
      "SYSTEM"."EMPLOYEE"."FIRST_NAME", 
      "SYSTEM"."EMPLOYEE"."LAST_NAME", 
      "SYSTEM"."EMPLOYEE"."SALARY" 
    from 
      "SYSTEM"."EMPLOYEE" 
    order by "SYSTEM"."EMPLOYEE"."SALARY"
    fetch next ? rows only    
    */
    public void findEmployeeLimit() {

        System.out.println("EXAMPLE 12\n" +
                ctx.select(EMPLOYEE.FIRST_NAME, EMPLOYEE.LAST_NAME, EMPLOYEE.SALARY)
                        .from(EMPLOYEE)
                        .orderBy(EMPLOYEE.SALARY)
                        .limit(10)
                        .fetch()
        );
    }
    
    // EXAMPLE 13
    /*
    select 
      "SYSTEM"."EMPLOYEE"."FIRST_NAME", 
      "SYSTEM"."EMPLOYEE"."LAST_NAME", 
      "SYSTEM"."EMPLOYEE"."SALARY" 
    from 
      "SYSTEM"."EMPLOYEE" 
    order by "SYSTEM"."EMPLOYEE"."SALARY"
    offset ? rows fetch next ? rows only    
    */
    public void findEmployeeLimitOffset() {

        System.out.println("EXAMPLE 13\n" +
                ctx.select(EMPLOYEE.FIRST_NAME, EMPLOYEE.LAST_NAME, EMPLOYEE.SALARY)
                        .from(EMPLOYEE)
                        .orderBy(EMPLOYEE.SALARY)
                        .limit(10)
                        .offset(5)
                        .fetch()
        );
    }
    
    // EXAMPLE 14
    /*
    select 
      "SYSTEM"."EMPLOYEE"."FIRST_NAME", 
      "SYSTEM"."EMPLOYEE"."LAST_NAME", 
      "SYSTEM"."EMPLOYEE"."SALARY" 
    from 
      "SYSTEM"."EMPLOYEE" 
    order by "SYSTEM"."EMPLOYEE"."SALARY"
    offset ? rows fetch next ? rows only    
    */
    public void findEmployeeLimitAndOffset() {

        System.out.println("EXAMPLE 14\n" +
                ctx.select(EMPLOYEE.FIRST_NAME, EMPLOYEE.LAST_NAME, EMPLOYEE.SALARY)
                        .from(EMPLOYEE)
                        .orderBy(EMPLOYEE.SALARY)
                        .limit(5, 10)                        
                        .fetch()
        );
    }
    
    public void limit1InJoinedTable() {

        /*
        select 
          "SYSTEM"."PRODUCTLINE"."PRODUCT_LINE", 
          "SYSTEM"."PRODUCTLINE"."CODE", 
          "SYSTEM"."PRODUCT"."PRODUCT_NAME", 
          "SYSTEM"."PRODUCT"."QUANTITY_IN_STOCK", 
          "SYSTEM"."PRODUCT"."PRODUCT_ID" 
        from 
          "SYSTEM"."PRODUCTLINE" 
          join "SYSTEM"."PRODUCT" on "SYSTEM"."PRODUCT"."PRODUCT_ID" = (
            select 
              "SYSTEM"."PRODUCT"."PRODUCT_ID" 
            from 
              "SYSTEM"."PRODUCT" 
            where 
              "SYSTEM"."PRODUCTLINE"."PRODUCT_LINE" = "SYSTEM"."PRODUCT"."PRODUCT_LINE" 
            order by 
              "SYSTEM"."PRODUCT"."PRODUCT_ID" fetch next ? rows only
          )
         */
        System.out.println("EXAMPLE 15\n"
                + ctx.select(PRODUCTLINE.PRODUCT_LINE, PRODUCTLINE.CODE,
                        PRODUCT.PRODUCT_NAME, PRODUCT.QUANTITY_IN_STOCK, PRODUCT.PRODUCT_ID)
                        .from(PRODUCTLINE)
                        .join(PRODUCT)
                        .on(PRODUCT.PRODUCT_ID.eq(select(PRODUCT.PRODUCT_ID).from(PRODUCT)
                                .where(PRODUCTLINE.PRODUCT_LINE.eq(PRODUCT.PRODUCT_LINE))
                                .orderBy(PRODUCT.PRODUCT_ID).limit(1)))
                        .fetch()
        );
    }

    // EXAMPLE 16
    /*
    select 
      "v0" "CITY", 
      "v1" "COUNTRY", 
      "v2" "JOB_TITLE", 
      "v3" "CUSTOMER_NUMBER", 
      "v4" "CUSTOMER_NAME", 
      "v5" "PHONE", 
      "v6" "SALES_REP_EMPLOYEE_NUMBER", 
      "v7" "CREDIT_LIMIT", 
      "v8" "CUSTOMER_NUMBER", 
      "v9" "CHECK_NUMBER", 
      "v10" "PAYMENT_DATE", 
      "v11" "INVOICE_AMOUNT", 
      "v12" "CACHING_DATE" 
    from 
      (
        select 
          "x"."v0", 
          "x"."v1", 
          "x"."v2", 
          "x"."v3", 
          "x"."v4", 
          "x"."v5", 
          "x"."v6", 
          "x"."v7", 
          "x"."v8", 
          "x"."v9", 
          "x"."v10", 
          "x"."v11", 
          "x"."v12", 
          rownum "rn" 
        from 
          (
            select 
              "SYSTEM"."OFFICE"."CITY" "v0", 
              "SYSTEM"."OFFICE"."COUNTRY" "v1", 
              "SYSTEM"."EMPLOYEE"."JOB_TITLE" "v2", 
              "SYSTEM"."CUSTOMER"."CUSTOMER_NUMBER" "v3", 
              "SYSTEM"."CUSTOMER"."CUSTOMER_NAME" "v4", 
              "SYSTEM"."CUSTOMER"."PHONE" "v5", 
              "SYSTEM"."CUSTOMER"."SALES_REP_EMPLOYEE_NUMBER" "v6", 
              "SYSTEM"."CUSTOMER"."CREDIT_LIMIT" "v7", 
              "SYSTEM"."PAYMENT"."CUSTOMER_NUMBER" "v8", 
              "SYSTEM"."PAYMENT"."CHECK_NUMBER" "v9", 
              "SYSTEM"."PAYMENT"."PAYMENT_DATE" "v10", 
              "SYSTEM"."PAYMENT"."INVOICE_AMOUNT" "v11", 
              "SYSTEM"."PAYMENT"."CACHING_DATE" "v12" 
            from 
              "SYSTEM"."OFFICE", 
              "SYSTEM"."EMPLOYEE", 
              "SYSTEM"."CUSTOMER", 
              "SYSTEM"."PAYMENT"
          ) "x" 
        where 
          rownum <= (0 + ?)
      ) 
    where 
      "rn" > 0    
    */
    public void decomposeSelect() {
        
        SelectQuery select = ctx.select()
                .from(OFFICE, EMPLOYEE, CUSTOMER, PAYMENT).limit(100).getQuery();
                
        select.addSelect(OFFICE.CITY, OFFICE.COUNTRY);
        select.addSelect(EMPLOYEE.JOB_TITLE);
        select.addSelect(CUSTOMER.asterisk().except(CUSTOMER.CONTACT_FIRST_NAME, CUSTOMER.CONTACT_LAST_NAME));
        select.addSelect(PAYMENT.fields());
        
        System.out.println("EXAMPLE 16\n" +
                select.fetch()
        );
    }
        
    // EXAMPLE 17
    /*    
    select 
      "v0" "CITY", 
      "v1" "COUNTRY", 
      "v2" "JOB_TITLE", 
      "v3" "CUSTOMER_NUMBER", 
      "v4" "CUSTOMER_NAME", 
      "v5" "PHONE", 
      "v6" "SALES_REP_EMPLOYEE_NUMBER", 
      "v7" "CREDIT_LIMIT", 
      "v8" "CUSTOMER_NUMBER", 
      "v9" "CHECK_NUMBER", 
      "v10" "PAYMENT_DATE", 
      "v11" "INVOICE_AMOUNT", 
      "v12" "CACHING_DATE" 
    from 
      (
        select 
          "x"."v0", 
          "x"."v1", 
          "x"."v2", 
          "x"."v3", 
          "x"."v4", 
          "x"."v5", 
          "x"."v6", 
          "x"."v7", 
          "x"."v8", 
          "x"."v9", 
          "x"."v10", 
          "x"."v11", 
          "x"."v12", 
          rownum "rn" 
        from 
          (
            select 
              "SYSTEM"."OFFICE"."CITY" "v0", 
              "SYSTEM"."OFFICE"."COUNTRY" "v1", 
              "SYSTEM"."EMPLOYEE"."JOB_TITLE" "v2", 
              "SYSTEM"."CUSTOMER"."CUSTOMER_NUMBER" "v3", 
              "SYSTEM"."CUSTOMER"."CUSTOMER_NAME" "v4", 
              "SYSTEM"."CUSTOMER"."PHONE" "v5", 
              "SYSTEM"."CUSTOMER"."SALES_REP_EMPLOYEE_NUMBER" "v6", 
              "SYSTEM"."CUSTOMER"."CREDIT_LIMIT" "v7", 
              "SYSTEM"."PAYMENT"."CUSTOMER_NUMBER" "v8", 
              "SYSTEM"."PAYMENT"."CHECK_NUMBER" "v9", 
              "SYSTEM"."PAYMENT"."PAYMENT_DATE" "v10", 
              "SYSTEM"."PAYMENT"."INVOICE_AMOUNT" "v11", 
              "SYSTEM"."PAYMENT"."CACHING_DATE" "v12" 
            from 
              "SYSTEM"."OFFICE", 
              "SYSTEM"."EMPLOYEE", 
              "SYSTEM"."CUSTOMER", 
              "SYSTEM"."PAYMENT"
          ) "x" 
        where 
          rownum <= (0 + ?)
      ) 
    where 
      "rn" > 0    
    */    
    public void decomposeSelectAndFrom() {
        
        SelectQuery select = ctx.select().limit(100).getQuery();
                        
        select.addFrom(OFFICE);        
        select.addSelect(OFFICE.CITY, OFFICE.COUNTRY);
        
        select.addFrom(EMPLOYEE);
        select.addSelect(EMPLOYEE.JOB_TITLE);
        
        select.addFrom(CUSTOMER);
        select.addSelect(CUSTOMER.asterisk().except(CUSTOMER.CONTACT_FIRST_NAME, CUSTOMER.CONTACT_LAST_NAME));
        
        select.addFrom(PAYMENT);
        select.addSelect(PAYMENT.fields());
        
        System.out.println("EXAMPLE 17\n" +
                select.fetch()
        );
    }    
}