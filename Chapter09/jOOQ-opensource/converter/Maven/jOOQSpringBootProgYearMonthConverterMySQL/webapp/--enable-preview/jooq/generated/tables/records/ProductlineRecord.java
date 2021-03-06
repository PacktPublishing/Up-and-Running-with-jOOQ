/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables.records;


import java.time.LocalDate;

import javax.annotation.processing.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jooq.generated.tables.Productline;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


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
public class ProductlineRecord extends UpdatableRecordImpl<ProductlineRecord> implements Record6<String, Long, String, String, byte[], LocalDate> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>classicmodels.productline.product_line</code>.
     */
    public void setProductLine(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>classicmodels.productline.product_line</code>.
     */
    @NotNull
    @Size(max = 50)
    public String getProductLine() {
        return (String) get(0);
    }

    /**
     * Setter for <code>classicmodels.productline.code</code>.
     */
    public void setCode(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>classicmodels.productline.code</code>.
     */
    @NotNull
    public Long getCode() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>classicmodels.productline.text_description</code>.
     */
    public void setTextDescription(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>classicmodels.productline.text_description</code>.
     */
    @Size(max = 4000)
    public String getTextDescription() {
        return (String) get(2);
    }

    /**
     * Setter for <code>classicmodels.productline.html_description</code>.
     */
    public void setHtmlDescription(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>classicmodels.productline.html_description</code>.
     */
    @Size(max = 16777215)
    public String getHtmlDescription() {
        return (String) get(3);
    }

    /**
     * Setter for <code>classicmodels.productline.image</code>.
     */
    public void setImage(byte[] value) {
        set(4, value);
    }

    /**
     * Getter for <code>classicmodels.productline.image</code>.
     */
    @Size(max = 16777215)
    public byte[] getImage() {
        return (byte[]) get(4);
    }

    /**
     * Setter for <code>classicmodels.productline.created_on</code>.
     */
    public void setCreatedOn(LocalDate value) {
        set(5, value);
    }

    /**
     * Getter for <code>classicmodels.productline.created_on</code>.
     */
    public LocalDate getCreatedOn() {
        return (LocalDate) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<String, Long> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<String, Long, String, String, byte[], LocalDate> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<String, Long, String, String, byte[], LocalDate> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Productline.PRODUCTLINE.PRODUCT_LINE;
    }

    @Override
    public Field<Long> field2() {
        return Productline.PRODUCTLINE.CODE;
    }

    @Override
    public Field<String> field3() {
        return Productline.PRODUCTLINE.TEXT_DESCRIPTION;
    }

    @Override
    public Field<String> field4() {
        return Productline.PRODUCTLINE.HTML_DESCRIPTION;
    }

    @Override
    public Field<byte[]> field5() {
        return Productline.PRODUCTLINE.IMAGE;
    }

    @Override
    public Field<LocalDate> field6() {
        return Productline.PRODUCTLINE.CREATED_ON;
    }

    @Override
    public String component1() {
        return getProductLine();
    }

    @Override
    public Long component2() {
        return getCode();
    }

    @Override
    public String component3() {
        return getTextDescription();
    }

    @Override
    public String component4() {
        return getHtmlDescription();
    }

    @Override
    public byte[] component5() {
        return getImage();
    }

    @Override
    public LocalDate component6() {
        return getCreatedOn();
    }

    @Override
    public String value1() {
        return getProductLine();
    }

    @Override
    public Long value2() {
        return getCode();
    }

    @Override
    public String value3() {
        return getTextDescription();
    }

    @Override
    public String value4() {
        return getHtmlDescription();
    }

    @Override
    public byte[] value5() {
        return getImage();
    }

    @Override
    public LocalDate value6() {
        return getCreatedOn();
    }

    @Override
    public ProductlineRecord value1(String value) {
        setProductLine(value);
        return this;
    }

    @Override
    public ProductlineRecord value2(Long value) {
        setCode(value);
        return this;
    }

    @Override
    public ProductlineRecord value3(String value) {
        setTextDescription(value);
        return this;
    }

    @Override
    public ProductlineRecord value4(String value) {
        setHtmlDescription(value);
        return this;
    }

    @Override
    public ProductlineRecord value5(byte[] value) {
        setImage(value);
        return this;
    }

    @Override
    public ProductlineRecord value6(LocalDate value) {
        setCreatedOn(value);
        return this;
    }

    @Override
    public ProductlineRecord values(String value1, Long value2, String value3, String value4, byte[] value5, LocalDate value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ProductlineRecord
     */
    public ProductlineRecord() {
        super(Productline.PRODUCTLINE);
    }

    /**
     * Create a detached, initialised ProductlineRecord
     */
    public ProductlineRecord(String productLine, Long code, String textDescription, String htmlDescription, byte[] image, LocalDate createdOn) {
        super(Productline.PRODUCTLINE);

        setProductLine(productLine);
        setCode(code);
        setTextDescription(textDescription);
        setHtmlDescription(htmlDescription);
        setImage(image);
        setCreatedOn(createdOn);
    }
}
