package edu.calpoly.csc365.example1.entity;

public class Passenger {
    private Integer Id;
    private String name;


    public Passenger() {
        this.Id=null;
        this.name=null;
    }

    public Passenger(String name, int Id) {
        this.Id=Id;
        this.name=name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public int getId() {
        return this.Id;
    }

    public void setId(int id) {
        this.Id=id;
    }


}