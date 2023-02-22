package com.st2apr.jpaintro_08022023;

import java.io.*;
import java.util.Collection;

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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Collection<TutorEntity> tutors = tutorBean.getAllTutors();

        for (TutorEntity tutor: tutors) {
            System.out.println("NAME : "+ tutor.getEmail());
        }
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