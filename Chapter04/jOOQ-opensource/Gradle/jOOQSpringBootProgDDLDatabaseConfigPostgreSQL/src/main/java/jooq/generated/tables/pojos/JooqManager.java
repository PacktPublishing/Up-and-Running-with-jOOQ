/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables.pojos;


import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqManager implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long   managerId;
    private String managerName;

    public JooqManager() {}

    public JooqManager(JooqManager value) {
        this.managerId = value.managerId;
        this.managerName = value.managerName;
    }

    public JooqManager(
        Long   managerId,
        String managerName
    ) {
        this.managerId = managerId;
        this.managerName = managerName;
    }

    /**
     * Getter for <code>manager.manager_id</code>.
     */
    public Long getManagerId() {
        return this.managerId;
    }

    /**
     * Setter for <code>manager.manager_id</code>.
     */
    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    /**
     * Getter for <code>manager.manager_name</code>.
     */
    @NotNull
    @Size(max = 50)
    public String getManagerName() {
        return this.managerName;
    }

    /**
     * Setter for <code>manager.manager_name</code>.
     */
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JooqManager (");

        sb.append(managerId);
        sb.append(", ").append(managerName);

        sb.append(")");
        return sb.toString();
    }
}
