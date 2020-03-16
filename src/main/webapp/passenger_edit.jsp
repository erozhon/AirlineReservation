<%--
  Created by IntelliJ IDEA.
  User: toshihirokuboi
  Date: 2019-11-21
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Passenger Form</title>
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
<form method="post" action="edit_passenger">
    <p><label for="id">ID</label><br/><input type="text" name="id" id="id" value="${passenger.id}" size="30" readonly="readonly"></p>
    <p><label for="name">NAME</label><br/><input type="text" name="name" id="name" value="${passenger.name}" size="30"></p>
    <input class="waves-effect waves-light btn"  type="submit">
</form>
    <p><a class="waves-effect waves-light btn" href="passengers">back to passengers</a></p>
    <script type="text/javascript" src="js/materialize.min.js"></script>
</div>
</body>
</html>