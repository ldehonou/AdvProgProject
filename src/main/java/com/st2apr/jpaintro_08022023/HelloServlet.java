package com.st2apr.jpaintro_08022023;

import java.io.*;
import java.util.Collection;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.EmployeeEntity;
import model.EmployeeSessionBean;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    @EJB
    EmployeeSessionBean employeeSessionBean;

    public void init() {}

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //processRequest(request, response);
        Collection<EmployeeEntity> employeesFromSessionBean = employeeSessionBean.getAllEmployees();

        for (EmployeeEntity employee: employeesFromSessionBean) {
            System.out.println("NAME : "+employee.getLastname());
        }
    }

    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //processRequest(request, response);
        String identifiant = request.getParameter("identifiant");
        String password = request.getParameter("password");
        System.out.println("ID" + identifiant);
        System.out.println("Pass " + password);

        request.setAttribute("message", "Hello " + identifiant + " !");
        request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    public void destroy() {
    }
}