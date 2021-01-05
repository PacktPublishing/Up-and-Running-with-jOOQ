package com.classicmodels.repository;

import java.util.List;
import jooq.generated.embeddables.pojos.OfficeFullAddress;
import jooq.generated.embeddables.records.OfficeFullAddressRecord;
import static jooq.generated.tables.Office.OFFICE;
import jooq.generated.tables.pojos.Office;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
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
    public void insertOffice() {

        // using embeddable type via OfficeFullAddressRecord   
        ctx.insertInto(OFFICE, OFFICE.OFFICE_CODE, OFFICE.OFFICE_FULL_ADDRESS, OFFICE.PHONE,
                OFFICE.ADDRESS_LINE_SECOND, OFFICE.POSTAL_CODE)
                .values(String.valueOf((int) (Math.random() * 1000)),
                        new OfficeFullAddressRecord("Naples", "Giuseppe Mazzini", "Campania", "Italy", "N/A"),
                        "09822-1229-12", "N/A", "zip-2322")
                .execute();
    }

    public void findOffice() {

        Result<Record1<OfficeFullAddressRecord>> result1 = ctx.select(OFFICE.OFFICE_FULL_ADDRESS)
                .from(OFFICE)
                .fetch();
        System.out.println("Result as OfficeFullAddressRecord:\n" + result1);

        List<OfficeFullAddress> result2 = ctx.select(OFFICE.OFFICE_FULL_ADDRESS)
                .from(OFFICE)
                .fetchInto(OfficeFullAddress.class);

        System.out.println("Result as POJO:\n" + result2);

        List<Office> result3 = ctx.selectFrom(OFFICE)
                .limit(10)
                .fetchInto(Office.class);

        System.out.println("All offices: " + result3);
    }
}
