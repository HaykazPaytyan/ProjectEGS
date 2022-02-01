package service.Implementation;

import connection.Connector;
import domain.Product;
import service.dao.ProductDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImplementation implements ProductDao {

    @Override
    public Product getById(long id) {

        final String sql = "SELECT * FROM products WHERE id=?";
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
                product = new Product();
                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setCount(resultSet.getInt("count"));
                product.setCode(resultSet.getString("code"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return product;
    }



    @Override
    public List<Product> getAll() {

        final String sql = "SELECT * FROM products";
        Product product = null;
        List<Product> products = new ArrayList<Product>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            connection = Connector.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                product = new Product();
                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setCount(resultSet.getInt("count"));
                product.setCode(resultSet.getString("code"));

                products.add(product);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }

        return products;

    }

    @Override
    public Product create(Product product) {


        int rs = 0;
        final String sql = "INSERT INTO products (name, price, count, code) VALUES (?,?,?,?)";
        Product product1 = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = Connector.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3,product.getCount());
            preparedStatement.setString(4,product.getCode());

            rs = preparedStatement.executeUpdate();

            if (rs == 1)
            {
                product1 = new Product();
                product1.setId(product.getId());
                product1.setName(product.getName());
                product1.setPrice(product.getPrice());
                product1.setCount(product.getCount());
                product1.setCode(product.getCode());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return product1;
    }


    @Override
    public Product update(Product product, long id) {


        int rs = 0;
        final String sql = "UPDATE products SET name=?,price=?,count=?,code=? WHERE id=?";
        Product product1 = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = Connector.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3,product.getCount());
            preparedStatement.setString(4,product.getCode());
            preparedStatement.setLong(5,id);

            rs = preparedStatement.executeUpdate();

            if (rs == 1)
            {
                product1 = new Product();
                product1.setId(product.getId());
                product1.setName(product.getName());
                product1.setPrice(product.getPrice());
                product1.setCount(product.getCount());
                product1.setCode(product.getCode());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return product1;
    }

    @Override
    public boolean remove(long id) {

        boolean isOk = false;
        int rs = 0;
        final String sql = "DELETE FROM  products  WHERE id=?";
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
