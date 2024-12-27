package com.hasansahin.gallerist.service;

import com.hasansahin.gallerist.dto.DtoAddress;
import com.hasansahin.gallerist.dto.DtoGallerist;
import com.hasansahin.gallerist.dto.DtoGalleristIU;
import com.hasansahin.gallerist.model.Gallerist;
import com.hasansahin.gallerist.repository.GalleristRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GalleristService {
    private final GalleristRepository galleristRepository;
    private final AddressService addressService;

    public GalleristService(GalleristRepository galleristRepository, AddressService addressService) {
        this.galleristRepository = galleristRepository;
        this.addressService = addressService;
    }

    private Gallerist createGallerist(DtoGalleristIU dtoGalleristIU){
        Gallerist gallerist = new Gallerist();
        gallerist.setCreatedDate(new Date());
        BeanUtils.copyProperties(dtoGalleristIU, gallerist);
        gallerist.setAddress(addressService.findAddressById(dtoGalleristIU.getAddressId()));
        return gallerist;
    }

    public DtoGallerist saveGallerist(DtoGalleristIU dtoGalleristIU){
        DtoGallerist dtoGallerist = new DtoGallerist();
        DtoAddress dtoAddress=new DtoAddress();

        Gallerist savedGallerist = galleristRepository.save(createGallerist(dtoGalleristIU));

        BeanUtils.copyProperties(savedGallerist, dtoGallerist);
        BeanUtils.copyProperties(savedGallerist.getAddress(), dtoAddress);

        dtoGallerist.setAddress(dtoAddress);
        return dtoGallerist;
    }
}
