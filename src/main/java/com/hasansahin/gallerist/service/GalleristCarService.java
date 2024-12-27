package com.hasansahin.gallerist.service;

import com.hasansahin.gallerist.dto.*;
import com.hasansahin.gallerist.model.GalleristCar;
import com.hasansahin.gallerist.repository.GalleristCarRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GalleristCarService {
    private final GalleristCarRepository galleristCarRepository;
    private final GalleristService galleristService;
    private final CarService carService;

    public GalleristCarService(GalleristCarRepository galleristCarRepository, GalleristService galleristService, CarService carService) {
        this.galleristCarRepository = galleristCarRepository;
        this.galleristService = galleristService;
        this.carService = carService;
    }

    private GalleristCar createGalleristCar(DtoGalleristCarIU dtoGalleristCarIU){
        GalleristCar galleristCar = new GalleristCar();
        galleristCar.setCreatedDate(new Date());
        galleristCar.setGallerist(galleristService.findGalleristById(dtoGalleristCarIU.getGalleristId()));
        galleristCar.setCar(carService.findCarById(dtoGalleristCarIU.getCarId()));
        return galleristCar;
    }

    public DtoGalleristCar saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU){
        DtoGalleristCar dtoGalleristCar = new DtoGalleristCar();
        DtoGallerist dtoGallerist = new DtoGallerist();
        DtoCar dtoCar = new DtoCar();
        DtoAddress dtoAddress=new DtoAddress();

        GalleristCar savedGalleristCar = galleristCarRepository.save(createGalleristCar(dtoGalleristCarIU));
        BeanUtils.copyProperties(savedGalleristCar, dtoGalleristCar);
        BeanUtils.copyProperties(savedGalleristCar.getGallerist(), dtoGallerist);
        BeanUtils.copyProperties(savedGalleristCar.getGallerist().getAddress(), dtoAddress);
        BeanUtils.copyProperties(savedGalleristCar.getCar(), dtoCar);

        dtoGallerist.setAddress(dtoAddress);

        dtoGalleristCar.setGallerist(dtoGallerist);
        dtoGalleristCar.setCar(dtoCar);

        return dtoGalleristCar;
    }
}
