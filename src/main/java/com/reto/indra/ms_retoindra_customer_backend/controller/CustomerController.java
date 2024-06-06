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
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value="customers")
    public ResponseEntity<Flux<Customer>> customers(){
        return new ResponseEntity<>(customerService.listClients(), HttpStatus.OK);
    }
    @GetMapping(value="customers/{id}")
    public ResponseEntity<Mono<Customer>> listCustomers(@PathVariable("id") Long id){
        return new ResponseEntity<>(customerService.listClientById(id),HttpStatus.OK);
    }

    @PostMapping(value="create",consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mono<Void>> createCustomer(@RequestBody Customer customer) throws Exception {
        SecretKey key = EncryptionAESUtil.generateAESKey();
        customer.setUniqueCode(EncryptionAESUtil.encryptAES(customer.getUniqueCode(), key));
        //customer.setId(null); // Asegúrate de que el ID sea null para permitir la auto-generación
        customer.setNewRow(true);
        return new ResponseEntity<>(customerService.createClient(customer),HttpStatus.OK);
    }
//    @DeleteMapping(value="eliminar")
//    public Mono<ResponseEntity<Producto>> eliminarProducto(@RequestParam("cod") int cod) {
//        return productosService.eliminarProducto(cod)//Mono<Producto>
//                .map(p->new ResponseEntity<>(p,HttpStatus.OK))//Mono<ResponseEntity<Producto>>
//                .switchIfEmpty(Mono.just(new ResponseEntity<>(HttpStatus.NOT_FOUND)));//Mono<ResponseEntity<Producto>>
//    }
//    @PutMapping(value="actualizar")
//    public Mono<ResponseEntity<Producto>> actualizarProducto(@RequestParam("cod") int cod,@RequestParam("precio") double precio) {
//        return productosService.actualizarPrecio(cod, precio)//Mono<Producto>
//                .map(p->new ResponseEntity<>(p,HttpStatus.OK))//Mono<ResponseEntity<Producto>>
//                .switchIfEmpty(Mono.just(new ResponseEntity<>(HttpStatus.NOT_FOUND)));//Mono<ResponseEntity<Producto>>
//    }
}
