package com.hasansahin.gallerist.dto;

import com.hasansahin.gallerist.enums.CurrencyType;

import java.math.BigDecimal;

public class DtoAccount extends DtoBase{
    private String accountNo;
    private String iban;
    private BigDecimal amount;
    private CurrencyType currencyType;

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
