package com.example.demo.servlet.api.delete;

import com.example.demo.service.Implementation.ProductDaoImplementation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteProductServlet", value = "/api/product/delete/*")
public class DeleteProductServlet extends HttpServlet {
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String param = request.getPathInfo().replace("/","");

        ProductDaoImplementation productDaoImplementation = new ProductDaoImplementation();
        productDaoImplementation.remove(Long.parseLong(param));
    }
}
