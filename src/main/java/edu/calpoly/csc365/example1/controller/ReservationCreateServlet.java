package edu.calpoly.csc365.example1.controller;

import edu.calpoly.csc365.example1.dao.DaoCommand;
import edu.calpoly.csc365.example1.dao.DaoManager;
import edu.calpoly.csc365.example1.dao.DaoManagerFactory;
import edu.calpoly.csc365.example1.dao.ReservationDaoCommandImpl;
import edu.calpoly.csc365.example1.entity.Reservation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet(name = "ReservationCreateServlet", urlPatterns = "/reservationcreate")
public class ReservationCreateServlet extends HttpServlet {
    private DaoManager dm;

    public ReservationCreateServlet() throws Exception {
        this.dm = DaoManagerFactory.createDaoManager();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("reservation.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer passengerId = Integer.parseInt(request.getParameter("Passenger_id"));
        Integer flightId = Integer.parseInt(request.getParameter("Flight_no"));
        Integer resId = Integer.parseInt(request.getParameter("Id"));
        Double cost = Double.parseDouble(request.getParameter("Cost"));
        Long cardNumber = Long.parseLong(request.getParameter("Credit_no"));
        Integer seatNo = Integer.parseInt(request.getParameter("Seat_no"));
        Boolean cancelled = Boolean.parseBoolean(request.getParameter("Cancelled"));
        Boolean hasPaid = Boolean.parseBoolean(request.getParameter("Has_paid"));
        Date tdate = Date.valueOf(request.getParameter("date"));
        System.out.println(tdate);
        Double amount = Double.parseDouble(request.getParameter("amount"));
        Reservation reservation = new Reservation();
        reservation.setId(resId);
        reservation.setCost(cost);
        reservation.setHasPaid(hasPaid);
        reservation.setCancelled(cancelled);
        reservation.setPassengerId(passengerId);
        reservation.setCreditNo(cardNumber);
        reservation.setSeatNo(seatNo);
        reservation.setFlightNo(flightId);
        DaoCommand daoCommand = new ReservationDaoCommandImpl(reservation);
        Object result = daoCommand.execute(this.dm);
        if (result != null) {
            reservation = (Reservation) result;
        }
        PrintWriter out = response.getWriter();
        out.println(reservation);
        out.close();
    }
}
