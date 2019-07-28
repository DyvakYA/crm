package com.dyvak.springbootvuejs.repository;


import com.dyvak.springbootvuejs.domain.Lead;
import com.dyvak.springbootvuejs.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadRepository extends CrudRepository<Lead, Long> {

}
