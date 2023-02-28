package com.st2apr.jpaintro_08022023;

import java.io.*;
import java.util.Collection;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.bean.TutorBean;

@WebServlet(name = "homeServlet", value = "/home")
public class HomeServlet extends HttpServlet {

    @EJB
    TutorBean tutorBean;

    public void init() {}

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        String emailTutor = session.getAttribute("identifiant").toString();
//        TutorEntity currentTutor = tutorBean.getTutorByEmail(emailTutor);
//        System.out.println(currentTutor.getLastname());
//        if(currentTutor != null){
//            System.out.println("ok");
//            Collection<MakeInternshipEntity> makeInternships = currentTutor.getMakeInternshipsById();
//            for (MakeInternshipEntity internship: makeInternships) {
//                System.out.println(internship.getInternByIdIntern().getEmail());
//
//            }
//        }

        request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }

    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    public void destroy() {
    }
}