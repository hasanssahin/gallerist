package com.hasansahin.gallerist.controller;

import com.hasansahin.gallerist.dto.currency_rates.CurrencyRatesReponse;
import com.hasansahin.gallerist.service.CurrencyRatesService;
import com.hasansahin.gallerist.utils.RootEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/currency-rates")
public class CurrencyRatesController extends BaseController {
    private final CurrencyRatesService currencyRatesService;

    public CurrencyRatesController(CurrencyRatesService currencyRatesService) {
        this.currencyRatesService = currencyRatesService;
    }

    @GetMapping
    public RootEntity<CurrencyRatesReponse> getCurrencyRates(@RequestParam String startDate, @RequestParam String endDate) {
        return ok(currencyRatesService.getCurrencyRates(startDate, endDate));
    }


}
