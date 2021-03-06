/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables.daos;


import java.util.List;

import jooq.generated.tables.Productline;
import jooq.generated.tables.pojos.JooqProductline;
import jooq.generated.tables.records.ProductlineRecord;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class ProductlineRepository extends DAOImpl<ProductlineRecord, JooqProductline, String> {

    /**
     * Create a new ProductlineRepository without any configuration
     */
    public ProductlineRepository() {
        super(Productline.PRODUCTLINE, JooqProductline.class);
    }

    /**
     * Create a new ProductlineRepository with an attached configuration
     */
    @Autowired
    public ProductlineRepository(Configuration configuration) {
        super(Productline.PRODUCTLINE, JooqProductline.class, configuration);
    }

    @Override
    public String getId(JooqProductline object) {
        return object.getProductLine();
    }

    /**
     * Fetch records that have <code>PRODUCT_LINE BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<JooqProductline> fetchRangeOfProductLine(String lowerInclusive, String upperInclusive) {
        return fetchRange(Productline.PRODUCTLINE.PRODUCT_LINE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>PRODUCT_LINE IN (values)</code>
     */
    public List<JooqProductline> fetchByProductLine(String... values) {
        return fetch(Productline.PRODUCTLINE.PRODUCT_LINE, values);
    }

    /**
     * Fetch a unique record that has <code>PRODUCT_LINE = value</code>
     */
    public JooqProductline fetchOneByProductLine(String value) {
        return fetchOne(Productline.PRODUCTLINE.PRODUCT_LINE, value);
    }

    /**
     * Fetch records that have <code>TEXT_DESCRIPTION BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<JooqProductline> fetchRangeOfTextDescription(String lowerInclusive, String upperInclusive) {
        return fetchRange(Productline.PRODUCTLINE.TEXT_DESCRIPTION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>TEXT_DESCRIPTION IN (values)</code>
     */
    public List<JooqProductline> fetchByTextDescription(String... values) {
        return fetch(Productline.PRODUCTLINE.TEXT_DESCRIPTION, values);
    }

    /**
     * Fetch records that have <code>HTML_DESCRIPTION BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<JooqProductline> fetchRangeOfHtmlDescription(String lowerInclusive, String upperInclusive) {
        return fetchRange(Productline.PRODUCTLINE.HTML_DESCRIPTION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>HTML_DESCRIPTION IN (values)</code>
     */
    public List<JooqProductline> fetchByHtmlDescription(String... values) {
        return fetch(Productline.PRODUCTLINE.HTML_DESCRIPTION, values);
    }

    /**
     * Fetch records that have <code>IMAGE BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<JooqProductline> fetchRangeOfImage(byte[] lowerInclusive, byte[] upperInclusive) {
        return fetchRange(Productline.PRODUCTLINE.IMAGE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>IMAGE IN (values)</code>
     */
    public List<JooqProductline> fetchByImage(byte[]... values) {
        return fetch(Productline.PRODUCTLINE.IMAGE, values);
    }
}
