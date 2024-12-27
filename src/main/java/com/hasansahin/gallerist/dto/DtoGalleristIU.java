package com.hasansahin.gallerist.dto;

import jakarta.validation.constraints.NotNull;

public class DtoGalleristIU {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Long addressId;

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

    public @NotNull Long getAddressId() {
        return addressId;
    }

    public void setAddressId(@NotNull Long addressId) {
        this.addressId = addressId;
    }
}
