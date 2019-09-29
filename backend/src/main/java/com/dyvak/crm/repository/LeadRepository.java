package com.dyvak.crm.repository;


import com.dyvak.crm.domain.Lead;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadRepository extends CrudRepository<Lead, Long> {

}
