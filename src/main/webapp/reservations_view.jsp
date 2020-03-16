<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reservations</title>

    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
<h3>Reservations</h3>
<p><a class="waves-effect waves-light btn" href="./">home</a></p>
Message:
<p>${message}</p>
<table class="highlight">
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
            <td><a class="waves-effect waves-light btn" data-id="${reservation.id}" href="edit_reservation?id=${reservation.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
<p><a class="waves-effect waves-light btn" href="reservationcreate">Add</a></p>
<p><a class="waves-effect waves-light btn" href="./">home</a></p>
<script type="text/javascript" src="js/materialize.min.js"></script>

</body>
</html>