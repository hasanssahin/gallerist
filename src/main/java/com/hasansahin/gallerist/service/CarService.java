package com.hasansahin.gallerist.service;

import com.hasansahin.gallerist.dto.DtoCar;
import com.hasansahin.gallerist.dto.DtoCarIU;
import com.hasansahin.gallerist.model.Car;
import com.hasansahin.gallerist.repository.CarRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    private Car createCar(DtoCarIU dtoCarIU) {
        Car car = new Car();
        car.setCreatedDate(new Date());
        BeanUtils.copyProperties(dtoCarIU, car);
        return car;
    }

    public DtoCar saveCar(DtoCarIU dtoCarIU) {
        DtoCar dtoCar = new DtoCar();
        Car savedCar=carRepository.save(createCar(dtoCarIU));
        BeanUtils.copyProperties(savedCar, dtoCar);
        return dtoCar;
    }


}
