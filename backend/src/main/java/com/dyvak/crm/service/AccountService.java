package com.dyvak.crm.service;

import com.dyvak.crm.domain.Account;

import java.util.List;

public interface AccountService {

    List<Account> findAllAccountsByOrganizationId(Integer orgId);

    void create(Account account);
}
