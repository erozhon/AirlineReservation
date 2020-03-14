package edu.calpoly.csc365.example1.entity;

public class Airport {
    private String city;
    private String name;
    private String code;
    private String country;
    private String cabbr;


    public Airport() {
        this.city=null;
        this.name=null;
        this.code=null;
        this.country=null;
        this.cabbr=null;
    }

    public Airport(String city, String name, String code, String country, String cabbr) {
        this.city=city;
        this.name=name;
        this.code=code;
        this.country=country;
        this.cabbr=cabbr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city=city;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code=code;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String c) {
        this.country=c;
    }


    public String getCAbbr() {
        return this.cabbr;
    }

    public void setCabbr(String c) {
        this.cabbr=c;
    }

}