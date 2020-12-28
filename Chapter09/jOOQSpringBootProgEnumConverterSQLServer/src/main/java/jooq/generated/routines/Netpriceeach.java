/*
 * This file is generated by jOOQ.
 */
package jooq.generated.routines;


import java.math.BigDecimal;

import javax.annotation.processing.Generated;

import jooq.generated.Dbo;

import org.jooq.Field;
import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;
import org.jooq.impl.Internal;
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
public class Netpriceeach extends AbstractRoutine<BigDecimal> {

    private static final long serialVersionUID = 1L;

    /**
     * The parameter <code>classicmodels.dbo.netPriceEach.RETURN_VALUE</code>.
     */
    public static final Parameter<BigDecimal> RETURN_VALUE = Internal.createParameter("RETURN_VALUE", SQLDataType.NUMERIC(10, 2), false, false);

    /**
     * The parameter <code>classicmodels.dbo.netPriceEach.quantity</code>.
     */
    public static final Parameter<Integer> QUANTITY = Internal.createParameter("quantity", SQLDataType.INTEGER, false, false);

    /**
     * The parameter <code>classicmodels.dbo.netPriceEach.list_price</code>.
     */
    public static final Parameter<BigDecimal> LIST_PRICE = Internal.createParameter("list_price", SQLDataType.NUMERIC(10, 2), false, false);

    /**
     * The parameter <code>classicmodels.dbo.netPriceEach.discount</code>.
     */
    public static final Parameter<BigDecimal> DISCOUNT = Internal.createParameter("discount", SQLDataType.NUMERIC(4, 2), false, false);

    /**
     * Create a new routine call instance
     */
    public Netpriceeach() {
        super("netPriceEach", Dbo.DBO, SQLDataType.NUMERIC(10, 2));

        setReturnParameter(RETURN_VALUE);
        addInParameter(QUANTITY);
        addInParameter(LIST_PRICE);
        addInParameter(DISCOUNT);
    }

    /**
     * Set the <code>quantity</code> parameter IN value to the routine
     */
    public void setQuantity(Integer value) {
        setValue(QUANTITY, value);
    }

    /**
     * Set the <code>quantity</code> parameter to the function to be used with a {@link org.jooq.Select} statement
     */
    public void setQuantity(Field<Integer> field) {
        setField(QUANTITY, field);
    }

    /**
     * Set the <code>list_price</code> parameter IN value to the routine
     */
    public void setListPrice(BigDecimal value) {
        setValue(LIST_PRICE, value);
    }

    /**
     * Set the <code>list_price</code> parameter to the function to be used with a {@link org.jooq.Select} statement
     */
    public void setListPrice(Field<BigDecimal> field) {
        setField(LIST_PRICE, field);
    }

    /**
     * Set the <code>discount</code> parameter IN value to the routine
     */
    public void setDiscount(BigDecimal value) {
        setValue(DISCOUNT, value);
    }

    /**
     * Set the <code>discount</code> parameter to the function to be used with a {@link org.jooq.Select} statement
     */
    public void setDiscount(Field<BigDecimal> field) {
        setField(DISCOUNT, field);
    }
}
