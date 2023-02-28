package com.st2apr.jpaintro_08022023;

import java.io.*;
import java.util.Collection;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.bean.TutorBean;
import model.entity.InternEntity;
import model.entity.InternshipEntity;
import model.entity.TutorEntity;

@WebServlet(name = "homeServlet", value = "/home")
public class HomeServlet extends HttpServlet {

    @EJB
    TutorBean tutorBean;

    public void init() {}

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if(session.getAttribute("identifiant") != null){
            String emailTutor = session.getAttribute("identifiant").toString();
            TutorEntity currentTutor = tutorBean.getTutorByEmail(emailTutor);
            if(currentTutor != null){
                Collection<InternshipEntity> makeInternships = currentTutor.getInternshipsById();
                //System.out.println(makeInternships);
                for (InternshipEntity employee: makeInternships) {
                    System.out.println("NAME : "+employee.getInternByIdIntern().getEmail());
                }
                request.setAttribute("interns", makeInternships);
            }
            request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }

    }

    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    public void destroy() {
    }
}