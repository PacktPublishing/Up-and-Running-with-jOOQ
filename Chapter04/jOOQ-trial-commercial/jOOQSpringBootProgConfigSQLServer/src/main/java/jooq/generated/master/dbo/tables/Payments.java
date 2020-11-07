/*
 * This file is generated by jOOQ.
 */
package jooq.generated.master.dbo.tables;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import jooq.generated.master.dbo.Dbo;
import jooq.generated.master.dbo.Keys;
import jooq.generated.master.dbo.tables.records.PaymentsRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.5",
        "schema version:1.1"
    },
    date = "2020-10-31T06:19:36.439Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Payments extends TableImpl<PaymentsRecord> {

    private static final long serialVersionUID = 823683859;

    /**
     * The reference instance of <code>master.dbo.payments</code>
     */
    public static final Payments PAYMENTS = new Payments();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PaymentsRecord> getRecordType() {
        return PaymentsRecord.class;
    }

    /**
     * The column <code>master.dbo.payments.customerNumber</code>.
     */
    public final TableField<PaymentsRecord, Integer> CUSTOMERNUMBER = createField(DSL.name("customerNumber"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>master.dbo.payments.checkNumber</code>.
     */
    public final TableField<PaymentsRecord, String> CHECKNUMBER = createField(DSL.name("checkNumber"), org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>master.dbo.payments.paymentDate</code>.
     */
    public final TableField<PaymentsRecord, LocalDate> PAYMENTDATE = createField(DSL.name("paymentDate"), org.jooq.impl.SQLDataType.LOCALDATE.nullable(false), this, "");

    /**
     * The column <code>master.dbo.payments.amount</code>.
     */
    public final TableField<PaymentsRecord, BigDecimal> AMOUNT = createField(DSL.name("amount"), org.jooq.impl.SQLDataType.NUMERIC(10, 2).nullable(false), this, "");

    /**
     * Create a <code>master.dbo.payments</code> table reference
     */
    public Payments() {
        this(DSL.name("payments"), null);
    }

    /**
     * Create an aliased <code>master.dbo.payments</code> table reference
     */
    public Payments(String alias) {
        this(DSL.name(alias), PAYMENTS);
    }

    /**
     * Create an aliased <code>master.dbo.payments</code> table reference
     */
    public Payments(Name alias) {
        this(alias, PAYMENTS);
    }

    private Payments(Name alias, Table<PaymentsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Payments(Name alias, Table<PaymentsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Payments(Table<O> child, ForeignKey<O, PaymentsRecord> key) {
        super(child, key, PAYMENTS);
    }

    @Override
    public Schema getSchema() {
        return Dbo.DBO;
    }

    @Override
    public UniqueKey<PaymentsRecord> getPrimaryKey() {
        return Keys.PAYMENTS__PK__PAYMENTS__6C3E46E65F42F546;
    }

    @Override
    public List<UniqueKey<PaymentsRecord>> getKeys() {
        return Arrays.<UniqueKey<PaymentsRecord>>asList(Keys.PAYMENTS__PK__PAYMENTS__6C3E46E65F42F546);
    }

    @Override
    public List<ForeignKey<PaymentsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<PaymentsRecord, ?>>asList(Keys.PAYMENTS_IBFK_1);
    }

    public Customers customers() {
        return new Customers(this, Keys.PAYMENTS_IBFK_1);
    }

    @Override
    public Payments as(String alias) {
        return new Payments(DSL.name(alias), this);
    }

    @Override
    public Payments as(Name alias) {
        return new Payments(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Payments rename(String name) {
        return new Payments(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Payments rename(Name name) {
        return new Payments(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, LocalDate, BigDecimal> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}