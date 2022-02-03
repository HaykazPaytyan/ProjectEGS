package com.example.demo.servlet.admin.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminUserEditServlet", value = "/admin/user/edit/*")
public class AdminUserEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/pages/admin/user/edit.html").forward(request,response);
    }
}
