package com.classicmodels.repository;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jooq.generated.tables.Employee.EMPLOYEE;
import static jooq.generated.tables.Sale.SALE;
import jooq.generated.tables.records.SaleRecord;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.tools.jdbc.BatchedConnection;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ClassicModelsRepository {

    private final DSLContext ctx;

    public ClassicModelsRepository(DSLContext ctx) {
        this.ctx = ctx;
    }

    public void batchedInsertsAndUpdates1() {

        ctx.batched(this::insertsAndUpdates);
    }

    public void batchedInsertsAndUpdates2() {

        ctx.batched((Configuration c) -> {
            inserts(c);
            updates(c);
        });
    }

    public void batchedAndReturn() {

        String result = ctx.batchedResult((Configuration c) -> {
            return insertsAndReturn(c);
        });

        System.out.println("EXAMPLE 1: " + result);
    }

    private void insertsAndUpdates(Configuration c) {

        DSLContext ctxLocal = c.dsl();

        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(2005, 1370L, 1282.64).execute();
        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(2004, 1370L, 3938.24).execute();
        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(2004, 1370L, 4676.14).execute();
        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(2003, 1166L, 2223.0).execute();
        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(2004, 1166L, 4531.35).execute();
        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(2004, 1166L, 6751.33).execute();

        ctxLocal.update(EMPLOYEE)
                .set(EMPLOYEE.SALARY, EMPLOYEE.SALARY.plus(1_000))
                .where(EMPLOYEE.SALARY.between(100_000, 120_000)).execute();
        ctxLocal.update(EMPLOYEE)
                .set(EMPLOYEE.SALARY, EMPLOYEE.SALARY.plus(5_000))
                .where(EMPLOYEE.SALARY.between(65_000, 80_000)).execute();
        ctxLocal.update(EMPLOYEE)
                .set(EMPLOYEE.SALARY, EMPLOYEE.SALARY.plus(10_000))
                .where(EMPLOYEE.SALARY.between(55_000, 60_000)).execute();

        ctxLocal.insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                .values(10L, "Toga", "Alison", "x3332", "talison@classicmodelcars.com", "1", 110000, "VP Sales")
                .onConflictDoNothing().execute();
        ctxLocal.insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                .values(11L, "Marius", "Pologa", "x5332", "mpologa@classicmodelcars.com", "3", 50000, "Sales Rep")
                .onConflictDoNothing().execute();
        ctxLocal.insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                .values(12L, "Ana", "Arica", "x5111", "aarica@classicmodelcars.com", "3", 50000, "Sales Rep")
                .onConflictDoNothing().execute();
    }

    private void inserts(Configuration c) {

        DSLContext ctxLocal = c.dsl();

        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(2005, 1370L, 1282.64).execute();
        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(2004, 1370L, 3938.24).execute();
        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(2004, 1370L, 4676.14).execute();
        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(2003, 1166L, 2223.0).execute();
        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(2004, 1166L, 4531.35).execute();
        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(2004, 1166L, 6751.33).execute();

        ctxLocal.insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                .values(10L, "Toga", "Alison", "x3332", "talison@classicmodelcars.com", "1", 110000, "VP Sales")
                .onConflictDoNothing().execute();
        ctxLocal.insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                .values(11L, "Marius", "Pologa", "x5332", "mpologa@classicmodelcars.com", "3", 50000, "Sales Rep")
                .onConflictDoNothing().execute();
        ctxLocal.insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                .values(12L, "Ana", "Arica", "x5111", "aarica@classicmodelcars.com", "3", 50000, "Sales Rep")
                .onConflictDoNothing().execute();
    }

    private String insertsAndReturn(Configuration c) {

        DSLContext ctxLocal = c.dsl();

        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(2005, 1370L, 1282.64).execute();
        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(2004, 1370L, 3938.24).execute();
        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(2004, 1370L, 4676.14).execute();
        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(2003, 1166L, 2223.0).execute();
        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(2004, 1166L, 4531.35).execute();
        ctxLocal.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                .values(2004, 1166L, 6751.33).execute();

        ctxLocal.insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                .values(13L, "Toga", "Alison", "x3332", "talison@classicmodelcars.com", "1", 110000, "VP Sales")
                .onConflictDoNothing().execute();
        ctxLocal.insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                .values(14L, "Marius", "Pologa", "x5332", "mpologa@classicmodelcars.com", "3", 50000, "Sales Rep")
                .onConflictDoNothing().execute();
        ctxLocal.insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                .values(15L, "Ana", "Arica", "x5111", "aarica@classicmodelcars.com", "3", 50000, "Sales Rep")
                .onConflictDoNothing().execute();

        return "success";
    }

    private void updates(Configuration c) {

        DSLContext ctxLocal = c.dsl();

        ctxLocal.update(EMPLOYEE)
                .set(EMPLOYEE.SALARY, EMPLOYEE.SALARY.plus(1_000))
                .where(EMPLOYEE.SALARY.between(100_000, 120_000)).execute();
        ctxLocal.update(EMPLOYEE)
                .set(EMPLOYEE.SALARY, EMPLOYEE.SALARY.plus(5_000))
                .where(EMPLOYEE.SALARY.between(65_000, 80_000)).execute();
        ctxLocal.update(EMPLOYEE)
                .set(EMPLOYEE.SALARY, EMPLOYEE.SALARY.plus(10_000))
                .where(EMPLOYEE.SALARY.between(55_000, 60_000)).execute();
    }

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
        // insert into `classicmodels`.`sale` (`fiscal_year`, `sale`, `trend`) values (?, ?, ?)
        SaleRecord sr1 = new SaleRecord();
        sr1.setFiscalYear(2003);
        sr1.setTrend("UP");
        sr1.setSale(34493.22);

        // by default the generated INSERT has 4 placeholders
        // insert into `classicmodels`.`sale` (`fiscal_year`, `sale`, `employee_number`, `hot`) values (?, ?, ?, ?)
        SaleRecord sr2 = new SaleRecord();
        sr2.setEmployeeNumber(1370L);
        sr2.setSale(4522.34);
        sr2.setFiscalYear(2005);
        sr2.setHot((byte) 1);

        // in this context, there will be 2 batches, but we can force a single batch if
        // we force a insert having the same string, and for this we can
        // enforce all INSERT statements to be the same by 
        // seting all changed flags of each individual record to true
        sr1.changed(true);
        sr2.changed(true);

        // a single batch is executed having this INSERT
        // insert into `classicmodels`.`sale` (`sale_id`, `fiscal_year`, `sale`, `employee_number`, `hot`, `rate`, `vat`, `trend`) values (?, ?, ?, ?, ?, ?, ?, ?)
        ctx.batchInsert(sr1, sr2).execute();
    }

    // use BatchedConnection    
    public void batchedConnectionUsage() {

        try ( BatchedConnection conn = new BatchedConnection(DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/classicmodels", "root", "root"), 2)) {

            String sql1 = "insert into `classicmodels`.`sale` (`fiscal_year`, `employee_number`, `sale`) "
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
            String sql2 = "insert into `classicmodels`.`sale` (`fiscal_year`, `employee_number`, `sale`, `trend`) "
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
                "jdbc:mysql://localhost:3306/classicmodels", "root", "root"), 2)) {

            try ( PreparedStatement stmt = conn.prepareStatement("insert into `classicmodels`.`sale` (`fiscal_year`, `employee_number`, `sale`) "
                    + "values (?, ?, ?);")) {

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
            try ( PreparedStatement stmt = conn.prepareStatement("insert into `classicmodels`.`sale` (`fiscal_year`, `employee_number`, `sale`, `trend`) "
                    + "values (?, ?, ?, ?);")) {

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

    public void batchingOneToMany() {

        // avoid this approach since you can optimize the number of batches by ordering inserts (executes 4 batches)
        ctx.batched((Configuration c) -> {
            c.dsl().insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                    EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                    .values(20001L, "Alison", "Joly", "x445", "ajoly@classicmodelcars.com", "3", 55000, "Sales Rep")
                    .onDuplicateKeyIgnore().execute();
            c.dsl().insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(2005, 20001L, 1282.64).execute();
            c.dsl().insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(2004, 20001L, 3938.24).execute();
            c.dsl().insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(2004, 20001L, 4676.14).execute();

            c.dsl().insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                    EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                    .values(20002L, "Tyler", "Seven", "x101", "tseven@classicmodelcars.com", "2", 57000, "Sales Rep")
                    .onDuplicateKeyIgnore().execute();
            c.dsl().insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(2003, 20002L, 2223.0).execute();
            c.dsl().insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(2004, 20002L, 4531.35).execute();
            c.dsl().insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(2004, 20002L, 6751.33).execute();
        });

        // prefer this approach (executes 2 batches)
        ctx.batched((Configuration c) -> {
            c.dsl().insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                    EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                    .values(20001L, "Alison", "Joly", "x445", "ajoly@classicmodelcars.com", "3", 55000, "Sales Rep")
                    .onDuplicateKeyIgnore().execute();
            c.dsl().insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                    EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                    .values(20002L, "Tyler", "Seven", "x101", "tseven@classicmodelcars.com", "2", 57000, "Sales Rep")
                    .onDuplicateKeyIgnore().execute();

            c.dsl().insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(2005, 20001L, 1282.64).execute();
            c.dsl().insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(2004, 20001L, 3938.24).execute();
            c.dsl().insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(2004, 20001L, 4676.14).execute();
            c.dsl().insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(2003, 20002L, 2223.0).execute();
            c.dsl().insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(2004, 20002L, 4531.35).execute();
            c.dsl().insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(2004, 20002L, 6751.33).execute();
        });
    }
}