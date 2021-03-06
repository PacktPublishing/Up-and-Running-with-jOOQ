/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables;


import java.math.BigDecimal;
import java.time.LocalDate;

import javax.annotation.processing.Generated;

import jooq.generated.System;
import jooq.generated.tables.records.ProductPrivsRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row8;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
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
public class ProductPrivs extends TableImpl<ProductPrivsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>SYSTEM.PRODUCT_PRIVS</code>
     */
    public static final ProductPrivs PRODUCT_PRIVS = new ProductPrivs();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ProductPrivsRecord> getRecordType() {
        return ProductPrivsRecord.class;
    }

    /**
     * The column <code>SYSTEM.PRODUCT_PRIVS.PRODUCT</code>.
     */
    public final TableField<ProductPrivsRecord, String> PRODUCT = createField(DSL.name("PRODUCT"), SQLDataType.VARCHAR(30).nullable(false), this, "");

    /**
     * The column <code>SYSTEM.PRODUCT_PRIVS.USERID</code>.
     */
    public final TableField<ProductPrivsRecord, String> USERID = createField(DSL.name("USERID"), SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>SYSTEM.PRODUCT_PRIVS.ATTRIBUTE</code>.
     */
    public final TableField<ProductPrivsRecord, String> ATTRIBUTE = createField(DSL.name("ATTRIBUTE"), SQLDataType.VARCHAR(240), this, "");

    /**
     * The column <code>SYSTEM.PRODUCT_PRIVS.SCOPE</code>.
     */
    public final TableField<ProductPrivsRecord, String> SCOPE = createField(DSL.name("SCOPE"), SQLDataType.VARCHAR(240), this, "");

    /**
     * The column <code>SYSTEM.PRODUCT_PRIVS.NUMERIC_VALUE</code>.
     */
    public final TableField<ProductPrivsRecord, BigDecimal> NUMERIC_VALUE = createField(DSL.name("NUMERIC_VALUE"), SQLDataType.NUMERIC(15, 2), this, "");

    /**
     * The column <code>SYSTEM.PRODUCT_PRIVS.CHAR_VALUE</code>.
     */
    public final TableField<ProductPrivsRecord, String> CHAR_VALUE = createField(DSL.name("CHAR_VALUE"), SQLDataType.VARCHAR(240), this, "");

    /**
     * The column <code>SYSTEM.PRODUCT_PRIVS.DATE_VALUE</code>.
     */
    public final TableField<ProductPrivsRecord, LocalDate> DATE_VALUE = createField(DSL.name("DATE_VALUE"), SQLDataType.LOCALDATE, this, "");

    /**
     * The column <code>SYSTEM.PRODUCT_PRIVS.LONG_VALUE</code>.
     */
    public final TableField<ProductPrivsRecord, String> LONG_VALUE = createField(DSL.name("LONG_VALUE"), SQLDataType.CLOB, this, "");

    private ProductPrivs(Name alias, Table<ProductPrivsRecord> aliased) {
        this(alias, aliased, null);
    }

    private ProductPrivs(Name alias, Table<ProductPrivsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.view("create view \"PRODUCT_PRIVS\" as SELECT PRODUCT, USERID, ATTRIBUTE, SCOPE,\n         NUMERIC_VALUE, CHAR_VALUE, DATE_VALUE, LONG_VALUE\n  FROM SQLPLUS_PRODUCT_PROFILE\n  WHERE USERID = 'PUBLIC' OR\n        USERID LIKE SYS_CONTEXT('USERENV','CURRENT_USER')"));
    }

    /**
     * Create an aliased <code>SYSTEM.PRODUCT_PRIVS</code> table reference
     */
    public ProductPrivs(String alias) {
        this(DSL.name(alias), PRODUCT_PRIVS);
    }

    /**
     * Create an aliased <code>SYSTEM.PRODUCT_PRIVS</code> table reference
     */
    public ProductPrivs(Name alias) {
        this(alias, PRODUCT_PRIVS);
    }

    /**
     * Create a <code>SYSTEM.PRODUCT_PRIVS</code> table reference
     */
    public ProductPrivs() {
        this(DSL.name("PRODUCT_PRIVS"), null);
    }

    public <O extends Record> ProductPrivs(Table<O> child, ForeignKey<O, ProductPrivsRecord> key) {
        super(child, key, PRODUCT_PRIVS);
    }

    @Override
    public Schema getSchema() {
        return System.SYSTEM;
    }

    @Override
    public ProductPrivs as(String alias) {
        return new ProductPrivs(DSL.name(alias), this);
    }

    @Override
    public ProductPrivs as(Name alias) {
        return new ProductPrivs(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ProductPrivs rename(String name) {
        return new ProductPrivs(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ProductPrivs rename(Name name) {
        return new ProductPrivs(name, null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<String, String, String, String, BigDecimal, String, LocalDate, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }
}
