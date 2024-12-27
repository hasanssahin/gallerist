package com.hasansahin.gallerist.dto;

public class DtoSoldCar extends DtoBase{
    private DtoCustomer customer;
    private DtoGallerist gallerist;
    private DtoCar car;

    public DtoCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(DtoCustomer customer) {
        this.customer = customer;
    }

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
