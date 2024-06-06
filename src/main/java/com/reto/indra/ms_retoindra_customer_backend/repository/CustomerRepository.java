package com.reto.indra.ms_retoindra_customer_backend.repository;

import com.reto.indra.ms_retoindra_customer_backend.model.Customer;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {

}
