package com.classicmodels.repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Arrays;
import jooq.generated.tables.records.BankTransactionRecord;
import jooq.generated.tables.records.SaleRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ClassicModelsRepository {

    private final DSLContext ctx;

    public ClassicModelsRepository(DSLContext ctx) {
        this.ctx = ctx;
    }

    public void batchMerges1() {

        SaleRecord sr1 = new SaleRecord(BigInteger.valueOf(1), BigInteger.valueOf(2005), 1223.23, 1370L, null, null, null, null);
        SaleRecord sr2 = new SaleRecord(BigInteger.valueOf(2), BigInteger.valueOf(2004), 543.33, null, null, null, null, null);
        SaleRecord sr3 = new SaleRecord(BigInteger.valueOf(3), BigInteger.valueOf(2005), 9022.21, 1370L, null, null, null, null);
        SaleRecord sr4 = new SaleRecord(BigInteger.valueOf(10000), BigInteger.valueOf(2003), 4333.22, 1504L, null, null, null, "UP");
        SaleRecord sr5 = new SaleRecord(BigInteger.valueOf(99999), BigInteger.valueOf(2003), 8002.22, 1504L, null, null, null, null);

        // There will just 1 batch since the generated SQL with bind variables is the same for all SaleRecords
        // The order of records is perserved
        
        // Records batch merges (single query, bind values)
        int[] result = ctx.batchMerge(sr1, sr2, sr3, sr4, sr5)
                .execute();
        
        // Records batch merges (multiple query, inlined values)
        // Order of records is always preserved entirely
        // ctx.configuration().derive(
        //        new Settings().withStatementType(StatementType.STATIC_STATEMENT))
        //        .dsl().batchMerge(...) ...

        System.out.println("EXAMPLE 1.1: " + Arrays.toString(result));
    }

    public void batchMerges2() {

        SaleRecord sr1 = new SaleRecord(BigInteger.valueOf(1), BigInteger.valueOf(2005), 1223.23, 1370L, null, null, null, null);
        SaleRecord sr2 = new SaleRecord(BigInteger.valueOf(2), BigInteger.valueOf(2004), 543.33, null, null, null, null, null);
        SaleRecord sr3 = new SaleRecord(BigInteger.valueOf(3), BigInteger.valueOf(2005), 9022.21, 1370L, null, null, null, null);
        BankTransactionRecord bt1 = new BankTransactionRecord(
                pk(), "", "", BigDecimal.ONE, LocalDateTime.now(), 112L, "BO864823", "");
        SaleRecord sr4 = new SaleRecord(BigInteger.valueOf(1000), BigInteger.valueOf(2003), 4333.22, 1504L, null, null, null, "UP");
        SaleRecord sr5 = new SaleRecord(BigInteger.valueOf(9999), BigInteger.valueOf(2003), 8002.22, 1504L, null, null, null, null);
        BankTransactionRecord bt2 = new BankTransactionRecord(
                pk(), "", "", BigDecimal.ONE, LocalDateTime.now(), 112L, "HQ55022", "");

        // There will just 2 batches, 1 batch for SaleRecord and 1 batch for BankTransactionRecord
        // The order of records is not perserved since:
        // the first batch is for BankTransactionRecord
        // the first batch is for SaleRecord
        int[] result = ctx.batchMerge(bt2, sr1, sr2, sr3, bt1, sr4, sr5)
                .execute();

        System.out.println("EXAMPLE 1.2: " + Arrays.toString(result));
    }

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

        System.out.println("EXAMPLE 1.3: " + Arrays.toString(result));
    }

    private long pk() {

        return (long) (Math.random() * 999999999);
    }
}