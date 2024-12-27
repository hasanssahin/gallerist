package com.hasansahin.gallerist.dto.currency_rates;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyRatesItems {
    @JsonProperty("Tarih")
    private String date;
    @JsonProperty("TP_DK_USD_A")
    private String usd;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUsd() {
        return usd;
    }

    public void setUsd(String usd) {
        this.usd = usd;
    }
}
