package org.example.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.models.User;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {

        User person = new User();
        person.setUserId(resultSet.getInt("person_id"));
        person.setUserName(resultSet.getString("person_name"));
        person.setUserPhone(resultSet.getString("person_phone"));
        person.setUserEmail(resultSet.getString("person_email"));
        return person;
    }
}
