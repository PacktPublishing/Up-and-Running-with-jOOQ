/*
 * This file is generated by jOOQ.
 */
package jooq.generated.master.dbo.tables.pojos;


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
        "jOOQ version:3.13.5",
        "schema version:1.1"
    },
    date = "2020-10-31T06:19:36.439Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqOffices implements Serializable {

    private static final long serialVersionUID = 266037662;

    private String officecode;
    private String city;
    private String phone;
    private String addressline1;
    private String addressline2;
    private String state;
    private String country;
    private String postalcode;
    private String territory;

    public JooqOffices() {}

    public JooqOffices(JooqOffices value) {
        this.officecode = value.officecode;
        this.city = value.city;
        this.phone = value.phone;
        this.addressline1 = value.addressline1;
        this.addressline2 = value.addressline2;
        this.state = value.state;
        this.country = value.country;
        this.postalcode = value.postalcode;
        this.territory = value.territory;
    }

    public JooqOffices(
        String officecode,
        String city,
        String phone,
        String addressline1,
        String addressline2,
        String state,
        String country,
        String postalcode,
        String territory
    ) {
        this.officecode = officecode;
        this.city = city;
        this.phone = phone;
        this.addressline1 = addressline1;
        this.addressline2 = addressline2;
        this.state = state;
        this.country = country;
        this.postalcode = postalcode;
        this.territory = territory;
    }

    @NotNull
    @Size(max = 10)
    public String getOfficecode() {
        return this.officecode;
    }

    public void setOfficecode(String officecode) {
        this.officecode = officecode;
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
    public String getAddressline1() {
        return this.addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    @Size(max = 50)
    public String getAddressline2() {
        return this.addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
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
    public String getPostalcode() {
        return this.postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
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
        StringBuilder sb = new StringBuilder("JooqOffices (");

        sb.append(officecode);
        sb.append(", ").append(city);
        sb.append(", ").append(phone);
        sb.append(", ").append(addressline1);
        sb.append(", ").append(addressline2);
        sb.append(", ").append(state);
        sb.append(", ").append(country);
        sb.append(", ").append(postalcode);
        sb.append(", ").append(territory);

        sb.append(")");
        return sb.toString();
    }
}