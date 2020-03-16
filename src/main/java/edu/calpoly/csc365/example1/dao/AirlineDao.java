package edu.calpoly.csc365.example1.dao;

import edu.calpoly.csc365.example1.entity.Airline;
import edu.calpoly.csc365.example1.entity.Flight;

public interface AirlineDao{

    public Airline getById(int id);
}
