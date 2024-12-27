package com.hasansahin.gallerist.service;

import com.hasansahin.gallerist.dto.DtoAccount;
import com.hasansahin.gallerist.dto.DtoAccountIU;
import com.hasansahin.gallerist.exception.BaseException;
import com.hasansahin.gallerist.exception.ErrorMessage;
import com.hasansahin.gallerist.exception.MessageType;
import com.hasansahin.gallerist.model.Account;
import com.hasansahin.gallerist.repository.AccountRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    private Account createAccount(DtoAccountIU dtoAccountIU){
        Account account=new Account();
        account.setCreatedDate(new Date());
        BeanUtils.copyProperties(dtoAccountIU,account);
        return account;
    }

    public DtoAccount saveAccount(DtoAccountIU dtoAccountIU){
        DtoAccount dtoAccount=new DtoAccount();
        Account savedAccount = accountRepository.save(createAccount(dtoAccountIU));
        BeanUtils.copyProperties(savedAccount,dtoAccount);
        return dtoAccount;
    }

    protected Account findAccountById(Long id){
        return accountRepository.findById(id).orElseThrow(()->new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,id.toString())));
    }
}
