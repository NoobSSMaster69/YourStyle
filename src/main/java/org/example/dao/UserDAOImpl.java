package org.example.dao;

import org.example.dao.interfaces.UserDAO;
import org.example.mappers.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.example.models.User;

import javax.sql.DataSource;
import java.util.List;


@Component
public class UserDAOImpl implements UserDAO {

    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_PERSON = "select * from person where person_id = ?";
    private final String SQL_DELETE_PERSON = "delete from person where person_id = ?";
    private final String SQL_UPDATE_PERSON = "update person set person_name = ?, person_phone = ?, person_email = ? where person_id = ?";
    private final String SQL_GET_ALL = "select * from person";
    private final String SQL_INSERT_PERSON = "insert into person(person_id, person_name, person_email, person_pass) values(DEFAULT,?,?,?)";

    @Autowired
    public UserDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public User getPersonById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_PERSON, new UserRowMapper(), new Object[] { id });
    }

    public List<User> getAllPersons() {
        return jdbcTemplate.query(SQL_GET_ALL, new UserRowMapper());
    }

    public boolean deletePerson(User user) {
        return jdbcTemplate.update(SQL_DELETE_PERSON, user.getUserId()) > 0;
    }

    public boolean updatePerson(User user) {
        return jdbcTemplate.update(SQL_UPDATE_PERSON, user.getUserName(), user.getUserPhone(),
                user.getUserEmail()) > 0;
    }

    public void createPerson(User user) {
        jdbcTemplate.update(SQL_INSERT_PERSON, user.getUserName(),
                user.getUserEmail(), user.getUserPass());
    }}