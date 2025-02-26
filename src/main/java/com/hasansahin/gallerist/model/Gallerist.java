package com.hasansahin.gallerist.model;

import jakarta.persistence.*;

@Entity
@Table(name = "gallerist")
public class Gallerist extends BaseEntity{
    private String firstName;
    private String lastName;
    @OneToOne
    private Address address;

    public Gallerist() {
    }

    public Gallerist(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
