package com.example.springtest.model;

import com.example.springtest.common.Constants;
import jakarta.persistence.*;

@Entity
@Table(name = "application_user")
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String birthdate;
    private String birthplace;
    private String sex;
    private String currentAddress;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = Constants.FIRST_NAME)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = Constants.LAST_NAME)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = Constants.BIRTHDATE)
    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Column(name = Constants.BIRTHPLACE)
    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    @Column(name = Constants.SEX)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Column(name = Constants.CURRENT_ADDRESS)
    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }
}
