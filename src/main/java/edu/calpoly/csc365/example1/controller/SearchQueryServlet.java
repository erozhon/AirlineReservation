package edu.calpoly.csc365.example1.controller;

import edu.calpoly.csc365.example1.dao.Dao;
import edu.calpoly.csc365.example1.dao.DaoManager;
import edu.calpoly.csc365.example1.dao.DaoManagerFactory;
import edu.calpoly.csc365.example1.dao.FlightDaoImpl;
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
import java.util.Set;


@WebServlet(name = "SearchQueryServlet", urlPatterns = "/search_query")
public class SearchQueryServlet extends HttpServlet {

    private DaoManager dm;
    private FlightDaoImpl flightDao;
    private Dao<Seat> seatDao;

    public SearchQueryServlet() throws Exception {
        dm = DaoManagerFactory.createDaoManager();
        flightDao = (FlightDaoImpl)dm.getFlightDao();
        seatDao = dm.getSeatsDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("search.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date date = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = Date.valueOf(request.getParameter("Date"));
        } catch (Exception e) {}
        String source = request.getParameter("Source");
        String destination = request.getParameter("Destination");
        String seatType = request.getParameter("seatType");
        String seatClass = request.getParameter("seatClass");
        Set<Flight> onDate = null;
        System.out.println(date);
        if (date != null) {
            onDate = flightDao.getByTakeoff(date);
            System.out.println(onDate);
        }

        request.getRequestDispatcher("search_query.jsp").forward(request, response);
    }
}


