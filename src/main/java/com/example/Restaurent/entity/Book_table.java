package com.example.Restaurent.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "booktable")  // MongoDB collection name
public class Book_table {

    @Id
    private String id; // MongoDB uses String IDs

    private String name;
    private String email;
    private int person;
    private LocalDate dob;
    private String address;

    public Book_table() {}

    public Book_table(String id, String name, String email, int person, LocalDate dob, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.person = person;
        this.dob = dob;
        this.address = address;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
