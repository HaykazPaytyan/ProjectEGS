package servlet.api;



import com.google.gson.Gson;
import domain.User;
import dto.UserDto;
import service.Implementation.UserDaoImplementation;


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

        UserDto userDto = new Gson().fromJson(request.getReader(),UserDto.class);
        User user = this.userDtoToUser(userDto);

        UserDaoImplementation userDaoImplementation = new UserDaoImplementation();
        userDaoImplementation.create(user);

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
