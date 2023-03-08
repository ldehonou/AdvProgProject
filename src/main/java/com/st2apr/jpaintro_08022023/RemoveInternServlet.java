package com.st2apr.jpaintro_08022023;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.InternBean;
import model.bean.InternshipBean;
import model.entity.InternEntity;
import model.entity.InternshipEntity;

import java.io.IOException;

@WebServlet(name = "removeInternServlet", value = "/removeIntern")
public class RemoveInternServlet extends HttpServlet {
    @EJB
    InternBean internBean;
    @EJB
    InternshipBean internshipBean;
    public void init() {}

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idIntern = Integer.valueOf(request.getParameter("id"));
        InternEntity intern = internBean.getInternById(idIntern);
        internBean.removeIntern(intern);
        response.sendRedirect(request.getContextPath() + "/home");

    }

    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    public void destroy() {
    }
}
