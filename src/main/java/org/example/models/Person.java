package org.example.models;


import org.springframework.data.annotation.Id;

import javax.validation.constraints.*;

public class Person {
    @Id
    private int person_id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 1, max = 30, message = "Name should be between 1 and 30 characters")
    private String person_name;

    @Size(min = 1, max = 30, message = "Last name should be between 1 and 30 characters")
    private String person_lastname;

    @Size(min = 1, max = 30, message = "Patronymic should be between 1 and 30 characters")
    private String person_patronymic;


    @Max(value = 12, message = "Age should be greater than 0")
    private String person_phone;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String person_email;

    @NotEmpty(message = "Password should not be empty")
    private String person_pass;

    public String getPerson_pass() {
        return person_pass;
    }

    public void setPerson_pass(String person_pass) {
        this.person_pass = person_pass;
    }

    public Person() {

    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getPerson_lastname() {
        return person_lastname;
    }

    public void setPerson_lastname(String person_lastname) {
        this.person_lastname = person_lastname;
    }

    public String getPerson_patronymic() {
        return person_patronymic;
    }

    public void setPerson_patronymic(String person_patronymic) {
        this.person_patronymic = person_patronymic;
    }

    public String getPerson_phone() {
        return person_phone;
    }

    public void setPerson_phone(String person_phone) {
        this.person_phone = person_phone;
    }

    public String getPerson_email() {
        return person_email;
    }

    public void setPerson_email(String person_email) {
        this.person_email = person_email;
    }

    public Person(int person_id, String person_name, String person_phone, String person_email) {
        this.person_id = person_id;
        this.person_name = person_name;
        this.person_phone = person_phone;
        this.person_email = person_email;
    }

}
