package com.dyvak.crm.service.impl;

import com.dyvak.crm.domain.Account;
import com.dyvak.crm.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {

    private AccountRepository accountRepository;

    @Transactional(readOnly = true)
    public List<Account> findAllAccountsByOrganizationId(Integer orgId) {
        return accountRepository.findAllByOrganizationId(orgId);
    }

    @Transactional
    public void create(Account account) {
        accountRepository.save(account);
    }
}
