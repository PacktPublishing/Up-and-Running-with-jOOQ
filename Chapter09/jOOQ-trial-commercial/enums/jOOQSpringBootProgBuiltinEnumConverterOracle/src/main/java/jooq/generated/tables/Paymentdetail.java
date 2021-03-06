/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import jooq.generated.Keys;
import jooq.generated.System;
import jooq.generated.tables.records.PaymentdetailRecord;

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
public class Paymentdetail extends TableImpl<PaymentdetailRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>SYSTEM.PAYMENTDETAIL</code>
     */
    public static final Paymentdetail PAYMENTDETAIL = new Paymentdetail();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PaymentdetailRecord> getRecordType() {
        return PaymentdetailRecord.class;
    }

    /**
     * The column <code>SYSTEM.PAYMENTDETAIL.CUSTOMER_NUMBER</code>.
     */
    public final TableField<PaymentdetailRecord, Long> CUSTOMER_NUMBER = createField(DSL.name("CUSTOMER_NUMBER"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>SYSTEM.PAYMENTDETAIL.CHECK_NUMBER</code>.
     */
    public final TableField<PaymentdetailRecord, String> CHECK_NUMBER = createField(DSL.name("CHECK_NUMBER"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>SYSTEM.PAYMENTDETAIL.BANK_NAME</code>.
     */
    public final TableField<PaymentdetailRecord, String> BANK_NAME = createField(DSL.name("BANK_NAME"), SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>SYSTEM.PAYMENTDETAIL.BANK_IBAN</code>.
     */
    public final TableField<PaymentdetailRecord, String> BANK_IBAN = createField(DSL.name("BANK_IBAN"), SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>SYSTEM.PAYMENTDETAIL.TRANSACTION_TYPE</code>.
     */
    public final TableField<PaymentdetailRecord, Byte> TRANSACTION_TYPE = createField(DSL.name("TRANSACTION_TYPE"), SQLDataType.TINYINT.defaultValue(DSL.field("0", SQLDataType.TINYINT)), this, "");

    private Paymentdetail(Name alias, Table<PaymentdetailRecord> aliased) {
        this(alias, aliased, null);
    }

    private Paymentdetail(Name alias, Table<PaymentdetailRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>SYSTEM.PAYMENTDETAIL</code> table reference
     */
    public Paymentdetail(String alias) {
        this(DSL.name(alias), PAYMENTDETAIL);
    }

    /**
     * Create an aliased <code>SYSTEM.PAYMENTDETAIL</code> table reference
     */
    public Paymentdetail(Name alias) {
        this(alias, PAYMENTDETAIL);
    }

    /**
     * Create a <code>SYSTEM.PAYMENTDETAIL</code> table reference
     */
    public Paymentdetail() {
        this(DSL.name("PAYMENTDETAIL"), null);
    }

    public <O extends Record> Paymentdetail(Table<O> child, ForeignKey<O, PaymentdetailRecord> key) {
        super(child, key, PAYMENTDETAIL);
    }

    @Override
    public Schema getSchema() {
        return System.SYSTEM;
    }

    @Override
    public UniqueKey<PaymentdetailRecord> getPrimaryKey() {
        return Keys.SYS_C008049;
    }

    @Override
    public List<UniqueKey<PaymentdetailRecord>> getKeys() {
        return Arrays.<UniqueKey<PaymentdetailRecord>>asList(Keys.SYS_C008049);
    }

    @Override
    public Paymentdetail as(String alias) {
        return new Paymentdetail(DSL.name(alias), this);
    }

    @Override
    public Paymentdetail as(Name alias) {
        return new Paymentdetail(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Paymentdetail rename(String name) {
        return new Paymentdetail(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Paymentdetail rename(Name name) {
        return new Paymentdetail(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, String, String, String, Byte> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
