package com.hasansahin.gallerist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "sold_car", uniqueConstraints = {@UniqueConstraint(columnNames = {"gallerist_id","car_id","customer_id"},name = "uq_gallerist_car_customer")})
public class SoldCar extends BaseEntity{
    @ManyToOne
    private Gallerist gallerist;
    @ManyToOne
    private Car car;
    @ManyToOne
    private Customer customer;

    public SoldCar() {
    }

    public SoldCar(Gallerist gallerist, Car car, Customer customer) {
        this.gallerist = gallerist;
        this.car = car;
        this.customer = customer;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
