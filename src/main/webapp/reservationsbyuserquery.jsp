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

    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <style>
        input[type="submit"] {
            color: whitesmoke;
        }
    </style>
</head>
<body>
<div style="width:30%;height:50%;margin:10% auto;padding: 10px;">
    <p><a class="waves-effect waves-light btn" href="./">home</a></p>
    <form method="post" action="reservationsbyuser">
        <p><label for="Passenger_id">Passenger id</label><br/><div class=?.input-field> <input type="text" name="Passenger_id" id="Passenger_id" value="" size="30"></div></p>
        <input class="waves-effect waves-light btn" type="submit">
    </form>
</div>
<script type="text/javascript" src="js/materialize.min.js"></script>
</body>
</html>