package com.classicmodels.repository;

import static jooq.generated.tables.BankTransaction.BANK_TRANSACTION;
import static jooq.generated.tables.Customer.CUSTOMER;
import static jooq.generated.tables.Customerdetail.CUSTOMERDETAIL;
import static jooq.generated.tables.Orderdetail.ORDERDETAIL;
import static jooq.generated.tables.Payment.PAYMENT;
import static jooq.generated.tables.Product.PRODUCT;
import static jooq.generated.tables.Productline.PRODUCTLINE;
import org.jooq.DSLContext;
import org.jooq.JSON;
import org.jooq.Record1;
import org.jooq.Result;
import static org.jooq.impl.DSL.jsonObject;
import static org.jooq.impl.DSL.jsonArrayAgg;
import static org.jooq.impl.DSL.key;
import static org.jooq.impl.DSL.select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class ClassicModelsRepository {

    private final DSLContext ctx;

    public ClassicModelsRepository(DSLContext ctx) {
        this.ctx = ctx;
    }

    public void jsonProductlineProductOrderdetail() {
/*
        Result<Record1<JSON>> result1 = ctx.select(
                jsonObject(
                        key("productLine").value(PRODUCTLINE.PRODUCT_LINE),
                        key("textDescription").value(PRODUCTLINE.TEXT_DESCRIPTION),
                        key("products").value(select(jsonArrayAgg(
                                jsonObject(key("productName").value(PRODUCT.PRODUCT_NAME),
                                        key("productVendor").value(PRODUCT.PRODUCT_VENDOR),
                                        key("quantityInStock").value(PRODUCT.QUANTITY_IN_STOCK),
                                        key("orderdetail")
                                                .value(select(jsonArrayAgg(
                                                        jsonObject(
                                                                key("quantityOrdered").value(ORDERDETAIL.QUANTITY_ORDERED),
                                                                key("priceEach").value(ORDERDETAIL.PRICE_EACH)))
                                                        .orderBy(ORDERDETAIL.QUANTITY_ORDERED))
                                                        .from(ORDERDETAIL)
                                                        .where(ORDERDETAIL.PRODUCT_ID.eq(PRODUCT.PRODUCT_ID)))))
                                .orderBy(PRODUCT.QUANTITY_IN_STOCK))
                                .from(PRODUCT)
                                .where(PRODUCTLINE.PRODUCT_LINE.eq(PRODUCT.PRODUCT_LINE)))))
                .from(PRODUCTLINE)
                .fetch();
        System.out.println("Example 1.1:\n" + result1.formatJSON());
  
        Result<Record1<JSON>> result2 = ctx.select(
                PRODUCTLINE.PRODUCT_LINE, PRODUCTLINE.TEXT_DESCRIPTION,
                select(PRODUCT.PRODUCT_NAME, PRODUCT.PRODUCT_VENDOR, PRODUCT.QUANTITY_IN_STOCK,
                        select(ORDERDETAIL.QUANTITY_ORDERED, ORDERDETAIL.PRICE_EACH)
                                .from(ORDERDETAIL)
                                .where(ORDERDETAIL.PRODUCT_ID.eq(PRODUCT.PRODUCT_ID))
                                .orderBy(ORDERDETAIL.QUANTITY_ORDERED)
                                // .limit(3) // limit 'orderdetail'
                                .forJSON().path().asField("orderdetails"))
                        .from(PRODUCT)
                        .where(PRODUCT.PRODUCT_LINE.eq(PRODUCTLINE.PRODUCT_LINE))
                        .orderBy(PRODUCT.QUANTITY_IN_STOCK)
                        // .limit(2) // limit 'product'
                        .forJSON().path().asField("products"))
                .from(PRODUCTLINE)
                .orderBy(PRODUCTLINE.PRODUCT_LINE)
                // .limit(2) // limit 'productline'
                .forJSON().path()
                .fetch();

        System.out.println("Example 1.2:\n" + result2.formatJSON());
*/
    }

    public void jsonCustomerPaymentBankTransactionCustomerdetail() {

        Result<Record1<JSON>> result1 = ctx.select(
                jsonObject(
                        key("customerName").value(CUSTOMER.CUSTOMER_NAME),
                        key("creditLimit").value(CUSTOMER.CREDIT_LIMIT),
                        key("payments").value(select(jsonArrayAgg(
                                jsonObject(key("paymentNumber").value(PAYMENT.CUSTOMER_NUMBER),
                                        key("invoiceAmount").value(PAYMENT.INVOICE_AMOUNT),
                                        key("cachingDate").value(PAYMENT.CACHING_DATE),
                                        key("transactions")
                                                .value(select(jsonArrayAgg(
                                                        jsonObject(
                                                                key("bankName").value(BANK_TRANSACTION.BANK_NAME),
                                                                key("transferAmount").value(BANK_TRANSACTION.TRANSFER_AMOUNT)))
                                                        .orderBy(BANK_TRANSACTION.TRANSFER_AMOUNT))
                                                        .from(BANK_TRANSACTION)
                                                        .where(BANK_TRANSACTION.CUSTOMER_NUMBER.eq(PAYMENT.CUSTOMER_NUMBER)
                                                                .and(BANK_TRANSACTION.CHECK_NUMBER.eq(PAYMENT.CHECK_NUMBER))))))
                                .orderBy(PAYMENT.CACHING_DATE))
                                .from(PAYMENT)
                                .where(PAYMENT.CUSTOMER_NUMBER.eq(CUSTOMER.CUSTOMER_NUMBER))),
                        key("details").value(select(
                                jsonObject(key("city").value(CUSTOMERDETAIL.CITY),
                                        key("addressLineFirst").value(CUSTOMERDETAIL.ADDRESS_LINE_FIRST),
                                        key("state").value(CUSTOMERDETAIL.STATE)))
                                .from(CUSTOMERDETAIL)
                                .where(CUSTOMERDETAIL.CUSTOMER_NUMBER.eq(CUSTOMER.CUSTOMER_NUMBER)))))
                .from(CUSTOMER)                
                .fetch();
        System.out.println("Example 2.1:\n" + result1.formatJSON());
        
        Result<Record1<JSON>> result2 = ctx.select(
                CUSTOMER.CUSTOMER_NAME, CUSTOMER.CREDIT_LIMIT,
                select(PAYMENT.CUSTOMER_NUMBER, PAYMENT.INVOICE_AMOUNT, PAYMENT.CACHING_DATE,
                        select(BANK_TRANSACTION.BANK_NAME, BANK_TRANSACTION.TRANSFER_AMOUNT)
                                .from(BANK_TRANSACTION)
                                .where(BANK_TRANSACTION.CUSTOMER_NUMBER.eq(PAYMENT.CUSTOMER_NUMBER)
                                        .and(BANK_TRANSACTION.CHECK_NUMBER.eq(PAYMENT.CHECK_NUMBER)))
                                .orderBy(BANK_TRANSACTION.TRANSFER_AMOUNT)
                                // .limit(3) // limit 'transactions'
                                .forJSON().path().asField("transactions"))
                        .from(PAYMENT)
                        .where(PAYMENT.CUSTOMER_NUMBER.eq(CUSTOMER.CUSTOMER_NUMBER))
                        .orderBy(PAYMENT.CACHING_DATE)
                        // .limit(2) // limit 'payments'
                        .forJSON().path().asField("payments"),
                select(CUSTOMERDETAIL.CITY, CUSTOMERDETAIL.ADDRESS_LINE_FIRST, CUSTOMERDETAIL.STATE)
                        .from(CUSTOMERDETAIL)
                        .where(CUSTOMERDETAIL.CUSTOMER_NUMBER.eq(CUSTOMER.CUSTOMER_NUMBER))                       
                        .forJSON().path().asField("details"))
                .from(CUSTOMER)
                .orderBy(CUSTOMER.CREDIT_LIMIT)
                // .limit(2) // limit 'customers'
                .forJSON().path()
                .fetch();

        System.out.println("Example 2.2:\n" + result2.formatJSON());
    }
}