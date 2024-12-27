package com.hasansahin.gallerist.dto;

import java.util.Date;

public class DtoCustomer extends DtoBase{
    private String firstName;
    private String lastName;
    private String tckn;
    private Date birthOfDate;
    private DtoAddress address;
    private DtoAccount account;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTckn() {
        return tckn;
    }

    public void setTckn(String tckn) {
        this.tckn = tckn;
    }

    public Date getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(Date birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public DtoAddress getAddress() {
        return address;
    }

    public void setAddress(DtoAddress address) {
        this.address = address;
    }

    public DtoAccount getAccount() {
        return account;
    }

    public void setAccount(DtoAccount account) {
        this.account = account;
    }
}
