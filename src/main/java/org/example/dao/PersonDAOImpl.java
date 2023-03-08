package org.example.dao;

import org.example.dao.interfaces.PersonDAO;
import org.example.mappers.PersonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.example.models.Person;

import javax.sql.DataSource;
import java.util.List;


@Component
public class PersonDAOImpl implements PersonDAO {

    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_PERSON = "select * from person where person_id = ?";
    private final String SQL_DELETE_PERSON = "delete from person where person_id = ?";
    private final String SQL_UPDATE_PERSON = "update person set person_name = ?, person_phone = ?, person_email = ? where person_id = ?";
    private final String SQL_GET_ALL = "select * from person";
    private final String SQL_INSERT_PERSON = "insert into person(person_id, person_name, person_email, person_pass) values(DEFAULT,?,?,?)";

    @Autowired
    public PersonDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Person getPersonById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_PERSON, new PersonRowMapper(), new Object[] { id });
    }

    public List<Person> getAllPersons() {
        return jdbcTemplate.query(SQL_GET_ALL, new PersonRowMapper());
    }

    public boolean deletePerson(Person person) {
        return jdbcTemplate.update(SQL_DELETE_PERSON, person.getPerson_id()) > 0;
    }

    public boolean updatePerson(Person person) {
        return jdbcTemplate.update(SQL_UPDATE_PERSON, person.getPerson_name(), person.getPerson_phone(),
                person.getPerson_email()) > 0;
    }

    public void createPerson(Person person) {
        jdbcTemplate.update(SQL_INSERT_PERSON, person.getPerson_name(),
                person.getPerson_email(), person.getPerson_pass());
    }}