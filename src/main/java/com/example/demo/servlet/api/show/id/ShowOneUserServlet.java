package com.example.demo.servlet.api.show.id;

import com.example.demo.domain.User;
import com.example.demo.service.Implementation.UserDaoImplementation;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShowOneUserServlet", value = "/api/user/*")
public class ShowOneUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String param = request.getPathInfo().replace("/","");

        UserDaoImplementation userDaoImplementation = new UserDaoImplementation();
        User user = userDaoImplementation.getById(Long.parseLong(param));

        response.setContentType("application/json; charset=utf-8");

        PrintWriter writer = response.getWriter();
        writer.print(new Gson().toJson(user));
        writer.flush();
    }

}
