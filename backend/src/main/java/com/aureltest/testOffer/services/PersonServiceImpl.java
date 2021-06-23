package com.aureltest.testOffer.services;

import java.util.Calendar;

import com.aureltest.testOffer.models.Person;
import com.aureltest.testOffer.repositories.PersonRepository;
import com.aureltest.testOffer.web.errors.PersonLogicException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of PersonService
 */
@Service
public class PersonServiceImpl implements PersonService {

    /**
     * The JPA repository
     */
    @Autowired
    private PersonRepository personRepository;

    /**
     * Finds a Person by its id
     */
    public Person getUserById(int id) {
        /*
         * not using getById to avoid hibernate to inject proxy class which is not
         * serializable (should not be this way in a concrete project)
         */
        return personRepository.findById(id).get();
    }

    public Person createPerson(Person p) throws PersonLogicException {
        // check Person object before saving it
        Calendar ageLimit = Calendar.getInstance();
        ageLimit.add(Calendar.YEAR, -18);
        ageLimit.set(Calendar.SECOND, 0);
        ageLimit.set(Calendar.HOUR, 0);
        System.out.println("toto");
        if (p.getDateBirth().after(ageLimit.getTime())) {
            throw new PersonLogicException("You must be 18 or older to register");
        }
        if (!p.getState().equals("FRANCE")) {
            throw new PersonLogicException("You must be from FRANCE to register");
        }
        return personRepository.save(p);
    }
}