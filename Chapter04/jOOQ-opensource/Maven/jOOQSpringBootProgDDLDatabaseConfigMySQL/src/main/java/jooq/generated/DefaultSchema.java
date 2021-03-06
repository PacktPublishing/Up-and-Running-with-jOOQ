/*
 * This file is generated by jOOQ.
 */
package jooq.generated;


import java.util.Arrays;
import java.util.List;

import jooq.generated.tables.Customer;
import jooq.generated.tables.Customerdetail;
import jooq.generated.tables.Department;
import jooq.generated.tables.Employee;
import jooq.generated.tables.Manager;
import jooq.generated.tables.Office;
import jooq.generated.tables.OfficeHasManager;
import jooq.generated.tables.Order;
import jooq.generated.tables.Orderdetail;
import jooq.generated.tables.Payment;
import jooq.generated.tables.Product;
import jooq.generated.tables.Productline;
import jooq.generated.tables.Sale;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DefaultSchema extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>DEFAULT_SCHEMA</code>
     */
    public static final DefaultSchema DEFAULT_SCHEMA = new DefaultSchema();

    /**
     * The table <code>customer</code>.
     */
    public final Customer CUSTOMER = Customer.CUSTOMER;

    /**
     * The table <code>customerdetail</code>.
     */
    public final Customerdetail CUSTOMERDETAIL = Customerdetail.CUSTOMERDETAIL;

    /**
     * The table <code>department</code>.
     */
    public final Department DEPARTMENT = Department.DEPARTMENT;

    /**
     * The table <code>employee</code>.
     */
    public final Employee EMPLOYEE = Employee.EMPLOYEE;

    /**
     * The table <code>manager</code>.
     */
    public final Manager MANAGER = Manager.MANAGER;

    /**
     * The table <code>office</code>.
     */
    public final Office OFFICE = Office.OFFICE;

    /**
     * The table <code>office_has_manager</code>.
     */
    public final OfficeHasManager OFFICE_HAS_MANAGER = OfficeHasManager.OFFICE_HAS_MANAGER;

    /**
     * The table <code>order</code>.
     */
    public final Order ORDER = Order.ORDER;

    /**
     * The table <code>orderdetail</code>.
     */
    public final Orderdetail ORDERDETAIL = Orderdetail.ORDERDETAIL;

    /**
     * The table <code>payment</code>.
     */
    public final Payment PAYMENT = Payment.PAYMENT;

    /**
     * The table <code>product</code>.
     */
    public final Product PRODUCT = Product.PRODUCT;

    /**
     * The table <code>productline</code>.
     */
    public final Productline PRODUCTLINE = Productline.PRODUCTLINE;

    /**
     * The table <code>sale</code>.
     */
    public final Sale SALE = Sale.SALE;

    /**
     * No further instances allowed
     */
    private DefaultSchema() {
        super("", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            Customer.CUSTOMER,
            Customerdetail.CUSTOMERDETAIL,
            Department.DEPARTMENT,
            Employee.EMPLOYEE,
            Manager.MANAGER,
            Office.OFFICE,
            OfficeHasManager.OFFICE_HAS_MANAGER,
            Order.ORDER,
            Orderdetail.ORDERDETAIL,
            Payment.PAYMENT,
            Product.PRODUCT,
            Productline.PRODUCTLINE,
            Sale.SALE);
    }
}
