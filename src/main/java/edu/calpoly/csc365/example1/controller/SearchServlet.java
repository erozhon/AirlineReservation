package edu.calpoly.csc365.example1.controller;

import edu.calpoly.csc365.example1.dao.*;
import edu.calpoly.csc365.example1.entity.Passenger;
import edu.calpoly.csc365.example1.entity.Reservation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Set;


@WebServlet(name = "SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {

    private DaoManager dm;
    private Dao<Passenger> passengerDao;

    public SearchServlet() throws Exception {
        dm = DaoManagerFactory.createDaoManager();
        passengerDao = dm.getPassengerDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("search_query.jsp").forward(request, response);
    }
}


