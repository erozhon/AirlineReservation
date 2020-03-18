package edu.calpoly.csc365.example1.controller;

import edu.calpoly.csc365.example1.dao.Dao;
import edu.calpoly.csc365.example1.dao.DaoManager;
import edu.calpoly.csc365.example1.dao.DaoManagerFactory;
import edu.calpoly.csc365.example1.entity.Passenger;
import edu.calpoly.csc365.example1.entity.Reservation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "ReservationEditServlet", urlPatterns = "/edit_reservation")
public class ReservationEditServlet extends HttpServlet {
    private DaoManager dm;
    private Dao<Reservation> reservationDao;

    public ReservationEditServlet() throws Exception {
        dm = DaoManagerFactory.createDaoManager();
        reservationDao = dm.getReservationDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer passenger_id = Integer.parseInt(request.getParameter("Passenger_id"));
        Integer seat_no = Integer.parseInt(request.getParameter("Seat_no"));
        Double cost = Double.parseDouble(request.getParameter("Cost"));
        Long credit_no = Long.parseLong(request.getParameter("Credit_no"));
        Integer flight_no = Integer.parseInt(request.getParameter("Flight_no"));
        Boolean paid = Boolean.parseBoolean(request.getParameter("Has_paid"));
        Boolean cancelled = Boolean.parseBoolean(request.getParameter("Cancelled"));
        Reservation reservation = new Reservation(id, passenger_id, seat_no, cost, credit_no, flight_no, paid, cancelled);
        this.reservationDao.update(reservation);
        request.setAttribute("reservation", reservation);
        request.getRequestDispatcher("reservation_edit.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Reservation reservation = this.reservationDao.getById(Integer.parseInt(id));
        request.setAttribute("reservation", reservation);
        request.getRequestDispatcher("reservation_edit.jsp").forward(request, response);
    }
}


