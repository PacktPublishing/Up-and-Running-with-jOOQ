/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables.pojos;


import java.io.Serializable;

import javax.annotation.processing.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.2",
        "schema version:1.1"
    },
    date = "2020-07-04T08:58:29.902Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Office implements Serializable {

    private static final long serialVersionUID = 429083890;

    private String officeCode;
    private String city;
    private String phone;
    private String addressLine_1;
    private String addressLine_2;
    private String state;
    private String country;
    private String postalCode;
    private String territory;

    public Office() {}

    public Office(Office value) {
        this.officeCode = value.officeCode;
        this.city = value.city;
        this.phone = value.phone;
        this.addressLine_1 = value.addressLine_1;
        this.addressLine_2 = value.addressLine_2;
        this.state = value.state;
        this.country = value.country;
        this.postalCode = value.postalCode;
        this.territory = value.territory;
    }

    public Office(
        String officeCode,
        String city,
        String phone,
        String addressLine_1,
        String addressLine_2,
        String state,
        String country,
        String postalCode,
        String territory
    ) {
        this.officeCode = officeCode;
        this.city = city;
        this.phone = phone;
        this.addressLine_1 = addressLine_1;
        this.addressLine_2 = addressLine_2;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.territory = territory;
    }

    @NotNull
    @Size(max = 10)
    public String getOfficeCode() {
        return this.officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    @NotNull
    @Size(max = 50)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @NotNull
    @Size(max = 50)
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @NotNull
    @Size(max = 50)
    public String getAddressLine_1() {
        return this.addressLine_1;
    }

    public void setAddressLine_1(String addressLine_1) {
        this.addressLine_1 = addressLine_1;
    }

    @Size(max = 50)
    public String getAddressLine_2() {
        return this.addressLine_2;
    }

    public void setAddressLine_2(String addressLine_2) {
        this.addressLine_2 = addressLine_2;
    }

    @Size(max = 50)
    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @NotNull
    @Size(max = 50)
    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @NotNull
    @Size(max = 15)
    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @NotNull
    @Size(max = 10)
    public String getTerritory() {
        return this.territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Office (");

        sb.append(officeCode);
        sb.append(", ").append(city);
        sb.append(", ").append(phone);
        sb.append(", ").append(addressLine_1);
        sb.append(", ").append(addressLine_2);
        sb.append(", ").append(state);
        sb.append(", ").append(country);
        sb.append(", ").append(postalCode);
        sb.append(", ").append(territory);

        sb.append(")");
        return sb.toString();
    }
}
