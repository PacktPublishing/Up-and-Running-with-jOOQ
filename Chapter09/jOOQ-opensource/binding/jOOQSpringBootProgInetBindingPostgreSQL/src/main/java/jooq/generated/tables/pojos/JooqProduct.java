/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables.pojos;


import java.io.Serializable;
import java.math.BigDecimal;

import javax.annotation.processing.Generated;
import javax.validation.constraints.Size;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.4",
        "schema version:1.1"
    },
    date = "2020-12-28T06:34:31.202Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqProduct implements Serializable {

    private static final long serialVersionUID = 1931759058;

    private Long       productId;
    private String     productName;
    private String     productLine;
    private String     productScale;
    private String     productVendor;
    private String     productDescription;
    private Short      quantityInStock;
    private BigDecimal buyPrice;
    private BigDecimal msrp;
    private Object     specs;

    public JooqProduct() {}

    public JooqProduct(JooqProduct value) {
        this.productId = value.productId;
        this.productName = value.productName;
        this.productLine = value.productLine;
        this.productScale = value.productScale;
        this.productVendor = value.productVendor;
        this.productDescription = value.productDescription;
        this.quantityInStock = value.quantityInStock;
        this.buyPrice = value.buyPrice;
        this.msrp = value.msrp;
        this.specs = value.specs;
    }

    public JooqProduct(
        Long       productId,
        String     productName,
        String     productLine,
        String     productScale,
        String     productVendor,
        String     productDescription,
        Short      quantityInStock,
        BigDecimal buyPrice,
        BigDecimal msrp,
        Object     specs
    ) {
        this.productId = productId;
        this.productName = productName;
        this.productLine = productLine;
        this.productScale = productScale;
        this.productVendor = productVendor;
        this.productDescription = productDescription;
        this.quantityInStock = quantityInStock;
        this.buyPrice = buyPrice;
        this.msrp = msrp;
        this.specs = specs;
    }

    public Long getProductId() {
        return this.productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Size(max = 70)
    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Size(max = 50)
    public String getProductLine() {
        return this.productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    @Size(max = 10)
    public String getProductScale() {
        return this.productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    @Size(max = 50)
    public String getProductVendor() {
        return this.productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public String getProductDescription() {
        return this.productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Short getQuantityInStock() {
        return this.quantityInStock;
    }

    public void setQuantityInStock(Short quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public BigDecimal getBuyPrice() {
        return this.buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public BigDecimal getMsrp() {
        return this.msrp;
    }

    public void setMsrp(BigDecimal msrp) {
        this.msrp = msrp;
    }


    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using {@literal <deprecationOnUnknownTypes/>} in your code generator configuration.
     */
    @java.lang.Deprecated
    public Object getSpecs() {
        return this.specs;
    }


    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using {@literal <deprecationOnUnknownTypes/>} in your code generator configuration.
     */
    @java.lang.Deprecated
    public void setSpecs(Object specs) {
        this.specs = specs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JooqProduct (");

        sb.append(productId);
        sb.append(", ").append(productName);
        sb.append(", ").append(productLine);
        sb.append(", ").append(productScale);
        sb.append(", ").append(productVendor);
        sb.append(", ").append(productDescription);
        sb.append(", ").append(quantityInStock);
        sb.append(", ").append(buyPrice);
        sb.append(", ").append(msrp);
        sb.append(", ").append(specs);

        sb.append(")");
        return sb.toString();
    }
}