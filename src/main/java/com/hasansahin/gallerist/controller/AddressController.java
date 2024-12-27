package com.hasansahin.gallerist.controller;

import com.hasansahin.gallerist.dto.DtoAddress;
import com.hasansahin.gallerist.dto.DtoAddressIU;
import com.hasansahin.gallerist.service.AddressService;
import com.hasansahin.gallerist.utils.RootEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class AddressController extends BaseController{
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/save")
    public RootEntity<DtoAddress> saveAddress(@Valid @RequestBody DtoAddressIU dtoAddressIU){
        return ok(addressService.saveAddress(dtoAddressIU));
    }
}
