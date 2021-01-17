<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <title>Events</title>
</head>
<body>
<h2>Events list</h2>
<p><a href='<c:url value="/create" />'>Create new</a></p>
<table>
    <thead>
    <tr>
        <td>Title</td>
        <td>Date</td>
        <td>Time</td>
        <td>Address</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${eventsList}" var="event">
        <tr>
            <td>${event.title}</td>
            <td>${event.date}</td>
            <td>${event.time}</td>
            <td>${event.address.city}</td>
            <td>${event.address.street}</td>
            <td>${event.address.building}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
