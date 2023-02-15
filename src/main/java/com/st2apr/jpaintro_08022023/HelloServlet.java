package com.st2apr.jpaintro_08022023;

import java.io.*;
import java.util.Collection;

import jakarta.ejb.EJB;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.EmployeeEntity;
import model.EmployeeSessionBean;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    @EJB
    EmployeeSessionBean employeeSessionBean;

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Collection<EmployeeEntity> employeesFromSessionBean = employeeSessionBean.getAllEmployees();

        for (EmployeeEntity employee: employeesFromSessionBean) {
            System.out.println("NAME : "+employee.getLastname());
        }
    }

    public void destroy() {
    }
}