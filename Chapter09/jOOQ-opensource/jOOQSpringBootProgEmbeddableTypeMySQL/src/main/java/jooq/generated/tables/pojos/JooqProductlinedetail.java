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
public class JooqProductlinedetail implements Serializable {

    private static final long serialVersionUID = 1L;

    private String  productLine;
    private Long    code;
    private String  lineCapacity;
    private Integer lineType;

    public JooqProductlinedetail() {}

    public JooqProductlinedetail(JooqProductlinedetail value) {
        this.productLine = value.productLine;
        this.code = value.code;
        this.lineCapacity = value.lineCapacity;
        this.lineType = value.lineType;
    }

    public JooqProductlinedetail(
        String  productLine,
        Long    code,
        String  lineCapacity,
        Integer lineType
    ) {
        this.productLine = productLine;
        this.code = code;
        this.lineCapacity = lineCapacity;
        this.lineType = lineType;
    }

    /**
     * Getter for <code>classicmodels.productlinedetail.product_line</code>.
     */
    @NotNull
    @Size(max = 50)
    public String getProductLine() {
        return this.productLine;
    }

    /**
     * Setter for <code>classicmodels.productlinedetail.product_line</code>.
     */
    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    /**
     * Getter for <code>classicmodels.productlinedetail.code</code>.
     */
    @NotNull
    public Long getCode() {
        return this.code;
    }

    /**
     * Setter for <code>classicmodels.productlinedetail.code</code>.
     */
    public void setCode(Long code) {
        this.code = code;
    }

    /**
     * Getter for <code>classicmodels.productlinedetail.line_capacity</code>.
     */
    @NotNull
    @Size(max = 20)
    public String getLineCapacity() {
        return this.lineCapacity;
    }

    /**
     * Setter for <code>classicmodels.productlinedetail.line_capacity</code>.
     */
    public void setLineCapacity(String lineCapacity) {
        this.lineCapacity = lineCapacity;
    }

    /**
     * Getter for <code>classicmodels.productlinedetail.line_type</code>.
     */
    public Integer getLineType() {
        return this.lineType;
    }

    /**
     * Setter for <code>classicmodels.productlinedetail.line_type</code>.
     */
    public void setLineType(Integer lineType) {
        this.lineType = lineType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JooqProductlinedetail (");

        sb.append(productLine);
        sb.append(", ").append(code);
        sb.append(", ").append(lineCapacity);
        sb.append(", ").append(lineType);

        sb.append(")");
        return sb.toString();
    }
}
