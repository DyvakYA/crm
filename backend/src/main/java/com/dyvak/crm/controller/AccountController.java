package com.dyvak.crm.controller;

import com.dyvak.crm.aspects.Benchmark;
import com.dyvak.crm.aspects.LoggedArgs;
import com.dyvak.crm.aspects.LoggedReturn;
import com.dyvak.crm.domain.Account;
import com.dyvak.crm.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AccountController {

    private AccountService accountService;

    @LoggedArgs
    @LoggedReturn
    @Benchmark
    @RequestMapping(path = "/accounts", method = RequestMethod.POST)
    public ResponseEntity<Void> accounts(@RequestBody Account account) {
        accountService.create(account);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @LoggedArgs
    @LoggedReturn
    @Benchmark
    @RequestMapping(path = "/accounts/{orgId}", method = RequestMethod.GET)
    public List<Account> accounts(@PathVariable(value = "orgId") Integer orgId) {
        return accountService.findAllAccountsByOrganizationId(orgId);
    }


}
