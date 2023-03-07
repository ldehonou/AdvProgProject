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
import model.entity.CompanyEntity;
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
        int idIntern = Integer.valueOf(request.getParameter("id"));
        InternEntity intern = internBean.getInternById(idIntern);
        InternshipEntity internship = internshipBean.getInternshipByIdIntern(intern);
        request.setAttribute("intern", intern);
        request.setAttribute("internship", internship);
        request.getRequestDispatcher("/WEB-INF/intern.jsp").forward(request, response);

    }

    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idIntern = Integer.valueOf(request.getParameter("idIntern"));
        boolean cdc = (request.getParameter("cdc") != null);
        boolean visitSheet = request.getParameter("visitSheet") != null;
        boolean evalSheet = request.getParameter("evalSheet")!= null;
        boolean webSurvey = request.getParameter("webSurvey") != null;
        boolean report = request.getParameter("report") != null;
        boolean defense = request.getParameter("defense") != null;
        String noteTech = request.getParameter("noteTech");
        String noteCom = request.getParameter("noteCom");

        internshipBean.updateInternship(idIntern, cdc,visitSheet,evalSheet,webSurvey,report, defense, noteTech, noteCom);

        response.sendRedirect(request.getContextPath() + "/home");

    }

    public void destroy() {
    }
}
