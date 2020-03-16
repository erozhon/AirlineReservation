package edu.calpoly.csc365.example1.controller;

import edu.calpoly.csc365.example1.dao.DaoManagerFactory;
import edu.calpoly.csc365.example1.dao.Dao;
import edu.calpoly.csc365.example1.dao.DaoManager;
import edu.calpoly.csc365.example1.entity.Customer;
import edu.calpoly.csc365.example1.entity.Passenger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @WebServlet(name = "PassengerEditServlet", urlPatterns = "/edit_passenger")
    public class PassengerEditServlet extends HttpServlet {
        private DaoManager dm;
        private Dao<Passenger> passengerDao;

        public PassengerEditServlet() throws Exception {
            dm = DaoManagerFactory.createDaoManager();
            passengerDao = dm.getPassengerDao();
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Integer id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            Passenger passenger = new Passenger(name, id);
            this.passengerDao.update(passenger);
            request.setAttribute("passenger", passenger);
            request.getRequestDispatcher("passenger_edit.jsp").forward(request, response);
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String id = request.getParameter("id");
            Passenger passenger = this.passengerDao.getById(Integer.parseInt(id));
            request.setAttribute("passenger", passenger);
            request.getRequestDispatcher("passenger_edit.jsp").forward(request, response);
        }
    }


