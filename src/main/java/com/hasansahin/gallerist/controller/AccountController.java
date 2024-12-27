package com.hasansahin.gallerist.controller;

import com.hasansahin.gallerist.dto.DtoAccount;
import com.hasansahin.gallerist.dto.DtoAccountIU;
import com.hasansahin.gallerist.service.AccountService;
import com.hasansahin.gallerist.utils.RootEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController extends BaseController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/save")
    public RootEntity<DtoAccount> saveAccount(@Valid @RequestBody DtoAccountIU dtoAccountIU){
        return ok(accountService.saveAccount(dtoAccountIU));
    }

}
