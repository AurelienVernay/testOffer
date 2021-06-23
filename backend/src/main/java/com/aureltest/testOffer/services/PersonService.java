package com.aureltest.testOffer.services;

import com.aureltest.testOffer.models.Person;

public interface PersonService {
    /**
     * Finds a Person by its id
     * 
     * @param id the identifier
     * @return the Person found
     */
    public Person getUserById(int id);

    /**
     * Saves a person into DB
     * 
     * @param p the Person to save
     * @return the Person created (with its generated id)
     */
    public Person createPerson(Person p);
}
