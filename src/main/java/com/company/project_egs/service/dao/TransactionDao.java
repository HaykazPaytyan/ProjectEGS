package com.company.project_egs.service.dao;



import com.company.project_egs.domain.Product;
import com.company.project_egs.domain.Transaction;
import com.company.project_egs.domain.User;

import java.util.List;

public interface TransactionDao {

    Transaction getById(long id);
    List<Transaction> getAll();
    Transaction create(User user, Product product);
    Transaction update(User user, Product product,long id);
    boolean delete(long id);
}
