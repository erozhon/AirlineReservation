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
<form method="post" action="Reservation">
    <p><label for="Passenger Id">Passenger Id</label><br/><input type="text" name="Passenger_id" id="Passenger_id" value="" size="30"></p>
    <p><label for="Id">Id</label><br/><input type="text" name="Id" id="Id" value="" size="30"></p>
    <p><label for="Seat No">Seat No</label><br/><input type="text" name="Seat_no" id="Seat_no" value="" size="30"></p>
    <p><label for="Flight No">Date</label><br/><input type="text" name="Flight_no" id="Flight_no" value="" size="30"></p>
    <input type="submit">
</form>
</div>
</body>
</html>
