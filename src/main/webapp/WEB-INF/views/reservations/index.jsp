<%@page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href='<%= request.getContextPath() + "/css/main.css" %>'/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <title>Reservations</title>
</head>
<body id ="main" >
<div id="header">
</div>
<div class="table-container">
    <p class="headline gray">Reservations waiting for approval:</p>
    <table class="table table-striped index-table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Villa name</th>
            <th>Name</th>
            <th>Lastname</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Total days</th>
            <th>Price</th>
            <th>Total price</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${reservations_waiting}" var="reservation">
            <tr>
                <td>${reservation.id}</td>
                <td>${reservation.villa.name}</td>
                <td>${reservation.customer.firstName}</td>
                <td>${reservation.customer.lastName}</td>
                <td>${reservation.customer.email}</td>
                <td>${reservation.customer.phone}</td>
                <td>${reservation.totalDays}</td>
                <td>${reservation.price}</td>
                <td>${reservation.totalPrice}</td>
                <td><a href="${pageContext.request.contextPath}/admin/reservations/${reservation.id}?status=1">Approve</a>
                    <a href="${pageContext.request.contextPath}/admin/reservations/${reservation.id}?status=-1">Reject</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="table-container">
    <p class="headline green">Reservations approved:</p>
    <table class="table table-striped index-table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Villa name</th>
            <th>Name</th>
            <th>Lastname</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Total days</th>
            <th>Price</th>
            <th>Total price</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${reservations_approved}" var="reservation">
            <tr>
                <td>${reservation.id}</td>
                <td>${reservation.villa.name}</td>
                <td>${reservation.customer.firstName}</td>
                <td>${reservation.customer.lastName}</td>
                <td>${reservation.customer.email}</td>
                <td>${reservation.customer.phone}</td>
                <td>${reservation.totalDays}</td>
                <td>${reservation.price}</td>
                <td>${reservation.totalPrice}</td>
                <td><a href="${pageContext.request.contextPath}/admin/reservations/${reservation.id}?status=-1">Reject</a>
                    <a href="${pageContext.request.contextPath}/admin/reservations/${reservation.id}?status=0">Wait</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="table-container">
    <p class="headline red">Reservations rejected:</p>
    <table class="table table-striped index-table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Villa name</th>
            <th>Name</th>
            <th>Lastname</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Total days</th>
            <th>Price</th>
            <th>Total price</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${reservations_rejected}" var="reservation">
            <tr>
                <td>${reservation.id}</td>
                <td>${reservation.villa.name}</td>
                <td>${reservation.customer.firstName}</td>
                <td>${reservation.customer.lastName}</td>
                <td>${reservation.customer.email}</td>
                <td>${reservation.customer.phone}</td>
                <td>${reservation.totalDays}</td>
                <td>${reservation.price}</td>
                <td>${reservation.totalPrice}</td>
                <td><a href="${pageContext.request.contextPath}/admin/reservations/${reservation.id}?status=1">Approve</a>
                    <a href="${pageContext.request.contextPath}/admin/reservations/${reservation.id}?status=0">Wait</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
