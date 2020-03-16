<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Flights</title>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
<h3 class="flow-text">Flights</h3>
Message:
<p class="flow-text">${message}</p>
<p class="flow-text"><a href="./" class="waves-effect waves-light btn">home</a></p>
<table class="highlight">
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
            <td><a data-id="${flight.id}" href="edit_flight?id=${flight.id}" class="waves-effect waves-light btn">Edit</a></td>
        </tr>
    </c:forEach>
</table>
<p><a href="create_flight" class="waves-effect waves-light btn">Add</a></p>
<p><a href="./" class="waves-effect waves-light btn">home</a></p>
<script type="text/javascript" src="js/materialize.min.js"></script>
</body>
</html>