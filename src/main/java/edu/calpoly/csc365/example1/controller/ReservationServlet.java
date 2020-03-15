package edu.calpoly.csc365.example1.controller;

import edu.calpoly.csc365.example1.dao.DaoManagerFactory;
import edu.calpoly.csc365.example1.dao.Dao;
import edu.calpoly.csc365.example1.dao.DaoManager;
import edu.calpoly.csc365.example1.entity.Customer;
import edu.calpoly.csc365.example1.entity.Reservation;
import edu.calpoly.csc365.example1.service.AuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

    @WebServlet(name = "ReservationServlet", urlPatterns = "/reservations")
    public class ReservationServlet extends HttpServlet {

        private DaoManager dm;
        private Dao<Reservation> reservationDao;

        public ReservationServlet() throws Exception {
            dm = DaoManagerFactory.createDaoManager();
            reservationDao = dm.getReservationDao();
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                Set<Reservation> reservations = reservationDao.getAll();
                request.setAttribute("reservations", reservations);
                request.getRequestDispatcher("reservations_view.jsp").forward(request, response);
            }
        }