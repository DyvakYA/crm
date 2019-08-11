package com.dyvak.springbootvuejs.repository;


import com.dyvak.springbootvuejs.domain.Contact;
import com.dyvak.springbootvuejs.domain.Lead;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {

}
