package com.dionnecondorfarrell.addressbookapi.model;

import javax.persistence.*;
import java.util.Objects;

public class Customer {

    private int id;

    private String firstName;

    private String surname;

    private String address;

    private String postCode;

    public Customer() {

    }

    public Customer(String firstName, String surname, String address, String postCode){
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.postCode = postCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getPostCode() {
        return postCode;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,surname, firstName);
    }
}
