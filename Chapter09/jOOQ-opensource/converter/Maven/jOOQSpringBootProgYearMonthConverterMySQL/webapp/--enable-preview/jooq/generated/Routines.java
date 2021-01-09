/*
 * This file is generated by jOOQ.
 */
package jooq.generated;


import java.math.BigDecimal;

import javax.annotation.processing.Generated;

import jooq.generated.routines.Customerlevel;

import org.jooq.Configuration;
import org.jooq.Field;


/**
 * Convenience access to all stored procedures and functions in classicmodels.
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
public class Routines {

    /**
     * Call <code>classicmodels.CustomerLevel</code>
     */
    public static String customerlevel(
          Configuration configuration
        , BigDecimal credit
    ) {
        Customerlevel f = new Customerlevel();
        f.setCredit(credit);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>classicmodels.CustomerLevel</code> as a field.
     */
    public static Field<String> customerlevel(
          BigDecimal credit
    ) {
        Customerlevel f = new Customerlevel();
        f.setCredit(credit);

        return f.asField();
    }

    /**
     * Get <code>classicmodels.CustomerLevel</code> as a field.
     */
    public static Field<String> customerlevel(
          Field<BigDecimal> credit
    ) {
        Customerlevel f = new Customerlevel();
        f.setCredit(credit);

        return f.asField();
    }
}