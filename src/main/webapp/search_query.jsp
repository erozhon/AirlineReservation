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
    <title>Results</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }
        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<div style="width:30%;height:50%;margin:10% auto;padding: 10px;">
    <p><a href="./">Home</a></p>
    <p><a href="/search">Search Again</a></p>
    <table>
        <thead>Flights and Their Available Seats</thead>
        <tr>
            <th>Id</th>
            <th>Airline</th>
            <th>Source</th>
            <th>Destination</th>
            <th>Takeoff</th>
            <th>Arrival</th>
            <th>Seat Number</th>
            <th>Seat Type</th>
            <th>Seat Class</th>
        </tr>
        <c:forEach items="${results}" var="result">
            <tr>
                <td>${result.Id}</td>
                <td>${result.airline}</td>
                <td>${result.source}</td>
                <td>${result.destination}</td>
                <td>${result.takeoff}</td>
                <td>${result.arrival}</td>
                <td>${result.seatNo}</td>
                <td>${result.type}</td>
                <td>${result.seatClass}</td>
            </tr>
        </c:forEach>
    </table>
</form>
</div>
</body>
</html>