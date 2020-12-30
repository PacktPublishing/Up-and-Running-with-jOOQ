/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import jooq.generated.Keys;
import jooq.generated.Public;
import jooq.generated.tables.records.Top3productRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
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
    date = "2020-12-28T06:34:31.202Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Top3product extends TableImpl<Top3productRecord> {

    private static final long serialVersionUID = -1161925911;

    /**
     * The reference instance of <code>public.top3product</code>
     */
    public static final Top3product TOP3PRODUCT = new Top3product();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Top3productRecord> getRecordType() {
        return Top3productRecord.class;
    }

    /**
     * The column <code>public.top3product.product_id</code>.
     */
    public final TableField<Top3productRecord, Long> PRODUCT_ID = createField(DSL.name("product_id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.top3product.product_name</code>.
     */
    public final TableField<Top3productRecord, String> PRODUCT_NAME = createField(DSL.name("product_name"), org.jooq.impl.SQLDataType.VARCHAR(70).defaultValue(org.jooq.impl.DSL.field("NULL::character varying", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * Create a <code>public.top3product</code> table reference
     */
    public Top3product() {
        this(DSL.name("top3product"), null);
    }

    /**
     * Create an aliased <code>public.top3product</code> table reference
     */
    public Top3product(String alias) {
        this(DSL.name(alias), TOP3PRODUCT);
    }

    /**
     * Create an aliased <code>public.top3product</code> table reference
     */
    public Top3product(Name alias) {
        this(alias, TOP3PRODUCT);
    }

    private Top3product(Name alias, Table<Top3productRecord> aliased) {
        this(alias, aliased, null);
    }

    private Top3product(Name alias, Table<Top3productRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Top3product(Table<O> child, ForeignKey<O, Top3productRecord> key) {
        super(child, key, TOP3PRODUCT);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<Top3productRecord> getPrimaryKey() {
        return Keys.TOP3PRODUCT_PKEY;
    }

    @Override
    public List<UniqueKey<Top3productRecord>> getKeys() {
        return Arrays.<UniqueKey<Top3productRecord>>asList(Keys.TOP3PRODUCT_PKEY);
    }

    @Override
    public List<ForeignKey<Top3productRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<Top3productRecord, ?>>asList(Keys.TOP3PRODUCT__TOP3PRODUCT_IBFK_1);
    }

    public Product product() {
        return new Product(this, Keys.TOP3PRODUCT__TOP3PRODUCT_IBFK_1);
    }

    @Override
    public Top3product as(String alias) {
        return new Top3product(DSL.name(alias), this);
    }

    @Override
    public Top3product as(Name alias) {
        return new Top3product(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Top3product rename(String name) {
        return new Top3product(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Top3product rename(Name name) {
        return new Top3product(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Long, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}