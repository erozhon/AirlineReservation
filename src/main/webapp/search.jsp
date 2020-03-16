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
<div style="margin:auto;padding: 10px;">
    <p><a href="./">Home</a></p>
    <p><a href="./search_query">Search Again</a></p>
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
                out.print("<td><a href='reservationcreate?seat_no=" + result.getSeatNo() + "&flight_no=" + result.getId() + "'> Book it </a></td></tr>");
            }

        %>
    </table>
</div>
</body>
</html>