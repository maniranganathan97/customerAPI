package com.example.customerapi.model;

import javax.persistence.*;

@Entity
@Table
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customerSequence",
            sequenceName = "customerSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy =GenerationType.IDENTITY,
            generator = "customerSequence"
    )
    private Long id;
    private String name;
    private String accountNumber;
    private String email;

    public Customer(Long id, String name, String accountNumber, String email) {
        this.id = id;
        this.name = name;
        this.accountNumber = accountNumber;
        this.email = email;
    }

    public Customer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
