package com.reto.indra.ms_retoindra_customer_backend.controller;

import com.org.reto.indra.constants.ConstantsUtil;
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
import javax.crypto.spec.SecretKeySpec;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value="/")
    public ResponseEntity<Flux<Customer>> customers(){
        return new ResponseEntity<>(customerService.listCustomers(), HttpStatus.OK);
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<Mono<Customer>> listCustomers(@PathVariable("id") String id){
        return new ResponseEntity<>(customerService.listCustomerById(id),HttpStatus.OK);
    }

    @GetMapping(value="/findByUniqueCode")
    public ResponseEntity<Mono<Customer>> findByUniqueCode(@RequestParam("uniqueCode") String encodedUniqueCode) {
        try {
            encodedUniqueCode = encodedUniqueCode.replace(" ", "+");
            System.out.println("encodedUniqueCode==>" + encodedUniqueCode);

            return new ResponseEntity<>(customerService.listClientByUniqueCode(encodedUniqueCode), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

@PostMapping(value="/create")
public ResponseEntity<Mono<Customer>> createCustomer(@RequestBody Customer customer) {
    try {
        SecretKey key = EncryptionAESUtil.generateAESKey();
        String encryptedUniqueCode = EncryptionAESUtil.encryptAES(customer.getUniqueCode(), key);
        customer.setUniqueCode(encryptedUniqueCode);
        return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.OK);
    } catch (Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
}
