package com.hasansahin.gallerist.service;

import com.hasansahin.gallerist.dto.DtoAccount;
import com.hasansahin.gallerist.dto.DtoAddress;
import com.hasansahin.gallerist.dto.DtoCustomer;
import com.hasansahin.gallerist.dto.DtoCustomerIU;
import com.hasansahin.gallerist.exception.BaseException;
import com.hasansahin.gallerist.exception.ErrorMessage;
import com.hasansahin.gallerist.exception.MessageType;
import com.hasansahin.gallerist.model.Customer;
import com.hasansahin.gallerist.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final AddressService addressService;
    private final AccountService accountService;

    public CustomerService(CustomerRepository customerRepository, AddressService addressService, AccountService accountService) {
        this.customerRepository = customerRepository;
        this.addressService = addressService;
        this.accountService = accountService;
    }

    private Customer createCustomer(DtoCustomerIU dtoCustomerIU) {
        Customer customer = new Customer();
        customer.setCreatedDate(new Date());
        BeanUtils.copyProperties(dtoCustomerIU, customer);
        customer.setAddress(addressService.findAddressById(dtoCustomerIU.getAddressId()));
        customer.setAccount(accountService.findAccountById(dtoCustomerIU.getAccountId()));
        return customer;
    }

    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU) {
        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoAddress dtoAddress=new DtoAddress();
        DtoAccount dtoAccount=new DtoAccount();

        Customer savedCustomer = customerRepository.save(createCustomer(dtoCustomerIU));

        BeanUtils.copyProperties(savedCustomer.getAddress(), dtoAddress);
        BeanUtils.copyProperties(savedCustomer.getAccount(), dtoAccount);
        BeanUtils.copyProperties(savedCustomer, dtoCustomer);

        dtoCustomer.setAddress(dtoAddress);
        dtoCustomer.setAccount(dtoAccount);

        return dtoCustomer;
    }

    protected Customer findCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElseThrow(()->new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,customerId.toString())));
    }

    protected Customer update(Customer customer){
        return customerRepository.save(customer);
    }
}
