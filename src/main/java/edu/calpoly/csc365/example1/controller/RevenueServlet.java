package edu.calpoly.csc365.example1.controller;

import edu.calpoly.csc365.example1.dao.Dao;
import edu.calpoly.csc365.example1.dao.DaoManager;
import edu.calpoly.csc365.example1.dao.DaoManagerFactory;
import edu.calpoly.csc365.example1.dao.FlightDao;
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

    public class Revenue {
        private String flightPair;
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

        public String getFlightPair() {
            return flightPair;
        }

        public void setFlightPair(String flightPair) {
            this.flightPair = flightPair;
        }

        public int getJan() {
            return jan;
        }

        public void setJan(int jan) {
            this.jan = jan;
        }

        public int getFeb() {
            return feb;
        }

        public void setFeb(int feb) {
            this.feb = feb;
        }

        public int getMarch() {
            return march;
        }

        public void setMarch(int march) {
            this.march = march;
        }

        public int getApril() {
            return april;
        }

        public void setApril(int april) {
            this.april = april;
        }

        public int getMay() {
            return may;
        }

        public void setMay(int may) {
            this.may = may;
        }

        public int getJune() {
            return june;
        }

        public void setJune(int june) {
            this.june = june;
        }

        public int getJuly() {
            return july;
        }

        public void setJuly(int july) {
            this.july = july;
        }

        public int getAug() {
            return aug;
        }

        public void setAug(int aug) {
            this.aug = aug;
        }

        public int getSept() {
            return sept;
        }

        public void setSept(int sept) {
            this.sept = sept;
        }

        public int getOct() {
            return oct;
        }

        public void setOct(int oct) {
            this.oct = oct;
        }

        public int getNov() {
            return nov;
        }

        public void setNov(int nov) {
            this.nov = nov;
        }

        public int getDec() {
            return dec;
        }

        public void setDec(int dec) {
            this.dec = dec;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public Revenue(String flightpath) {
            this.flightPair = flightpath;
        }

        public void addRevenue(Date takeoff, Double cost) {
            int c = Math.round((float)(double)cost);
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
        Hashtable<String, Revenue> flightPathToRevenue = new Hashtable<String, Revenue>();
        Set<Reservation> reservations = revenueDao.getAll();
        FlightDao flightDao = null;
        try {
            flightDao = dm.getFlightDao();
        } catch (Exception e) {
            e.printStackTrace();
        };
        Set<Flight> flightsSet = flightDao.getAll();
        ArrayList<Flight> flights = new ArrayList<Flight>(flightsSet);
        Collections.sort(flights, new Comparator<Flight>() { public int compare(Flight f1, Flight f2) {return f1.getId().compareTo(f2.getId());}});
        for (Reservation res: reservations ) {
            Flight flight = flights.get(res.getFlightNo() - 1);
            String flightPath = String.format("%s => %s", flight.getSource(), flight.getDestination());
            if (!flightPathToRevenue.containsKey(flightPath)) {
                flightPathToRevenue.put(flightPath, new Revenue(flightPath));
            }
            if (res.getHasPaid()) {
                flightPathToRevenue.get(flightPath).addRevenue(flight.getTakeoff(), res.getCost());
            }
//            System.out.println("res num: " + res.getId());
        }
            ArrayList<Revenue> revenues = new ArrayList<Revenue>(Collections.list(flightPathToRevenue.elements()));
            Collections.sort(revenues, new Comparator<Revenue>() { public int compare(Revenue r1, Revenue r2) {return r1.getFlightPair().compareTo(r2.getFlightPair());}});
            request.setAttribute("revenues", revenues);
            //request.setAttribute("message", "Hello " + loginCookie.getValue());
            request.getRequestDispatcher("revenue.jsp").forward(request, response);
        //}
    }
}


