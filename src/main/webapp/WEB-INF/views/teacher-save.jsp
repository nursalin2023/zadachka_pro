<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dastan
  Date: 11.03.2023
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style><%@include file="/WEB-INF/views/css/form.css"%>
    </style>
</head>
<body>
<div class="box">
    <h1>Save teacher</h1>
    <form action="/saveTeacher" method="post">
        <div class="input-box">
            <input type="text" name="first_Name" placeholder="first_name:">
            <i></i>
        </div>
        <div class="input-box">
            <input type="text" name="last_Name" placeholder="last_name:">
            <i></i>
        </div>
        <div class="input-box">
            <input type="text" name="email" placeholder="email:">
            <i></i>
        </div>
        <c:forEach items="${teacher}" var="company">
            <input type="checkbox" id="${company.id}" name="id" value="${company.id}">
            <label for="${company.id}">${company.courName}</label>
        </c:forEach>
        <input type="submit" value="save">
    </form>
</div>
</body>
</html>
