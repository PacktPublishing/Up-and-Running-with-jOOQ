/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables.daos;


import java.util.List;

import javax.annotation.processing.Generated;

import jooq.generated.tables.Customerdetail;
import jooq.generated.tables.records.CustomerdetailRecord;

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
        "jOOQ version:3.13.2",
        "schema version:1.1"
    },
    date = "2020-08-29T13:16:19.652Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class CustomerdetailRepository extends DAOImpl<CustomerdetailRecord, jooq.generated.tables.pojos.Customerdetail, Long> {

    /**
     * Create a new CustomerdetailRepository without any configuration
     */
    public CustomerdetailRepository() {
        super(Customerdetail.CUSTOMERDETAIL, jooq.generated.tables.pojos.Customerdetail.class);
    }

    /**
     * Create a new CustomerdetailRepository with an attached configuration
     */
    @Autowired
    public CustomerdetailRepository(Configuration configuration) {
        super(Customerdetail.CUSTOMERDETAIL, jooq.generated.tables.pojos.Customerdetail.class, configuration);
    }

    @Override
    public Long getId(jooq.generated.tables.pojos.Customerdetail object) {
        return object.getCustomerNumber();
    }

    /**
     * Fetch records that have <code>customer_number BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<jooq.generated.tables.pojos.Customerdetail> fetchRangeOfCustomerNumber(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Customerdetail.CUSTOMERDETAIL.CUSTOMER_NUMBER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>customer_number IN (values)</code>
     */
    public List<jooq.generated.tables.pojos.Customerdetail> fetchByCustomerNumber(Long... values) {
        return fetch(Customerdetail.CUSTOMERDETAIL.CUSTOMER_NUMBER, values);
    }

    /**
     * Fetch a unique record that has <code>customer_number = value</code>
     */
    public jooq.generated.tables.pojos.Customerdetail fetchOneByCustomerNumber(Long value) {
        return fetchOne(Customerdetail.CUSTOMERDETAIL.CUSTOMER_NUMBER, value);
    }

    /**
     * Fetch records that have <code>address_line_first BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<jooq.generated.tables.pojos.Customerdetail> fetchRangeOfAddressLineFirst(String lowerInclusive, String upperInclusive) {
        return fetchRange(Customerdetail.CUSTOMERDETAIL.ADDRESS_LINE_FIRST, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>address_line_first IN (values)</code>
     */
    public List<jooq.generated.tables.pojos.Customerdetail> fetchByAddressLineFirst(String... values) {
        return fetch(Customerdetail.CUSTOMERDETAIL.ADDRESS_LINE_FIRST, values);
    }

    /**
     * Fetch records that have <code>address_line_second BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<jooq.generated.tables.pojos.Customerdetail> fetchRangeOfAddressLineSecond(String lowerInclusive, String upperInclusive) {
        return fetchRange(Customerdetail.CUSTOMERDETAIL.ADDRESS_LINE_SECOND, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>address_line_second IN (values)</code>
     */
    public List<jooq.generated.tables.pojos.Customerdetail> fetchByAddressLineSecond(String... values) {
        return fetch(Customerdetail.CUSTOMERDETAIL.ADDRESS_LINE_SECOND, values);
    }

    /**
     * Fetch records that have <code>city BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<jooq.generated.tables.pojos.Customerdetail> fetchRangeOfCity(String lowerInclusive, String upperInclusive) {
        return fetchRange(Customerdetail.CUSTOMERDETAIL.CITY, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>city IN (values)</code>
     */
    public List<jooq.generated.tables.pojos.Customerdetail> fetchByCity(String... values) {
        return fetch(Customerdetail.CUSTOMERDETAIL.CITY, values);
    }

    /**
     * Fetch records that have <code>state BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<jooq.generated.tables.pojos.Customerdetail> fetchRangeOfState(String lowerInclusive, String upperInclusive) {
        return fetchRange(Customerdetail.CUSTOMERDETAIL.STATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>state IN (values)</code>
     */
    public List<jooq.generated.tables.pojos.Customerdetail> fetchByState(String... values) {
        return fetch(Customerdetail.CUSTOMERDETAIL.STATE, values);
    }

    /**
     * Fetch records that have <code>postal_code BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<jooq.generated.tables.pojos.Customerdetail> fetchRangeOfPostalCode(String lowerInclusive, String upperInclusive) {
        return fetchRange(Customerdetail.CUSTOMERDETAIL.POSTAL_CODE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>postal_code IN (values)</code>
     */
    public List<jooq.generated.tables.pojos.Customerdetail> fetchByPostalCode(String... values) {
        return fetch(Customerdetail.CUSTOMERDETAIL.POSTAL_CODE, values);
    }

    /**
     * Fetch records that have <code>country BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<jooq.generated.tables.pojos.Customerdetail> fetchRangeOfCountry(String lowerInclusive, String upperInclusive) {
        return fetchRange(Customerdetail.CUSTOMERDETAIL.COUNTRY, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>country IN (values)</code>
     */
    public List<jooq.generated.tables.pojos.Customerdetail> fetchByCountry(String... values) {
        return fetch(Customerdetail.CUSTOMERDETAIL.COUNTRY, values);
    }
}
