package com.reto.indra.ms_retoindra_customer_backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {

    private Long id;
    private String uniqueCode;
    private String name;
    private String lastName;
    private String dni;
    private int age;
    private String address;
    private String phoneNumber;
    private String email;

}
