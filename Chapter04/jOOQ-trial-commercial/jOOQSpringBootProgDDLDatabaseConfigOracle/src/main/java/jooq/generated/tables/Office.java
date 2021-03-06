/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables;


import java.util.Arrays;
import java.util.List;

import jooq.generated.DefaultSchema;
import jooq.generated.Keys;
import jooq.generated.tables.records.OfficeRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row9;
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
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Office extends TableImpl<OfficeRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>OFFICE</code>
     */
    public static final Office OFFICE = new Office();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OfficeRecord> getRecordType() {
        return OfficeRecord.class;
    }

    /**
     * The column <code>OFFICE.OFFICE_CODE</code>.
     */
    public final TableField<OfficeRecord, String> OFFICE_CODE = createField(DSL.name("OFFICE_CODE"), SQLDataType.VARCHAR(10).nullable(false), this, "");

    /**
     * The column <code>OFFICE.CITY</code>.
     */
    public final TableField<OfficeRecord, String> CITY = createField(DSL.name("CITY"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>OFFICE.PHONE</code>.
     */
    public final TableField<OfficeRecord, String> PHONE = createField(DSL.name("PHONE"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>OFFICE.ADDRESS_LINE_FIRST</code>.
     */
    public final TableField<OfficeRecord, String> ADDRESS_LINE_FIRST = createField(DSL.name("ADDRESS_LINE_FIRST"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>OFFICE.ADDRESS_LINE_SECOND</code>.
     */
    public final TableField<OfficeRecord, String> ADDRESS_LINE_SECOND = createField(DSL.name("ADDRESS_LINE_SECOND"), SQLDataType.VARCHAR(50).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>OFFICE.STATE</code>.
     */
    public final TableField<OfficeRecord, String> STATE = createField(DSL.name("STATE"), SQLDataType.VARCHAR(50).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>OFFICE.COUNTRY</code>.
     */
    public final TableField<OfficeRecord, String> COUNTRY = createField(DSL.name("COUNTRY"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>OFFICE.POSTAL_CODE</code>.
     */
    public final TableField<OfficeRecord, String> POSTAL_CODE = createField(DSL.name("POSTAL_CODE"), SQLDataType.VARCHAR(15).nullable(false), this, "");

    /**
     * The column <code>OFFICE.TERRITORY</code>.
     */
    public final TableField<OfficeRecord, String> TERRITORY = createField(DSL.name("TERRITORY"), SQLDataType.VARCHAR(10).nullable(false), this, "");

    private Office(Name alias, Table<OfficeRecord> aliased) {
        this(alias, aliased, null);
    }

    private Office(Name alias, Table<OfficeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>OFFICE</code> table reference
     */
    public Office(String alias) {
        this(DSL.name(alias), OFFICE);
    }

    /**
     * Create an aliased <code>OFFICE</code> table reference
     */
    public Office(Name alias) {
        this(alias, OFFICE);
    }

    /**
     * Create a <code>OFFICE</code> table reference
     */
    public Office() {
        this(DSL.name("OFFICE"), null);
    }

    public <O extends Record> Office(Table<O> child, ForeignKey<O, OfficeRecord> key) {
        super(child, key, OFFICE);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<OfficeRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_8;
    }

    @Override
    public List<UniqueKey<OfficeRecord>> getKeys() {
        return Arrays.<UniqueKey<OfficeRecord>>asList(Keys.CONSTRAINT_8);
    }

    @Override
    public Office as(String alias) {
        return new Office(DSL.name(alias), this);
    }

    @Override
    public Office as(Name alias) {
        return new Office(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Office rename(String name) {
        return new Office(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Office rename(Name name) {
        return new Office(name, null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<String, String, String, String, String, String, String, String, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }
}
