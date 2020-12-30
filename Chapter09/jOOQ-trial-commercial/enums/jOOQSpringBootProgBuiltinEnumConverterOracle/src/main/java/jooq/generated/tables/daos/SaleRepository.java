/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables.daos;


import com.classicmodels.enums.RateType;
import com.classicmodels.enums.VatType;

import java.math.BigInteger;
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
public class SaleRepository extends DAOImpl<SaleRecord, JooqSale, BigInteger> {

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
    public BigInteger getId(JooqSale object) {
        return object.getSaleId();
    }

    /**
     * Fetch records that have <code>SALE_ID BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<JooqSale> fetchRangeOfSaleId(BigInteger lowerInclusive, BigInteger upperInclusive) {
        return fetchRange(Sale.SALE.SALE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>SALE_ID IN (values)</code>
     */
    public List<JooqSale> fetchBySaleId(BigInteger... values) {
        return fetch(Sale.SALE.SALE_ID, values);
    }

    /**
     * Fetch a unique record that has <code>SALE_ID = value</code>
     */
    public JooqSale fetchOneBySaleId(BigInteger value) {
        return fetchOne(Sale.SALE.SALE_ID, value);
    }

    /**
     * Fetch records that have <code>FISCAL_YEAR BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<JooqSale> fetchRangeOfFiscalYear(BigInteger lowerInclusive, BigInteger upperInclusive) {
        return fetchRange(Sale.SALE.FISCAL_YEAR, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>FISCAL_YEAR IN (values)</code>
     */
    public List<JooqSale> fetchByFiscalYear(BigInteger... values) {
        return fetch(Sale.SALE.FISCAL_YEAR, values);
    }

    /**
     * Fetch records that have <code>SALE BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<JooqSale> fetchRangeOfSale(Double lowerInclusive, Double upperInclusive) {
        return fetchRange(Sale.SALE.SALE_, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>SALE IN (values)</code>
     */
    public List<JooqSale> fetchBySale(Double... values) {
        return fetch(Sale.SALE.SALE_, values);
    }

    /**
     * Fetch records that have <code>EMPLOYEE_NUMBER BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<JooqSale> fetchRangeOfEmployeeNumber(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Sale.SALE.EMPLOYEE_NUMBER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>EMPLOYEE_NUMBER IN (values)</code>
     */
    public List<JooqSale> fetchByEmployeeNumber(Long... values) {
        return fetch(Sale.SALE.EMPLOYEE_NUMBER, values);
    }

    /**
     * Fetch records that have <code>HOT BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<JooqSale> fetchRangeOfHot(Byte lowerInclusive, Byte upperInclusive) {
        return fetchRange(Sale.SALE.HOT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>HOT IN (values)</code>
     */
    public List<JooqSale> fetchByHot(Byte... values) {
        return fetch(Sale.SALE.HOT, values);
    }

    /**
     * Fetch records that have <code>RATE BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<JooqSale> fetchRangeOfRate(RateType lowerInclusive, RateType upperInclusive) {
        return fetchRange(Sale.SALE.RATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>RATE IN (values)</code>
     */
    public List<JooqSale> fetchByRate(RateType... values) {
        return fetch(Sale.SALE.RATE, values);
    }

    /**
     * Fetch records that have <code>VAT BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<JooqSale> fetchRangeOfVat(VatType lowerInclusive, VatType upperInclusive) {
        return fetchRange(Sale.SALE.VAT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>VAT IN (values)</code>
     */
    public List<JooqSale> fetchByVat(VatType... values) {
        return fetch(Sale.SALE.VAT, values);
    }

    /**
     * Fetch records that have <code>TREND BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<JooqSale> fetchRangeOfTrend(String lowerInclusive, String upperInclusive) {
        return fetchRange(Sale.SALE.TREND, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>TREND IN (values)</code>
     */
    public List<JooqSale> fetchByTrend(String... values) {
        return fetch(Sale.SALE.TREND, values);
    }
}