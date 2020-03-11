package edu.calpoly.csc365.example1.entity;

public class Reservation {

    private Integer Id;
    private Integer passengerId;
    private Integer seatNo;
    private Double cost;
    private Long creditNo;
    private Integer flightNo;
    private Boolean hasPaid;
    private Boolean cancelled;

    public Reservation(){
        this.Id = null;
        this.passengerId = null;
        this.seatNo = null;
        this.cost = null;
        this.creditNo = null;
        this.flightNo = null;
        this.hasPaid = null;
    }

    public Reservation(Integer id, Integer passengerId, Integer seatNo, Double cost, Long creditNo, Integer flightNo, Boolean hasPaid, Boolean cancelled) {
        this.Id = id;
        this.passengerId = passengerId;
        this.seatNo = seatNo;
        this.cost = cost;
        this.creditNo = creditNo;
        this.flightNo = flightNo;
        this.hasPaid = hasPaid;
        this.cancelled = cancelled;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public Integer getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(Integer seatNo) {
        this.seatNo = seatNo;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Long getCreditNo() {
        return creditNo;
    }

    public void setCreditNo(Long creditNo) {
        this.creditNo = creditNo;
    }

    public Integer getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(Integer flightNo) {
        this.flightNo = flightNo;
    }

    public Boolean getHasPaid() {
        return hasPaid;
    }

    public void setHasPaid(Boolean hasPaid) {
        this.hasPaid = hasPaid;
    }

    public Boolean getCancelled() {
        return cancelled;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }
}
