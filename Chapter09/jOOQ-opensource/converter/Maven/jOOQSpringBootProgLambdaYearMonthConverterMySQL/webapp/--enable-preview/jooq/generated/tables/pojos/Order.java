/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables.pojos;


import java.io.Serializable;
import java.time.LocalDate;

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
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long      orderId;
    private LocalDate orderDate;
    private LocalDate requiredDate;
    private LocalDate shippedDate;
    private String    status;
    private String    comments;
    private Long      customerNumber;

    public Order() {}

    public Order(Order value) {
        this.orderId = value.orderId;
        this.orderDate = value.orderDate;
        this.requiredDate = value.requiredDate;
        this.shippedDate = value.shippedDate;
        this.status = value.status;
        this.comments = value.comments;
        this.customerNumber = value.customerNumber;
    }

    public Order(
        Long      orderId,
        LocalDate orderDate,
        LocalDate requiredDate,
        LocalDate shippedDate,
        String    status,
        String    comments,
        Long      customerNumber
    ) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.status = status;
        this.comments = comments;
        this.customerNumber = customerNumber;
    }

    /**
     * Getter for <code>classicmodels.order.order_id</code>.
     */
    public Long getOrderId() {
        return this.orderId;
    }

    /**
     * Setter for <code>classicmodels.order.order_id</code>.
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * Getter for <code>classicmodels.order.order_date</code>.
     */
    @NotNull
    public LocalDate getOrderDate() {
        return this.orderDate;
    }

    /**
     * Setter for <code>classicmodels.order.order_date</code>.
     */
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Getter for <code>classicmodels.order.required_date</code>.
     */
    @NotNull
    public LocalDate getRequiredDate() {
        return this.requiredDate;
    }

    /**
     * Setter for <code>classicmodels.order.required_date</code>.
     */
    public void setRequiredDate(LocalDate requiredDate) {
        this.requiredDate = requiredDate;
    }

    /**
     * Getter for <code>classicmodels.order.shipped_date</code>.
     */
    public LocalDate getShippedDate() {
        return this.shippedDate;
    }

    /**
     * Setter for <code>classicmodels.order.shipped_date</code>.
     */
    public void setShippedDate(LocalDate shippedDate) {
        this.shippedDate = shippedDate;
    }

    /**
     * Getter for <code>classicmodels.order.status</code>.
     */
    @NotNull
    @Size(max = 15)
    public String getStatus() {
        return this.status;
    }

    /**
     * Setter for <code>classicmodels.order.status</code>.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Getter for <code>classicmodels.order.comments</code>.
     */
    @Size(max = 65535)
    public String getComments() {
        return this.comments;
    }

    /**
     * Setter for <code>classicmodels.order.comments</code>.
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Getter for <code>classicmodels.order.customer_number</code>.
     */
    @NotNull
    public Long getCustomerNumber() {
        return this.customerNumber;
    }

    /**
     * Setter for <code>classicmodels.order.customer_number</code>.
     */
    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order (");

        sb.append(orderId);
        sb.append(", ").append(orderDate);
        sb.append(", ").append(requiredDate);
        sb.append(", ").append(shippedDate);
        sb.append(", ").append(status);
        sb.append(", ").append(comments);
        sb.append(", ").append(customerNumber);

        sb.append(")");
        return sb.toString();
    }
}
