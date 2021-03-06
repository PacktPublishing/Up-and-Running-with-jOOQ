/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables.pojos;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.YearMonth;

import javax.annotation.processing.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


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
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long       customerNumber;
    private String     customerName;
    private String     contactLastName;
    private String     contactFirstName;
    private String     phone;
    private Long       salesRepEmployeeNumber;
    private BigDecimal creditLimit;
    private YearMonth  firstBuyDate;

    public Customer() {}

    public Customer(Customer value) {
        this.customerNumber = value.customerNumber;
        this.customerName = value.customerName;
        this.contactLastName = value.contactLastName;
        this.contactFirstName = value.contactFirstName;
        this.phone = value.phone;
        this.salesRepEmployeeNumber = value.salesRepEmployeeNumber;
        this.creditLimit = value.creditLimit;
        this.firstBuyDate = value.firstBuyDate;
    }

    public Customer(
        Long       customerNumber,
        String     customerName,
        String     contactLastName,
        String     contactFirstName,
        String     phone,
        Long       salesRepEmployeeNumber,
        BigDecimal creditLimit,
        YearMonth  firstBuyDate
    ) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.contactLastName = contactLastName;
        this.contactFirstName = contactFirstName;
        this.phone = phone;
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
        this.creditLimit = creditLimit;
        this.firstBuyDate = firstBuyDate;
    }

    /**
     * Getter for <code>classicmodels.customer.customer_number</code>.
     */
    public Long getCustomerNumber() {
        return this.customerNumber;
    }

    /**
     * Setter for <code>classicmodels.customer.customer_number</code>.
     */
    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
    }

    /**
     * Getter for <code>classicmodels.customer.customer_name</code>.
     */
    @NotNull
    @Size(max = 50)
    public String getCustomerName() {
        return this.customerName;
    }

    /**
     * Setter for <code>classicmodels.customer.customer_name</code>.
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Getter for <code>classicmodels.customer.contact_last_name</code>.
     */
    @NotNull
    @Size(max = 50)
    public String getContactLastName() {
        return this.contactLastName;
    }

    /**
     * Setter for <code>classicmodels.customer.contact_last_name</code>.
     */
    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    /**
     * Getter for <code>classicmodels.customer.contact_first_name</code>.
     */
    @NotNull
    @Size(max = 50)
    public String getContactFirstName() {
        return this.contactFirstName;
    }

    /**
     * Setter for <code>classicmodels.customer.contact_first_name</code>.
     */
    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    /**
     * Getter for <code>classicmodels.customer.phone</code>.
     */
    @NotNull
    @Size(max = 50)
    public String getPhone() {
        return this.phone;
    }

    /**
     * Setter for <code>classicmodels.customer.phone</code>.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Getter for <code>classicmodels.customer.sales_rep_employee_number</code>.
     */
    public Long getSalesRepEmployeeNumber() {
        return this.salesRepEmployeeNumber;
    }

    /**
     * Setter for <code>classicmodels.customer.sales_rep_employee_number</code>.
     */
    public void setSalesRepEmployeeNumber(Long salesRepEmployeeNumber) {
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
    }

    /**
     * Getter for <code>classicmodels.customer.credit_limit</code>.
     */
    public BigDecimal getCreditLimit() {
        return this.creditLimit;
    }

    /**
     * Setter for <code>classicmodels.customer.credit_limit</code>.
     */
    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    /**
     * Getter for <code>classicmodels.customer.first_buy_date</code>.
     */
    public YearMonth getFirstBuyDate() {
        return this.firstBuyDate;
    }

    /**
     * Setter for <code>classicmodels.customer.first_buy_date</code>.
     */
    public void setFirstBuyDate(YearMonth firstBuyDate) {
        this.firstBuyDate = firstBuyDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Customer (");

        sb.append(customerNumber);
        sb.append(", ").append(customerName);
        sb.append(", ").append(contactLastName);
        sb.append(", ").append(contactFirstName);
        sb.append(", ").append(phone);
        sb.append(", ").append(salesRepEmployeeNumber);
        sb.append(", ").append(creditLimit);
        sb.append(", ").append(firstBuyDate);

        sb.append(")");
        return sb.toString();
    }
}
