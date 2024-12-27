package com.hasansahin.gallerist.service;

import com.hasansahin.gallerist.dto.*;
import com.hasansahin.gallerist.dto.currency_rates.CurrencyRatesReponse;
import com.hasansahin.gallerist.enums.CarStatusType;
import com.hasansahin.gallerist.exception.BaseException;
import com.hasansahin.gallerist.exception.ErrorMessage;
import com.hasansahin.gallerist.exception.MessageType;
import com.hasansahin.gallerist.model.*;
import com.hasansahin.gallerist.repository.SoldCarRepository;
import com.hasansahin.gallerist.utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

@Service
public class SoldCarService {
    private final SoldCarRepository soldCarRepository;
    private final CarService carService;
    private final CustomerService customerService;
    private final GalleristService galleristService;
    private final CurrencyRatesService currencyRatesService;

    public SoldCarService(SoldCarRepository soldCarRepository, CarService carService, CustomerService customerService, GalleristService galleristService, CurrencyRatesService currencyRatesService) {
        this.soldCarRepository = soldCarRepository;
        this.carService = carService;
        this.customerService = customerService;
        this.galleristService = galleristService;
        this.currencyRatesService = currencyRatesService;
    }

    private BigDecimal convertCustomerAmountToUSD(Customer customer) {
        CurrencyRatesReponse currencyRatesReponse = currencyRatesService.getCurrencyRates(DateUtils.getCurrentDate(new Date()),DateUtils.getCurrentDate(new Date()));
        BigDecimal usd=new BigDecimal(currencyRatesReponse.getItems().get(0).getUsd());
        return customer.getAccount().getAmount().divide(usd, 2, RoundingMode.HALF_UP);
    }

    private boolean checkCarStatus(Long carId){
        Car foundCar = carService.findCarById(carId);
        return !foundCar.getCarStatusType().equals(CarStatusType.SOLD);
    }

    private boolean checkAmount(DtoSoldCarIU dtoSoldCarIU){
        Customer foundCustomer =customerService.findCustomerById(dtoSoldCarIU.getCustomerId());
        Car foundCar = carService.findCarById(dtoSoldCarIU.getCarId());
        BigDecimal customerUSDAmount = convertCustomerAmountToUSD(foundCustomer);
        return customerUSDAmount.compareTo(foundCar.getPrice()) >= 0;
    }

    private SoldCar createSoldCar(DtoSoldCarIU dtoSoldCarIU){
        SoldCar soldCar=new SoldCar();
        soldCar.setCreatedDate(new Date());
        soldCar.setCustomer(customerService.findCustomerById(dtoSoldCarIU.getCustomerId()));
        soldCar.setCar(carService.findCarById(dtoSoldCarIU.getCarId()));
        soldCar.setGallerist(galleristService.findGalleristById(dtoSoldCarIU.getGalleristId()));
        return soldCar;
    }

    private BigDecimal remainingAmount(Customer customer, Car car){
        BigDecimal customerUSDAmount = convertCustomerAmountToUSD(customer);
        BigDecimal remainingCustomerUSDAmount = customerUSDAmount.subtract(car.getPrice());
        CurrencyRatesReponse currencyRatesResponse = currencyRatesService.getCurrencyRates(DateUtils.getCurrentDate(new Date()), DateUtils.getCurrentDate(new Date()));
        return remainingCustomerUSDAmount.multiply(new BigDecimal(currencyRatesResponse.getItems().get(0).getUsd()));
    }

    public DtoSoldCar buyCar(DtoSoldCarIU dtoSoldCarIU) {
        if(!checkAmount(dtoSoldCarIU)){
            throw new BaseException(new ErrorMessage(MessageType.CUSTOMER_AMOUNT_IS_NOT_ENOUGH,null));
        }
        if(!checkCarStatus(dtoSoldCarIU.getCarId())){
            throw new BaseException(new ErrorMessage(MessageType.CAR_STATUS_IS_ALREADY_SOLD,dtoSoldCarIU.getCarId().toString()));
        }
        SoldCar savedSoldCar = soldCarRepository.save(createSoldCar(dtoSoldCarIU));
        Car car=savedSoldCar.getCar();
        car.setCarStatusType(CarStatusType.SOLD);
        carService.update(car);

        Customer customer=savedSoldCar.getCustomer();
        customer.getAccount().setAmount(remainingAmount(customer,car));
        customerService.update(customer);
        return toDTO(savedSoldCar);
    }

    private DtoSoldCar toDTO(SoldCar soldCar){
        DtoSoldCar dtoSoldCar=new DtoSoldCar();
        DtoCustomer dtoCustomer=new DtoCustomer();
        DtoGallerist dtoGallerist=new DtoGallerist();
        DtoCar dtoCar=new DtoCar();

        BeanUtils.copyProperties(soldCar,dtoSoldCar);
        BeanUtils.copyProperties(soldCar.getCustomer(),dtoCustomer);
        BeanUtils.copyProperties(soldCar.getGallerist(),dtoGallerist);
        BeanUtils.copyProperties(soldCar.getCar(),dtoCar);

        Address customerAddress=soldCar.getCustomer().getAddress();
        DtoAddress dtoCustomerAddress=new DtoAddress();
        BeanUtils.copyProperties(customerAddress,dtoCustomerAddress);
        dtoCustomer.setAddress(dtoCustomerAddress);

        Account customerAccount=soldCar.getCustomer().getAccount();
        DtoAccount dtoAccount=new DtoAccount();
        BeanUtils.copyProperties(customerAccount,dtoAccount);
        dtoCustomer.setAccount(dtoAccount);

        Address galleristAddress=soldCar.getGallerist().getAddress();
        DtoAddress dtoGalleristAddress=new DtoAddress();
        BeanUtils.copyProperties(galleristAddress,dtoGalleristAddress);
        dtoGallerist.setAddress(dtoGalleristAddress);

        dtoSoldCar.setCustomer(dtoCustomer);
        dtoSoldCar.setGallerist(dtoGallerist);
        dtoSoldCar.setCar(dtoCar);

        return dtoSoldCar;
    }
}
