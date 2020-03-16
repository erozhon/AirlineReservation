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
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
<h3>Revenue</h3>
Message:
<p>${message}</p>
<p><a class="waves-effect waves-light btn" href="./">home</a></p>
<table class="highlight">
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
        <th>December</th>
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
<p><a class="waves-effect waves-light btn" href="create_passenger">Add</a></p>
<p><a class="waves-effect waves-light btn" href="./">home</a></p>
<script type="text/javascript" src="js/materialize.min.js"></script>
</body>
</html>