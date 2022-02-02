package com.company.project_egs.servlet.api.id;

import com.company.project_egs.domain.User;
import com.company.project_egs.dto.UserDto;
import com.company.project_egs.service.Implementation.UserDaoImplementation;
import com.google.gson.Gson;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class UserIdServlet  extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String param = request.getPathInfo().replace("/","");

        UserDaoImplementation userDaoImplementation = new UserDaoImplementation();
        User user = userDaoImplementation.getById(Long.parseLong(param));

        response.setContentType("application/json; charset=utf-8");

        PrintWriter writer = response.getWriter();
        writer.print(new Gson().toJson(user));
        writer.flush();
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String param = request.getPathInfo().replace("/","");

        UserDto userDto = new Gson().fromJson(request.getReader(),UserDto.class);
        User user = this.userDtoToUser(userDto);

        UserDaoImplementation userDaoImplementation = new UserDaoImplementation();
        userDaoImplementation.update(user,Long.parseLong(param));


    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {

         String param = request.getPathInfo().replace("/","");

         UserDaoImplementation userDaoImplementation = new UserDaoImplementation();
         userDaoImplementation.remove(Long.parseLong(param));

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
