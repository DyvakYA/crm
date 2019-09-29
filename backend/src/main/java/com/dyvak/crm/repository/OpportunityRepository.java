package com.dyvak.crm.repository;


import com.dyvak.crm.domain.Opportunity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportunityRepository extends CrudRepository<Opportunity, Long> {

}
