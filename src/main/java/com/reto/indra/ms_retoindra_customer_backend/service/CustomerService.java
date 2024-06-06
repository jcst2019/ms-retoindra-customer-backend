package com.reto.indra.ms_retoindra_customer_backend.service;

import com.reto.indra.ms_retoindra_customer_backend.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Flux<Customer> listClients();
    Mono<Customer> listClientById(Long id);
    Mono<Void> createClient(Customer customer);
    Mono<Customer> deleteClient(Long id);
    Mono<Customer> updateClient(Customer customer);

}
