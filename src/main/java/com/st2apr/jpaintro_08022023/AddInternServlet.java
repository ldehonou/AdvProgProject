package com.st2apr.jpaintro_08022023;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.CompanyBean;
import model.bean.InternBean;
import model.bean.InternshipBean;
import model.bean.TutorBean;
import model.entity.CompanyEntity;
import model.entity.InternEntity;
import model.entity.TutorEntity;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@WebServlet(name = "addInternServlet", value = "/createIntern")
public class AddInternServlet extends HttpServlet {

    @EJB
    InternBean internBean;
    @EJB
    TutorBean tutorBean;
    @EJB
    CompanyBean companyBean;
    @EJB
    InternshipBean internshipBean;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        request.getRequestDispatcher("/WEB-INF/addIntern.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //get tutor
        HttpSession session = request.getSession(false);
        String emailTutor = session.getAttribute("identifiant").toString();
        TutorEntity currentTutor = tutorBean.getTutorByEmail(emailTutor);

        //create intern
        String lastname = request.getParameter("lastname");
        String firstname = request.getParameter("firstname");
        String phone = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String postalCode = request.getParameter("postalCode");
        String city = request.getParameter("city");
        String email = request.getParameter("email");
        InternEntity intern = internBean.createIntern(lastname, firstname, phone, address, postalCode, city, email);

        //create company
        String company = request.getParameter("company");
        String addressCompany = request.getParameter("addressCompany");
        String postalCodeCompany = request.getParameter("postalCodeCompany");
        String cityCompany = request.getParameter("cityCompany");
        CompanyEntity companyEntity = companyBean.createCompany(company, addressCompany, postalCodeCompany, cityCompany);

        //create internship
        String mission = request.getParameter("mission");
        String startedDate = request.getParameter("startedDate");
        String endedDate = request.getParameter("endedDate");

        internshipBean.createInternship(currentTutor,intern,companyEntity,mission,java.sql.Date.valueOf(startedDate), java.sql.Date.valueOf(endedDate));

        response.sendRedirect(request.getContextPath() + "/home");


    }
}
