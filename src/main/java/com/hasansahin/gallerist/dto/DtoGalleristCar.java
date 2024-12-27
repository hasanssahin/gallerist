package com.hasansahin.gallerist.dto;

public class DtoGalleristCar extends DtoBase{
    private DtoGallerist gallerist;
    private DtoCar car;

    public DtoGallerist getGallerist() {
        return gallerist;
    }

    public void setGallerist(DtoGallerist gallerist) {
        this.gallerist = gallerist;
    }

    public DtoCar getCar() {
        return car;
    }

    public void setCar(DtoCar car) {
        this.car = car;
    }
}
