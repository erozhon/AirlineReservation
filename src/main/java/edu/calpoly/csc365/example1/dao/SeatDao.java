package edu.calpoly.csc365.example1.dao;

import edu.calpoly.csc365.example1.entity.Seat;

import java.util.Set;


public interface SeatDao{

    public Seat getByFlightId(int flightId);
    public Seat getByFlightIdTypeClass(int flightId, String type, String seatClass);
    public Set<Seat> getAll();



}
