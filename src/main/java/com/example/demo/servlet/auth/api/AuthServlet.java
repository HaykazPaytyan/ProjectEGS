package com.example.demo.servlet.auth.api;


import com.example.demo.domain.User;
import com.example.demo.dto.auth.Credential;
import com.example.demo.service.Implementation.AuthDaoImplementation;
import com.google.gson.Gson;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AuthServlet", value = "/auth")
public class AuthServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Credential credentials = new Gson().fromJson(request.getReader(), Credential.class);

        AuthDaoImplementation auth = new AuthDaoImplementation();
        User user = auth.attempt(credentials);

        PrintWriter writer = response.getWriter();
        writer.println(new Gson().toJson(user));
        writer.flush();
    }


}
