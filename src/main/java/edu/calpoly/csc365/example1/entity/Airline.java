package edu.calpoly.csc365.example1.entity;

public class Airline {
    private Integer Id;
    private String name;
    private String abbr;
    private String country;


    public Airline() {
        this.Id = null;
        this.name = null;
        this.abbr = null;
        this.country = null;
    }

    public Airline(Integer Id, String name, String abbr, String country) {
        this.Id=Id;
        this.name=name;
        this.abbr=abbr;
        this.country=country;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getAbbr() {
        return this.abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr=abbr;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String c) {
        this.country=c;
    }

}
