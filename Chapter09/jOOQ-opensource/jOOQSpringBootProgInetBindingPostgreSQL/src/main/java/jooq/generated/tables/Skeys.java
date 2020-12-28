/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables;


import javax.annotation.processing.Generated;

import jooq.generated.Public;
import jooq.generated.tables.records.SkeysRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row1;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.4",
        "schema version:1.1"
    },
    date = "2020-12-28T06:34:31.202Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Skeys extends TableImpl<SkeysRecord> {

    private static final long serialVersionUID = -365838685;

    /**
     * The reference instance of <code>public.skeys</code>
     */
    public static final Skeys SKEYS = new Skeys();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SkeysRecord> getRecordType() {
        return SkeysRecord.class;
    }

    /**
     * The column <code>public.skeys.skeys</code>.
     */
    public final TableField<SkeysRecord, String> SKEYS_ = createField(DSL.name("skeys"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>public.skeys</code> table reference
     */
    public Skeys() {
        this(DSL.name("skeys"), null);
    }

    /**
     * Create an aliased <code>public.skeys</code> table reference
     */
    public Skeys(String alias) {
        this(DSL.name(alias), SKEYS);
    }

    /**
     * Create an aliased <code>public.skeys</code> table reference
     */
    public Skeys(Name alias) {
        this(alias, SKEYS);
    }

    private Skeys(Name alias, Table<SkeysRecord> aliased) {
        this(alias, aliased, new Field[1]);
    }

    private Skeys(Name alias, Table<SkeysRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.function());
    }

    public <O extends Record> Skeys(Table<O> child, ForeignKey<O, SkeysRecord> key) {
        super(child, key, SKEYS);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Skeys as(String alias) {
        return new Skeys(DSL.name(alias), this, parameters);
    }

    @Override
    public Skeys as(Name alias) {
        return new Skeys(alias, this, parameters);
    }

    /**
     * Rename this table
     */
    @Override
    public Skeys rename(String name) {
        return new Skeys(DSL.name(name), null, parameters);
    }

    /**
     * Rename this table
     */
    @Override
    public Skeys rename(Name name) {
        return new Skeys(name, null, parameters);
    }

    // -------------------------------------------------------------------------
    // Row1 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row1<String> fieldsRow() {
        return (Row1) super.fieldsRow();
    }

    /**
     * Call this table-valued function
     */
    public Skeys call(Object __1) {
        return new Skeys(DSL.name(getName()), null, new Field[] { 
              DSL.val(__1, org.jooq.impl.DefaultDataType.getDefaultDataType("\"public\".\"hstore\""))
        });
    }

    /**
     * Call this table-valued function
     */
    public Skeys call(Field<Object> __1) {
        return new Skeys(DSL.name(getName()), null, new Field[] { 
              __1
        });
    }
}