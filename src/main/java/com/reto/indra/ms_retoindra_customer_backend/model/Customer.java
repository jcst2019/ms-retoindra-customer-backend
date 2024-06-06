package com.reto.indra.ms_retoindra_customer_backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(value="customers")
public class Customer implements Persistable<Long> {
    @Id
    @Column(value="idCustomer")
    private Long id;
    @Column(value="uniqueCode")
    private String uniqueCode;
    private String name;
    @Column(value="lastName")
    private String lastName;
    private String dni;
    private int age;
    private String address;
    @Column(value="phoneNumber")
    private String phoneNumber;
    private String email;
    @Transient
    private boolean newRow;

    @Override
    public boolean isNew() {
        return newRow || id == null;
    }
//    @Transient
//    private boolean nuevo;

    @Override
    public Long getId() {
        return id;
    }
//
//    @Override
//    public boolean isNew() {
//        return nuevo;
//    }
}
