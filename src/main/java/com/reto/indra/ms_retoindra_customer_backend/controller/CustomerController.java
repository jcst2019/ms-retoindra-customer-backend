package com.reto.indra.ms_retoindra_customer_backend.controller;

import com.org.reto.indra.util.EncryptionAESUtil;
import com.reto.indra.ms_retoindra_customer_backend.model.Customer;
import com.reto.indra.ms_retoindra_customer_backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.crypto.SecretKey;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value="/")
    public ResponseEntity<Flux<Customer>> customers(){
        return new ResponseEntity<>(customerService.listClients(), HttpStatus.OK);
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<Mono<Customer>> listCustomers(@PathVariable("id") String id){
        return new ResponseEntity<>(customerService.listClientById(id),HttpStatus.OK);
    }

    @PostMapping(value="/create",consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mono<Customer>> createCustomer(@RequestBody Customer customer) throws Exception {
        SecretKey key = EncryptionAESUtil.generateAESKey();
        customer.setUniqueCode(EncryptionAESUtil.encryptAES(customer.getUniqueCode(), key));
        return new ResponseEntity<>(customerService.createClient(customer),HttpStatus.OK);
    }
}
