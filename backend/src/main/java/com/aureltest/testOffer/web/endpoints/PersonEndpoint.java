package com.aureltest.testOffer.web.endpoints;

import com.aureltest.testOffer.models.Person;
import com.aureltest.testOffer.services.PersonService;
import com.aureltest.testOffer.web.errors.PersonLogicException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/persons")
public class PersonEndpoint {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable("id") int id) throws PersonLogicException {
        try {
            return personService.getUserById(id);
        } catch (Exception exc) {
            // should check exception type to throw only if not found
            throw new PersonLogicException("user not found");
        }

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Person getPerson(@RequestBody() Person person) throws PersonLogicException {
        return personService.createPerson(person);
    }

}
