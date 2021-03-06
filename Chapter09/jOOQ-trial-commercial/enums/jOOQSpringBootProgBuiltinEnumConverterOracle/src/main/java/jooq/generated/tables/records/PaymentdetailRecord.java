/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables.records;


import javax.annotation.processing.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jooq.generated.tables.Paymentdetail;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record5;
import org.jooq.Row5;
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
public class PaymentdetailRecord extends UpdatableRecordImpl<PaymentdetailRecord> implements Record5<Long, String, String, String, Byte> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>SYSTEM.PAYMENTDETAIL.CUSTOMER_NUMBER</code>.
     */
    public void setCustomerNumber(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>SYSTEM.PAYMENTDETAIL.CUSTOMER_NUMBER</code>.
     */
    @NotNull
    public Long getCustomerNumber() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>SYSTEM.PAYMENTDETAIL.CHECK_NUMBER</code>.
     */
    public void setCheckNumber(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>SYSTEM.PAYMENTDETAIL.CHECK_NUMBER</code>.
     */
    @NotNull
    @Size(max = 50)
    public String getCheckNumber() {
        return (String) get(1);
    }

    /**
     * Setter for <code>SYSTEM.PAYMENTDETAIL.BANK_NAME</code>.
     */
    public void setBankName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>SYSTEM.PAYMENTDETAIL.BANK_NAME</code>.
     */
    @NotNull
    @Size(max = 20)
    public String getBankName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>SYSTEM.PAYMENTDETAIL.BANK_IBAN</code>.
     */
    public void setBankIban(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>SYSTEM.PAYMENTDETAIL.BANK_IBAN</code>.
     */
    @NotNull
    @Size(max = 100)
    public String getBankIban() {
        return (String) get(3);
    }

    /**
     * Setter for <code>SYSTEM.PAYMENTDETAIL.TRANSACTION_TYPE</code>.
     */
    public void setTransactionType(Byte value) {
        set(4, value);
    }

    /**
     * Getter for <code>SYSTEM.PAYMENTDETAIL.TRANSACTION_TYPE</code>.
     */
    public Byte getTransactionType() {
        return (Byte) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<Long, String> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, String, String, String, Byte> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Long, String, String, String, Byte> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Paymentdetail.PAYMENTDETAIL.CUSTOMER_NUMBER;
    }

    @Override
    public Field<String> field2() {
        return Paymentdetail.PAYMENTDETAIL.CHECK_NUMBER;
    }

    @Override
    public Field<String> field3() {
        return Paymentdetail.PAYMENTDETAIL.BANK_NAME;
    }

    @Override
    public Field<String> field4() {
        return Paymentdetail.PAYMENTDETAIL.BANK_IBAN;
    }

    @Override
    public Field<Byte> field5() {
        return Paymentdetail.PAYMENTDETAIL.TRANSACTION_TYPE;
    }

    @Override
    public Long component1() {
        return getCustomerNumber();
    }

    @Override
    public String component2() {
        return getCheckNumber();
    }

    @Override
    public String component3() {
        return getBankName();
    }

    @Override
    public String component4() {
        return getBankIban();
    }

    @Override
    public Byte component5() {
        return getTransactionType();
    }

    @Override
    public Long value1() {
        return getCustomerNumber();
    }

    @Override
    public String value2() {
        return getCheckNumber();
    }

    @Override
    public String value3() {
        return getBankName();
    }

    @Override
    public String value4() {
        return getBankIban();
    }

    @Override
    public Byte value5() {
        return getTransactionType();
    }

    @Override
    public PaymentdetailRecord value1(Long value) {
        setCustomerNumber(value);
        return this;
    }

    @Override
    public PaymentdetailRecord value2(String value) {
        setCheckNumber(value);
        return this;
    }

    @Override
    public PaymentdetailRecord value3(String value) {
        setBankName(value);
        return this;
    }

    @Override
    public PaymentdetailRecord value4(String value) {
        setBankIban(value);
        return this;
    }

    @Override
    public PaymentdetailRecord value5(Byte value) {
        setTransactionType(value);
        return this;
    }

    @Override
    public PaymentdetailRecord values(Long value1, String value2, String value3, String value4, Byte value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PaymentdetailRecord
     */
    public PaymentdetailRecord() {
        super(Paymentdetail.PAYMENTDETAIL);
    }

    /**
     * Create a detached, initialised PaymentdetailRecord
     */
    public PaymentdetailRecord(Long customerNumber, String checkNumber, String bankName, String bankIban, Byte transactionType) {
        super(Paymentdetail.PAYMENTDETAIL);

        setCustomerNumber(customerNumber);
        setCheckNumber(checkNumber);
        setBankName(bankName);
        setBankIban(bankIban);
        setTransactionType(transactionType);
    }
}
