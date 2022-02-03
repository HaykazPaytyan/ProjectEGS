package com.example.demo.servlet.api.create;



import com.example.demo.domain.Product;
import com.example.demo.dto.ProductDto;
import com.example.demo.service.Implementation.ProductDaoImplementation;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;



@WebServlet(name = "CreateProductServlet", value = "/api/product/create")
public class CreateProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
