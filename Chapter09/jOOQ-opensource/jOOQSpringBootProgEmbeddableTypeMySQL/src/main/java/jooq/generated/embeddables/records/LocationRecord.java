/*
 * This file is generated by jOOQ.
 */
package jooq.generated.embeddables.records;


import javax.annotation.processing.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jooq.generated.tables.Office;

import org.jooq.Field;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.EmbeddableRecordImpl;
import org.jooq.impl.Internal;


/**
 * The embeddable <code>classicmodels.LOCATION</code>.
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
public class LocationRecord extends EmbeddableRecordImpl<LocationRecord> implements Record4<String, String, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>classicmodels.LOCATION.city</code>.
     */
    public void setCity(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>classicmodels.LOCATION.city</code>.
     */
    @Size(max = 50)
    public String getCity() {
        return (String) get(0);
    }

    /**
     * Setter for <code>classicmodels.LOCATION.address_line_first</code>.
     */
    public void setAddressLineFirst(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>classicmodels.LOCATION.address_line_first</code>.
     */
    @NotNull
    @Size(max = 50)
    public String getAddressLineFirst() {
        return (String) get(1);
    }

    /**
     * Setter for <code>classicmodels.LOCATION.state</code>.
     */
    public void setState(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>classicmodels.LOCATION.state</code>.
     */
    @Size(max = 50)
    public String getState() {
        return (String) get(2);
    }

    /**
     * Setter for <code>classicmodels.LOCATION.country</code>.
     */
    public void setCountry(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>classicmodels.LOCATION.country</code>.
     */
    @Size(max = 50)
    public String getCountry() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<String, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<String, String, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return (Field<String>) field(0);
    }

    @Override
    public Field<String> field2() {
        return (Field<String>) field(1);
    }

    @Override
    public Field<String> field3() {
        return (Field<String>) field(2);
    }

    @Override
    public Field<String> field4() {
        return (Field<String>) field(3);
    }

    @Override
    public String component1() {
        return getCity();
    }

    @Override
    public String component2() {
        return getAddressLineFirst();
    }

    @Override
    public String component3() {
        return getState();
    }

    @Override
    public String component4() {
        return getCountry();
    }

    @Override
    public String value1() {
        return getCity();
    }

    @Override
    public String value2() {
        return getAddressLineFirst();
    }

    @Override
    public String value3() {
        return getState();
    }

    @Override
    public String value4() {
        return getCountry();
    }

    @Override
    public LocationRecord value1(String value) {
        setCity(value);
        return this;
    }

    @Override
    public LocationRecord value2(String value) {
        setAddressLineFirst(value);
        return this;
    }

    @Override
    public LocationRecord value3(String value) {
        setState(value);
        return this;
    }

    @Override
    public LocationRecord value4(String value) {
        setCountry(value);
        return this;
    }

    @Override
    public LocationRecord values(String value1, String value2, String value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LocationRecord
     */
    public LocationRecord() {
        super(Internal.fields(Office.OFFICE.LOCATION));
    }

    /**
     * Create a detached, initialised LocationRecord
     */
    public LocationRecord(String city, String addressLineFirst, String state, String country) {
        this();

        setCity(city);
        setAddressLineFirst(addressLineFirst);
        setState(state);
        setCountry(country);
    }
}
