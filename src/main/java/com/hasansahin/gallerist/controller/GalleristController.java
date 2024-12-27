package com.hasansahin.gallerist.controller;

import com.hasansahin.gallerist.dto.DtoGallerist;
import com.hasansahin.gallerist.dto.DtoGalleristIU;
import com.hasansahin.gallerist.service.GalleristService;
import com.hasansahin.gallerist.utils.RootEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gallerist")
public class GalleristController extends BaseController{
    private final GalleristService galleristService;

    public GalleristController(GalleristService galleristService) {
        this.galleristService = galleristService;
    }

    @PostMapping("/save")
    public RootEntity<DtoGallerist> saveGallerist(@Valid @RequestBody DtoGalleristIU dtoGalleristIU){
        return ok(galleristService.saveGallerist(dtoGalleristIU));
    }
}
