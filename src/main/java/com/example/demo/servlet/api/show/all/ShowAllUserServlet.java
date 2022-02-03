package com.example.demo.servlet.api.show.all;

import com.example.demo.domain.User;
import com.example.demo.service.Implementation.UserDaoImplementation;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ShowAllUserServlet", value = "/api/users")
public class ShowAllUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDaoImplementation userDaoImplementation = new UserDaoImplementation();
        List<User> users = userDaoImplementation.getAll();

        response.setContentType("application/json; charset=utf-8");

        PrintWriter writer = response.getWriter();
        writer.print(new Gson().toJson(users));
        writer.flush();
    }

}
