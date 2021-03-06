/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables.records;


import javax.annotation.processing.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jooq.generated.tables.Manager;

import org.jooq.Field;
import org.jooq.JSON;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
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
public class ManagerRecord extends UpdatableRecordImpl<ManagerRecord> implements Record4<Long, String, JSON, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>classicmodels.manager.manager_id</code>.
     */
    public void setManagerId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>classicmodels.manager.manager_id</code>.
     */
    public Long getManagerId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>classicmodels.manager.manager_name</code>.
     */
    public void setManagerName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>classicmodels.manager.manager_name</code>.
     */
    @NotNull
    @Size(max = 50)
    public String getManagerName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>classicmodels.manager.manager_detail</code>.
     */
    public void setManagerDetail(JSON value) {
        set(2, value);
    }

    /**
     * Getter for <code>classicmodels.manager.manager_detail</code>.
     */
    public JSON getManagerDetail() {
        return (JSON) get(2);
    }

    /**
     * Setter for <code>classicmodels.manager.manager_evaluation</code>.
     */
    public void setManagerEvaluation(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>classicmodels.manager.manager_evaluation</code>.
     */
    @Size(max = 200)
    public String getManagerEvaluation() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, String, JSON, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Long, String, JSON, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Manager.MANAGER.MANAGER_ID;
    }

    @Override
    public Field<String> field2() {
        return Manager.MANAGER.MANAGER_NAME;
    }

    @Override
    public Field<JSON> field3() {
        return Manager.MANAGER.MANAGER_DETAIL;
    }

    @Override
    public Field<String> field4() {
        return Manager.MANAGER.MANAGER_EVALUATION;
    }

    @Override
    public Long component1() {
        return getManagerId();
    }

    @Override
    public String component2() {
        return getManagerName();
    }

    @Override
    public JSON component3() {
        return getManagerDetail();
    }

    @Override
    public String component4() {
        return getManagerEvaluation();
    }

    @Override
    public Long value1() {
        return getManagerId();
    }

    @Override
    public String value2() {
        return getManagerName();
    }

    @Override
    public JSON value3() {
        return getManagerDetail();
    }

    @Override
    public String value4() {
        return getManagerEvaluation();
    }

    @Override
    public ManagerRecord value1(Long value) {
        setManagerId(value);
        return this;
    }

    @Override
    public ManagerRecord value2(String value) {
        setManagerName(value);
        return this;
    }

    @Override
    public ManagerRecord value3(JSON value) {
        setManagerDetail(value);
        return this;
    }

    @Override
    public ManagerRecord value4(String value) {
        setManagerEvaluation(value);
        return this;
    }

    @Override
    public ManagerRecord values(Long value1, String value2, JSON value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ManagerRecord
     */
    public ManagerRecord() {
        super(Manager.MANAGER);
    }

    /**
     * Create a detached, initialised ManagerRecord
     */
    public ManagerRecord(Long managerId, String managerName, JSON managerDetail, String managerEvaluation) {
        super(Manager.MANAGER);

        setManagerId(managerId);
        setManagerName(managerName);
        setManagerDetail(managerDetail);
        setManagerEvaluation(managerEvaluation);
    }
}
