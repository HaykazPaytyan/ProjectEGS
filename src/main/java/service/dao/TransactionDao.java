package service.dao;

import domain.Product;
import domain.Transaction;
import domain.User;

import java.util.List;

public interface TransactionDao {

    Transaction getById(long id);
    List<Transaction> getAll();
    Transaction create(User user, Product product);
    Transaction update(User user, Product product,long id);
    boolean delete(long id);
}
