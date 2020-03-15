<%--
  Created by IntelliJ IDEA.
  User: meinfr13nd
  Date: 3/14/2020
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Revenue</title>
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
    <thead>Revenue</thead>
    <tr>
        <th>Flight Path</th>
        <th>January</th>
        <th>February</th>
        <th>March</th>
        <th>April</th>
        <th>May</th>
        <th>June</th>
        <th>July</th>
        <th>August</th>
        <th>September</th>
        <th>October</th>
        <th>November</th>
        <th>December</th>>
        <th>Total Revenue</th>
    </tr>
    <c:forEach items="${revenues}" var="revenue">
        <tr>
            <td>${revenue.flightPair}</td>
            <td>${revenue.jan}</td>
            <td>${revenue.feb}</td>
            <td>${revenue.march}</td>
            <td>${revenue.april}</td>
            <td>${revenue.may}</td>
            <td>${revenue.june}</td>
            <td>${revenue.july}</td>
            <td>${revenue.aug}</td>
            <td>${revenue.sept}</td>
            <td>${revenue.oct}</td>
            <td>${revenue.nov}</td>
            <td>${revenue.dec}</td>
            <td>${revenue.total}</td>
        </tr>
    </c:forEach>
</table>
<p><a href="create_passenger">Add</a></p>
<p><a href="./">home</a></p>
</body>
</html>