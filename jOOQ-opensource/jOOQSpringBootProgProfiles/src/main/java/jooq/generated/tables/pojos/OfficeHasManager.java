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
        "jOOQ version:3.13.2",
        "schema version:1.1"
    },
    date = "2020-07-04T08:58:29.902Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OfficeHasManager implements Serializable {

    private static final long serialVersionUID = 1949449032;

    private String officeCode;
    private Long   managerId;

    public OfficeHasManager() {}

    public OfficeHasManager(OfficeHasManager value) {
        this.officeCode = value.officeCode;
        this.managerId = value.managerId;
    }

    public OfficeHasManager(
        String officeCode,
        Long   managerId
    ) {
        this.officeCode = officeCode;
        this.managerId = managerId;
    }

    @NotNull
    @Size(max = 10)
    public String getOfficeCode() {
        return this.officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    @NotNull
    public Long getManagerId() {
        return this.managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("OfficeHasManager (");

        sb.append(officeCode);
        sb.append(", ").append(managerId);

        sb.append(")");
        return sb.toString();
    }
}
