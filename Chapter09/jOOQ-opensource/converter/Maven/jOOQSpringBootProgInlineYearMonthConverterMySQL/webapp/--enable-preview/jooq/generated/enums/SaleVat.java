/*
 * This file is generated by jOOQ.
 */
package jooq.generated.enums;


import javax.annotation.processing.Generated;

import org.jooq.Catalog;
import org.jooq.EnumType;
import org.jooq.Schema;


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
public enum SaleVat implements EnumType {

    NONE("NONE"),

    MIN("MIN"),

    MAX("MAX");

    private final String literal;

    private SaleVat(String literal) {
        this.literal = literal;
    }

    @Override
    public Catalog getCatalog() {
        return null;
    }

    @Override
    public Schema getSchema() {
        return null;
    }

    @Override
    public String getName() {
        return "sale_vat";
    }

    @Override
    public String getLiteral() {
        return literal;
    }
}
