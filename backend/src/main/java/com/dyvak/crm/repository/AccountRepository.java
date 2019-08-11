package com.dyvak.springbootvuejs.repository;


import com.dyvak.springbootvuejs.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

}
