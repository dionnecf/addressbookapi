package com.dionnecondorfarrell.addressbookapi.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name="customers")
public class Customer {

    @Id
    @Column(name="email")
    private String id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="surname")
    private String surname;

    @Column(name="address")
    private String address;

    @Column(name="post_code")
    private String postCode;

}
