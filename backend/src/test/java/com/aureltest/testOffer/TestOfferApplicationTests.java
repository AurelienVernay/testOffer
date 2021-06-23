package com.aureltest.testOffer;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import com.aureltest.testOffer.models.Person;
import com.aureltest.testOffer.services.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;

@SpringBootTest
@ImportResource({ "classpath:spring-context.xml" })
class TestOfferApplicationTests {

	@Autowired
	private PersonService personService;

	/**
	 * Ensures that context is correctly loaded
	 */
	@Test
	void contextLoads() {
	}

	/**
	 * Useless test
	 */
	@Test
	void shouldReturnDefaultUser() {
		assertTrue(true);
	}

	/**
	 * This test should ensure that the created person is retrieved by the
	 * PersonService
	 */
	void shouldCreateAndRetrieveUser() {
		Person p = new Person(100, "person", "TEST", "M", new Date(), "1 rue du test", "31200 TOULOUSE", "FRANCE");
		assertTrue(personService.createPerson(p).equals(personService.getUserById(100)));
	}
}
