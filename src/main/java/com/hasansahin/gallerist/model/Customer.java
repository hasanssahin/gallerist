package com.hasansahin.gallerist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "customer")
public class Customer extends BaseEntity{
    private String firstName;
    private String lastName;
    private String tckn;
    private Date birthOfDate;
    @OneToOne
    private Address address;
    @OneToOne
    private Account account;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String tckn, Date birthOfDate, Address address, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.tckn = tckn;
        this.birthOfDate = birthOfDate;
        this.address = address;
        this.account = account;
    }

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
