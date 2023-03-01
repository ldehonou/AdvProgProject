package com.st2apr.jpaintro_08022023;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.InternBean;
import model.bean.InternshipBean;
import model.bean.TutorBean;
import model.entity.InternEntity;
import model.entity.InternshipEntity;
import model.entity.TutorEntity;

import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "internServlet", value = "/intern")
public class InternServlet extends HttpServlet {
    @EJB
    InternBean internBean;
    @EJB
    InternshipBean internshipBean;

    public void init() {}

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        int idIntern = Integer.valueOf(request.getParameter("id"));
        System.out.println("ID = " + idIntern);
        InternEntity intern = internBean.getInternById(idIntern);
        InternshipEntity internship = internshipBean.getInternshipByIdIntern(intern);
        System.out.println(intern.getEmail());
        request.setAttribute("intern", intern);
        request.setAttribute("internship", internship);
        request.getRequestDispatcher("/WEB-INF/intern.jsp").forward(request, response);

    }

    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    public void destroy() {
    }
}
