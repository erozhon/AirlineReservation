package edu.calpoly.csc365.example1.entity;

public class Seat {

    private Integer flightId;
    private Integer seatNo;
    private String type;
    private String seatClass;

    public Seat(){
        this.flightId=null;
        this.seatNo=null;
        this.seatClass=null;
        this.type=null;
    }

    public Seat(Integer flightId, Integer seatNo, String type, String seatClass){
        this.flightId=flightId;
        this.seatClass=seatClass;
        this.seatNo=seatNo;
        this.type=type;
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

}
