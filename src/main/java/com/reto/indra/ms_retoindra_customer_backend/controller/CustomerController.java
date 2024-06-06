package com.reto.indra.ms_retoindra_customer_backend.controller;

import com.reto.indra.ms_retoindra_customer_backend.model.Customer;
import com.reto.indra.ms_retoindra_customer_backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@CrossOrigin("*")
@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value="customers")
    public ResponseEntity<Flux<Customer>> productos(){
        return new ResponseEntity<>(customerService.listClients(), HttpStatus.OK);
    }
}
