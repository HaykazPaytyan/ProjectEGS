package com.company.project_egs.servlet.account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccountIndexServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            request.getRequestDispatcher("/pages/account/index.html").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
