package edu.calpoly.csc365.example1.dao;

import edu.calpoly.csc365.example1.entity.Flight;

import java.sql.Date;
import java.util.Set;

public interface FlightDao extends Dao<Flight>{

    Set<Flight> getBySource(String source);
    Set<Flight> getByDestination(String destination);
    Set<Flight> getByTakeoff(Date d);
    Set<Flight> getByArrival(Date d);
    Boolean isFull(Integer id);


}
