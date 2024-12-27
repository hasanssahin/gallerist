package com.hasansahin.gallerist.service;

import com.hasansahin.gallerist.dto.DtoAddress;
import com.hasansahin.gallerist.dto.DtoAddressIU;
import com.hasansahin.gallerist.model.Address;
import com.hasansahin.gallerist.repository.AddressRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    private Address createAddress(DtoAddressIU dtoAddressIU){
        Address address = new Address();
        address.setCreatedDate(new Date());
        BeanUtils.copyProperties(dtoAddressIU,address);
        return address;
    }

    public DtoAddress saveAddress(DtoAddressIU dtoAddressIU){
        DtoAddress dtoAddress = new DtoAddress();
        Address savedAddress=addressRepository.save(createAddress(dtoAddressIU));
        BeanUtils.copyProperties(savedAddress,dtoAddress);
        return dtoAddress;
    }
}
