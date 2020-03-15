package edu.calpoly.csc365.example1.controller;

import edu.calpoly.csc365.example1.dao.Dao;
import edu.calpoly.csc365.example1.dao.DaoManager;
import edu.calpoly.csc365.example1.dao.DaoManagerFactory;
import edu.calpoly.csc365.example1.entity.Reservation;
import edu.calpoly.csc365.example1.entity.Flight;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.lang.Math;


@WebServlet(name = "RevenueServlet", urlPatterns = "/revenue")
public class RevenueServlet extends HttpServlet {

    private class Revenue {
        public String flightPair;
        private int jan = 0;
        private int feb = 0;
        private int march = 0;
        private int april = 0;
        private int may = 0;
        private int june = 0;
        private int july = 0;
        private int aug = 0;
        private int sept = 0;
        private int oct = 0;
        private int nov = 0;
        private int dec = 0;
        private int total = 0;

        public Revenue(String flightpath) {
            this.flightPair = flightpath;
        }

        public void addRevenue(Date takeoff, Double cost) {
            int c = (int) Math.round(cost);
            Calendar cal = Calendar.getInstance();
            cal.setTime(takeoff);
            int month = cal.get(Calendar.MONTH);
            if (month == Calendar.JANUARY) {
                this.jan += c;
            } else if (month == Calendar.FEBRUARY) {
                this.feb += c;
            } else if (month == Calendar.MARCH) {
                this.march += c;
            } else if (month == Calendar.APRIL) {
                this.april += c;
            } else if (month == Calendar.MAY) {
                this.may += c;
            } else if (month == Calendar.JUNE) {
                this.june += c;
            } else if (month == Calendar.JULY) {
                this.july += c;
            } else if (month == Calendar.AUGUST) {
                this.aug += c;
            } else if (month == Calendar.SEPTEMBER) {
                this.sept += c;
            } else if (month == Calendar.OCTOBER) {
                this.oct += c;
            } else if (month == Calendar.NOVEMBER) {
                this.nov += c;
            } else if (month == Calendar.DECEMBER) {
                this.dec += c;
            }
            this.total += c;
        }
    }


    private DaoManager dm;
    private Dao<Reservation> revenueDao;

    public RevenueServlet() throws Exception {
        dm = DaoManagerFactory.createDaoManager();
        revenueDao = dm.getReservationDao();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            Cookie loginCookie = AuthenticationService.getLoginCookie(request);
//            if (loginCookie == null) {
//                response.sendRedirect("login");
//            } else {
//                response.addCookie(loginCookie);
        Hashtable<String, Revenue> flightPathToRevenue = new Hashtable<String, Revenue>();
        for (Reservation res: revenueDao.getAll() ) {
            Flight flight = null;
            try {
                flight = dm.getFlightDao().getById(res.getFlightNo());
            } catch (Exception e) {
                e.printStackTrace();
            };
            String flightPath = String.format("%s -> %s", flight.getSource(), flight.getDestination());
            if (!flightPathToRevenue.containsKey(flightPath)) {
                flightPathToRevenue.put(flightPath, new Revenue(flightPath));
            }
            flightPathToRevenue.get(flightPath).addRevenue(flight.getTakeoff(), res.getCost());
        }
            Set<Revenue> revenues = new HashSet<Revenue>(Collections.list(flightPathToRevenue.elements()));
            request.setAttribute("revenues", revenues);
            //request.setAttribute("message", "Hello " + loginCookie.getValue());
            request.getRequestDispatcher("revenue.jsp").forward(request, response);
        //}
    }
}


