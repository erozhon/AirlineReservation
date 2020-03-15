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
    <title>Search for Flights</title>
</head>
<body>
<div style="width:30%;height:50%;margin:10% auto;padding: 10px;">
    <p><a href="./">home</a></p>
    <form method="post" action="search_query">
        <p><label for="Date">Date</label><br/><input type="text" name="Date" id="Date" value="" size="30"></p>
        <p><label for="Source">Source</label><br/><input type="text" name="Source" id="Source" value="" size="30"></p>
        <p><label for="Destination">Destination</label><br/><input type="text" name="Destination" id="Destination" value="" size="30"></p>
        <p><label for="seatType">Seat Type</label><br/><input type="text" name="seatType" id="seatType" value="" size="30"></p>
        <p><label for="seatClass">Seat Class</label><br/><input type="text" name="seatClass" id="seatClass" value="" size="30"></p>
        <input type="submit">
</div>
</body>
</html>