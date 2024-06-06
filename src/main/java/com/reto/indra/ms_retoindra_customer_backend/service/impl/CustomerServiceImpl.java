package com.reto.indra.ms_retoindra_customer_backend.service.impl;

import com.reto.indra.ms_retoindra_customer_backend.model.Customer;
import com.reto.indra.ms_retoindra_customer_backend.repository.CustomerRepository;
import com.reto.indra.ms_retoindra_customer_backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Flux<Customer> listClients() {
                return customerRepository.findAll();
//                        .delayElements(Duration.ofMillis(500)); //TODO Solo para las pruebas iniciales
    }

    @Override
    public Mono<Customer> listClientById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Mono<Void> createClient(Customer customer) {
        return listClientById(customer.getId())
                .switchIfEmpty(Mono.just(customer).flatMap(c->customerRepository.save(c)))
                .then();
    }

    @Override
    public Mono<Customer> deleteClient(Long id) {
        return listClientById(id) //Mono<Producto>
                .flatMap(c->customerRepository.deleteById(id)
                            .then(Mono.just(c))
                );
    }

    @Override
    public Mono<Customer> updateClient(Customer customer) {
        return listClientById(customer.getId())
                .flatMap(c->{return customerRepository.save(c);});
    }
}
