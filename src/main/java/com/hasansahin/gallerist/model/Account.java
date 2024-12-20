package com.hasansahin.gallerist.model;

import com.hasansahin.gallerist.enums.CurrencyType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "account")
public class Account extends BaseEntity{
    private String accountNo;
    private String iban;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;

    public Account() {
    }

    public Account(String accountNo, String iban, BigDecimal amount, CurrencyType currencyType) {
        this.accountNo = accountNo;
        this.iban = iban;
        this.amount = amount;
        this.currencyType = currencyType;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }
}
