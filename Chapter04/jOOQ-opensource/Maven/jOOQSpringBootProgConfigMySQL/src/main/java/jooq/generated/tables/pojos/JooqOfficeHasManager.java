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
        "jOOQ version:3.13.4",
        "schema version:1.1"
    },
    date = "2020-10-19T13:27:12.864Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqOfficeHasManager implements Serializable {

    private static final long serialVersionUID = -2104746304;

    private String officesOfficeCode;
    private Long   managersManagerId;

    public JooqOfficeHasManager() {}

    public JooqOfficeHasManager(JooqOfficeHasManager value) {
        this.officesOfficeCode = value.officesOfficeCode;
        this.managersManagerId = value.managersManagerId;
    }

    public JooqOfficeHasManager(
        String officesOfficeCode,
        Long   managersManagerId
    ) {
        this.officesOfficeCode = officesOfficeCode;
        this.managersManagerId = managersManagerId;
    }

    @NotNull
    @Size(max = 10)
    public String getOfficesOfficeCode() {
        return this.officesOfficeCode;
    }

    public void setOfficesOfficeCode(String officesOfficeCode) {
        this.officesOfficeCode = officesOfficeCode;
    }

    @NotNull
    public Long getManagersManagerId() {
        return this.managersManagerId;
    }

    public void setManagersManagerId(Long managersManagerId) {
        this.managersManagerId = managersManagerId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JooqOfficeHasManager (");

        sb.append(officesOfficeCode);
        sb.append(", ").append(managersManagerId);

        sb.append(")");
        return sb.toString();
    }
}
