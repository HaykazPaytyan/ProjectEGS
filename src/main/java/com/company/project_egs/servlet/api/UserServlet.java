package com.company.project_egs.servlet.api;


import com.company.project_egs.domain.User;
import com.company.project_egs.dto.UserDto;
import com.company.project_egs.service.Implementation.UserDaoImplementation;
import com.google.gson.Gson;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class UserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        UserDaoImplementation userDaoImplementation = new UserDaoImplementation();
        List<User> users = userDaoImplementation.getAll();

        response.setContentType("application/json; charset=utf-8");

        PrintWriter writer = response.getWriter();
        writer.print(new Gson().toJson(users));
        writer.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        UserDto userDto = new Gson().fromJson(request.getReader(), UserDto.class);
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
