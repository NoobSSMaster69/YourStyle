package org.example.dao.interfaces;

import java.util.List;

import org.example.models.User;

public interface UserDAO {
    User getPersonById(Long id);

    List<User> getUserByLogin(String login);

    List<User> getAllPersons();

    boolean deletePerson(User user);

    boolean updatePerson(User user);

    void createUser(User user);

}