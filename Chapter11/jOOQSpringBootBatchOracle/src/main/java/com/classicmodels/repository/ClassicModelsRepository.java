package com.classicmodels.repository;

import com.classicmodels.pojo.SimpleSale;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jooq.generated.tables.BankTransaction.BANK_TRANSACTION;
import static jooq.generated.tables.Customer.CUSTOMER;
import static jooq.generated.tables.Customerdetail.CUSTOMERDETAIL;
import static jooq.generated.tables.Employee.EMPLOYEE;
import static jooq.generated.tables.Order.ORDER;
import static jooq.generated.tables.Orderdetail.ORDERDETAIL;
import static jooq.generated.tables.Payment.PAYMENT;
import static jooq.generated.tables.Productlinedetail.PRODUCTLINEDETAIL;
import static jooq.generated.tables.Sale.SALE;
import jooq.generated.tables.records.BankTransactionRecord;
import jooq.generated.tables.records.SaleRecord;
import org.jooq.BatchBindStep;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.conf.Settings;
import org.jooq.conf.StatementType;
import static org.jooq.impl.DSL.select;
import org.jooq.tools.jdbc.BatchedConnection;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class ClassicModelsRepository {

    private final DSLContext ctx;

    public ClassicModelsRepository(DSLContext ctx) {
        this.ctx = ctx;
    }

    @Transactional
    public void batchInserts() {

        // batch inserts in a table having auto-generated primary key (several queries)
        int[] result1 = ctx.configuration().derive(
                new Settings().withBatchSize(3))
                .dsl().batch(
                        ctx.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(BigInteger.valueOf(2005), 1370L, 1282.64),
                        ctx.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(BigInteger.valueOf(2004), 1370L, 3938.24),
                        ctx.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(BigInteger.valueOf(2004), 1370L, 4676.14),
                        ctx.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(BigInteger.valueOf(2003), 1166L, 2223.0),
                        ctx.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(BigInteger.valueOf(2004), 1166L, 4531.35),
                        ctx.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(BigInteger.valueOf(2004), 1166L, 6751.33)
                ).execute();

        System.out.println("EXAMPLE 1.1: " + Arrays.toString(result1));

        // batch inserts in a table having auto-generated primary key (single query)
        int[] result2 = ctx.configuration().derive(
                new Settings().withBatchSize(3))
                .dsl().batch(
                        ctx.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values((BigInteger) null, null, null))
                .bind(2005, 1370L, 1282.64)
                .bind(2004, 1370L, 3938.24)
                .bind(2004, 1370L, 4676.14)
                .bind(2003, 1166L, 2223.0)
                .bind(2004, 1166L, 4531.35)
                .bind(2004, 1166L, 6751.33)
                .execute();

        System.out.println("EXAMPLE 1.2: " + Arrays.toString(result2));

        // rely on global batch size (see com.classicmodels.jooq.settings.JooqSetting)
        int[] result3 = ctx.batch(
                ctx.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values((BigInteger) null, null, null))
                .bind(2005, 1370L, 1282.64)
                .bind(2004, 1370L, 3938.24)
                .bind(2004, 1370L, 4676.14)
                .bind(2003, 1166L, 2223.0)
                .bind(2004, 1166L, 4531.35)
                .bind(2004, 1166L, 6751.33)
                .execute();

        System.out.println("EXAMPLE 1.3: " + Arrays.toString(result3));

        // batch inserts in a table having manually assigned primary key
        int[] result4 = ctx.configuration().derive(
                new Settings().withBatchSize(3))
                .dsl().batch(
                        ctx.insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                                EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                                .values(10L, "Toga", "Alison", "x3332", "talison@classicmodelcars.com", "1", BigInteger.valueOf(110000), "VP Sales")
                                .onConflictDoNothing(),
                        ctx.insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                                EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                                .values(11L, "Marius", "Pologa", "x5332", "mpologa@classicmodelcars.com", "3", BigInteger.valueOf(50000), "Sales Rep")
                                .onConflictDoNothing(),
                        ctx.insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                                EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                                .values(12L, "Ana", "Arica", "x5111", "aarica@classicmodelcars.com", "3", BigInteger.valueOf(50000), "Sales Rep")
                                .onConflictDoNothing()
                ).execute();

        System.out.println("EXAMPLE 1.4: " + Arrays.toString(result4));

        // records batch inserts       
        SaleRecord sr1 = new SaleRecord(null, BigInteger.valueOf(2005), 1223.23, 1370L, null, null, null, null);
        SaleRecord sr2 = new SaleRecord(null, BigInteger.valueOf(2004), 543.33, 1166L, null, null, null, null);
        SaleRecord sr3 = new SaleRecord(null, BigInteger.valueOf(2005), 9022.21, 1370L, null, null, null, null);
        SaleRecord sr4 = new SaleRecord(null, BigInteger.valueOf(2003), 4333.22, 1504L, null, null, null, null);
        SaleRecord sr5 = new SaleRecord(null, BigInteger.valueOf(2003), 8002.22, 1504L, null, null, null, null);

        List<SaleRecord> sales = List.of(sr1, sr2, sr3, sr4, sr5);

        int[] result5 = ctx.configuration().derive(
                new Settings().withBatchSize(3)).dsl()
                .batchInsert(sales)
                // or, .batchInsert(sr1, sr2, sr3, sr4, sr5)
                .execute();

        System.out.println("EXAMPLE 1.5: " + Arrays.toString(result5));
    }

    @Transactional
    public void batchUpdates() {

        // batch updates (several queries)
        int[] result1 = ctx.configuration().derive(
                new Settings().withBatchSize(2))
                .dsl().batch(
                        ctx.update(EMPLOYEE)
                                .set(EMPLOYEE.SALARY, EMPLOYEE.SALARY.plus(1_000))
                                .where(EMPLOYEE.SALARY.between(BigInteger.valueOf(100_000), BigInteger.valueOf(120_000))),
                        ctx.update(EMPLOYEE)
                                .set(EMPLOYEE.SALARY, EMPLOYEE.SALARY.plus(5_000))
                                .where(EMPLOYEE.SALARY.between(BigInteger.valueOf(65_000), BigInteger.valueOf(80_000))),
                        ctx.update(EMPLOYEE)
                                .set(EMPLOYEE.SALARY, EMPLOYEE.SALARY.plus(10_000))
                                .where(EMPLOYEE.SALARY.between(BigInteger.valueOf(55_000), BigInteger.valueOf(60_000))),
                        ctx.update(EMPLOYEE)
                                .set(EMPLOYEE.SALARY, EMPLOYEE.SALARY.plus(15_000))
                                .where(EMPLOYEE.SALARY.between(BigInteger.valueOf(50_000), BigInteger.valueOf(50_000)))) // or simply, eq(BigInteger.valueOf(50_000))
                .execute();

        System.out.println("EXAMPLE 2.1: " + Arrays.toString(result1));

        // batch updates (single query)
        int[] result2 = ctx.batch(
                ctx.update(EMPLOYEE)
                        .set(EMPLOYEE.SALARY, EMPLOYEE.SALARY.plus((Integer) null))
                        .where(EMPLOYEE.SALARY.between((BigInteger) null, (BigInteger) null)))
                .bind(1000, 100000, 120000)
                .bind(5000, 65000, 80000)
                .bind(10000, 55000, 60000)
                .bind(15000, 50000, 50000)
                .execute();

        System.out.println("EXAMPLE 2.2: " + Arrays.toString(result2));

        // records batch updates
        List<SaleRecord> sales = ctx.selectFrom(SALE)
                .orderBy(SALE.SALE_ID)
                .limit(3)
                .fetch();

        sales.get(0).setTrend("UP");
        sales.get(0).setFiscalYear(BigInteger.valueOf(2004));
        sales.get(1).setSale(5664.2);
        sales.get(2).setFiscalYear(BigInteger.valueOf(2003));
        sales.get(2).setEmployeeNumber(1504L);

        int[] result3 = ctx.configuration().derive(
                new Settings().withBatchSize(3)).dsl()
                .batchUpdate(sales) // or, .batchUpdate(sales.get(0), sales.get(1), sales.get(2))
                .execute();

        System.out.println("EXAMPLE 2.3: " + Arrays.toString(result3));
    }

    @Transactional
    public void batchDeletes() {

        // batch deletes (several queries)
        int[] result1 = ctx.configuration().derive(
                new Settings().withBatchSize(2))
                .dsl().batch(
                        ctx.deleteFrom(ORDERDETAIL)
                                .where(ORDERDETAIL.ORDER_ID.in(
                                        select(ORDER.ORDER_ID).from(ORDER)
                                                .where(ORDER.CUSTOMER_NUMBER.eq(103L)))),
                        ctx.deleteFrom(ORDER)
                                .where(ORDER.CUSTOMER_NUMBER.eq(103L)),
                        ctx.deleteFrom(CUSTOMERDETAIL)
                                .where(CUSTOMERDETAIL.CUSTOMER_NUMBER.eq(103L)),
                        ctx.deleteFrom(BANK_TRANSACTION)
                                .where(BANK_TRANSACTION.CUSTOMER_NUMBER.eq(103L)),
                        ctx.deleteFrom(PAYMENT)
                                .where(PAYMENT.CUSTOMER_NUMBER.eq(103L)),
                        ctx.deleteFrom(CUSTOMER)
                                .where(CUSTOMER.CUSTOMER_NUMBER.eq(103L)))
                .execute();

        System.out.println("EXAMPLE 3.1: " + Arrays.toString(result1));

        // batch deletes (single query)
        int[] result2 = ctx.batch(
                ctx.deleteFrom(SALE)
                        .where(SALE.SALE_.between((Double) null, (Double) null)))
                .bind(0, 1000)
                .bind(2000, 3000)
                .bind(4000, 5000)
                .execute();

        System.out.println("EXAMPLE 3.2: " + Arrays.toString(result2));

        // records batch deletes
        var r1 = ctx.selectFrom(SALE)
                .where(SALE.SALE_ID.eq(BigInteger.valueOf(1)))
                .fetchOne();

        var r2 = ctx.selectFrom(BANK_TRANSACTION)
                .where(BANK_TRANSACTION.TRANSACTION_ID.eq(1L))
                .fetchOne();

        var r3 = ctx.selectFrom(PRODUCTLINEDETAIL)
                .where(PRODUCTLINEDETAIL.PRODUCT_LINE.eq("Classic Cars"))
                .fetchOne();

        int[] result3 = ctx.configuration().derive(
                new Settings().withBatchSize(3)).dsl()
                .batchDelete(r1, r2, r3)
                .execute();

        System.out.println("EXAMPLE 3.3: " + Arrays.toString(result3));
    }

    @Transactional
    public void batchMerges1() {

        SaleRecord sr1 = new SaleRecord(BigInteger.valueOf(1), BigInteger.valueOf(2005), 1223.23, 1370L, null, null, null, null);
        SaleRecord sr2 = new SaleRecord(BigInteger.valueOf(2), BigInteger.valueOf(2004), 543.33, null, null, null, null, null);
        SaleRecord sr3 = new SaleRecord(BigInteger.valueOf(3), BigInteger.valueOf(2005), 9022.21, 1370L, null, null, null, null);
        SaleRecord sr4 = new SaleRecord(BigInteger.valueOf(10000), BigInteger.valueOf(2003), 4333.22, 1504L, null, null, null, "UP");
        SaleRecord sr5 = new SaleRecord(BigInteger.valueOf(99999), BigInteger.valueOf(2003), 8002.22, 1504L, null, null, null, null);
        
        // There will just 1 batch since the generated SQL with bind variables is the same for all SaleRecords
        // The order of records is perserved
        int[] result = ctx.batchMerge(sr1, sr2, sr3, sr4, sr5)
                .execute();

        System.out.println("EXAMPLE 4.1: " + Arrays.toString(result));
    }

    @Transactional
    public void batchMerges2() {

        SaleRecord sr1 = new SaleRecord(BigInteger.valueOf(1), BigInteger.valueOf(2005), 1223.23, 1370L, null, null, null, null);
        SaleRecord sr2 = new SaleRecord(BigInteger.valueOf(2), BigInteger.valueOf(2004), 543.33, null, null, null, null, null);
        SaleRecord sr3 = new SaleRecord(BigInteger.valueOf(3), BigInteger.valueOf(2005), 9022.21, 1370L, null, null, null, null);
        BankTransactionRecord bt1 = new BankTransactionRecord(
                (long) (Math.random() * 999999), "", "", BigDecimal.ONE, LocalDateTime.now(), 112L, "BO864823", "");
        SaleRecord sr4 = new SaleRecord(BigInteger.valueOf(1000), BigInteger.valueOf(2003), 4333.22, 1504L, null, null, null, "UP");
        SaleRecord sr5 = new SaleRecord(BigInteger.valueOf(9999), BigInteger.valueOf(2003), 8002.22, 1504L, null, null, null, null);
        BankTransactionRecord bt2 = new BankTransactionRecord(
                (long) (Math.random() * 999999), "", "", BigDecimal.ONE, LocalDateTime.now(), 112L, "HQ55022", "");

        // There will just 2 batches, 1 batch for SaleRecord and 1 batch for BankTransactionRecord
        // The order of records is not perserved since:
        // the first batch is for BankTransactionRecord
        // the first batch is for SaleRecord
        int[] result = ctx.batchMerge(bt2, sr1, sr2, sr3, bt1, sr4, sr5)
                .execute();

        System.out.println("EXAMPLE 4.2: " + Arrays.toString(result));
    }

    @Transactional
    public void batchMerges3() {

        SaleRecord sr1 = new SaleRecord();     
        sr1.setFiscalYear(BigInteger.valueOf(2005));
        sr1.setSale(1223.23);
        sr1.setEmployeeNumber(1370L);
        sr1.setTrend("UP");
        
        SaleRecord sr2 = new SaleRecord();        
        sr2.setFiscalYear(BigInteger.valueOf(2005));
        sr2.setSale(9022.21);
        
        SaleRecord sr3 = new SaleRecord();        
        sr3.setFiscalYear(BigInteger.valueOf(2003));
        sr3.setSale(8002.22);
        sr3.setEmployeeNumber(1504L);        

        // There will 3 batches, 1 batch for each SaleRecord since  
        // each SaleRecord has a different generated SQL with bind variables
        // The order of records is perserved        
        int[] result = ctx.batchMerge(sr1, sr2, sr3)
                .execute();

        System.out.println("EXAMPLE 4.3: " + Arrays.toString(result));
    }

    @Transactional
    public void batchStoresSimple() {

        // execute an INSERT
        SaleRecord sr1 = new SaleRecord(BigInteger.valueOf((long) (Math.random() * 99999)), 
                BigInteger.valueOf(2005), 1223.23, 1370L, null, null, null, null);

        // execute an UPDATE (if you modify the primary key that an INSERT is executed
        SaleRecord sr2 = ctx.selectFrom(SALE)
                .where(SALE.SALE_ID.eq(BigInteger.valueOf(1)))
                .fetchOne();

        if (sr2 != null) {
            sr2.setFiscalYear(BigInteger.valueOf(2006));
        }

        int[] result = ctx.batchStore(sr1, sr2)
                .execute();

        System.out.println("EXAMPLE 5: " + Arrays.toString(result));
    }

    @Transactional
    public void batchStoresPreparedStatement1() {

        SaleRecord i1 = new SaleRecord(BigInteger.valueOf((long) (Math.random() * 9999)), BigInteger.valueOf(2005), 1223.23, 1370L, null, null, null, null);
        SaleRecord i2 = new SaleRecord(BigInteger.valueOf((long) (Math.random() * 9999)), BigInteger.valueOf(2005), 9022.21, 1166L, null, null, null, null);
        SaleRecord i3 = new SaleRecord(BigInteger.valueOf((long) (Math.random() * 9999)), BigInteger.valueOf(2003), 8002.22, 1504L, null, null, null, null);
        SaleRecord i4 = new SaleRecord(BigInteger.valueOf((long) (Math.random() * 9999)), BigInteger.valueOf(2003), 8002.22, 1611L, null, null, null, null);

        SaleRecord u1 = ctx.selectFrom(SALE).where(SALE.SALE_ID.eq(BigInteger.valueOf(1))).fetchSingle();
        u1.setFiscalYear(BigInteger.valueOf(2010));
        SaleRecord u2 = ctx.selectFrom(SALE).where(SALE.SALE_ID.eq(BigInteger.valueOf(2))).fetchSingle();
        u2.setFiscalYear(BigInteger.valueOf(2011));
        SaleRecord u3 = ctx.selectFrom(SALE).where(SALE.SALE_ID.eq(BigInteger.valueOf(3))).fetchSingle();
        u3.setFiscalYear(BigInteger.valueOf(2012));
        SaleRecord u4 = ctx.selectFrom(SALE).where(SALE.SALE_ID.eq(BigInteger.valueOf(4))).fetchSingle();
        u4.setFiscalYear(BigInteger.valueOf(2013));

        // There will just 2 batches, 1 batch for INSERTs and 1 batch for UPDATEs because
        // the generated SQL with bind variables is the same for all INSERTs, and the same for all UPDATEs.
        // The order of records is perserved exactly since:
        // INSERTs are executed in order i1, i2, i3, i4
        // UPDATEs are executed in order u1, u2, u3, u4
        int[] result61 = ctx.batchStore(i1, u1, i2, u2, i3, u3, i4, u4)
                .execute();

        System.out.println("EXAMPLE 6.1: " + Arrays.toString(result61));
    }

    @Transactional
    public void batchStoresPreparedStatement2() {

        SaleRecord i1 = new SaleRecord(BigInteger.valueOf((long) (Math.random() * 99999)), BigInteger.valueOf(2005), 1223.23, 1370L, null, null, null, null);
        SaleRecord u1 = ctx.selectFrom(SALE).where(SALE.SALE_ID.eq(BigInteger.valueOf(1))).fetchSingle();
        u1.setFiscalYear(BigInteger.valueOf(2006));
        SaleRecord i2 = new SaleRecord(BigInteger.valueOf((long) (Math.random() * 99999)), BigInteger.valueOf(2005), 9022.21, 1166L, null, null, null, null);
        SaleRecord u2 = ctx.selectFrom(SALE).where(SALE.SALE_ID.eq(BigInteger.valueOf(2))).fetchSingle();
        u2.setFiscalYear(BigInteger.valueOf(2007));
        SaleRecord i3 = new SaleRecord(BigInteger.valueOf((long) (Math.random() * 99999)), BigInteger.valueOf(2003), 8002.22, 1504L, null, null, null, null);
        SaleRecord u3 = ctx.selectFrom(SALE).where(SALE.SALE_ID.eq(BigInteger.valueOf(3))).fetchSingle();
        u3.setFiscalYear(BigInteger.valueOf(2008));
        SaleRecord i4 = new SaleRecord(BigInteger.valueOf((long) (Math.random() * 99999)), BigInteger.valueOf(2003), 8002.22, 1611L, null, null, null, null);
        SaleRecord u4 = ctx.selectFrom(SALE).where(SALE.SALE_ID.eq(BigInteger.valueOf(4))).fetchSingle();
        u4.setFiscalYear(BigInteger.valueOf(2009));

        // There will just 2 batches, 1 batch for INSERTs and 1 batch for UPDATEs because
        // the generated SQL with bind variables is the same for all INSERTs, and the same for all UPDATEs.
        // The order of records is not perserved since:
        // INSERTs are executed in order i1, i2, i3, i4
        // UPDATEs are executed in order u1, u2, u3, u4
        int[] result62 = ctx.batchStore(i1, u1, i2, u2, i3, u3, i4, u4)
                .execute();

        System.out.println("EXAMPLE 6.2: " + Arrays.toString(result62));
    }

    @Transactional
    public void batchStoresPreparedStatement3() {

        SaleRecord i1 = new SaleRecord(BigInteger.valueOf((long) (Math.random() * 9999999)), BigInteger.valueOf(2005), 1223.23, 1370L, null, null, null, null);
        SaleRecord u1 = ctx.selectFrom(SALE).where(SALE.SALE_ID.eq(BigInteger.valueOf(1))).fetchSingle();
        u1.setFiscalYear(BigInteger.valueOf(2016));
        SaleRecord i2 = new SaleRecord(BigInteger.valueOf((long) (Math.random() * 9999999)), BigInteger.valueOf(2005), 9022.21, 1166L, null, null, null, null);
        SaleRecord u2 = ctx.selectFrom(SALE).where(SALE.SALE_ID.eq(BigInteger.valueOf(2))).fetchSingle();
        u2.setTrend("CONSTANT");
        SaleRecord i3 = new SaleRecord(BigInteger.valueOf((long) (Math.random() * 9999999)), BigInteger.valueOf(2003), 8002.22, 1504L, null, null, null, null);
        SaleRecord u3 = ctx.selectFrom(SALE).where(SALE.SALE_ID.eq(BigInteger.valueOf(3))).fetchSingle();
        u3.setSale(0.0);
        SaleRecord i4 = new SaleRecord(BigInteger.valueOf((long) (Math.random() * 9999999)), BigInteger.valueOf(2003), 8002.22, 1611L, null, null, null, null);
        SaleRecord u4 = ctx.selectFrom(SALE).where(SALE.SALE_ID.eq(BigInteger.valueOf(4))).fetchSingle();
        u4.setFiscalYear(BigInteger.valueOf(2017));

        // There will just 4 batches, 1 batch for INSERTs and 3 batch for UPDATEs because
        // The generated SQL with bind variables is the same for all INSERTs.
        // The generated SQL with bind variables is the same for UPDATEs u1 and u4, so they form 1 batch.
        // The generated SQL with bind variables is not the same for UPDATEs u2 and u3, so they form 1 batch each.
        // The order of records is not perserved since:
        // INSERTs are executed in order i1, i2, i3, i4
        // UPDATEs are executed in order u1, u4, u2, u3
        int[] result63 = ctx.batchStore(i1, u1, i2, u2, i3, u3, i4, u4)
                .execute();

        System.out.println("EXAMPLE 6.3: " + Arrays.toString(result63));
    }

    @Transactional
    public void batchStoresPreparedStatement4() {

        SaleRecord i1 = new SaleRecord();
        i1.setSaleId(BigInteger.valueOf((long) (Math.random() * 999999999)));
        i1.setFiscalYear(BigInteger.valueOf(2005));
        i1.setSale(1223.23);
        i1.setEmployeeNumber(1370L);
        i1.setTrend("UP");
        SaleRecord u1 = ctx.selectFrom(SALE).where(SALE.SALE_ID.eq(BigInteger.valueOf(1))).fetchSingle();
        u1.setFiscalYear(BigInteger.valueOf(2018));
        SaleRecord i2 = new SaleRecord();
        i2.setSaleId(BigInteger.valueOf((long) (Math.random() * 999999999)));
        i2.setFiscalYear(BigInteger.valueOf(2005));
        i2.setSale(9022.21);
        SaleRecord u2 = ctx.selectFrom(SALE).where(SALE.SALE_ID.eq(BigInteger.valueOf(2))).fetchSingle();
        u2.setTrend("DOWN");
        SaleRecord i3 = new SaleRecord();
        i3.setSaleId(BigInteger.valueOf((long) (Math.random() * 999999999)));
        i3.setFiscalYear(BigInteger.valueOf(2003));
        i3.setSale(8002.22);
        i3.setEmployeeNumber(1504L);
        SaleRecord u3 = ctx.selectFrom(SALE).where(SALE.SALE_ID.eq(BigInteger.valueOf(3))).fetchSingle();
        u3.setSale(10000.0);
        SaleRecord i4 = new SaleRecord();
        i4.setSaleId(BigInteger.valueOf((long) (Math.random() * 999999999)));
        i4.setFiscalYear(BigInteger.valueOf(2003));
        i4.setSale(8002.22);
        i4.setEmployeeNumber(1611L);
        i4.setHot((byte) 1);
        SaleRecord u4 = ctx.selectFrom(SALE).where(SALE.SALE_ID.eq(BigInteger.valueOf(4))).fetchSingle();
        u4.setEmployeeNumber(1165L);

        // This is the worst-case scenario, there will just 8 batches, 1 batch for each INSERT and each UPDATE
        // The generated SQL with bind variables different for all statements.
        // The order of records is perserved since:
        // Statements are processed as: i1, u1, i2, u2, i3, u3, i4, u4
        int[] result64 = ctx.batchStore(i1, u1, i2, u2, i3, u3, i4, u4)
                .execute();

        System.out.println("EXAMPLE 6.4: " + Arrays.toString(result64));
    }

    @Transactional
    public void batchStoresStaticStatement() {

        SaleRecord i1 = new SaleRecord(BigInteger.valueOf((long) (Math.random() * 99999999)), BigInteger.valueOf(2005), 1223.23, 1370L, null, null, null, null);
        SaleRecord i2 = new SaleRecord(BigInteger.valueOf((long) (Math.random() * 99999999)), BigInteger.valueOf(2005), 9022.21, 1166L, null, null, null, null);
        SaleRecord i3 = new SaleRecord(BigInteger.valueOf((long) (Math.random() * 99999999)), BigInteger.valueOf(2003), 8002.22, 1504L, null, null, null, null);
        SaleRecord i4 = new SaleRecord(BigInteger.valueOf((long) (Math.random() * 99999999)), BigInteger.valueOf(2003), 8002.22, 1611L, null, null, null, null);

        SaleRecord u1 = ctx.selectFrom(SALE).where(SALE.SALE_ID.eq(BigInteger.valueOf(1))).fetchSingle();
        u1.setFiscalYear(BigInteger.valueOf(2010));
        SaleRecord u2 = ctx.selectFrom(SALE).where(SALE.SALE_ID.eq(BigInteger.valueOf(2))).fetchSingle();
        u2.setFiscalYear(BigInteger.valueOf(2011));
        SaleRecord u3 = ctx.selectFrom(SALE).where(SALE.SALE_ID.eq(BigInteger.valueOf(3))).fetchSingle();
        u3.setFiscalYear(BigInteger.valueOf(2012));
        SaleRecord u4 = ctx.selectFrom(SALE).where(SALE.SALE_ID.eq(BigInteger.valueOf(4))).fetchSingle();
        u4.setFiscalYear(BigInteger.valueOf(2013));

        // The order of records is perserved exactly
        // jOOQ can guarantee that only a single batch statement is serialised to the database
        int[] result = ctx.configuration().derive(
                new Settings().withStatementType(StatementType.STATIC_STATEMENT))
                .dsl().batchStore(i1, u1, i2, u2, i3, u3, i4, u4)
                .execute();

        System.out.println("EXAMPLE 7: " + Arrays.toString(result));
    }

    @Transactional
    public void combineBatch() {

        // combine batch
        int[] result = ctx.configuration().derive(
                new Settings().withBatchSize(3))
                .dsl().batch(
                        ctx.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(BigInteger.valueOf(2005), 1370L, 1282.64),
                        ctx.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(BigInteger.valueOf(2004), 1370L, 3938.24),
                        ctx.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(BigInteger.valueOf(2004), 1370L, 4676.14),
                        ctx.update(EMPLOYEE)
                                .set(EMPLOYEE.SALARY, EMPLOYEE.SALARY.plus(1_000))
                                .where(EMPLOYEE.SALARY.between(BigInteger.valueOf(100_000), BigInteger.valueOf(120_000))),
                        ctx.update(EMPLOYEE)
                                .set(EMPLOYEE.SALARY, EMPLOYEE.SALARY.plus(5_000))
                                .where(EMPLOYEE.SALARY.between(BigInteger.valueOf(65_000), BigInteger.valueOf(80_000))),
                        ctx.update(EMPLOYEE)
                                .set(EMPLOYEE.SALARY, EMPLOYEE.SALARY.plus(10_000))
                                .where(EMPLOYEE.SALARY.between(BigInteger.valueOf(55_000), BigInteger.valueOf(60_000))),
                        ctx.deleteFrom(BANK_TRANSACTION).where(BANK_TRANSACTION.TRANSACTION_ID.eq(1L)),
                        ctx.deleteFrom(BANK_TRANSACTION).where(BANK_TRANSACTION.TRANSACTION_ID.eq(2L)),
                        ctx.deleteFrom(BANK_TRANSACTION).where(BANK_TRANSACTION.TRANSACTION_ID.eq(3L)),
                        ctx.deleteFrom(BANK_TRANSACTION).where(BANK_TRANSACTION.TRANSACTION_ID.eq(4L))
                ).execute();

        System.out.println("EXAMPLE 8: " + Arrays.toString(result));

    }

    // batch collection of Objects
    @Transactional
    public void batchCollectionOfObjects() {

        List<SimpleSale> sales = List.of(
                new SimpleSale(2005, 1370L, 1282.64),
                new SimpleSale(2004, 1370L, 3938.24),
                new SimpleSale(2004, 1370L, 4676.14)
        );

        BatchBindStep batch = ctx.batch(
                ctx.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                        .values((BigInteger) null, null, null)
        );

        sales.forEach(s -> batch.bind(s.getFiscalYear(), s.getEmployeeNumber(), s.getSale()));
        batch.execute();
    }

    // use batched()
    @Transactional
    public void batchedInsertsAndUpdates1() {

        ctx.batched(this::insertsAndUpdates);
    }   

    @Transactional
    public void batchedInsertsAndUpdates2() {

        ctx.batched((Configuration c) -> {
            inserts(c);
            updates(c);
        });
    }
    
    @Transactional
    public void batchedAndReturn() {

        String result = ctx.batchedResult((Configuration c) -> {
            return insertsAndReturn(c);
        });
        
        System.out.println("EXAMPLE 9: " + result);
    }

    public void insertsAndUpdates(Configuration c) {

        DSLContext ctxLocal = c.dsl();

        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(BigInteger.valueOf(2005), 1370L, 1282.64).execute();
        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(BigInteger.valueOf(2004), 1370L, 3938.24).execute();
        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(BigInteger.valueOf(2004), 1370L, 4676.14).execute();
        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(BigInteger.valueOf(2003), 1166L, 2223.0).execute();
        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(BigInteger.valueOf(2004), 1166L, 4531.35).execute();
        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(BigInteger.valueOf(2004), 1166L, 6751.33).execute();

        ctxLocal.update(EMPLOYEE)
                .set(EMPLOYEE.SALARY, EMPLOYEE.SALARY.plus(1_000))
                .where(EMPLOYEE.SALARY.between(BigInteger.valueOf(100_000), BigInteger.valueOf(120_000))).execute();
        ctxLocal.update(EMPLOYEE)
                .set(EMPLOYEE.SALARY, EMPLOYEE.SALARY.plus(5_000))
                .where(EMPLOYEE.SALARY.between(BigInteger.valueOf(65_000), BigInteger.valueOf(80_000))).execute();
        ctxLocal.update(EMPLOYEE)
                .set(EMPLOYEE.SALARY, EMPLOYEE.SALARY.plus(10_000))
                .where(EMPLOYEE.SALARY.between(BigInteger.valueOf(55_000), BigInteger.valueOf(60_000))).execute();

        ctxLocal.insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                .values(10L, "Toga", "Alison", "x3332", "talison@classicmodelcars.com", "1", BigInteger.valueOf(110000), "VP Sales")
                .onConflictDoNothing().execute();
        ctxLocal.insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                .values(11L, "Marius", "Pologa", "x5332", "mpologa@classicmodelcars.com", "3", BigInteger.valueOf(50000), "Sales Rep")
                .onConflictDoNothing().execute();
        ctxLocal.insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                .values(12L, "Ana", "Arica", "x5111", "aarica@classicmodelcars.com", "3", BigInteger.valueOf(50000), "Sales Rep")
                .onConflictDoNothing().execute();
    }

    public void inserts(Configuration c) {

        DSLContext ctxLocal = c.dsl();

        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(BigInteger.valueOf(2005), 1370L, 1282.64).execute();
        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(BigInteger.valueOf(2004), 1370L, 3938.24).execute();
        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(BigInteger.valueOf(2004), 1370L, 4676.14).execute();
        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(BigInteger.valueOf(2003), 1166L, 2223.0).execute();
        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(BigInteger.valueOf(2004), 1166L, 4531.35).execute();
        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(BigInteger.valueOf(2004), 1166L, 6751.33).execute();

        ctxLocal.insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                .values(10L, "Toga", "Alison", "x3332", "talison@classicmodelcars.com", "1", BigInteger.valueOf(110000), "VP Sales")
                .onConflictDoNothing().execute();
        ctxLocal.insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                .values(11L, "Marius", "Pologa", "x5332", "mpologa@classicmodelcars.com", "3", BigInteger.valueOf(50000), "Sales Rep")
                .onConflictDoNothing().execute();
        ctxLocal.insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                .values(12L, "Ana", "Arica", "x5111", "aarica@classicmodelcars.com", "3", BigInteger.valueOf(50000), "Sales Rep")
                .onConflictDoNothing().execute();
    }
    
    public String insertsAndReturn(Configuration c) {

        DSLContext ctxLocal = c.dsl();

        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(BigInteger.valueOf(2005), 1370L, 1282.64).execute();
        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(BigInteger.valueOf(2004), 1370L, 3938.24).execute();
        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(BigInteger.valueOf(2004), 1370L, 4676.14).execute();
        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(BigInteger.valueOf(2003), 1166L, 2223.0).execute();
        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(BigInteger.valueOf(2004), 1166L, 4531.35).execute();
        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(BigInteger.valueOf(2004), 1166L, 6751.33).execute();

        ctxLocal.insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                .values(13L, "Toga", "Alison", "x3332", "talison@classicmodelcars.com", "1", BigInteger.valueOf(110000), "VP Sales")
                .onConflictDoNothing().execute();
        ctxLocal.insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                .values(14L, "Marius", "Pologa", "x5332", "mpologa@classicmodelcars.com", "3", BigInteger.valueOf(50000), "Sales Rep")
                .onConflictDoNothing().execute();
        ctxLocal.insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                .values(15L, "Ana", "Arica", "x5111", "aarica@classicmodelcars.com", "3", BigInteger.valueOf(50000), "Sales Rep")
                .onConflictDoNothing().execute();
        
        return "success";
    }

    public void updates(Configuration c) {

        DSLContext ctxLocal = c.dsl();

        ctxLocal.update(EMPLOYEE)
                .set(EMPLOYEE.SALARY, EMPLOYEE.SALARY.plus(1_000))
                .where(EMPLOYEE.SALARY.between(BigInteger.valueOf(100_000), BigInteger.valueOf(120_000))).execute();
        ctxLocal.update(EMPLOYEE)
                .set(EMPLOYEE.SALARY, EMPLOYEE.SALARY.plus(5_000))
                .where(EMPLOYEE.SALARY.between(BigInteger.valueOf(65_000), BigInteger.valueOf(80_000))).execute();
        ctxLocal.update(EMPLOYEE)
                .set(EMPLOYEE.SALARY, EMPLOYEE.SALARY.plus(10_000))
                .where(EMPLOYEE.SALARY.between(BigInteger.valueOf(55_000), BigInteger.valueOf(60_000))).execute();
    }

    // use batched() and records
    @Transactional
    public void batchedRecords() {

        ctx.batched(c -> {

            Result<SaleRecord> records = c.dsl().selectFrom(SALE)
                    .limit(5)
                    .fetch();

            records.forEach(record -> {
                record.setTrend("CONSTANT");
                // ...
                record.store();
            });
        });

        // by default the generated INSERT has 3 placeholders
        // insert into "SYSTEM"."SALE" ("SYSTEM"."SALE"."FISCAL_YEAR", "SYSTEM"."SALE"."SALE", "SYSTEM"."SALE"."TREND") values (?, ?, ?)
        SaleRecord sr1 = new SaleRecord();
        sr1.setFiscalYear(BigInteger.valueOf(2003));
        sr1.setTrend("UP");
        sr1.setSale(34493.22);

        // by default the generated INSERT has 4 placeholders
        // insert into "SYSTEM"."SALE" ("SYSTEM"."SALE"."FISCAL_YEAR", "SYSTEM"."SALE"."SALE", "SYSTEM"."SALE"."EMPLOYEE_NUMBER", "SYSTEM"."SALE"."HOT") values (?, ?, ?, ?)
        SaleRecord sr2 = new SaleRecord();
        sr2.setEmployeeNumber(1370L);
        sr2.setSale(4522.34);
        sr2.setFiscalYear(BigInteger.valueOf(2005));
        sr2.setHot((byte) 1);

        // in this context, there will be 2 batches, but we can force a single batch if
        // we force a insert having the same string, and for this we can
        // enforce all INSERT statements to be the same by 
        // seting all changed flags of each individual record to true
        sr1.changed(true);
        sr2.changed(true);

        // a single batch is executed having this INSERT
        // insert into "SYSTEM"."SALE" ("SYSTEM"."SALE"."SALE_ID", "SYSTEM"."SALE"."FISCAL_YEAR", "SYSTEM"."SALE"."SALE", 
        //   "SYSTEM"."SALE"."EMPLOYEE_NUMBER", "SYSTEM"."SALE"."HOT", "SYSTEM"."SALE"."RATE", "SYSTEM"."SALE"."VAT", "SYSTEM"."SALE"."TREND") values (?, ?, ?, ?, ?, ?, ?, ?)
        ctx.batchInsert(sr1, sr2).execute();
    }

    // use BatchedConnection    
    public void batchedConnectionUsage() {

        try ( BatchedConnection conn = new BatchedConnection(DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "root"), 2)) {

            String sql1 = "insert into \"SYSTEM\".\"SALE\" (\"SYSTEM\".\"SALE\".\"FISCAL_YEAR\", \"SYSTEM\".\"SALE\".\"EMPLOYEE_NUMBER\", \"SYSTEM\".\"SALE\".\"SALE\") "
                    + "values (?, ?, ?)";

            try ( PreparedStatement stmt = conn.prepareStatement(sql1)) {
                stmt.setInt(1, 2004);
                stmt.setLong(2, 1166L);
                stmt.setDouble(3, 543.33);
                stmt.executeUpdate();
            }

            try ( PreparedStatement stmt = conn.prepareStatement(sql1)) {
                stmt.setInt(1, 2005);
                stmt.setLong(2, 1370L);
                stmt.setDouble(3, 9022.20);
                stmt.executeUpdate();
            }

            // reached batch limit so this is the second batch
            try ( PreparedStatement stmt = conn.prepareStatement(sql1)) {
                stmt.setInt(1, 2003);
                stmt.setLong(2, 1166L);
                stmt.setDouble(3, 3213.0);
                stmt.executeUpdate();
            }

            // since the following SQL string is different, next statements represents the third batch
            String sql2 = "insert into \"SYSTEM\".\"SALE\" (\"SYSTEM\".\"SALE\".\"FISCAL_YEAR\", \"SYSTEM\".\"SALE\".\"EMPLOYEE_NUMBER\", \"SYSTEM\".\"SALE\".\"SALE\", \"SYSTEM\".\"SALE\".\"TREND\") "
                    + "values (?, ?, ?, ?)";

            try ( PreparedStatement stmt = conn.prepareStatement(sql2)) {
                stmt.setInt(1, 2004);
                stmt.setLong(2, 1166L);
                stmt.setDouble(3, 4541.35);
                stmt.setString(4, "UP");
                stmt.executeUpdate();
            }

            try ( PreparedStatement stmt = conn.prepareStatement(sql2)) {
                stmt.setInt(1, 2005);
                stmt.setLong(2, 1370L);
                stmt.setDouble(3, 1282.64);
                stmt.setString(4, "DOWN");
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassicModelsRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        // same thing, less verbose
        try ( BatchedConnection conn = new BatchedConnection(DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "root"), 2)) {

            try ( PreparedStatement stmt = conn.prepareStatement("insert into \"SYSTEM\".\"SALE\" (\"SYSTEM\".\"SALE\".\"FISCAL_YEAR\", \"SYSTEM\".\"SALE\".\"EMPLOYEE_NUMBER\", \"SYSTEM\".\"SALE\".\"SALE\") "
                    + "values (?, ?, ?)")) {

                // the next 2 statements will become the first batch                        
                stmt.setInt(1, 2004);
                stmt.setLong(2, 1166L);
                stmt.setDouble(3, 543.33);
                stmt.executeUpdate();

                stmt.setInt(1, 2005);
                stmt.setLong(2, 1370L);
                stmt.setDouble(3, 9022.20);
                stmt.executeUpdate();

                // reached batch limit so this is the second batch
                stmt.setInt(1, 2003);
                stmt.setLong(2, 1166L);
                stmt.setDouble(3, 3213.0);
                stmt.executeUpdate();
            }

            // since the following SQL string is different, next statements represents the third batch
            try ( PreparedStatement stmt = conn.prepareStatement("insert into \"SYSTEM\".\"SALE\" (\"SYSTEM\".\"SALE\".\"FISCAL_YEAR\", \"SYSTEM\".\"SALE\".\"EMPLOYEE_NUMBER\", \"SYSTEM\".\"SALE\".\"SALE\", \"SYSTEM\".\"SALE\".\"TREND\") "
                    + "values (?, ?, ?, ?)")) {

                stmt.setInt(1, 2004);
                stmt.setLong(2, 1166L);
                stmt.setDouble(3, 4541.35);
                stmt.setString(4, "UP");
                stmt.executeUpdate();

                stmt.setInt(1, 2005);
                stmt.setLong(2, 1370L);
                stmt.setDouble(3, 1282.64);
                stmt.setString(4, "DOWN");
                stmt.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClassicModelsRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // batching relationships
    @Transactional
    public void batchingOneToMany() {

        // avoid this approach since you can optimize the number of batches by ordering inserts (executes 4 batches)
        ctx.batched((Configuration c) -> {
            c.dsl().insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                    EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                    .values(20001L, "Alison", "Joly", "x445", "ajoly@classicmodelcars.com", "3", BigInteger.valueOf(55000), "Sales Rep")
                    .onConflictDoNothing().execute();
            c.dsl().insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(BigInteger.valueOf(2005), 20001L, 1282.64).execute();
            c.dsl().insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(BigInteger.valueOf(2004), 20001L, 3938.24).execute();
            c.dsl().insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(BigInteger.valueOf(2004), 20001L, 4676.14).execute();

            c.dsl().insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                    EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                    .values(20002L, "Tyler", "Seven", "x101", "tseven@classicmodelcars.com", "2", BigInteger.valueOf(57000), "Sales Rep")
                    .onConflictDoNothing().execute();
            c.dsl().insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(BigInteger.valueOf(2003), 20002L, 2223.0).execute();
            c.dsl().insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(BigInteger.valueOf(2004), 20002L, 4531.35).execute();
            c.dsl().insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(BigInteger.valueOf(2004), 20002L, 6751.33).execute();
        });

        // prefer this approach (executes 2 batches)
        ctx.batched((Configuration c) -> {
            c.dsl().insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                    EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                    .values(20001L, "Alison", "Joly", "x445", "ajoly@classicmodelcars.com", "3", BigInteger.valueOf(55000), "Sales Rep")
                    .onConflictDoNothing().execute();
            c.dsl().insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                    EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                    .values(20002L, "Tyler", "Seven", "x101", "tseven@classicmodelcars.com", "2", BigInteger.valueOf(57000), "Sales Rep")
                    .onConflictDoNothing().execute();

            c.dsl().insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(BigInteger.valueOf(2005), 20001L, 1282.64).execute();
            c.dsl().insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(BigInteger.valueOf(2004), 20001L, 3938.24).execute();
            c.dsl().insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(BigInteger.valueOf(2004), 20001L, 4676.14).execute();
            c.dsl().insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(BigInteger.valueOf(2003), 20002L, 2223.0).execute();
            c.dsl().insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(BigInteger.valueOf(2004), 20002L, 4531.35).execute();
            c.dsl().insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(BigInteger.valueOf(2004), 20002L, 6751.33).execute();
        });
    }
}