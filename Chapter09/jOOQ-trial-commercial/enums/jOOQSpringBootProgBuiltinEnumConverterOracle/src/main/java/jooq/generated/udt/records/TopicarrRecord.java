/*
 * This file is generated by jOOQ.
 */
package jooq.generated.udt.records;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.annotation.processing.Generated;

import jooq.generated.System;

import org.jooq.Configuration;
import org.jooq.impl.ArrayRecordImpl;
import org.jooq.impl.SQLDataType;


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
public class TopicarrRecord extends ArrayRecordImpl<String> {

    private static final long serialVersionUID = 1L;

    /**
     * @deprecated - 3.4.0 - [#3126] - Use the {@link #TopicarrRecord()} constructor instead
     */
    @java.lang.Deprecated
    public TopicarrRecord(Configuration configuration) {
        super(System.SYSTEM, "TOPICARR", SQLDataType.VARCHAR(100), configuration);
    }

    /**
     * @deprecated - 3.4.0 - [#3126] - Use the {@link #TopicarrRecord()} constructor instead
     */
    @java.lang.Deprecated
    public TopicarrRecord(Configuration configuration, String... array) {
        this(configuration);
        set(array);
    }

    /**
     * @deprecated - 3.4.0 - [#3126] - Use the {@link #TopicarrRecord()} constructor instead
     */
    @java.lang.Deprecated
    public TopicarrRecord(Configuration configuration, List<? extends String> list) {
        this(configuration);
        setList(list);
    }

    /**
     * Create a new <code>SYSTEM.TOPICARR</code> record
     */
    public TopicarrRecord() {
        super(System.SYSTEM, "TOPICARR", SQLDataType.VARCHAR(100));
    }

    /**
     * Create a new <code>SYSTEM.TOPICARR</code> record
     */
    public TopicarrRecord(String... array) {
        this();
        if (array != null)
            addAll(Arrays.asList(array));
    }

    /**
     * Create a new <code>SYSTEM.TOPICARR</code> record
     */
    public TopicarrRecord(Collection<? extends String> collection) {
        this();
        addAll(collection);
    }
}
