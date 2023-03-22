package org.example.dao.interfaces;

import java.util.List;

import org.example.models.User;

public interface UserDAO {
    User getPersonById(Long id);

    List<User> getAllPersons();

    boolean deletePerson(User user);

    boolean updatePerson(User user);

    void createPerson(User user);
}