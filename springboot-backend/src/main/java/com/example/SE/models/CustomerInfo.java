package com.example.SE.models;

import java.time.Instant;
import java.util.List;

import com.example.SE.models.User;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Document(collection = "CustomerInfo")
public class CustomerInfo {
    @Id
    private String id;

    private String user_id;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    private String firstname;
    private String lastname;
    private List<String> address;
    private String phoneNumber;

    private int defaultAddress;

    //getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(int defaultAddress) {
        this.defaultAddress = defaultAddress;
    }
}