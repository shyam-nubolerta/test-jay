package com.example.springtest.dto;

import java.io.Serializable;

public class UserRequest implements Serializable{

    private String firstName;
    private String lastName;
    private String birthdate;
    private String birthplace;
    private String sex;
    private String currentAddress;

    public UserRequest(String firstName, String lastName, String birthdate, String birthplace, String sex, String currentAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.birthplace = birthplace;
        this.sex = sex;
        this.currentAddress = currentAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }
}
