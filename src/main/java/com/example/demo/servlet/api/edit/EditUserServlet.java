package com.example.demo.servlet.api.edit;

import com.example.demo.domain.User;
import com.example.demo.dto.UserDto;
import com.example.demo.service.Implementation.UserDaoImplementation;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditUserServlet", value = "/api/user/edit/*")
public class EditUserServlet extends HttpServlet {
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String param = request.getPathInfo().replace("/","");

        UserDto userDto = new Gson().fromJson(request.getReader(),UserDto.class);
        User user = this.userDtoToUser(userDto);

        UserDaoImplementation userDaoImplementation = new UserDaoImplementation();
        userDaoImplementation.update(user,Long.parseLong(param));
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
