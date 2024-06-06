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

    private static List<Customer> customers=new ArrayList<>(List.of(
             new Customer(1L, "ABC123", "John", "Doe", "12345678", 30, "123 Main St", "1234567890", "john@example.com"),
             new Customer(2L, "DEF456", "Jane", "Smith", "87654321", 25, "456 Elm St", "9876543210", "jane@example.com"),
             new Customer(3L, "GHI789", "Michael", "Johnson", "45678901", 40, "789 Oak St", "2345678901", "michael@example.com"),
             new Customer(4L, "JKL012", "Emily", "Davis", "32109876", 35, "987 Pine St", "3456789012", "emily@example.com"),
             new Customer(5L, "MNO345", "David", "Martinez", "67890123", 28, "654 Cedar St", "4567890123", "david@example.com"),
             new Customer(6L, "PQR678", "Sarah", "Garcia", "89012345", 33, "321 Birch St", "5678901234", "sarah@example.com"),
             new Customer(7L, "STU901", "Chris", "Lopez", "23456789", 27, "456 Walnut St", "6789012345", "chris@example.com"),
             new Customer(8L, "VWX234", "Michelle", "Hernandez", "90123456", 42, "789 Maple St", "7890123456", "michelle@example.com"),
             new Customer(9L, "YZA567", "Daniel", "Brown", "34567890", 31, "987 Pine St", "8901234567", "daniel@example.com"),
             new Customer(10L, "BCD890", "Amanda", "Wilson", "01234567", 29, "654 Cedar St", "9012345678", "amanda@example.com"),
             new Customer(11L, "EFG123", "Jessica", "Taylor", "78901234", 38, "321 Birch St", "0123456789", "jessica@example.com"),
             new Customer(12L, "HIJ456", "Andrew", "King", "23456789", 32, "456 Walnut St", "1234567890", "andrew@example.com"),
             new Customer(13L, "KLM789", "Stephanie", "Lee", "90123456", 39, "789 Maple St", "2345678901", "stephanie@example.com"),
             new Customer(14L, "NOP012", "Jason", "Wong", "34567890", 36, "987 Pine St", "3456789012", "jason@example.com"),
             new Customer(15L, "QRS345", "Rachel", "Nguyen", "01234567", 26, "654 Cedar St", "4567890123", "rachel@example.com")));

    @Override
    public Flux<Customer> listClients() {
                return Flux.fromIterable(customers)
                        .delayElements(Duration.ofMillis(500)); //TODO Solo para las pruebas iniciales
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
