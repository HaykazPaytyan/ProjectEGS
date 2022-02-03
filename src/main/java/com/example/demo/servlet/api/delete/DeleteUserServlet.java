package com.example.demo.servlet.api.delete;

import com.example.demo.service.Implementation.UserDaoImplementation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteUserServlet", value = "/api/user/delete/*")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        String param = request.getPathInfo().replace("/","");

        UserDaoImplementation userDaoImplementation = new UserDaoImplementation();
        userDaoImplementation.remove(Long.parseLong(param));
    }
}
