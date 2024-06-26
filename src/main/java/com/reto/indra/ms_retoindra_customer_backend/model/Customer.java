package com.reto.indra.ms_retoindra_customer_backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document(collection="customers")
public class Customer {
    @Id
    private String id;
    private String uniqueCode;
    private String name;
    private String lastName;
    private String dni;
    private int age;
    private String address;
    private String phoneNumber;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Builder.Default
    private Date createAt=new Date();

}
