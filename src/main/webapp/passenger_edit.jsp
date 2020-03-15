reservationedit.jspreservationedit.jsp<%--
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
</head>
<body>
<div style="width:30%;height:50%;margin:10% auto;padding: 10px;">
<form method="post" action="edit_passenger">
    <p><label for="id">ID</label><br/><input type="text" name="id" id="id" value="${passenger.id}" size="30" readonly="readonly"></p>
    <p><label for="name">NAME</label><br/><input type="text" name="name" id="name" value="${passenger.name}" size="30"></p>
    <input type="submit">
</form>
    <p><a href="passengers">back to passengers</a></p>
</div>
</body>
</html>