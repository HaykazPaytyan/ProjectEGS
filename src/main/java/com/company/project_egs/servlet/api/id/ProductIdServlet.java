package com.company.project_egs.servlet.api.id;

import com.company.project_egs.domain.Product;
import com.company.project_egs.dto.ProductDto;
import com.company.project_egs.service.Implementation.ProductDaoImplementation;
import com.google.gson.Gson;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ProductIdServlet  extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String param = request.getPathInfo().replace("/","");

        ProductDaoImplementation productDaoImplementation = new ProductDaoImplementation();
        Product product = productDaoImplementation.getById(Long.parseLong(param));

        response.setContentType("application/json; charset=utf-8");

        PrintWriter writer = response.getWriter();
        writer.print(new Gson().toJson(product));
        writer.flush();
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String param = request.getPathInfo().replace("/","");

        ProductDto productDto = new Gson().fromJson(request.getReader(), ProductDto.class);
        Product product = this.productDtoToProduct(productDto);

        ProductDaoImplementation productDaoImplementation = new ProductDaoImplementation();
        productDaoImplementation.update(product,Long.parseLong(param));


    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {

        String param = request.getPathInfo().replace("/","");

        ProductDaoImplementation productDaoImplementation = new ProductDaoImplementation();
        productDaoImplementation.remove(Long.parseLong(param));

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
