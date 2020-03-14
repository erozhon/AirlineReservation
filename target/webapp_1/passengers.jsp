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
<table>
    <thead>Passengers</thead>
    <tr><th>id</th><th>name</th><th></th></tr>
    <c:forEach items="${passengers}" var="passenger">
        <tr>
            <td>${passenger.id}</td>
            <td>${passenger.name}</td>
            <td><a data-id="${passenger.id}" href="edit_passenger?id=${passenger.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
<p><a href="create_passenger">Add</a></p>
<p><a href="./">home</a></p>
</body>
</html>