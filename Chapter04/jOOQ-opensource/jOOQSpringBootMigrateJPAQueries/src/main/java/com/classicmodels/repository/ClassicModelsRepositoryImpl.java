package com.classicmodels.repository;

import com.classicmodels.entity.Employee;
import com.classicmodels.pojo.EmployeeCntr;
import java.util.List;
import static jooq.generated.tables.Employee.EMPLOYEE;
import static jooq.generated.tables.Sale.SALE;
import org.jooq.DSLContext;
import static org.jooq.impl.DSL.firstValue;
import static org.jooq.impl.DSL.partitionBy;
import static org.jooq.impl.DSL.sum;
import org.springframework.stereotype.Repository;
import com.classicmodels.pojo.EmployeeProjection1;
import com.classicmodels.pojo.EmployeeProjection2;
import javax.persistence.EntityManager;
import static jooq.generated.tables.Office.OFFICE;
import static org.jooq.impl.DSL.select;

@Repository
public class ClassicModelsRepositoryImpl implements ClassicModelsRepository {

    private final DSLContext ctx;
    private final EntityManager em;

    public ClassicModelsRepositoryImpl(DSLContext ctx, EntityManager em) {
        this.ctx = ctx;
        this.em = em;
    }

    @Override
    public List<Object[]> findEmployeesWithTotalSalesByFiscalYear() {

        List<Object[]> result = ctx.select(EMPLOYEE.FIRST_NAME,
                EMPLOYEE.LAST_NAME, SALE.FISCAL_YEAR, SALE.SALE_, SALE.EMPLOYEE_NUMBER,
                sum(SALE.SALE_)
                        .over(partitionBy(SALE.FISCAL_YEAR)).as("TOTAL_SALES"))
                .from(SALE)
                .join(EMPLOYEE).on(SALE.EMPLOYEE_NUMBER.eq(EMPLOYEE.EMPLOYEE_NUMBER))
                .fetchInto(Object[].class);

        return result;
    }

    @Override
    public List<EmployeeProjection1> findEmployeesAndLeastSalary() {

        List<EmployeeProjection1> result = ctx.select(EMPLOYEE.FIRST_NAME,
                EMPLOYEE.LAST_NAME,
                EMPLOYEE.SALARY,
                firstValue(EMPLOYEE.FIRST_NAME)
                        .over().orderBy(EMPLOYEE.SALARY).as("least_salary"))
                .from(EMPLOYEE)
                .fetchInto(EmployeeProjection1.class);

        return result;
    }

    @Override
    public List<EmployeeCntr> findEmployeesAndLeastSalaryCntr() {

        List<EmployeeCntr> result = ctx.select(EMPLOYEE.FIRST_NAME,
                EMPLOYEE.LAST_NAME, EMPLOYEE.SALARY)
                .from(EMPLOYEE)
                .where(EMPLOYEE.SALARY.gt(80000))
                .fetchInto(EmployeeCntr.class);

        return result;
    }

    @Override
    public List<EmployeeProjection2> findFirst5ByOrderBySalaryDesc() {

        List<EmployeeProjection2> result = ctx.select(
                EMPLOYEE.FIRST_NAME, EMPLOYEE.LAST_NAME, EMPLOYEE.SALARY)
                .from(EMPLOYEE)
                .orderBy(EMPLOYEE.SALARY.desc())
                .limit(5)
                .fetchInto(EmployeeProjection2.class);

        return result;
    }
    
    @Override    
    public List<Employee> findEmployeeInCity(String city) {

        org.jooq.Query query
                = ctx.select()
                        .from(EMPLOYEE)
                        .where(EMPLOYEE.OFFICE_CODE.eq(
                                select(OFFICE.OFFICE_CODE)
                                        .from(OFFICE)
                                        .where(OFFICE.CITY.eq(city))));

        return Queries.nativeQueryToEntity(em, query, Employee.class);
    }    
    
    @Override
    public  List<Employee> findEmployeeSalaryInRange(int start, int end) {
        
        org.jooq.Query query
                = ctx.select()
                        .from(EMPLOYEE)
                        .where(EMPLOYEE.SALARY.between(start, end));

        return Queries.nativeQueryToEntity(em, query, Employee.class);        
    }
}
