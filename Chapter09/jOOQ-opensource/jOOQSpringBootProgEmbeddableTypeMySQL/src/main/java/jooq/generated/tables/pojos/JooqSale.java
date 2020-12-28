/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables.pojos;


import java.io.Serializable;

import javax.annotation.processing.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jooq.generated.enums.SaleRate;
import jooq.generated.enums.SaleVat;


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
public class JooqSale implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long     saleId;
    private Integer  fiscalYear;
    private Double   sale;
    private Long     employeeNumber;
    private Byte     hot;
    private SaleRate rate;
    private SaleVat  vat;
    private String   trend;

    public JooqSale() {}

    public JooqSale(JooqSale value) {
        this.saleId = value.saleId;
        this.fiscalYear = value.fiscalYear;
        this.sale = value.sale;
        this.employeeNumber = value.employeeNumber;
        this.hot = value.hot;
        this.rate = value.rate;
        this.vat = value.vat;
        this.trend = value.trend;
    }

    public JooqSale(
        Long     saleId,
        Integer  fiscalYear,
        Double   sale,
        Long     employeeNumber,
        Byte     hot,
        SaleRate rate,
        SaleVat  vat,
        String   trend
    ) {
        this.saleId = saleId;
        this.fiscalYear = fiscalYear;
        this.sale = sale;
        this.employeeNumber = employeeNumber;
        this.hot = hot;
        this.rate = rate;
        this.vat = vat;
        this.trend = trend;
    }

    /**
     * Getter for <code>classicmodels.sale.sale_id</code>.
     */
    public Long getSaleId() {
        return this.saleId;
    }

    /**
     * Setter for <code>classicmodels.sale.sale_id</code>.
     */
    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    /**
     * Getter for <code>classicmodels.sale.fiscal_year</code>.
     */
    @NotNull
    public Integer getFiscalYear() {
        return this.fiscalYear;
    }

    /**
     * Setter for <code>classicmodels.sale.fiscal_year</code>.
     */
    public void setFiscalYear(Integer fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    /**
     * Getter for <code>classicmodels.sale.sale</code>.
     */
    @NotNull
    public Double getSale() {
        return this.sale;
    }

    /**
     * Setter for <code>classicmodels.sale.sale</code>.
     */
    public void setSale(Double sale) {
        this.sale = sale;
    }

    /**
     * Getter for <code>classicmodels.sale.employee_number</code>.
     */
    public Long getEmployeeNumber() {
        return this.employeeNumber;
    }

    /**
     * Setter for <code>classicmodels.sale.employee_number</code>.
     */
    public void setEmployeeNumber(Long employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    /**
     * Getter for <code>classicmodels.sale.hot</code>.
     */
    public Byte getHot() {
        return this.hot;
    }

    /**
     * Setter for <code>classicmodels.sale.hot</code>.
     */
    public void setHot(Byte hot) {
        this.hot = hot;
    }

    /**
     * Getter for <code>classicmodels.sale.rate</code>.
     */
    public SaleRate getRate() {
        return this.rate;
    }

    /**
     * Setter for <code>classicmodels.sale.rate</code>.
     */
    public void setRate(SaleRate rate) {
        this.rate = rate;
    }

    /**
     * Getter for <code>classicmodels.sale.vat</code>.
     */
    public SaleVat getVat() {
        return this.vat;
    }

    /**
     * Setter for <code>classicmodels.sale.vat</code>.
     */
    public void setVat(SaleVat vat) {
        this.vat = vat;
    }

    /**
     * Getter for <code>classicmodels.sale.trend</code>.
     */
    @Size(max = 10)
    public String getTrend() {
        return this.trend;
    }

    /**
     * Setter for <code>classicmodels.sale.trend</code>.
     */
    public void setTrend(String trend) {
        this.trend = trend;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JooqSale (");

        sb.append(saleId);
        sb.append(", ").append(fiscalYear);
        sb.append(", ").append(sale);
        sb.append(", ").append(employeeNumber);
        sb.append(", ").append(hot);
        sb.append(", ").append(rate);
        sb.append(", ").append(vat);
        sb.append(", ").append(trend);

        sb.append(")");
        return sb.toString();
    }
}
