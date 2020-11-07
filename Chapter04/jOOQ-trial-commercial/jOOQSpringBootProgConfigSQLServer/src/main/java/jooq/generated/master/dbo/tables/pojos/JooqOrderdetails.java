/*
 * This file is generated by jOOQ.
 */
package jooq.generated.master.dbo.tables.pojos;


import java.io.Serializable;
import java.math.BigDecimal;

import javax.annotation.processing.Generated;
import javax.validation.constraints.NotNull;


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
public class JooqOrderdetails implements Serializable {

    private static final long serialVersionUID = 2077423350;

    private Integer    orderid;
    private Integer    productid;
    private Integer    quantityordered;
    private BigDecimal priceeach;
    private Short      orderlinenumber;

    public JooqOrderdetails() {}

    public JooqOrderdetails(JooqOrderdetails value) {
        this.orderid = value.orderid;
        this.productid = value.productid;
        this.quantityordered = value.quantityordered;
        this.priceeach = value.priceeach;
        this.orderlinenumber = value.orderlinenumber;
    }

    public JooqOrderdetails(
        Integer    orderid,
        Integer    productid,
        Integer    quantityordered,
        BigDecimal priceeach,
        Short      orderlinenumber
    ) {
        this.orderid = orderid;
        this.productid = productid;
        this.quantityordered = quantityordered;
        this.priceeach = priceeach;
        this.orderlinenumber = orderlinenumber;
    }

    @NotNull
    public Integer getOrderid() {
        return this.orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    @NotNull
    public Integer getProductid() {
        return this.productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    @NotNull
    public Integer getQuantityordered() {
        return this.quantityordered;
    }

    public void setQuantityordered(Integer quantityordered) {
        this.quantityordered = quantityordered;
    }

    @NotNull
    public BigDecimal getPriceeach() {
        return this.priceeach;
    }

    public void setPriceeach(BigDecimal priceeach) {
        this.priceeach = priceeach;
    }

    @NotNull
    public Short getOrderlinenumber() {
        return this.orderlinenumber;
    }

    public void setOrderlinenumber(Short orderlinenumber) {
        this.orderlinenumber = orderlinenumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JooqOrderdetails (");

        sb.append(orderid);
        sb.append(", ").append(productid);
        sb.append(", ").append(quantityordered);
        sb.append(", ").append(priceeach);
        sb.append(", ").append(orderlinenumber);

        sb.append(")");
        return sb.toString();
    }
}