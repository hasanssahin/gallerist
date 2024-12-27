package com.hasansahin.gallerist.dto;

import jakarta.validation.constraints.NotNull;

public class DtoGalleristCarIU {
    @NotNull
    private Long galleristId;
    @NotNull
    private Long carId;

    public @NotNull Long getGalleristId() {
        return galleristId;
    }

    public void setGalleristId(@NotNull Long galleristId) {
        this.galleristId = galleristId;
    }

    public @NotNull Long getCarId() {
        return carId;
    }

    public void setCarId(@NotNull Long carId) {
        this.carId = carId;
    }
}
