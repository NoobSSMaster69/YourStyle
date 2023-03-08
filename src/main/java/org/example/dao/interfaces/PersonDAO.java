package org.example.dao.interfaces;

import java.util.List;

import org.example.models.Person;

public interface PersonDAO {
    Person getPersonById(Long id);

    List<Person> getAllPersons();

    boolean deletePerson(Person person);

    boolean updatePerson(Person person);

    void createPerson(Person person);
}