package com.aureltest.testOffer.repositories;

import com.aureltest.testOffer.models.Person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
