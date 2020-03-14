package edu.calpoly.csc365.example1.dao;

import edu.calpoly.csc365.example1.entity.Flight;

import java.sql.Date;

public interface FlightDao extends Dao<Flight>{

    Flight getBySource(String source);
    Flight getByDestination(String destination);
    Flight getByTakeoff(Date d);
    Flight getByArrival(Date d);
    Boolean isFull(Integer id);


}
