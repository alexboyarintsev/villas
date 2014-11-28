<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html ng-app="reservations">
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.2/angular.min.js"></script>
  <script type="text/javascript">
    <%@include file="reservations.js"%>
  </script>
</head>

<body ng-controller="ReservationsController as reservationsCtrl">

<form ng-submit="reservationsCtrl.addReservation()">
  firstname:  <input ng-model="reservationsCtrl.reservation.firstname" type="text" value="Leha"><br /> <br />
  lastname:   <input ng-model="reservationsCtrl.reservation.lastname" type="text" value="Boyarin"><br /> <br />
  passportNo: <input ng-model="reservationsCtrl.reservation.passportNo" type="text" value="234234234234234"><br /> <br />
  phone:      <input ng-model="reservationsCtrl.reservation.phone" type="text" value="80634113537"><br /> <br />
  email:      <input ng-model="reservationsCtrl.reservation.email" type="text" value="4124717@gmail.com"><br /> <br />
  villaId:    <input ng-model="reservationsCtrl.reservation.villaId" type="text" value="13"><br /> <br />
  dateStart:  <input ng-model="reservationsCtrl.reservation.dateStart" type="text" value="2014-11-16"><br /> <br />
  dateFinish: <input ng-model="reservationsCtrl.reservation.dateFinish" type="text" value="2014-11-26"><br /> <br />

  <input type="submit" value="Upload"> Press here to upload the file!
</form>

</body>
</html>