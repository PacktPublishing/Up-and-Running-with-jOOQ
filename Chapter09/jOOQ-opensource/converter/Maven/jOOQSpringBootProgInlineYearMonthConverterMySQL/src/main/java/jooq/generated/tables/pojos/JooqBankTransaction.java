/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables.pojos;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.annotation.processing.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.4",
        "schema version:1.1"
    },
    date = "2020-12-29T07:38:31.604Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqBankTransaction implements Serializable {

    private static final long serialVersionUID = 874656485;

    private Long          transactionId;
    private String        bankName;
    private String        bankIban;
    private BigDecimal    transferAmount;
    private LocalDateTime cachingDate;
    private Long          customerNumber;
    private String        checkNumber;

    public JooqBankTransaction() {}

    public JooqBankTransaction(JooqBankTransaction value) {
        this.transactionId = value.transactionId;
        this.bankName = value.bankName;
        this.bankIban = value.bankIban;
        this.transferAmount = value.transferAmount;
        this.cachingDate = value.cachingDate;
        this.customerNumber = value.customerNumber;
        this.checkNumber = value.checkNumber;
    }

    public JooqBankTransaction(
        Long          transactionId,
        String        bankName,
        String        bankIban,
        BigDecimal    transferAmount,
        LocalDateTime cachingDate,
        Long          customerNumber,
        String        checkNumber
    ) {
        this.transactionId = transactionId;
        this.bankName = bankName;
        this.bankIban = bankIban;
        this.transferAmount = transferAmount;
        this.cachingDate = cachingDate;
        this.customerNumber = customerNumber;
        this.checkNumber = checkNumber;
    }

    public Long getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    @NotNull
    @Size(max = 50)
    public String getBankName() {
        return this.bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @NotNull
    @Size(max = 50)
    public String getBankIban() {
        return this.bankIban;
    }

    public void setBankIban(String bankIban) {
        this.bankIban = bankIban;
    }

    @NotNull
    public BigDecimal getTransferAmount() {
        return this.transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }

    public LocalDateTime getCachingDate() {
        return this.cachingDate;
    }

    public void setCachingDate(LocalDateTime cachingDate) {
        this.cachingDate = cachingDate;
    }

    @NotNull
    public Long getCustomerNumber() {
        return this.customerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
    }

    @NotNull
    @Size(max = 50)
    public String getCheckNumber() {
        return this.checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JooqBankTransaction (");

        sb.append(transactionId);
        sb.append(", ").append(bankName);
        sb.append(", ").append(bankIban);
        sb.append(", ").append(transferAmount);
        sb.append(", ").append(cachingDate);
        sb.append(", ").append(customerNumber);
        sb.append(", ").append(checkNumber);

        sb.append(")");
        return sb.toString();
    }
}