package com.hasansahin.gallerist.dto;


public class DtoGallerist extends DtoBase{
    private String firstName;
    private String lastName;
    private DtoAddress address;

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

    public DtoAddress getAddress() {
        return address;
    }

    public void setAddress(DtoAddress address) {
        this.address = address;
    }
}
