package org.example.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.models.Person;
import org.springframework.jdbc.core.RowMapper;

public class PersonRowMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {

        Person person = new Person();
        person.setPerson_id(resultSet.getInt("person_id"));
        person.setPerson_name(resultSet.getString("person_name"));
        person.setPerson_phone(resultSet.getString("person_phone"));
        person.setPerson_email(resultSet.getString("person_email"));
        return person;
    }
}
