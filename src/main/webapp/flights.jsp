<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customers</title>
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
<p><a href="./">home</a></p>
<table>
    <thead>Flights</thead>
    <tr><th>id</th><th>airline</th><th>source</th><th>destination</th><th>takeoff</th><th>arrival</th><th>full</th><th>capacity</th></tr>
    <c:forEach items="${flights}" var="flight">
        <tr>
            <td>${flight.id}</td>
            <td>${flight.airline}</td>
            <td>${flight.source}</td>
            <td>${flight.destination}</td>
            <td>${flight.takeoff}</td>
            <td>${flight.arrival}</td>
            <td>${flight.full}</td>
            <td>${flight.capacity}</td>
            <td><a data-id="${flight.id}" href="edit_flight?id=${flight.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
<p><a href="create_flight">Add</a></p>
<p><a href="./">home</a></p>
</body>
</html>