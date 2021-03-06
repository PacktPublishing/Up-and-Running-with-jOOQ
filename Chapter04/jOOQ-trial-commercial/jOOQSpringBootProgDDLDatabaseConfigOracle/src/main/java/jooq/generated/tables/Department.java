/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables;


import java.util.Arrays;
import java.util.List;

import jooq.generated.DefaultSchema;
import jooq.generated.Keys;
import jooq.generated.tables.records.DepartmentRecord;

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
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Department extends TableImpl<DepartmentRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>DEPARTMENT</code>
     */
    public static final Department DEPARTMENT = new Department();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DepartmentRecord> getRecordType() {
        return DepartmentRecord.class;
    }

    /**
     * The column <code>DEPARTMENT.DEPARTMENT_ID</code>.
     */
    public final TableField<DepartmentRecord, Long> DEPARTMENT_ID = createField(DSL.name("DEPARTMENT_ID"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DEPARTMENT.NAME</code>.
     */
    public final TableField<DepartmentRecord, String> NAME = createField(DSL.name("NAME"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>DEPARTMENT.PHONE</code>.
     */
    public final TableField<DepartmentRecord, String> PHONE = createField(DSL.name("PHONE"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>DEPARTMENT.CODE</code>.
     */
    public final TableField<DepartmentRecord, Integer> CODE = createField(DSL.name("CODE"), SQLDataType.INTEGER.defaultValue(DSL.field("1", SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>DEPARTMENT.OFFICE_CODE</code>.
     */
    public final TableField<DepartmentRecord, String> OFFICE_CODE = createField(DSL.name("OFFICE_CODE"), SQLDataType.VARCHAR(10).nullable(false), this, "");

    private Department(Name alias, Table<DepartmentRecord> aliased) {
        this(alias, aliased, null);
    }

    private Department(Name alias, Table<DepartmentRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>DEPARTMENT</code> table reference
     */
    public Department(String alias) {
        this(DSL.name(alias), DEPARTMENT);
    }

    /**
     * Create an aliased <code>DEPARTMENT</code> table reference
     */
    public Department(Name alias) {
        this(alias, DEPARTMENT);
    }

    /**
     * Create a <code>DEPARTMENT</code> table reference
     */
    public Department() {
        this(DSL.name("DEPARTMENT"), null);
    }

    public <O extends Record> Department(Table<O> child, ForeignKey<O, DepartmentRecord> key) {
        super(child, key, DEPARTMENT);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<DepartmentRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_4;
    }

    @Override
    public List<UniqueKey<DepartmentRecord>> getKeys() {
        return Arrays.<UniqueKey<DepartmentRecord>>asList(Keys.CONSTRAINT_4);
    }

    @Override
    public List<ForeignKey<DepartmentRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<DepartmentRecord, ?>>asList(Keys.DEPARTMENT_IBFK_1);
    }

    public Office office() {
        return new Office(this, Keys.DEPARTMENT_IBFK_1);
    }

    @Override
    public Department as(String alias) {
        return new Department(DSL.name(alias), this);
    }

    @Override
    public Department as(Name alias) {
        return new Department(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Department rename(String name) {
        return new Department(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Department rename(Name name) {
        return new Department(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, String, String, Integer, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
