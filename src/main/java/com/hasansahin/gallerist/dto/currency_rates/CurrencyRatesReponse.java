package com.hasansahin.gallerist.dto.currency_rates;

import java.util.List;

public class CurrencyRatesReponse {
    private Integer totalCount;
    private List<CurrencyRatesItems> items;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<CurrencyRatesItems> getItems() {
        return items;
    }

    public void setItems(List<CurrencyRatesItems> items) {
        this.items = items;
    }
}
