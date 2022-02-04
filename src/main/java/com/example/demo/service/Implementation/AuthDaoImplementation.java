package com.example.demo.service.Implementation;

import com.example.demo.connection.Connector;
import com.example.demo.domain.User;
import com.example.demo.dto.auth.Credential;
import com.example.demo.service.dao.Auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthDaoImplementation implements Auth {

    @Override
    public User attempt(Credential credential) {

        final String sql = "SELECT * FROM users WHERE email=? AND password=?";
        User user = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            connection = Connector.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,credential.getEmail());
            preparedStatement.setString(2,credential.getPassword());
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFirst_name(resultSet.getString("first_name"));
                user.setLast_name(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
