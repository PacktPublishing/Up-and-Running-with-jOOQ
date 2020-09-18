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
    date = "2020-08-29T13:16:19.652Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Employee implements Serializable {

    private static final long serialVersionUID = -941051816;

    private Long    employeeNumber;
    private String  lastName;
    private String  firstName;
    private String  extension;
    private String  email;
    private String  officeCode;
    private Integer salary;
    private Long    reportsTo;
    private String  jobTitle;

    public Employee() {}

    public Employee(Employee value) {
        this.employeeNumber = value.employeeNumber;
        this.lastName = value.lastName;
        this.firstName = value.firstName;
        this.extension = value.extension;
        this.email = value.email;
        this.officeCode = value.officeCode;
        this.salary = value.salary;
        this.reportsTo = value.reportsTo;
        this.jobTitle = value.jobTitle;
    }

    public Employee(
        Long    employeeNumber,
        String  lastName,
        String  firstName,
        String  extension,
        String  email,
        String  officeCode,
        Integer salary,
        Long    reportsTo,
        String  jobTitle
    ) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.extension = extension;
        this.email = email;
        this.officeCode = officeCode;
        this.salary = salary;
        this.reportsTo = reportsTo;
        this.jobTitle = jobTitle;
    }

    @NotNull
    public Long getEmployeeNumber() {
        return this.employeeNumber;
    }

    public void setEmployeeNumber(Long employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @NotNull
    @Size(max = 50)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotNull
    @Size(max = 50)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotNull
    @Size(max = 10)
    public String getExtension() {
        return this.extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @NotNull
    @Size(max = 100)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    public Integer getSalary() {
        return this.salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Long getReportsTo() {
        return this.reportsTo;
    }

    public void setReportsTo(Long reportsTo) {
        this.reportsTo = reportsTo;
    }

    @NotNull
    @Size(max = 50)
    public String getJobTitle() {
        return this.jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Employee (");

        sb.append(employeeNumber);
        sb.append(", ").append(lastName);
        sb.append(", ").append(firstName);
        sb.append(", ").append(extension);
        sb.append(", ").append(email);
        sb.append(", ").append(officeCode);
        sb.append(", ").append(salary);
        sb.append(", ").append(reportsTo);
        sb.append(", ").append(jobTitle);

        sb.append(")");
        return sb.toString();
    }
}
