package com.example.demo.servlet.api.show.all;

import com.example.demo.domain.Product;
import com.example.demo.service.Implementation.ProductDaoImplementation;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ShowAllProductServlet", value = "/api/products")
public class ShowAllProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductDaoImplementation productDaoImplementation = new ProductDaoImplementation();
        List<Product> products = productDaoImplementation.getAll();

        response.setContentType("application/json; charset=utf-8");

        PrintWriter writer = response.getWriter();
        writer.print(new Gson().toJson(products));
        writer.flush();
    }

}
