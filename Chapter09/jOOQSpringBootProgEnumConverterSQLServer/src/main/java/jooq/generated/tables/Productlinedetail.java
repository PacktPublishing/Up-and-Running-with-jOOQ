/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import jooq.generated.Dbo;
import jooq.generated.Keys;
import jooq.generated.tables.records.ProductlinedetailRecord;

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
public class Productlinedetail extends TableImpl<ProductlinedetailRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>classicmodels.dbo.productlinedetail</code>
     */
    public static final Productlinedetail PRODUCTLINEDETAIL = new Productlinedetail();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ProductlinedetailRecord> getRecordType() {
        return ProductlinedetailRecord.class;
    }

    /**
     * The column <code>classicmodels.dbo.productlinedetail.product_line</code>.
     */
    public final TableField<ProductlinedetailRecord, String> PRODUCT_LINE = createField(DSL.name("product_line"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>classicmodels.dbo.productlinedetail.code</code>.
     */
    public final TableField<ProductlinedetailRecord, Long> CODE = createField(DSL.name("code"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>classicmodels.dbo.productlinedetail.line_capacity</code>.
     */
    public final TableField<ProductlinedetailRecord, String> LINE_CAPACITY = createField(DSL.name("line_capacity"), SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>classicmodels.dbo.productlinedetail.line_type</code>.
     */
    public final TableField<ProductlinedetailRecord, Integer> LINE_TYPE = createField(DSL.name("line_type"), SQLDataType.INTEGER.defaultValue(DSL.field("((0))", SQLDataType.INTEGER)), this, "");

    private Productlinedetail(Name alias, Table<ProductlinedetailRecord> aliased) {
        this(alias, aliased, null);
    }

    private Productlinedetail(Name alias, Table<ProductlinedetailRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>classicmodels.dbo.productlinedetail</code> table reference
     */
    public Productlinedetail(String alias) {
        this(DSL.name(alias), PRODUCTLINEDETAIL);
    }

    /**
     * Create an aliased <code>classicmodels.dbo.productlinedetail</code> table reference
     */
    public Productlinedetail(Name alias) {
        this(alias, PRODUCTLINEDETAIL);
    }

    /**
     * Create a <code>classicmodels.dbo.productlinedetail</code> table reference
     */
    public Productlinedetail() {
        this(DSL.name("productlinedetail"), null);
    }

    public <O extends Record> Productlinedetail(Table<O> child, ForeignKey<O, ProductlinedetailRecord> key) {
        super(child, key, PRODUCTLINEDETAIL);
    }

    @Override
    public Schema getSchema() {
        return Dbo.DBO;
    }

    @Override
    public UniqueKey<ProductlinedetailRecord> getPrimaryKey() {
        return Keys.PRODUCTLINEDETAIL__PK__PRODUCTL__B45DC9CD5D823647;
    }

    @Override
    public List<UniqueKey<ProductlinedetailRecord>> getKeys() {
        return Arrays.<UniqueKey<ProductlinedetailRecord>>asList(Keys.PRODUCTLINEDETAIL__PK__PRODUCTL__B45DC9CD5D823647, Keys.PRODUCTLINEDETAIL__UNIQUE_PRODUCT_LINE_DETAIL);
    }

    @Override
    public List<ForeignKey<ProductlinedetailRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ProductlinedetailRecord, ?>>asList(Keys.PRODUCTLINEDETAIL_IBFK_1, Keys.PRODUCTLINEDETAIL_IBFK_2);
    }

    public Productline productlinedetailIbfk_1() {
        return new Productline(this, Keys.PRODUCTLINEDETAIL_IBFK_1);
    }

    public Productline productlinedetailIbfk_2() {
        return new Productline(this, Keys.PRODUCTLINEDETAIL_IBFK_2);
    }

    @Override
    public Productlinedetail as(String alias) {
        return new Productlinedetail(DSL.name(alias), this);
    }

    @Override
    public Productlinedetail as(Name alias) {
        return new Productlinedetail(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Productlinedetail rename(String name) {
        return new Productlinedetail(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Productlinedetail rename(Name name) {
        return new Productlinedetail(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<String, Long, String, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}
