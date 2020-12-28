/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import jooq.generated.Classicmodels;
import jooq.generated.Keys;
import jooq.generated.tables.records.PaymentRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


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
public class Payment extends TableImpl<PaymentRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>classicmodels.payment</code>
     */
    public static final Payment PAYMENT = new Payment();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PaymentRecord> getRecordType() {
        return PaymentRecord.class;
    }

    /**
     * The column <code>classicmodels.payment.customer_number</code>.
     */
    public final TableField<PaymentRecord, Long> CUSTOMER_NUMBER = createField(DSL.name("customer_number"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>classicmodels.payment.check_number</code>.
     */
    public final TableField<PaymentRecord, String> CHECK_NUMBER = createField(DSL.name("check_number"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>classicmodels.payment.payment_date</code>.
     */
    public final TableField<PaymentRecord, LocalDateTime> PAYMENT_DATE = createField(DSL.name("payment_date"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "");

    /**
     * The column <code>classicmodels.payment.invoice_amount</code>.
     */
    public final TableField<PaymentRecord, BigDecimal> INVOICE_AMOUNT = createField(DSL.name("invoice_amount"), SQLDataType.DECIMAL(10, 2).nullable(false), this, "");

    /**
     * The column <code>classicmodels.payment.caching_date</code>.
     */
    public final TableField<PaymentRecord, LocalDateTime> CACHING_DATE = createField(DSL.name("caching_date"), SQLDataType.LOCALDATETIME(0), this, "");

    private Payment(Name alias, Table<PaymentRecord> aliased) {
        this(alias, aliased, null);
    }

    private Payment(Name alias, Table<PaymentRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>classicmodels.payment</code> table reference
     */
    public Payment(String alias) {
        this(DSL.name(alias), PAYMENT);
    }

    /**
     * Create an aliased <code>classicmodels.payment</code> table reference
     */
    public Payment(Name alias) {
        this(alias, PAYMENT);
    }

    /**
     * Create a <code>classicmodels.payment</code> table reference
     */
    public Payment() {
        this(DSL.name("payment"), null);
    }

    public <O extends Record> Payment(Table<O> child, ForeignKey<O, PaymentRecord> key) {
        super(child, key, PAYMENT);
    }

    @Override
    public Schema getSchema() {
        return Classicmodels.CLASSICMODELS;
    }

    @Override
    public UniqueKey<PaymentRecord> getPrimaryKey() {
        return Keys.KEY_PAYMENT_PRIMARY;
    }

    @Override
    public List<UniqueKey<PaymentRecord>> getKeys() {
        return Arrays.<UniqueKey<PaymentRecord>>asList(Keys.KEY_PAYMENT_PRIMARY, Keys.KEY_PAYMENT_UNIQUE_CHECK_NUMBER);
    }

    @Override
    public List<ForeignKey<PaymentRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<PaymentRecord, ?>>asList(Keys.PAYMENTS_IBFK_1);
    }

    public Customer customer() {
        return new Customer(this, Keys.PAYMENTS_IBFK_1);
    }

    @Override
    public Payment as(String alias) {
        return new Payment(DSL.name(alias), this);
    }

    @Override
    public Payment as(Name alias) {
        return new Payment(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Payment rename(String name) {
        return new Payment(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Payment rename(Name name) {
        return new Payment(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, String, LocalDateTime, BigDecimal, LocalDateTime> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
