package com.reto.indra.ms_retoindra_customer_backend.service;

import com.reto.indra.ms_retoindra_customer_backend.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Flux<Customer> listCustomers();
    Mono<Customer> listCustomerById(String id);
    Mono<Customer> listClientByUniqueCode(String uniqueCode);
    Mono<Customer> createCustomer(Customer customer);
    Mono<Customer> deleteCustomer(String id);
    Mono<Customer> updateCustomer(Customer customer);

}
