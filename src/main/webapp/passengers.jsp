<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Passengers</title>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
<h3>Passengers</h3>
Message:
<p>${message}</p>
<p><a class="waves-effect waves-light btn" href="./">home</a></p>
<table class="highlight">
    <tr><th>id</th><th>name</th><th></th></tr>
    <c:forEach items="${passengers}" var="passenger">
        <tr>
            <td>${passenger.id}</td>
            <td>${passenger.name}</td>
            <td><a class="waves-effect waves-light btn" data-id="${passenger.id}" href="edit_passenger?id=${passenger.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
<p><a class="waves-effect waves-light btn" href="create_passenger">Add</a></p>
<p><a class="waves-effect waves-light btn" href="./">home</a></p>
<script type="text/javascript" src="js/materialize.min.js"></script>
</body>
</html>