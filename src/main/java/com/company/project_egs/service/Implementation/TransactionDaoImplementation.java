package com.company.project_egs.service.Implementation;

import com.company.project_egs.connection.Connector;
import com.company.project_egs.domain.Product;
import com.company.project_egs.domain.Transaction;
import com.company.project_egs.domain.User;
import com.company.project_egs.service.dao.TransactionDao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDaoImplementation implements TransactionDao {
    @Override
    public Transaction getById(long id) {

        final String sql = "SELECT * FROM transactions WHERE is=?";
        Transaction transaction = null;
        User user = null;
        Product product = null;
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
                user.setId(resultSet.getLong("user_id"));

                product = new Product();
                product.setId(resultSet.getLong("product_id"));

                transaction = new Transaction();
                transaction.setId(resultSet.getLong("id"));
                transaction.setUser(user);
                transaction.setProduct(product);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return transaction;
    }

    @Override
    public List<Transaction> getAll() {

        final String sql = "SELECT * FROM transactions";
        User user = null;
        Product product = null;
        Transaction transaction = null;
        List<Transaction> transactions = new ArrayList<Transaction>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            connection = Connector.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                user = new User();
                user.setId(resultSet.getLong("user_id"));

                product = new Product();
                product.setId(resultSet.getLong("product_id"));

                transaction = new Transaction();
                transaction.setId(resultSet.getLong("id"));
                transaction.setUser(user);
                transaction.setProduct(product);

                transactions.add(transaction);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return transactions;
    }

    @Override
    public Transaction create(User user, Product product) {


        int rs = 0;
        final String sql = "INSERT INTO transactions (user_id, product_id) VALUES (?,?)";
        User user1 = null;
        Product product1 = null;
        Transaction transaction = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = Connector.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,user.getId());
            preparedStatement.setLong(2,product.getId());

            rs = preparedStatement.executeUpdate();

            if (rs == 1)
            {
                user1 = new User();
                user1.setId(user.getId());

                product1 = new Product();
                product1.setId(product.getId());

                transaction = new Transaction();
                transaction.setUser(user);
                transaction.setProduct(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return transaction;

    }

    @Override
    public Transaction update(User user, Product product, long id) {


        int rs =0;
        final String sql = "UPDATE transactions SET user_id=?,product_id=? WHERE id=?";
        User user1 = null;
        Product product1 = null;
        Transaction transaction = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {

            connection = Connector.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,user.getId());
            preparedStatement.setLong(2,product.getId());
            preparedStatement.setLong(3,id);


            rs = preparedStatement.executeUpdate();

            if (rs == 1)
            {
                user1 = new User();
                user1.setId(user.getId());

                product1 = new Product();
                product1.setId(product.getId());

                transaction = new Transaction();
                transaction.setId(id);
                transaction.setUser(user);
                transaction.setProduct(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return transaction;

    }

    @Override
    public boolean delete(long id) {

        boolean isOk = false;
        int rs = 0;
        final String sql = "DELETE FROM  transactions  WHERE id=?";
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
}
