package com.hasansahin.gallerist.controller;

import com.hasansahin.gallerist.dto.DtoSoldCar;
import com.hasansahin.gallerist.dto.DtoSoldCarIU;
import com.hasansahin.gallerist.service.SoldCarService;
import com.hasansahin.gallerist.utils.RootEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sold-car")
public class SoldCarController extends BaseController {
    private final SoldCarService soldCarService;

    public SoldCarController(SoldCarService soldCarService) {
        this.soldCarService = soldCarService;
    }

    @PostMapping("/buy")
    public RootEntity<DtoSoldCar> saveSoldCar(@Valid @RequestBody DtoSoldCarIU dtoSoldCarIU) {
        return ok(soldCarService.buyCar(dtoSoldCarIU));
    }
}
