/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables.records;


import com.classicmodels.enums.RateType;
import com.classicmodels.enums.VatType;

import java.math.BigInteger;

import javax.annotation.processing.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jooq.generated.tables.Sale;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;


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
public class SaleRecord extends UpdatableRecordImpl<SaleRecord> implements Record8<BigInteger, BigInteger, Double, Long, Byte, RateType, VatType, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>SYSTEM.SALE.SALE_ID</code>.
     */
    public void setSaleId(BigInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>SYSTEM.SALE.SALE_ID</code>.
     */
    @NotNull
    public BigInteger getSaleId() {
        return (BigInteger) get(0);
    }

    /**
     * Setter for <code>SYSTEM.SALE.FISCAL_YEAR</code>.
     */
    public void setFiscalYear(BigInteger value) {
        set(1, value);
    }

    /**
     * Getter for <code>SYSTEM.SALE.FISCAL_YEAR</code>.
     */
    @NotNull
    public BigInteger getFiscalYear() {
        return (BigInteger) get(1);
    }

    /**
     * Setter for <code>SYSTEM.SALE.SALE</code>.
     */
    public void setSale(Double value) {
        set(2, value);
    }

    /**
     * Getter for <code>SYSTEM.SALE.SALE</code>.
     */
    @NotNull
    public Double getSale() {
        return (Double) get(2);
    }

    /**
     * Setter for <code>SYSTEM.SALE.EMPLOYEE_NUMBER</code>.
     */
    public void setEmployeeNumber(Long value) {
        set(3, value);
    }

    /**
     * Getter for <code>SYSTEM.SALE.EMPLOYEE_NUMBER</code>.
     */
    public Long getEmployeeNumber() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>SYSTEM.SALE.HOT</code>.
     */
    public void setHot(Byte value) {
        set(4, value);
    }

    /**
     * Getter for <code>SYSTEM.SALE.HOT</code>.
     */
    public Byte getHot() {
        return (Byte) get(4);
    }

    /**
     * Setter for <code>SYSTEM.SALE.RATE</code>.
     */
    public void setRate(RateType value) {
        set(5, value);
    }

    /**
     * Getter for <code>SYSTEM.SALE.RATE</code>.
     */
    public RateType getRate() {
        return (RateType) get(5);
    }

    /**
     * Setter for <code>SYSTEM.SALE.VAT</code>.
     */
    public void setVat(VatType value) {
        set(6, value);
    }

    /**
     * Getter for <code>SYSTEM.SALE.VAT</code>.
     */
    public VatType getVat() {
        return (VatType) get(6);
    }

    /**
     * Setter for <code>SYSTEM.SALE.TREND</code>.
     */
    public void setTrend(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>SYSTEM.SALE.TREND</code>.
     */
    @Size(max = 10)
    public String getTrend() {
        return (String) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<BigInteger> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row8<BigInteger, BigInteger, Double, Long, Byte, RateType, VatType, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    @Override
    public Row8<BigInteger, BigInteger, Double, Long, Byte, RateType, VatType, String> valuesRow() {
        return (Row8) super.valuesRow();
    }

    @Override
    public Field<BigInteger> field1() {
        return Sale.SALE.SALE_ID;
    }

    @Override
    public Field<BigInteger> field2() {
        return Sale.SALE.FISCAL_YEAR;
    }

    @Override
    public Field<Double> field3() {
        return Sale.SALE.SALE_;
    }

    @Override
    public Field<Long> field4() {
        return Sale.SALE.EMPLOYEE_NUMBER;
    }

    @Override
    public Field<Byte> field5() {
        return Sale.SALE.HOT;
    }

    @Override
    public Field<RateType> field6() {
        return Sale.SALE.RATE;
    }

    @Override
    public Field<VatType> field7() {
        return Sale.SALE.VAT;
    }

    @Override
    public Field<String> field8() {
        return Sale.SALE.TREND;
    }

    @Override
    public BigInteger component1() {
        return getSaleId();
    }

    @Override
    public BigInteger component2() {
        return getFiscalYear();
    }

    @Override
    public Double component3() {
        return getSale();
    }

    @Override
    public Long component4() {
        return getEmployeeNumber();
    }

    @Override
    public Byte component5() {
        return getHot();
    }

    @Override
    public RateType component6() {
        return getRate();
    }

    @Override
    public VatType component7() {
        return getVat();
    }

    @Override
    public String component8() {
        return getTrend();
    }

    @Override
    public BigInteger value1() {
        return getSaleId();
    }

    @Override
    public BigInteger value2() {
        return getFiscalYear();
    }

    @Override
    public Double value3() {
        return getSale();
    }

    @Override
    public Long value4() {
        return getEmployeeNumber();
    }

    @Override
    public Byte value5() {
        return getHot();
    }

    @Override
    public RateType value6() {
        return getRate();
    }

    @Override
    public VatType value7() {
        return getVat();
    }

    @Override
    public String value8() {
        return getTrend();
    }

    @Override
    public SaleRecord value1(BigInteger value) {
        setSaleId(value);
        return this;
    }

    @Override
    public SaleRecord value2(BigInteger value) {
        setFiscalYear(value);
        return this;
    }

    @Override
    public SaleRecord value3(Double value) {
        setSale(value);
        return this;
    }

    @Override
    public SaleRecord value4(Long value) {
        setEmployeeNumber(value);
        return this;
    }

    @Override
    public SaleRecord value5(Byte value) {
        setHot(value);
        return this;
    }

    @Override
    public SaleRecord value6(RateType value) {
        setRate(value);
        return this;
    }

    @Override
    public SaleRecord value7(VatType value) {
        setVat(value);
        return this;
    }

    @Override
    public SaleRecord value8(String value) {
        setTrend(value);
        return this;
    }

    @Override
    public SaleRecord values(BigInteger value1, BigInteger value2, Double value3, Long value4, Byte value5, RateType value6, VatType value7, String value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SaleRecord
     */
    public SaleRecord() {
        super(Sale.SALE);
    }

    /**
     * Create a detached, initialised SaleRecord
     */
    public SaleRecord(BigInteger saleId, BigInteger fiscalYear, Double sale, Long employeeNumber, Byte hot, RateType rate, VatType vat, String trend) {
        super(Sale.SALE);

        setSaleId(saleId);
        setFiscalYear(fiscalYear);
        setSale(sale);
        setEmployeeNumber(employeeNumber);
        setHot(hot);
        setRate(rate);
        setVat(vat);
        setTrend(trend);
    }
}