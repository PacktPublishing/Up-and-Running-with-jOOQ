/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables.pojos;


import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqOffice implements Serializable {

    private static final long serialVersionUID = 1L;

    private String officeCode;
    private String city;
    private String phone;
    private String addressLineFirst;
    private String addressLineSecond;
    private String state;
    private String country;
    private String postalCode;
    private String territory;

    public JooqOffice() {}

    public JooqOffice(JooqOffice value) {
        this.officeCode = value.officeCode;
        this.city = value.city;
        this.phone = value.phone;
        this.addressLineFirst = value.addressLineFirst;
        this.addressLineSecond = value.addressLineSecond;
        this.state = value.state;
        this.country = value.country;
        this.postalCode = value.postalCode;
        this.territory = value.territory;
    }

    public JooqOffice(
        String officeCode,
        String city,
        String phone,
        String addressLineFirst,
        String addressLineSecond,
        String state,
        String country,
        String postalCode,
        String territory
    ) {
        this.officeCode = officeCode;
        this.city = city;
        this.phone = phone;
        this.addressLineFirst = addressLineFirst;
        this.addressLineSecond = addressLineSecond;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.territory = territory;
    }

    /**
     * Getter for <code>OFFICE.OFFICE_CODE</code>.
     */
    @NotNull
    @Size(max = 10)
    public String getOfficeCode() {
        return this.officeCode;
    }

    /**
     * Setter for <code>OFFICE.OFFICE_CODE</code>.
     */
    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    /**
     * Getter for <code>OFFICE.CITY</code>.
     */
    @Size(max = 50)
    public String getCity() {
        return this.city;
    }

    /**
     * Setter for <code>OFFICE.CITY</code>.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Getter for <code>OFFICE.PHONE</code>.
     */
    @NotNull
    @Size(max = 50)
    public String getPhone() {
        return this.phone;
    }

    /**
     * Setter for <code>OFFICE.PHONE</code>.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Getter for <code>OFFICE.ADDRESS_LINE_FIRST</code>.
     */
    @NotNull
    @Size(max = 50)
    public String getAddressLineFirst() {
        return this.addressLineFirst;
    }

    /**
     * Setter for <code>OFFICE.ADDRESS_LINE_FIRST</code>.
     */
    public void setAddressLineFirst(String addressLineFirst) {
        this.addressLineFirst = addressLineFirst;
    }

    /**
     * Getter for <code>OFFICE.ADDRESS_LINE_SECOND</code>.
     */
    @Size(max = 50)
    public String getAddressLineSecond() {
        return this.addressLineSecond;
    }

    /**
     * Setter for <code>OFFICE.ADDRESS_LINE_SECOND</code>.
     */
    public void setAddressLineSecond(String addressLineSecond) {
        this.addressLineSecond = addressLineSecond;
    }

    /**
     * Getter for <code>OFFICE.STATE</code>.
     */
    @Size(max = 50)
    public String getState() {
        return this.state;
    }

    /**
     * Setter for <code>OFFICE.STATE</code>.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Getter for <code>OFFICE.COUNTRY</code>.
     */
    @Size(max = 50)
    public String getCountry() {
        return this.country;
    }

    /**
     * Setter for <code>OFFICE.COUNTRY</code>.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Getter for <code>OFFICE.POSTAL_CODE</code>.
     */
    @NotNull
    @Size(max = 15)
    public String getPostalCode() {
        return this.postalCode;
    }

    /**
     * Setter for <code>OFFICE.POSTAL_CODE</code>.
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Getter for <code>OFFICE.TERRITORY</code>.
     */
    @NotNull
    @Size(max = 10)
    public String getTerritory() {
        return this.territory;
    }

    /**
     * Setter for <code>OFFICE.TERRITORY</code>.
     */
    public void setTerritory(String territory) {
        this.territory = territory;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JooqOffice (");

        sb.append(officeCode);
        sb.append(", ").append(city);
        sb.append(", ").append(phone);
        sb.append(", ").append(addressLineFirst);
        sb.append(", ").append(addressLineSecond);
        sb.append(", ").append(state);
        sb.append(", ").append(country);
        sb.append(", ").append(postalCode);
        sb.append(", ").append(territory);

        sb.append(")");
        return sb.toString();
    }
}
