/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables.pojos;


import java.io.Serializable;

import javax.annotation.processing.Generated;


/**
 * This class is generated by jOOQ.
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
public class JooqTopThreeSalesPerEmployee implements Serializable {

    private static final long serialVersionUID = 1L;

    private Double sales;

    public JooqTopThreeSalesPerEmployee() {}

    public JooqTopThreeSalesPerEmployee(JooqTopThreeSalesPerEmployee value) {
        this.sales = value.sales;
    }

    public JooqTopThreeSalesPerEmployee(
        Double sales
    ) {
        this.sales = sales;
    }

    /**
     * Getter for <code>classicmodels.dbo.top_three_sales_per_employee.sales</code>.
     */
    public Double getSales() {
        return this.sales;
    }

    /**
     * Setter for <code>classicmodels.dbo.top_three_sales_per_employee.sales</code>.
     */
    public void setSales(Double sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JooqTopThreeSalesPerEmployee (");

        sb.append(sales);

        sb.append(")");
        return sb.toString();
    }
}
