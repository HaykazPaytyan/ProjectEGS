package com.example.demo.servlet.api.show.id;

import com.example.demo.domain.Product;
import com.example.demo.service.Implementation.ProductDaoImplementation;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShowOneProductServlet", value = "/api/product/*")
public class ShowOneProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String param = request.getPathInfo().replace("/","");

        ProductDaoImplementation productDaoImplementation = new ProductDaoImplementation();
        Product product = productDaoImplementation.getById(Long.parseLong(param));

        response.setContentType("application/json; charset=utf-8");

        PrintWriter writer = response.getWriter();
        writer.print(new Gson().toJson(product));
        writer.flush();
    }

}
