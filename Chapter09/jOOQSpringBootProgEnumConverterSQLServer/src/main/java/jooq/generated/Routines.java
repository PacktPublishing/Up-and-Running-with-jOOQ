/*
 * This file is generated by jOOQ.
 */
package jooq.generated;


import java.math.BigDecimal;

import javax.annotation.processing.Generated;

import jooq.generated.routines.Netpriceeach;
import jooq.generated.tables.TopThreeSalesPerEmployee;
import jooq.generated.tables.records.TopThreeSalesPerEmployeeRecord;

import org.jooq.Configuration;
import org.jooq.Field;
import org.jooq.Result;


/**
 * Convenience access to all stored procedures and functions in dbo.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.4",
        "schema version:1.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Routines {

    /**
     * Call <code>classicmodels.dbo.netPriceEach</code>
     */
    public static BigDecimal netpriceeach(
          Configuration configuration
        , Integer quantity
        , BigDecimal listPrice
        , BigDecimal discount
    ) {
        Netpriceeach f = new Netpriceeach();
        f.setQuantity(quantity);
        f.setListPrice(listPrice);
        f.setDiscount(discount);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>classicmodels.dbo.netPriceEach</code> as a field.
     */
    public static Field<BigDecimal> netpriceeach(
          Integer quantity
        , BigDecimal listPrice
        , BigDecimal discount
    ) {
        Netpriceeach f = new Netpriceeach();
        f.setQuantity(quantity);
        f.setListPrice(listPrice);
        f.setDiscount(discount);

        return f.asField();
    }

    /**
     * Get <code>classicmodels.dbo.netPriceEach</code> as a field.
     */
    public static Field<BigDecimal> netpriceeach(
          Field<Integer> quantity
        , Field<BigDecimal> listPrice
        , Field<BigDecimal> discount
    ) {
        Netpriceeach f = new Netpriceeach();
        f.setQuantity(quantity);
        f.setListPrice(listPrice);
        f.setDiscount(discount);

        return f.asField();
    }

    /**
     * Call <code>classicmodels.dbo.top_three_sales_per_employee</code>.
     */
    public static Result<TopThreeSalesPerEmployeeRecord> topThreeSalesPerEmployee(
          Configuration configuration
        , Long employeeNr
    ) {
        return configuration.dsl().selectFrom(jooq.generated.tables.TopThreeSalesPerEmployee.TOP_THREE_SALES_PER_EMPLOYEE.call(
              employeeNr
        )).fetch();
    }

    /**
     * Get <code>classicmodels.dbo.top_three_sales_per_employee</code> as a table.
     */
    public static TopThreeSalesPerEmployee topThreeSalesPerEmployee(
          Long employeeNr
    ) {
        return jooq.generated.tables.TopThreeSalesPerEmployee.TOP_THREE_SALES_PER_EMPLOYEE.call(
              employeeNr
        );
    }

    /**
     * Get <code>classicmodels.dbo.top_three_sales_per_employee</code> as a table.
     */
    public static TopThreeSalesPerEmployee topThreeSalesPerEmployee(
          Field<Long> employeeNr
    ) {
        return jooq.generated.tables.TopThreeSalesPerEmployee.TOP_THREE_SALES_PER_EMPLOYEE.call(
              employeeNr
        );
    }
}
