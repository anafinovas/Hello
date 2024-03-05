package com.example.servlets;

import com.example.DAO.PersonDB;
import com.example.models.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "addServlet", value = "/add")
public class AddServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/add.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            int age = Integer.parseInt(request.getParameter("age"));
            Person person = new Person(name, surname, age);
            PersonDB.add(person);
            response.sendRedirect(request.getContextPath()+"/");
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/add.jsp").forward(request, response);
        }
    }
}
