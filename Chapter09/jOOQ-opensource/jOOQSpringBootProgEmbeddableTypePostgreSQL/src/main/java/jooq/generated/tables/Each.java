/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables;


import javax.annotation.processing.Generated;

import jooq.generated.Public;
import jooq.generated.tables.records.EachRecord;

import org.jooq.Field;
import org.jooq.Name;
import org.jooq.Row2;
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
public class Each extends TableImpl<EachRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.each</code>
     */
    public static final Each EACH = new Each();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<EachRecord> getRecordType() {
        return EachRecord.class;
    }

    /**
     * The column <code>public.each.key</code>.
     */
    public final TableField<EachRecord, String> KEY = createField(DSL.name("key"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.each.value</code>.
     */
    public final TableField<EachRecord, String> VALUE = createField(DSL.name("value"), SQLDataType.CLOB, this, "");

    private Each(Name alias, Table<EachRecord> aliased) {
        this(alias, aliased, new Field[1]);
    }

    private Each(Name alias, Table<EachRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.function());
    }

    /**
     * Create an aliased <code>public.each</code> table reference
     */
    public Each(String alias) {
        this(DSL.name(alias), EACH);
    }

    /**
     * Create an aliased <code>public.each</code> table reference
     */
    public Each(Name alias) {
        this(alias, EACH);
    }

    /**
     * Create a <code>public.each</code> table reference
     */
    public Each() {
        this(DSL.name("each"), null);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Each as(String alias) {
        return new Each(DSL.name(alias), this, parameters);
    }

    @Override
    public Each as(Name alias) {
        return new Each(alias, this, parameters);
    }

    /**
     * Rename this table
     */
    @Override
    public Each rename(String name) {
        return new Each(DSL.name(name), null, parameters);
    }

    /**
     * Rename this table
     */
    @Override
    public Each rename(Name name) {
        return new Each(name, null, parameters);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * Call this table-valued function
     */
    public Each call(
          Object hs
    ) {
        Each result = new Each(DSL.name("each"), null, new Field[] {
              DSL.val(hs, org.jooq.impl.DefaultDataType.getDefaultDataType("\"public\".\"hstore\""))
        });

        return aliased() ? result.as(getUnqualifiedName()) : result;
    }

    /**
     * Call this table-valued function
     */
    public Each call(
          Field<Object> hs
    ) {
        Each result = new Each(DSL.name("each"), null, new Field[] {
              hs
        });

        return aliased() ? result.as(getUnqualifiedName()) : result;
    }
}
