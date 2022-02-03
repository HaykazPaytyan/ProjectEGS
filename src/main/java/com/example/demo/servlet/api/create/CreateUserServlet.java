package com.example.demo.servlet.api.create;

import com.example.demo.domain.User;
import com.example.demo.dto.UserDto;
import com.example.demo.service.Implementation.UserDaoImplementation;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CreateUserServlet", value = "/api/user/create")
public class CreateUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDto userDto = new Gson().fromJson(request.getReader(),UserDto.class);
        User user = this.userDtoToUser(userDto);

        UserDaoImplementation userDaoImplementation = new UserDaoImplementation();
        User user1 = userDaoImplementation.create(user);

        response.setContentType("application/json; charset=utf-8");

        PrintWriter writer = response.getWriter();
        writer.print(new Gson().toJson(user1));
        writer.flush();
    }

    private User userDtoToUser(UserDto userDto){
        User user = new User();
        user.setFirst_name(userDto.getFirst_name());
        user.setLast_name(userDto.getLast_name());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }
}
