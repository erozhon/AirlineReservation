package edu.calpoly.csc365.example1.entity;

import java.sql.Date;

public class Flight {
    private Integer airline;
    private Integer Id;
    private String source;
    private String destination;
    private Date takeoff;
    private Date arrival;
    private Boolean full;
    private Integer capacity;


    public Flight() {
        this.airline=null;
        this.Id=null;
        this.source=null;
        this.destination=null;
        this.takeoff=null;
        this.arrival=null;
        this.full=null;
        this.capacity=null;
    }

    public Flight(int Id, int airline, String source, String destination, Date takeoff, Date arrival, boolean full, int capacity) {
        this.Id=Id;
        this.airline=airline;
        this.source=source;
        this.destination=destination;
        this.takeoff=takeoff;
        this.arrival=arrival;
        this.full=full;
        this.capacity=capacity;
    }

    public Integer getAirline() {
        return airline;
    }

    public void setAirline(Integer airline) {
        this.airline=airline;
    }

    public Integer getId() {
        return this.Id;
    }

    public void setId(Integer Id) {
        this.Id=Id;
    }

    public void setSource(String s) {
        this.source=s;
    }

    public String getSource() {
        return this.source;
    }

    public String getDestination(){
        return this.destination;
    }
    public void setDestination(String d) {
        this.destination=d;
    }

    public Date getTakeoff(){
        return this.takeoff;
    }

    public void setTakeoff(Date t){
        this.takeoff=t;
    }

    public Date getArrival(){
        return this.arrival;
    }

    public void setArrival(Date a){
        this.arrival=a;
    }

    public Boolean getFull() {
        return this.full;
    }

    public void setFull(Boolean full) {
        this.full = full;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }


    @Override
    public String toString() {
        return "Flight{" +
                "airline=" + airline +
                ", Id=" + Id +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", takeoff=" + takeoff +
                ", arrival=" + arrival +
                ", full=" + full +
                ", capacity=" + capacity +
                '}';
    }
}