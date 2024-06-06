package com.reto.indra.ms_retoindra_customer_backend.service;

import com.reto.indra.ms_retoindra_customer_backend.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Flux<Customer> listClients();
    Mono<Customer> listClientById(String id);
    Mono<Customer> listClientByUniqueCode(String uniqueCode);
    Mono<Customer> createClient(Customer customer);
    Mono<Customer> deleteClient(String id);
    Mono<Customer> updateClient(Customer customer);

}
