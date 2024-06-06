package com.reto.indra.ms_retoindra_customer_backend.repository;

import com.reto.indra.ms_retoindra_customer_backend.model.Customer;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {
    Mono<Customer> findByUniqueCode(String uniqueCode);
}
