<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <title>Create event</title>
</head>
<body>
<h3>New event</h3>
<form method="post">
    <label>Title</label><br>
    <input name="title"/><br><br>
    <label>Date</label><br>
    <input name="date" type="date"/><br><br>
    <label>Time</label><br>
    <input name="time" type="time"/><br><br>
    <label>City</label><br>
    <input name="city"/><br><br>
    <label>Street</label><br>
    <input name="street"/><br><br>
    <label>Building</label><br>
    <input name="building"/><br><br>
    <input type="submit" value="Save"/>
</form>
</body>
</html>