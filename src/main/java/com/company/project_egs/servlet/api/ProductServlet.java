package com.company.project_egs.servlet.api;

import com.company.project_egs.domain.Product;
import com.company.project_egs.dto.ProductDto;
import com.company.project_egs.service.Implementation.ProductDaoImplementation;
import com.google.gson.Gson;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ProductDaoImplementation productDaoImplementation = new ProductDaoImplementation();
        List<Product> products = productDaoImplementation.getAll();

        response.setContentType("application/json; charset=utf-8");

        PrintWriter writer = response.getWriter();
        writer.print(new Gson().toJson(products));
        writer.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ProductDto productDto = new Gson().fromJson(request.getReader(), ProductDto.class);
        Product product = this.productDtoToProduct(productDto);

        ProductDaoImplementation productDaoImplementation = new ProductDaoImplementation();
        productDaoImplementation.create(product);

    }

    private Product productDtoToProduct(ProductDto productDto){
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setCount(productDto.getCount());
        product.setCode(productDto.getCode());
        return product;
    }
}
