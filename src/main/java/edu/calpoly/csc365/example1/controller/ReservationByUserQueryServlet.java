

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

    @WebServlet(name = "ReservationByUserQueryServlet", urlPatterns = "/reservationsbyuserquery")
    public class ReservationByUserQueryServlet extends HttpServlet {

        private DaoManager dm;


        public ReservationByUserQueryServlet() throws Exception {
            dm = DaoManagerFactory.createDaoManager();
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.getRequestDispatcher("reservationsbyuserquery.jsp").forward(request, response);
        }
    }

