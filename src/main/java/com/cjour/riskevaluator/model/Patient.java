package com.cjour.riskevaluator.model;

import java.util.Date;

public class Patient {

    private Integer id;

    private String firstname;

    private String name;

    private Date birthdate;

    private String genre;

    private String address;

    private String phoneNumber;

    public Patient(){}

    public Patient(Integer id, String firstname, String name, Date birthdate, String genre, String address, String phoneNumber) {
        super();
        this.firstname = firstname;
        this.name = name;
        this.birthdate = birthdate;
        this.genre = genre;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
