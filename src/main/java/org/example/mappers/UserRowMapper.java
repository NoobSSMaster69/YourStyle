package org.example.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.models.User;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {

        User user = new User();
        user.setUserId(resultSet.getInt("userId"));
        user.setUserLogin(resultSet.getString("userLogin"));
        user.setUserName(resultSet.getString("userName"));
        user.setUserLastname(resultSet.getString("userLastname"));
        user.setUserPatronymic(resultSet.getString("userPatronymic"));
        user.setUserPhone(resultSet.getString("userPhone"));
        user.setUserEmail(resultSet.getString("userEmail"));
        user.setUserPass(resultSet.getString("userPass"));
        return user;
    }
}
