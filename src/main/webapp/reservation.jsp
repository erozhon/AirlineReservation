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
    <title>Reservation</title>
</head>
<body>
<div style="width:30%;height:50%;margin:10% auto;padding: 10px;">
<form method="post" action="reservationcreate">
    <p><label for="Passenger Id">Passenger Id</label><br/><input type="text" name="Passenger_id" id="Passenger_id" value="" size="30"></p>
    <p><label for="Id">Id</label><br/><input type="text" name="Id" id="Id" value="" size="30"></p>
    <p><label for="Seat No">Seat No</label><br/><input type="text" name="Seat_no" id="Seat_no" value="" size="30"></p>
    <p><label for="Flight No">Flight No</label><br/><input type="text" name="Flight_no" id="Flight_no" value="" size="30"></p>
    <p><label for="Cost">Cost</label><br/><input type="text" name="Cost" id="Cost" value="" size="30"></p>
    <p><label for="Cancelled">Cancelled</label><br/><input type="text" name="Cancelled" id="Cancelled" value="" size="30"></p>
    <p><label for="Has Paid">Has Paid?</label><br/><input type="text" name="Has_paid" id="Has_paid" value="" size="30"></p>
    <p><label for="Credit No">Credit No</label><br/><input type="text" name="Credit_no" id="Credit_no" value="" size="30"></p>
    <input type="submit">
</form>
</div>
</body>
</html>
