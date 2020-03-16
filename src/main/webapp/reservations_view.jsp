<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reservations</title>
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
Message:
<p>${message}</p>
<table>
    <thead>Reservations</thead>
    <tr><th>id</th><th>passenger id</th><th>seat no</th><th>cost</th><th>credit card no</th><th>flight no</th><th>has paid</th><th>cancelled</th></tr>
    <c:forEach items="${reservations}" var="reservation">
        <tr>
            <td>${reservation.id}</td>
            <td>${reservation.passengerId}</td>
            <td>${reservation.seatNo}</td>
            <td>${reservation.cost}</td>
            <td>${reservation.creditNo}</td>
            <td>${reservation.flightNo}</td>
            <td>${reservation.hasPaid}</td>
            <td>${reservation.cancelled}</td>
            <td><a data-id="${reservation.id}" href="edit_reservation?id=${reservation.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
<p><a href="reservationcreate">Add</a></p>
<p><a href="./">home</a></p>
</body>
</html>