package com.classicmodels.repository;

import static jooq.generated.tables.Product.PRODUCT;
import static jooq.generated.tables.Sale.SALE;
import org.jooq.DSLContext;
import static org.jooq.impl.DSL.count;
import static org.jooq.impl.DSL.rank;
import static org.jooq.impl.DSL.sum;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class ClassicModelsRepository {

    private final DSLContext ctx;

    public ClassicModelsRepository(DSLContext ctx) {
        this.ctx = ctx;
    }

    /*  The RANK() is a window function that assigns a rank to each 
    row within the partition of a result set. */
    
    // simple use case, just assign a rank to each row
    public void dummyAssignRankToProducts() {

        ctx.select(rank().over().orderBy(PRODUCT.PRODUCT_LINE).as("rank_nr"),
                PRODUCT.PRODUCT_LINE, PRODUCT.PRODUCT_NAME, PRODUCT.BUY_PRICE)
                .from(PRODUCT)
                .orderBy(PRODUCT.PRODUCT_LINE)
                .fetch();
    }

    public void saleRankByFiscalYear() {

        ctx.select(SALE.EMPLOYEE_NUMBER, SALE.FISCAL_YEAR, SALE.SALE_,
                rank().over().partitionBy(SALE.FISCAL_YEAR).orderBy(SALE.SALE_.desc()).as("sale_rank"))
                .from(SALE)
                .fetch();
    }

    public void saleRankByTotalSales() {

        ctx.select(SALE.EMPLOYEE_NUMBER, SALE.FISCAL_YEAR, sum(SALE.SALE_),
                rank().over().partitionBy(SALE.FISCAL_YEAR).orderBy(sum(SALE.SALE_).desc()).as("sale_rank"))
                .from(SALE)
                .groupBy(SALE.EMPLOYEE_NUMBER, SALE.FISCAL_YEAR)
                .fetch();
    }

    public void saleRankByNumberOfSales() {

        System.out.println(
        ctx.select(SALE.EMPLOYEE_NUMBER, SALE.FISCAL_YEAR, count().as("nr_of_sales"),
                rank().over().partitionBy(SALE.FISCAL_YEAR).orderBy(count().desc()).as("sale_rank"))
                .from(SALE)
                .groupBy(SALE.EMPLOYEE_NUMBER, SALE.FISCAL_YEAR)
                .fetch().format(100));
    }
}