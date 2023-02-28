package com.st2apr.jpaintro_08022023;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.InternBean;
import model.entity.TutorEntity;

import java.io.IOException;

@WebServlet(name = "addInternServlet", value = "/createIntern")
public class AddInternServlet extends HttpServlet {

    @EJB
    InternBean internBean;
    TutorEntity tutor;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        request.getRequestDispatcher("/WEB-INF/addIntern.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String lastname = request.getParameter("lastname");
        String firstname = request.getParameter("firstname");
        String phone = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String postalCode = request.getParameter("postalCode");
        String city = request.getParameter("city");
        String email = request.getParameter("email");

        internBean.createIntern(lastname, firstname, phone, address, postalCode, city, email);
        System.out.println("Intern added");

        response.sendRedirect(request.getContextPath() + "/home");


    }
}
