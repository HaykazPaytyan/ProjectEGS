package com.example.demo.service.dao;



import com.example.demo.domain.Product;
import com.example.demo.domain.Transaction;
import com.example.demo.domain.User;

import java.util.List;

public interface TransactionDao {

    Transaction getById(long id);
    List<Transaction> getAll();
    Transaction create(User user, Product product);
    Transaction update(User user, Product product,long id);
    boolean delete(long id);
}
