/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables.pojos;


import java.io.Serializable;

import javax.annotation.processing.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.JSON;


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
public class JooqManager implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long   managerId;
    private String managerName;
    private JSON   managerDetail;

    public JooqManager() {}

    public JooqManager(JooqManager value) {
        this.managerId = value.managerId;
        this.managerName = value.managerName;
        this.managerDetail = value.managerDetail;
    }

    public JooqManager(
        Long   managerId,
        String managerName,
        JSON   managerDetail
    ) {
        this.managerId = managerId;
        this.managerName = managerName;
        this.managerDetail = managerDetail;
    }

    /**
     * Getter for <code>SYSTEM.MANAGER.MANAGER_ID</code>.
     */
    @NotNull
    public Long getManagerId() {
        return this.managerId;
    }

    /**
     * Setter for <code>SYSTEM.MANAGER.MANAGER_ID</code>.
     */
    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    /**
     * Getter for <code>SYSTEM.MANAGER.MANAGER_NAME</code>.
     */
    @NotNull
    @Size(max = 50)
    public String getManagerName() {
        return this.managerName;
    }

    /**
     * Setter for <code>SYSTEM.MANAGER.MANAGER_NAME</code>.
     */
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    /**
     * Getter for <code>SYSTEM.MANAGER.MANAGER_DETAIL</code>.
     */
    public JSON getManagerDetail() {
        return this.managerDetail;
    }

    /**
     * Setter for <code>SYSTEM.MANAGER.MANAGER_DETAIL</code>.
     */
    public void setManagerDetail(JSON managerDetail) {
        this.managerDetail = managerDetail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JooqManager (");

        sb.append(managerId);
        sb.append(", ").append(managerName);
        sb.append(", ").append(managerDetail);

        sb.append(")");
        return sb.toString();
    }
}
