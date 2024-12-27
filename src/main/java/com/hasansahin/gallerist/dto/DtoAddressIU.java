package com.hasansahin.gallerist.dto;

import jakarta.validation.constraints.NotEmpty;

public class DtoAddressIU {
    @NotEmpty
    private String city;
    @NotEmpty
    private String district;
    @NotEmpty
    private String neighborhood;
    @NotEmpty
    private String street;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
