package com.example.demo.service.Implementation;



import com.example.demo.connection.Connector;
import com.example.demo.domain.User;
import com.example.demo.service.dao.UserDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImplementation implements UserDao {

    @Override
    public User getById(long id) {

        final String sql = "SELECT * FROM users WHERE id=?";
        User user = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            connection = Connector.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,id);
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



    @Override
    public List<User> getAll() {

        final String sql = "SELECT * FROM users";
        User user = null;
        List<User> users = new ArrayList<User>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            connection = Connector.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFirst_name(resultSet.getString("first_name"));
                user.setLast_name(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));

                users.add(user);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return users;

    }

    @Override
    public User create(User user) {


        int rs = 0;
        final String sql = "INSERT INTO users (first_name,last_name,email,password) VALUES (?,?,?,?)";
        User user1 = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = Connector.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getFirst_name());
            preparedStatement.setString(2,user.getLast_name());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setString(4,user.getPassword());

            rs = preparedStatement.executeUpdate();

            if (rs == 1)
            {
                user1 = new User();
                user1 = this.findByUserEmail(user.getEmail());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user1;
    }


    @Override
    public User update(User user, long id) {


        int rs =0;
        final String sql = "UPDATE users SET first_name=?,last_name=?,email=?,password=? WHERE id=?";
        User user1 = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {

            connection = Connector.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getFirst_name());
            preparedStatement.setString(2,user.getLast_name());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setString(4,user.getPassword());
            preparedStatement.setLong(5,id);

            rs = preparedStatement.executeUpdate();

            if (rs == 1)
            {
                user1 = new User();
                user1.setId(id);
                user1.setFirst_name(user.getFirst_name());
                user1.setLast_name(user.getLast_name());
                user1.setEmail(user.getEmail());
                user1.setPassword(user.getPassword());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user1;
    }

    @Override
    public boolean remove(long id) {

        boolean isOk = false;
        int rs = 0;
        final String sql = "DELETE FROM  users  WHERE id=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = Connector.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,id);

            rs = preparedStatement.executeUpdate();

            if (rs == 1){
                isOk = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return isOk;
    }

    @Override
    public User findByUserEmail(String email) {

        final String sql = "SELECT * FROM users WHERE email=?";
        User user = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            connection = Connector.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,email);
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
