<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Reservation</title>

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
<div style="width:30%;height:50%;margin: auto;padding: 10px;">
<form method="post" action="cancel_reservation">
    <p><label for="Id">Id</label><br/><input type="text" name="id" id="id" value="${reservation.id}" size="30"></p>
    <p><label for="Passenger Id">Passenger Id</label><br/><input type="text" name="Passenger_id" id="Passenger_id" value="${reservation.passengerId}" size="30"></p>
    <p><label for="Seat No">Seat No</label><br/><input type="text" name="Seat_no" id="Seat_no" value="${reservation.seatNo}" size="30"></p>
    <p><label for="Flight No">Flight No</label><br/><input type="text" name="Flight_no" id="Flight_no" value="${reservation.flightNo}" size="30"></p>
    <p><label for="Cost">Cost</label><br/><input type="text" name="Cost" id="Cost" value="${reservation.cost}" size="30"></p>
    <p><label for="Cancelled">Cancelled</label><br/><input type="text" name="Cancelled" id="Cancelled" value="${reservation.cancelled}" size="30"></p>
    <p><label for="Has Paid">Pay now?</label><br/><input type="text" name="Has_paid" id="Has_paid" value="${reservation.hasPaid}" size="30"></p>
    <p><label for="Credit No">Credit No</label><br/><input type="text" name="Credit_no" id="Credit_no" value="${reservation.creditNo}" size="30"></p>
    <input class="waves-effect waves-light btn" type="submit">
</form>
    <p><a class="waves-effect waves-light btn" href="reservations">back to reservations</a></p>
</div>
<script type="text/javascript" src="js/materialize.min.js"></script>

</body>
</html>
