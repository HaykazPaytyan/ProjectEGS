package com.example.demo.servlet.admin.product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminProductDeleteServlet", value = "/admin/product/delete/*")
public class AdminProductDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/pages/admin/product/delete.html").forward(request,response);
    }
}
