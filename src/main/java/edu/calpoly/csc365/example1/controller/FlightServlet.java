package edu.calpoly.csc365.example1.controller;

import edu.calpoly.csc365.example1.dao.DaoManagerFactory;
import edu.calpoly.csc365.example1.dao.Dao;
import edu.calpoly.csc365.example1.dao.DaoManager;
import edu.calpoly.csc365.example1.entity.Customer;
import edu.calpoly.csc365.example1.entity.Flight;
import edu.calpoly.csc365.example1.service.AuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;


    @WebServlet(name = "FlightServlet", urlPatterns = "/flights")
    public class FlightServlet extends HttpServlet {

        private DaoManager dm;
        private Dao<Flight> flightDao;

        public FlightServlet() throws Exception {
            dm = DaoManagerFactory.createDaoManager();
            flightDao = dm.getFlightDao();
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            Cookie loginCookie = AuthenticationService.getLoginCookie(request);
//                if (loginCookie == null) {
//                    response.sendRedirect("login");
//                } else {
//                response.addCookie(loginCookie);
                Set<Flight> flights = flightDao.getAll();
                request.setAttribute("flights", flights);
                //request.setAttribute("message", "Hello " + loginCookie.getValue());
                request.getRequestDispatcher("flights.jsp").forward(request, response);
            }
        }


