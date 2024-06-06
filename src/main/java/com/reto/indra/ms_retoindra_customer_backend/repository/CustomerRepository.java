package com.reto.indra.ms_retoindra_customer_backend.repository;

import com.reto.indra.ms_retoindra_customer_backend.model.Customer;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

public interface CustomerRepository extends ReactiveCrudRepository<Customer,Long> {

    Mono<Customer> findById(Long id);

    @Transactional
    @Modifying
    Mono<Void> deleteById(Long id);

}
