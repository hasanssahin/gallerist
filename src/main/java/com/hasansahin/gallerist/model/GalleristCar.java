package com.hasansahin.gallerist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "gallerist_car", uniqueConstraints = {@UniqueConstraint(columnNames = {"gallerist_id","car_id"},name = "uq_gallerist_car")})
public class GalleristCar extends BaseEntity {
    @ManyToOne
    private Gallerist gallerist;
    @ManyToOne
    private Car car;

    public GalleristCar() {
    }

    public GalleristCar(Gallerist gallerist, Car car) {
        this.gallerist = gallerist;
        this.car = car;
    }

    public Gallerist getGallerist() {
        return gallerist;
    }

    public void setGallerist(Gallerist gallerist) {
        this.gallerist = gallerist;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
