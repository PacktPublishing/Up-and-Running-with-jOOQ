/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables.records;


import java.math.BigDecimal;

import javax.annotation.processing.Generated;
import javax.validation.constraints.NotNull;

import jooq.generated.tables.Orderdetail;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


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
public class OrderdetailRecord extends UpdatableRecordImpl<OrderdetailRecord> implements Record5<Long, Long, Integer, BigDecimal, Short> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>classicmodels.orderdetail.order_id</code>.
     */
    public void setOrderId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>classicmodels.orderdetail.order_id</code>.
     */
    @NotNull
    public Long getOrderId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>classicmodels.orderdetail.product_id</code>.
     */
    public void setProductId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>classicmodels.orderdetail.product_id</code>.
     */
    @NotNull
    public Long getProductId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>classicmodels.orderdetail.quantity_ordered</code>.
     */
    public void setQuantityOrdered(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>classicmodels.orderdetail.quantity_ordered</code>.
     */
    @NotNull
    public Integer getQuantityOrdered() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>classicmodels.orderdetail.price_each</code>.
     */
    public void setPriceEach(BigDecimal value) {
        set(3, value);
    }

    /**
     * Getter for <code>classicmodels.orderdetail.price_each</code>.
     */
    @NotNull
    public BigDecimal getPriceEach() {
        return (BigDecimal) get(3);
    }

    /**
     * Setter for <code>classicmodels.orderdetail.order_line_number</code>.
     */
    public void setOrderLineNumber(Short value) {
        set(4, value);
    }

    /**
     * Getter for <code>classicmodels.orderdetail.order_line_number</code>.
     */
    @NotNull
    public Short getOrderLineNumber() {
        return (Short) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<Long, Long> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, Long, Integer, BigDecimal, Short> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Long, Long, Integer, BigDecimal, Short> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Orderdetail.ORDERDETAIL.ORDER_ID;
    }

    @Override
    public Field<Long> field2() {
        return Orderdetail.ORDERDETAIL.PRODUCT_ID;
    }

    @Override
    public Field<Integer> field3() {
        return Orderdetail.ORDERDETAIL.QUANTITY_ORDERED;
    }

    @Override
    public Field<BigDecimal> field4() {
        return Orderdetail.ORDERDETAIL.PRICE_EACH;
    }

    @Override
    public Field<Short> field5() {
        return Orderdetail.ORDERDETAIL.ORDER_LINE_NUMBER;
    }

    @Override
    public Long component1() {
        return getOrderId();
    }

    @Override
    public Long component2() {
        return getProductId();
    }

    @Override
    public Integer component3() {
        return getQuantityOrdered();
    }

    @Override
    public BigDecimal component4() {
        return getPriceEach();
    }

    @Override
    public Short component5() {
        return getOrderLineNumber();
    }

    @Override
    public Long value1() {
        return getOrderId();
    }

    @Override
    public Long value2() {
        return getProductId();
    }

    @Override
    public Integer value3() {
        return getQuantityOrdered();
    }

    @Override
    public BigDecimal value4() {
        return getPriceEach();
    }

    @Override
    public Short value5() {
        return getOrderLineNumber();
    }

    @Override
    public OrderdetailRecord value1(Long value) {
        setOrderId(value);
        return this;
    }

    @Override
    public OrderdetailRecord value2(Long value) {
        setProductId(value);
        return this;
    }

    @Override
    public OrderdetailRecord value3(Integer value) {
        setQuantityOrdered(value);
        return this;
    }

    @Override
    public OrderdetailRecord value4(BigDecimal value) {
        setPriceEach(value);
        return this;
    }

    @Override
    public OrderdetailRecord value5(Short value) {
        setOrderLineNumber(value);
        return this;
    }

    @Override
    public OrderdetailRecord values(Long value1, Long value2, Integer value3, BigDecimal value4, Short value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached OrderdetailRecord
     */
    public OrderdetailRecord() {
        super(Orderdetail.ORDERDETAIL);
    }

    /**
     * Create a detached, initialised OrderdetailRecord
     */
    public OrderdetailRecord(Long orderId, Long productId, Integer quantityOrdered, BigDecimal priceEach, Short orderLineNumber) {
        super(Orderdetail.ORDERDETAIL);

        setOrderId(orderId);
        setProductId(productId);
        setQuantityOrdered(quantityOrdered);
        setPriceEach(priceEach);
        setOrderLineNumber(orderLineNumber);
    }
}
