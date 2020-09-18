/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables.daos;


import java.math.BigDecimal;
import java.util.List;

import javax.annotation.processing.Generated;

import jooq.generated.tables.Orderdetail;
import jooq.generated.tables.records.OrderdetailRecord;

import org.jooq.Configuration;
import org.jooq.Record2;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.2",
        "schema version:1.1"
    },
    date = "2020-08-29T13:16:19.652Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class OrderdetailRepository extends DAOImpl<OrderdetailRecord, jooq.generated.tables.pojos.Orderdetail, Record2<Long, Long>> {

    /**
     * Create a new OrderdetailRepository without any configuration
     */
    public OrderdetailRepository() {
        super(Orderdetail.ORDERDETAIL, jooq.generated.tables.pojos.Orderdetail.class);
    }

    /**
     * Create a new OrderdetailRepository with an attached configuration
     */
    @Autowired
    public OrderdetailRepository(Configuration configuration) {
        super(Orderdetail.ORDERDETAIL, jooq.generated.tables.pojos.Orderdetail.class, configuration);
    }

    @Override
    public Record2<Long, Long> getId(jooq.generated.tables.pojos.Orderdetail object) {
        return compositeKeyRecord(object.getOrderId(), object.getProductId());
    }

    /**
     * Fetch records that have <code>order_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<jooq.generated.tables.pojos.Orderdetail> fetchRangeOfOrderId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Orderdetail.ORDERDETAIL.ORDER_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>order_id IN (values)</code>
     */
    public List<jooq.generated.tables.pojos.Orderdetail> fetchByOrderId(Long... values) {
        return fetch(Orderdetail.ORDERDETAIL.ORDER_ID, values);
    }

    /**
     * Fetch records that have <code>product_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<jooq.generated.tables.pojos.Orderdetail> fetchRangeOfProductId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Orderdetail.ORDERDETAIL.PRODUCT_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>product_id IN (values)</code>
     */
    public List<jooq.generated.tables.pojos.Orderdetail> fetchByProductId(Long... values) {
        return fetch(Orderdetail.ORDERDETAIL.PRODUCT_ID, values);
    }

    /**
     * Fetch records that have <code>quantity_ordered BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<jooq.generated.tables.pojos.Orderdetail> fetchRangeOfQuantityOrdered(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Orderdetail.ORDERDETAIL.QUANTITY_ORDERED, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>quantity_ordered IN (values)</code>
     */
    public List<jooq.generated.tables.pojos.Orderdetail> fetchByQuantityOrdered(Integer... values) {
        return fetch(Orderdetail.ORDERDETAIL.QUANTITY_ORDERED, values);
    }

    /**
     * Fetch records that have <code>price_each BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<jooq.generated.tables.pojos.Orderdetail> fetchRangeOfPriceEach(BigDecimal lowerInclusive, BigDecimal upperInclusive) {
        return fetchRange(Orderdetail.ORDERDETAIL.PRICE_EACH, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>price_each IN (values)</code>
     */
    public List<jooq.generated.tables.pojos.Orderdetail> fetchByPriceEach(BigDecimal... values) {
        return fetch(Orderdetail.ORDERDETAIL.PRICE_EACH, values);
    }

    /**
     * Fetch records that have <code>order_line_number BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<jooq.generated.tables.pojos.Orderdetail> fetchRangeOfOrderLineNumber(Short lowerInclusive, Short upperInclusive) {
        return fetchRange(Orderdetail.ORDERDETAIL.ORDER_LINE_NUMBER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>order_line_number IN (values)</code>
     */
    public List<jooq.generated.tables.pojos.Orderdetail> fetchByOrderLineNumber(Short... values) {
        return fetch(Orderdetail.ORDERDETAIL.ORDER_LINE_NUMBER, values);
    }
}
