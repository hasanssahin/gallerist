package com.hasansahin.gallerist.controller;

import com.hasansahin.gallerist.dto.DtoGalleristCar;
import com.hasansahin.gallerist.dto.DtoGalleristCarIU;
import com.hasansahin.gallerist.service.GalleristCarService;
import com.hasansahin.gallerist.utils.RootEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gallerist-car")
public class GalleristCarController extends BaseController {
    private final GalleristCarService galleristCarService;

    public GalleristCarController(GalleristCarService galleristCarService) {
        this.galleristCarService = galleristCarService;
    }

    @PostMapping("/save")
    public RootEntity<DtoGalleristCar> saveGalleristCar(@Valid @RequestBody DtoGalleristCarIU dtoGalleristCarIU) {
        return ok(galleristCarService.saveGalleristCar(dtoGalleristCarIU));
    }

}
