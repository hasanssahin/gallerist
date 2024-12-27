package com.hasansahin.gallerist.dto;

import jakarta.validation.constraints.NotNull;

public class DtoSoldCarIU {
    @NotNull
    private Long customerId;
    @NotNull
    private Long galleristId;
    @NotNull
    private Long carId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getGalleristId() {
        return galleristId;
    }

    public void setGalleristId(Long galleristId) {
        this.galleristId = galleristId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }
}
