/*
 * This file is generated by jOOQ.
 */
package jooq.generated;


import javax.annotation.processing.Generated;

import jooq.generated.tables.Customer;
import jooq.generated.tables.Customerdetail;
import jooq.generated.tables.Department;
import jooq.generated.tables.Employee;
import jooq.generated.tables.OfficeHasManager;
import jooq.generated.tables.Order;
import jooq.generated.tables.Orderdetail;
import jooq.generated.tables.Product;
import jooq.generated.tables.Sale;
import jooq.generated.tables.Top3product;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables in classicmodels.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.4",
        "schema version:1.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index CUSTOMERDETAIL_CUSTOMER_NUMBER = Internal.createIndex(DSL.name("customer_number"), Customerdetail.CUSTOMERDETAIL, new OrderField[] { Customerdetail.CUSTOMERDETAIL.CUSTOMER_NUMBER }, false);
    public static final Index ORDER_CUSTOMER_NUMBER = Internal.createIndex(DSL.name("customer_number"), Order.ORDER, new OrderField[] { Order.ORDER.CUSTOMER_NUMBER }, false);
    public static final Index SALE_EMPLOYEE_NUMBER = Internal.createIndex(DSL.name("employee_number"), Sale.SALE, new OrderField[] { Sale.SALE.EMPLOYEE_NUMBER }, false);
    public static final Index OFFICE_HAS_MANAGER_FK_OFFICES_HAS_MANAGERS_MANAGERS1_IDX = Internal.createIndex(DSL.name("fk_offices_has_managers_managers1_idx"), OfficeHasManager.OFFICE_HAS_MANAGER, new OrderField[] { OfficeHasManager.OFFICE_HAS_MANAGER.MANAGERS_MANAGER_ID }, false);
    public static final Index OFFICE_HAS_MANAGER_FK_OFFICES_HAS_MANAGERS_OFFICES_IDX = Internal.createIndex(DSL.name("fk_offices_has_managers_offices_idx"), OfficeHasManager.OFFICE_HAS_MANAGER, new OrderField[] { OfficeHasManager.OFFICE_HAS_MANAGER.OFFICES_OFFICE_CODE }, false);
    public static final Index DEPARTMENT_OFFICE_CODE = Internal.createIndex(DSL.name("office_code"), Department.DEPARTMENT, new OrderField[] { Department.DEPARTMENT.OFFICE_CODE }, false);
    public static final Index EMPLOYEE_OFFICE_CODE = Internal.createIndex(DSL.name("office_code"), Employee.EMPLOYEE, new OrderField[] { Employee.EMPLOYEE.OFFICE_CODE }, false);
    public static final Index ORDERDETAIL_PRODUCT_ID = Internal.createIndex(DSL.name("product_id"), Orderdetail.ORDERDETAIL, new OrderField[] { Orderdetail.ORDERDETAIL.PRODUCT_ID }, false);
    public static final Index TOP3PRODUCT_PRODUCT_ID = Internal.createIndex(DSL.name("product_id"), Top3product.TOP3PRODUCT, new OrderField[] { Top3product.TOP3PRODUCT.PRODUCT_ID }, false);
    public static final Index PRODUCT_PRODUCT_LINE = Internal.createIndex(DSL.name("product_line"), Product.PRODUCT, new OrderField[] { Product.PRODUCT.PRODUCT_LINE }, false);
    public static final Index EMPLOYEE_REPORTS_TO = Internal.createIndex(DSL.name("reports_to"), Employee.EMPLOYEE, new OrderField[] { Employee.EMPLOYEE.REPORTS_TO }, false);
    public static final Index CUSTOMER_SALES_REP_EMPLOYEE_NUMBER = Internal.createIndex(DSL.name("sales_rep_employee_number"), Customer.CUSTOMER, new OrderField[] { Customer.CUSTOMER.SALES_REP_EMPLOYEE_NUMBER }, false);
}