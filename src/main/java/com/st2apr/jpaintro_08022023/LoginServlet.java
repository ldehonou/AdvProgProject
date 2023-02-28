package com.st2apr.jpaintro_08022023;

import java.io.*;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.bean.TutorBean;
import model.entity.TutorEntity;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @EJB
    TutorBean tutorBean;

    public void init() {}

    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String identifiant = request.getParameter("identifiant");
        String password = request.getParameter("password");


        request.setAttribute("message", "Hello " + identifiant + " !");

        TutorEntity tutor = null;
        try {
            // Query the database to find the user with the given username and password
            tutor = tutorBean.getTutors(identifiant, password);

            System.out.println(tutor.getEmail());
            // If the user is found, set the user object in the session and redirect to the home page

        } catch (Exception e) {
            // If the user is not found, display an error message and forward to the login page
            System.out.println("Invalid username or password");
            request.setAttribute("error", "Invalid username or password");
        }

        if (tutor != null) {
            System.out.println("Try Redirect");
            HttpSession session = request.getSession(true);
            session.setAttribute("identifiant", tutor.getEmail());
            session.setAttribute("tutor", tutor.getFirstname() + " " + tutor.getLastname());
            response.sendRedirect(request.getContextPath() + "/home");

        } else {
            System.out.println("Fail Redirect");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    public void destroy() {
    }
}