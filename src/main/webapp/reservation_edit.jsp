<%--
  Created by IntelliJ IDEA.
  User: toshihirokuboi
  Date: 2019-11-21
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Reservation</title>
</head>
<body>
<div style="width:30%;height:50%;margin:10% auto;padding: 10px;">
<form method="post" action="edit_reservation">
    <p><label for="Id">Id</label><br/><input type="text" name="id" id="id" value="${reservation.id}" size="30"></p>
    <p><label for="Passenger Id">Passenger Id</label><br/><input type="text" name="Passenger_id" id="Passenger_id" value="${reservation.passengerId}" size="30"></p>
    <p><label for="Seat No">Seat No</label><br/><input type="text" name="Seat_no" id="Seat_no" value="${reservation.seatNo}" size="30"></p>
    <p><label for="Flight No">Flight No</label><br/><input type="text" name="Flight_no" id="Flight_no" value="${reservation.flightNo}" size="30"></p>
    <p><label for="Cost">Cost</label><br/><input type="text" name="Cost" id="Cost" value="${reservation.cost}" size="30"></p>
    <p><label for="Cancelled">Cancelled</label><br/><input type="text" name="Cancelled" id="Cancelled" value="${reservation.cancelled}" size="30"></p>
    <p><label for="Has Paid">Has Paid?</label><br/><input type="text" name="Has_paid" id="Has_paid" value="${reservation.hasPaid}" size="30"></p>
    <p><label for="Credit No">Credit No</label><br/><input type="text" name="Credit_no" id="Credit_no" value="${reservation.creditNo}" size="30"></p>
    <input type="submit">
</form>
    <p><a href="reservations">back to reservations</a></p>
</div>
</body>
</html>
