package com.dyvak.springbootvuejs.repository;


import com.dyvak.springbootvuejs.domain.Lead;
import com.dyvak.springbootvuejs.domain.Opportunity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportunityRepository extends CrudRepository<Opportunity, Long> {

}
