package com.company.project_egs.servlet.admin.user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminUserEditServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            request.getRequestDispatcher("/pages/admin/user/edit.html").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
