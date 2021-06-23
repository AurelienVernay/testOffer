package com.aureltest.testOffer.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.lang.Nullable;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "person")
@Getter
@Setter
public class Person {

    public Person() {
    }

    public Person(int id, String firstname, String lastname, String gender, Date dateBirth, String address1,
            String address2, String state) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.dateBirth = dateBirth;
        this.address1 = address1;
        this.address2 = address2;
        this.state = state;
    }

    @JsonProperty
    @Id
    @Nullable
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_id_seq")
    @Column(name = "id")
    Integer id;

    @JsonProperty
    @Column(name = "firstname")
    String firstname;

    @JsonProperty
    @Column(name = "lastname")
    String lastname;

    @JsonProperty
    @Column(name = "gender")
    String gender;

    @JsonProperty
    @Column(name = "address1")
    String address1;

    @JsonProperty
    @Column(name = "address2")
    String address2;

    @JsonProperty
    @Column(name = "date_birth")
    Date dateBirth;

    @JsonProperty
    @Column(name = "state")
    String state;

    /**
     * Overriding toString method to show values inside AOP logging
     */
    public String toString() {
        return "Person : " + firstname + " " + lastname + " " + gender + " " + address1 + " " + address2 + " " + state
                + " " + dateBirth.toString();
    }

    /**
     * return true if the object is equal to Person provided
     * 
     * @param p Person compared
     */
    public boolean equals(Person p) {
        return p.getId().equals(this.id) && p.getFirstname().equals(this.firstname)
                && p.getLastname().equals(this.lastname) && p.getGender().equals(this.gender)
                && p.getAddress1().equals(this.address1) && p.getAddress2().equals(this.address2)
                && p.getState().equals(this.state) && p.getDateBirth().equals(this.dateBirth);
    }
}