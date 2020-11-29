/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables.daos;


import java.time.LocalDate;
import java.util.List;

import javax.annotation.processing.Generated;

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
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.4",
        "schema version:1.1"
    },
    comments = "This class is generated by jOOQ"
)
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
     * Fetch records that have <code>product_line BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<JooqProductline> fetchRangeOfProductLine(String lowerInclusive, String upperInclusive) {
        return fetchRange(Productline.PRODUCTLINE.PRODUCT_LINE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>product_line IN (values)</code>
     */
    public List<JooqProductline> fetchByProductLine(String... values) {
        return fetch(Productline.PRODUCTLINE.PRODUCT_LINE, values);
    }

    /**
     * Fetch a unique record that has <code>product_line = value</code>
     */
    public JooqProductline fetchOneByProductLine(String value) {
        return fetchOne(Productline.PRODUCTLINE.PRODUCT_LINE, value);
    }

    /**
     * Fetch records that have <code>text_description BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<JooqProductline> fetchRangeOfTextDescription(String lowerInclusive, String upperInclusive) {
        return fetchRange(Productline.PRODUCTLINE.TEXT_DESCRIPTION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>text_description IN (values)</code>
     */
    public List<JooqProductline> fetchByTextDescription(String... values) {
        return fetch(Productline.PRODUCTLINE.TEXT_DESCRIPTION, values);
    }

    /**
     * Fetch records that have <code>html_description BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<JooqProductline> fetchRangeOfHtmlDescription(String lowerInclusive, String upperInclusive) {
        return fetchRange(Productline.PRODUCTLINE.HTML_DESCRIPTION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>html_description IN (values)</code>
     */
    public List<JooqProductline> fetchByHtmlDescription(String... values) {
        return fetch(Productline.PRODUCTLINE.HTML_DESCRIPTION, values);
    }

    /**
     * Fetch records that have <code>image BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<JooqProductline> fetchRangeOfImage(byte[] lowerInclusive, byte[] upperInclusive) {
        return fetchRange(Productline.PRODUCTLINE.IMAGE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>image IN (values)</code>
     */
    public List<JooqProductline> fetchByImage(byte[]... values) {
        return fetch(Productline.PRODUCTLINE.IMAGE, values);
    }

    /**
     * Fetch records that have <code>created_on BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<JooqProductline> fetchRangeOfCreatedOn(LocalDate lowerInclusive, LocalDate upperInclusive) {
        return fetchRange(Productline.PRODUCTLINE.CREATED_ON, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>created_on IN (values)</code>
     */
    public List<JooqProductline> fetchByCreatedOn(LocalDate... values) {
        return fetch(Productline.PRODUCTLINE.CREATED_ON, values);
    }
}
