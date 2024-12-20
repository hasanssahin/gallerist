package com.hasansahin.gallerist.model;

import com.hasansahin.gallerist.enums.CarStatusType;
import com.hasansahin.gallerist.enums.CurrencyType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "car")
public class Car extends BaseEntity{
    private String plaka;
    private String brand;
    private String model;
    private Integer productionYear;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;
    private BigDecimal damagePrice;
    @Enumerated(EnumType.STRING)
    private CarStatusType carStatusType;

    public Car() {
    }

    public Car(String plaka, String brand, String model, Integer productionYear, BigDecimal price, CurrencyType currencyType, BigDecimal damagePrice, CarStatusType carStatusType) {
        this.plaka = plaka;
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
        this.price = price;
        this.currencyType = currencyType;
        this.damagePrice = damagePrice;
        this.carStatusType = carStatusType;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public BigDecimal getDamagePrice() {
        return damagePrice;
    }

    public void setDamagePrice(BigDecimal damagePrice) {
        this.damagePrice = damagePrice;
    }

    public CarStatusType getCarStatusType() {
        return carStatusType;
    }

    public void setCarStatusType(CarStatusType carStatusType) {
        this.carStatusType = carStatusType;
    }
}
