package com.reto.indra.ms_retoindra_customer_backend.service.impl;

import com.reto.indra.ms_retoindra_customer_backend.model.Customer;
import com.reto.indra.ms_retoindra_customer_backend.service.CustomerService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static List<Customer> customers=new ArrayList<>();

    @Override
    public Flux<Customer> listClients() {
                return Flux.fromIterable(customers);
//                        .delayElements(Duration.ofMillis(500)); //TODO Solo para las pruebas iniciales
    }

    @Override
    public Mono<Customer> listClientById(Long id) {
        return listClients()
                .filter(p->p.getId().equals(id))
                .next();
    }

    @Override
    public Mono<Void> createClient(Customer customer) {
        return listClientById(customer.getId())
                .switchIfEmpty(Mono.just(customer).map(c->{
                    customers.add(customer);
                    return c;
                }))
                .then();
    }

    @Override
    public Mono<Customer> deleteClient(Long id) {
        return listClientById(id) //Mono<Producto>
                .map(c->{
                    customers.removeIf(r->r.getId()==id);
                    return c;
                });
    }

    @Override
    public Mono<Customer> updateClient(Customer customer) {
        return listClientById(customer.getId())
                .map(c->{
                    c=customer;
                    return c;
                });
    }
}
