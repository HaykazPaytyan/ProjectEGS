package com.example.demo.service.dao;


import com.example.demo.domain.Product;

import java.util.List;

public interface ProductDao {

    Product getById(long id);
    List<Product> getAll();
    Product create(Product product);
    Product update(Product product,long id);
    boolean remove(long id);
}
