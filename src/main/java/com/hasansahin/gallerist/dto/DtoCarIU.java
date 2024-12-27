package com.hasansahin.gallerist.dto;

import com.hasansahin.gallerist.enums.CarStatusType;
import com.hasansahin.gallerist.enums.CurrencyType;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class DtoCarIU {
    @NotNull
    private String plaka;
    @NotNull
    private String brand;
    @NotNull
    private String model;
    @NotNull
    private Integer productionYear;
    @NotNull
    private BigDecimal price;
    @NotNull
    private CurrencyType currencyType;
    @NotNull
    private BigDecimal damagePrice;
    @NotNull
    private CarStatusType carStatusType;

    public @NotNull String getPlaka() {
        return plaka;
    }

    public void setPlaka(@NotNull String plaka) {
        this.plaka = plaka;
    }

    public @NotNull String getBrand() {
        return brand;
    }

    public void setBrand(@NotNull String brand) {
        this.brand = brand;
    }

    public @NotNull String getModel() {
        return model;
    }

    public void setModel(@NotNull String model) {
        this.model = model;
    }

    public @NotNull Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(@NotNull Integer productionYear) {
        this.productionYear = productionYear;
    }

    public @NotNull BigDecimal getPrice() {
        return price;
    }

    public void setPrice(@NotNull BigDecimal price) {
        this.price = price;
    }

    public @NotNull CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(@NotNull CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public @NotNull BigDecimal getDamagePrice() {
        return damagePrice;
    }

    public void setDamagePrice(@NotNull BigDecimal damagePrice) {
        this.damagePrice = damagePrice;
    }

    public @NotNull CarStatusType getCarStatusType() {
        return carStatusType;
    }

    public void setCarStatusType(@NotNull CarStatusType carStatusType) {
        this.carStatusType = carStatusType;
    }
}
