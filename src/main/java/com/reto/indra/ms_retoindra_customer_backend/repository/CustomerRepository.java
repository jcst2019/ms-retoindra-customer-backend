package com.reto.indra.ms_retoindra_customer_backend.repository;

import com.reto.indra.ms_retoindra_customer_backend.model.Customer;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface CustomerRepository extends ReactiveCrudRepository<Customer,Long> {

}
