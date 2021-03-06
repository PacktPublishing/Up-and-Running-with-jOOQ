/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import jooq.generated.Keys;
import jooq.generated.Public;
import jooq.generated.tables.records.ManagerRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
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
        "jOOQ version:3.13.4",
        "schema version:1.1"
    },
    date = "2020-10-19T13:52:35.609Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Manager extends TableImpl<ManagerRecord> {

    private static final long serialVersionUID = -210900734;

    /**
     * The reference instance of <code>public.manager</code>
     */
    public static final Manager MANAGER = new Manager();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ManagerRecord> getRecordType() {
        return ManagerRecord.class;
    }

    /**
     * The column <code>public.manager.manager_id</code>.
     */
    public final TableField<ManagerRecord, Long> MANAGER_ID = createField(DSL.name("manager_id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('manager_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.manager.manager_name</code>.
     */
    public final TableField<ManagerRecord, String> MANAGER_NAME = createField(DSL.name("manager_name"), org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * Create a <code>public.manager</code> table reference
     */
    public Manager() {
        this(DSL.name("manager"), null);
    }

    /**
     * Create an aliased <code>public.manager</code> table reference
     */
    public Manager(String alias) {
        this(DSL.name(alias), MANAGER);
    }

    /**
     * Create an aliased <code>public.manager</code> table reference
     */
    public Manager(Name alias) {
        this(alias, MANAGER);
    }

    private Manager(Name alias, Table<ManagerRecord> aliased) {
        this(alias, aliased, null);
    }

    private Manager(Name alias, Table<ManagerRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Manager(Table<O> child, ForeignKey<O, ManagerRecord> key) {
        super(child, key, MANAGER);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<ManagerRecord, Long> getIdentity() {
        return Keys.IDENTITY_MANAGER;
    }

    @Override
    public UniqueKey<ManagerRecord> getPrimaryKey() {
        return Keys.MANAGER_PKEY;
    }

    @Override
    public List<UniqueKey<ManagerRecord>> getKeys() {
        return Arrays.<UniqueKey<ManagerRecord>>asList(Keys.MANAGER_PKEY);
    }

    @Override
    public Manager as(String alias) {
        return new Manager(DSL.name(alias), this);
    }

    @Override
    public Manager as(Name alias) {
        return new Manager(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Manager rename(String name) {
        return new Manager(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Manager rename(Name name) {
        return new Manager(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Long, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
