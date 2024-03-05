package com.example.servlets;

import com.example.DAO.PersonDB;
import com.example.models.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "peopleServlet", value = "/people")
public class PeopleServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Person> people = PersonDB.select();
        System.out.println("people:");
        System.out.println(people);
        request.setAttribute("people", people);
        getServletContext().getRequestDispatcher("/people.jsp").forward(request, response);
    }
}
