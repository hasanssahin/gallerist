package com.hasansahin.gallerist.dto;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class DtoCustomerIU {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String tckn;
    @NotNull
    private Date birthOfDate;
    @NotNull
    private Long addressId;
    @NotNull
    private Long accountId;

    public @NotNull String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotNull String firstName) {
        this.firstName = firstName;
    }

    public @NotNull String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull String lastName) {
        this.lastName = lastName;
    }

    public @NotNull String getTckn() {
        return tckn;
    }

    public void setTckn(@NotNull String tckn) {
        this.tckn = tckn;
    }

    public @NotNull Date getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(@NotNull Date birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public @NotNull Long getAddressId() {
        return addressId;
    }

    public void setAddressId(@NotNull Long addressId) {
        this.addressId = addressId;
    }

    public @NotNull Long getAccountId() {
        return accountId;
    }

    public void setAccountId(@NotNull Long accountId) {
        this.accountId = accountId;
    }
}
