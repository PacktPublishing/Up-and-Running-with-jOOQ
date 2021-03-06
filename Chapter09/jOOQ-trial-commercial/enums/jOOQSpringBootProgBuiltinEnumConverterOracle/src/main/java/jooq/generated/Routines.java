/*
 * This file is generated by jOOQ.
 */
package jooq.generated;


import java.math.BigDecimal;

import javax.annotation.processing.Generated;

import jooq.generated.routines.GetTotalSales;
import jooq.generated.routines.TopThreeSalesPerEmployee;
import jooq.generated.udt.records.TableResRecord;

import org.jooq.Configuration;
import org.jooq.Field;


/**
 * Convenience access to all stored procedures and functions in SYSTEM.
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
     * Call <code>SYSTEM.GET_TOTAL_SALES</code>
     */
    public static BigDecimal getTotalSales(
          Configuration configuration
        , Integer inYear
    ) {
        GetTotalSales f = new GetTotalSales();
        f.setInYear(inYear);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>SYSTEM.GET_TOTAL_SALES</code> as a field.
     */
    public static Field<BigDecimal> getTotalSales(
          Integer inYear
    ) {
        GetTotalSales f = new GetTotalSales();
        f.setInYear(inYear);

        return f.asField();
    }

    /**
     * Get <code>SYSTEM.GET_TOTAL_SALES</code> as a field.
     */
    public static Field<BigDecimal> getTotalSales(
          Field<Integer> inYear
    ) {
        GetTotalSales f = new GetTotalSales();
        f.setInYear(inYear);

        return f.asField();
    }

    /**
     * Call <code>SYSTEM.TOP_THREE_SALES_PER_EMPLOYEE</code>
     */
    public static TableResRecord topThreeSalesPerEmployee(
          Configuration configuration
        , Number employeeNr
    ) {
        TopThreeSalesPerEmployee f = new TopThreeSalesPerEmployee();
        f.setEmployeeNr(employeeNr);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>SYSTEM.TOP_THREE_SALES_PER_EMPLOYEE</code> as a field.
     */
    public static Field<TableResRecord> topThreeSalesPerEmployee(
          Number employeeNr
    ) {
        TopThreeSalesPerEmployee f = new TopThreeSalesPerEmployee();
        f.setEmployeeNr(employeeNr);

        return f.asField();
    }

    /**
     * Get <code>SYSTEM.TOP_THREE_SALES_PER_EMPLOYEE</code> as a field.
     */
    public static Field<TableResRecord> topThreeSalesPerEmployee(
          Field<? extends Number> employeeNr
    ) {
        TopThreeSalesPerEmployee f = new TopThreeSalesPerEmployee();
        f.setEmployeeNr(employeeNr);

        return f.asField();
    }
}
