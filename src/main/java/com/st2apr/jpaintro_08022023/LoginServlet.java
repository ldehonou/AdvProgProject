package com.st2apr.jpaintro_08022023;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    public void init() {}

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("GET");
    }

    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String identifiant = request.getParameter("identifiant");
        String password = request.getParameter("password");
        System.out.println("ID" + identifiant);
        System.out.println("Pass " + password);

        request.setAttribute("message", "Hello " + identifiant + " !");
        request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }

    public void destroy() {
    }
}