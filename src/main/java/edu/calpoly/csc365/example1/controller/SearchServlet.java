package edu.calpoly.csc365.example1.controller;

import edu.calpoly.csc365.example1.dao.*;
import edu.calpoly.csc365.example1.entity.Flight;
import edu.calpoly.csc365.example1.entity.Passenger;
import edu.calpoly.csc365.example1.entity.Reservation;
import edu.calpoly.csc365.example1.entity.Seat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;


@WebServlet(name = "SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {

    private DaoManager dm;
    private FlightDaoImpl flightDao;
    private SeatsDaoImpl seatDao;

    public SearchServlet() throws Exception {
        dm = DaoManagerFactory.createDaoManager();
        flightDao = (FlightDaoImpl)(dm.getFlightDao());
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
        Set<Flight> withDestination = null;
        Set<Flight> withSource = null;
        Set<Flight> forIteration = new HashSet<Flight>();
        ArrayList<Flight> flights = new ArrayList<Flight>();
        if (date != null) {
            onDate = flightDao.getByTakeoff(date);
            forIteration.addAll(onDate);
        }
        if (destination.length() > 0) {
            withDestination = flightDao.getByDestination(destination);
            forIteration.addAll(withDestination);
        }
        if (source.length() > 0) {
            withSource = flightDao.getBySource(source);
            forIteration.addAll(withSource);
        }

        for (Flight f: forIteration) {
            if (onDate != null && !onDate.contains(f))
                continue;
            if (withDestination != null && !withDestination.contains(f))
                continue;
            if (withSource != null && !withSource.contains(f))
                continue;
            flights.add(f);
        }
        Collections.sort(flights, new Comparator<Flight>() {
            @Override
            public int compare(Flight flight, Flight t1) {
                int first = flight.getSource().compareTo(t1.getSource());
                if (first != 0) {
                    return first;
                }
                return flight.getDestination().compareTo(t1.getDestination());
            }
        });

        ArrayList<Search> results = new ArrayList<Search>();
        for (Flight f: flights) {
            List<Seat> seats = new ArrayList<Seat>(seatDao.getByFlight(f.getId()));
            Collections.sort(seats, new Comparator<Seat>() {
                @Override
                public int compare(Seat seat, Seat t1) {
                    return seat.getSeatNo().compareTo(t1.getSeatNo());
                }
            });
            for (Seat s: seats ) {
                if (s.getTaken())
                    continue;
                results.add(new Search(f, s));
            }
        }
        request.setAttribute("res", results);
        request.getRequestDispatcher("search.jsp").forward(request, response);
    }

    public class Search {
        private Integer airline;
        private Integer Id;
        private String source;
        private String destination;
        private Date takeoff;
        private Date arrival;
        private Integer seatNo;
        private String type;
        private String seatClass;

        public Search(Flight f, Seat s) {
            this.airline=f.getAirline();
            this.Id=f.getId();
            this.source=f.getSource();
            this.destination=f.getDestination();
            this.takeoff=f.getTakeoff();
            this.arrival=f.getArrival();
            this.seatNo = s.getSeatNo();
            this.type = s.getType();
            this.seatClass = s.getSeatClass();
        }

        public Integer getAirline() {
            return airline;
        }

        public void setAirline(Integer airline) {
            this.airline = airline;
        }

        public Integer getId() {
            return Id;
        }

        public void setId(Integer id) {
            Id = id;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public Date getTakeoff() {
            return takeoff;
        }

        public void setTakeoff(Date takeoff) {
            this.takeoff = takeoff;
        }

        public Date getArrival() {
            return arrival;
        }

        public void setArrival(Date arrival) {
            this.arrival = arrival;
        }

        public Integer getSeatNo() {
            return seatNo;
        }

        public void setSeatNo(Integer seatNo) {
            this.seatNo = seatNo;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSeatClass() {
            return seatClass;
        }

        public void setSeatClass(String seatClass) {
            this.seatClass = seatClass;
        }

//        @Override
//        public String toString() {
//            return "Search{" +
//                    "airline=" + airline +
//                    ", Id=" + Id +
//                    ", source='" + source + '\'' +
//                    ", destination='" + destination + '\'' +
//                    ", takeoff=" + takeoff +
//                    ", arrival=" + arrival +
//                    ", seatNo=" + seatNo +
//                    ", type='" + type + '\'' +
//                    ", seatClass='" + seatClass + '\'' +
//                    '}';
//        }
    }

}


