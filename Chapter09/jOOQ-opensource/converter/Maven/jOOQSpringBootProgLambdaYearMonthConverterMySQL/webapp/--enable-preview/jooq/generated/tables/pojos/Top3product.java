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
        "jOOQ version:3.14.4",
        "schema version:1.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Top3product implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long   productId;
    private String productName;

    public Top3product() {}

    public Top3product(Top3product value) {
        this.productId = value.productId;
        this.productName = value.productName;
    }

    public Top3product(
        Long   productId,
        String productName
    ) {
        this.productId = productId;
        this.productName = productName;
    }

    /**
     * Getter for <code>classicmodels.top3product.product_id</code>.
     */
    @NotNull
    public Long getProductId() {
        return this.productId;
    }

    /**
     * Setter for <code>classicmodels.top3product.product_id</code>.
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * Getter for <code>classicmodels.top3product.product_name</code>.
     */
    @Size(max = 70)
    public String getProductName() {
        return this.productName;
    }

    /**
     * Setter for <code>classicmodels.top3product.product_name</code>.
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Top3product (");

        sb.append(productId);
        sb.append(", ").append(productName);

        sb.append(")");
        return sb.toString();
    }
}
