package edu.calpoly.csc365.example1.entity;

public class CreditCard {
  private Integer num;
  private Double balance;

  public CreditCard() {
    this.num = null;
    this.balance = null;
  }

  public CreditCard(Integer cardNumber, Double balance) {
    this.num = cardNumber;
    this.balance = balance;
  }

  public Integer getCardNumber() {
    return num;
  }

  public void setCardNumber(Integer cardNumber) {
    this.num = cardNumber;
  }

  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

}
