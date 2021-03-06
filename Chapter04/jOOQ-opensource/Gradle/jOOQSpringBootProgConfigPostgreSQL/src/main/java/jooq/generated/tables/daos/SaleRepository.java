/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables.daos;


import java.util.List;

import javax.annotation.processing.Generated;

import jooq.generated.tables.Sale;
import jooq.generated.tables.pojos.JooqSale;
import jooq.generated.tables.records.SaleRecord;

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
public class SaleRepository extends DAOImpl<SaleRecord, JooqSale, Long> {

    /**
     * Create a new SaleRepository without any configuration
     */
    public SaleRepository() {
        super(Sale.SALE, JooqSale.class);
    }

    /**
     * Create a new SaleRepository with an attached configuration
     */
    @Autowired
    public SaleRepository(Configuration configuration) {
        super(Sale.SALE, JooqSale.class, configuration);
    }

    @Override
    public Long getId(JooqSale object) {
        return object.getSaleId();
    }

    /**
     * Fetch records that have <code>sale_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<JooqSale> fetchRangeOfSaleId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Sale.SALE.SALE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>sale_id IN (values)</code>
     */
    public List<JooqSale> fetchBySaleId(Long... values) {
        return fetch(Sale.SALE.SALE_ID, values);
    }

    /**
     * Fetch a unique record that has <code>sale_id = value</code>
     */
    public JooqSale fetchOneBySaleId(Long value) {
        return fetchOne(Sale.SALE.SALE_ID, value);
    }

    /**
     * Fetch records that have <code>fiscal_year BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<JooqSale> fetchRangeOfFiscalYear(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Sale.SALE.FISCAL_YEAR, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>fiscal_year IN (values)</code>
     */
    public List<JooqSale> fetchByFiscalYear(Integer... values) {
        return fetch(Sale.SALE.FISCAL_YEAR, values);
    }

    /**
     * Fetch records that have <code>sale BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<JooqSale> fetchRangeOfSale(Double lowerInclusive, Double upperInclusive) {
        return fetchRange(Sale.SALE.SALE_, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>sale IN (values)</code>
     */
    public List<JooqSale> fetchBySale(Double... values) {
        return fetch(Sale.SALE.SALE_, values);
    }

    /**
     * Fetch records that have <code>employee_number BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<JooqSale> fetchRangeOfEmployeeNumber(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Sale.SALE.EMPLOYEE_NUMBER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>employee_number IN (values)</code>
     */
    public List<JooqSale> fetchByEmployeeNumber(Long... values) {
        return fetch(Sale.SALE.EMPLOYEE_NUMBER, values);
    }

    /**
     * Fetch records that have <code>hot BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<JooqSale> fetchRangeOfHot(Boolean lowerInclusive, Boolean upperInclusive) {
        return fetchRange(Sale.SALE.HOT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>hot IN (values)</code>
     */
    public List<JooqSale> fetchByHot(Boolean... values) {
        return fetch(Sale.SALE.HOT, values);
    }
}
