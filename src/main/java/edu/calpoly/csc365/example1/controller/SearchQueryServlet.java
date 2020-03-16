package edu.calpoly.csc365.example1.controller;

import edu.calpoly.csc365.example1.dao.*;
import edu.calpoly.csc365.example1.entity.Flight;
import edu.calpoly.csc365.example1.entity.Passenger;
import edu.calpoly.csc365.example1.entity.Seat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(name = "SearchQueryServlet", urlPatterns = "/search_query")
public class SearchQueryServlet extends HttpServlet {

    private DaoManager dm;


    public SearchQueryServlet() throws Exception {
        dm = DaoManagerFactory.createDaoManager();
        System.out.println("test3");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getAttribute("results"));
        System.out.println("tester");
        request.getRequestDispatcher("search_query.jsp").forward(request, response);
    }
}


