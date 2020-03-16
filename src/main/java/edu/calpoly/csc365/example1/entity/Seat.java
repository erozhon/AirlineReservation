package edu.calpoly.csc365.example1.entity;

public class Seat {

    private Integer flightId;
    private Integer seatNo;
    private String type;
    private String seatClass;
    private boolean taken;

    public Seat(){
        this.flightId=null;
        this.seatNo=null;
        this.seatClass=null;
        this.type=null;
        this.taken=false;
    }

    public Seat(Integer seatNo, Integer flightId, String type, String seatClass, boolean taken){
        this.flightId=flightId;
        this.seatClass=seatClass;
        this.seatNo=seatNo;
        this.type=type;
        this.taken=taken;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
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

    public boolean getTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }
}
