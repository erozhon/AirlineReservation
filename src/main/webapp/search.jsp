<%@ page import="edu.calpoly.csc365.example1.controller.SearchServlet" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
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

    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
<h3>Flights and Their Available Seats</h3>
<div style="margin:auto;padding: 10px;">
    <p><a class="waves-effect waves-light btn" href="./">Home</a></p>
    <p><a class="waves-effect waves-light btn" href="./search_query">Search Again</a></p>
    <table class="highlight">
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
        <% List<SearchServlet.Search> results = (ArrayList<SearchServlet.Search>)request.getAttribute("res");

            for(SearchServlet.Search result : results)
            {
                out.print("<tr><td>" + result.getId() + "</td>");
                out.print("<td>" + result.getAirline() + "</td>");
                out.print("<td>" + result.getSource() + "</td>");
                out.print("<td>" + result.getDestination() + "</td>");
                out.print("<td>" + result.getTakeoff() + "</td>");
                out.print("<td>" + result.getArrival() + "</td>");
                out.print("<td>" + result.getSeatNo() + "</td>");
                out.print("<td>" + result.getType() + "</td>");
                out.print("<td>" + result.getSeatClass() + "</td>");
                out.print("<td><a class='waves-effect waves-light btn' href='reservationcreate?seat_no=" + result.getSeatNo() + "&flight_no=" + result.getId() + "'> Book it </a></td></tr>");
            }

        %>
    </table>
</div>
<script type="text/javascript" src="js/materialize.min.js"></script>
</body>
</html>