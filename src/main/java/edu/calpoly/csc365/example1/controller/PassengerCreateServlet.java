package edu.calpoly.csc365.example1.controller;

import edu.calpoly.csc365.example1.dao.Dao;
import edu.calpoly.csc365.example1.dao.DaoManager;
import edu.calpoly.csc365.example1.dao.DaoManagerFactory;
import edu.calpoly.csc365.example1.entity.Customer;
import edu.calpoly.csc365.example1.entity.Passenger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


    @WebServlet(name = "PassengerCreateServlet", urlPatterns = "/create_passenger")
    public class PassengerCreateServlet extends HttpServlet {
        private DaoManager dm = null;
        private Dao<Passenger> passengerDao = null;

        public PassengerCreateServlet() throws Exception {
            dm = DaoManagerFactory.createDaoManager();
            passengerDao = dm.getPassengerDao();
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.getRequestDispatcher("passenger_create.jsp").forward(request, response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Integer id = null;
            String name = request.getParameter("name");
            Passenger passenger = new Passenger(name, id);
            id = this.passengerDao.insert(passenger);
            response.sendRedirect("edit_passenger?id=" + id.toString());
        }
    }

