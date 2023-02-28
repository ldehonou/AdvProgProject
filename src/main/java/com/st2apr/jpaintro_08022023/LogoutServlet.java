package com.st2apr.jpaintro_08022023;

import java.io.*;
import java.util.Collection;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.bean.TutorBean;
import model.entity.TutorEntity;

@WebServlet(name = "logoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {

    @EJB
    TutorBean tutorBean;

    public void init() {}

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session=request.getSession(false);
        session.removeAttribute("identifiant");
        session.removeAttribute("tutor");
        response.sendRedirect(request.getContextPath() + "/");

    }


    public void destroy() {
    }
}