/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import jooq.generated.Dbo;
import jooq.generated.Keys;
import jooq.generated.tables.records.CustomerdetailRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row7;
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
public class Customerdetail extends TableImpl<CustomerdetailRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>classicmodels.dbo.customerdetail</code>
     */
    public static final Customerdetail CUSTOMERDETAIL = new Customerdetail();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CustomerdetailRecord> getRecordType() {
        return CustomerdetailRecord.class;
    }

    /**
     * The column <code>classicmodels.dbo.customerdetail.customer_number</code>.
     */
    public final TableField<CustomerdetailRecord, Long> CUSTOMER_NUMBER = createField(DSL.name("customer_number"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>classicmodels.dbo.customerdetail.address_line_first</code>.
     */
    public final TableField<CustomerdetailRecord, String> ADDRESS_LINE_FIRST = createField(DSL.name("address_line_first"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>classicmodels.dbo.customerdetail.address_line_second</code>.
     */
    public final TableField<CustomerdetailRecord, String> ADDRESS_LINE_SECOND = createField(DSL.name("address_line_second"), SQLDataType.VARCHAR(50).defaultValue(DSL.field("(NULL)", SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>classicmodels.dbo.customerdetail.city</code>.
     */
    public final TableField<CustomerdetailRecord, String> CITY = createField(DSL.name("city"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>classicmodels.dbo.customerdetail.state</code>.
     */
    public final TableField<CustomerdetailRecord, String> STATE = createField(DSL.name("state"), SQLDataType.VARCHAR(50).defaultValue(DSL.field("(NULL)", SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>classicmodels.dbo.customerdetail.postal_code</code>.
     */
    public final TableField<CustomerdetailRecord, String> POSTAL_CODE = createField(DSL.name("postal_code"), SQLDataType.VARCHAR(15).defaultValue(DSL.field("(NULL)", SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>classicmodels.dbo.customerdetail.country</code>.
     */
    public final TableField<CustomerdetailRecord, String> COUNTRY = createField(DSL.name("country"), SQLDataType.VARCHAR(50), this, "");

    private Customerdetail(Name alias, Table<CustomerdetailRecord> aliased) {
        this(alias, aliased, null);
    }

    private Customerdetail(Name alias, Table<CustomerdetailRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>classicmodels.dbo.customerdetail</code> table reference
     */
    public Customerdetail(String alias) {
        this(DSL.name(alias), CUSTOMERDETAIL);
    }

    /**
     * Create an aliased <code>classicmodels.dbo.customerdetail</code> table reference
     */
    public Customerdetail(Name alias) {
        this(alias, CUSTOMERDETAIL);
    }

    /**
     * Create a <code>classicmodels.dbo.customerdetail</code> table reference
     */
    public Customerdetail() {
        this(DSL.name("customerdetail"), null);
    }

    public <O extends Record> Customerdetail(Table<O> child, ForeignKey<O, CustomerdetailRecord> key) {
        super(child, key, CUSTOMERDETAIL);
    }

    @Override
    public Schema getSchema() {
        return Dbo.DBO;
    }

    @Override
    public UniqueKey<CustomerdetailRecord> getPrimaryKey() {
        return Keys.CUSTOMERDETAIL__PK__CUSTOMER__F38611D5AEC4AD8A;
    }

    @Override
    public List<UniqueKey<CustomerdetailRecord>> getKeys() {
        return Arrays.<UniqueKey<CustomerdetailRecord>>asList(Keys.CUSTOMERDETAIL__PK__CUSTOMER__F38611D5AEC4AD8A);
    }

    @Override
    public List<ForeignKey<CustomerdetailRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<CustomerdetailRecord, ?>>asList(Keys.CUSTOMERS_DETAILS_IBFK_1);
    }

    public Customer customer() {
        return new Customer(this, Keys.CUSTOMERS_DETAILS_IBFK_1);
    }

    @Override
    public Customerdetail as(String alias) {
        return new Customerdetail(DSL.name(alias), this);
    }

    @Override
    public Customerdetail as(Name alias) {
        return new Customerdetail(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Customerdetail rename(String name) {
        return new Customerdetail(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Customerdetail rename(Name name) {
        return new Customerdetail(name, null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<Long, String, String, String, String, String, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }
}
