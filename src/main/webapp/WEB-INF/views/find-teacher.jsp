<%--
  Created by IntelliJ IDEA.
  User: dastan
  Date: 11.03.2023
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="/WEB-INF/views/css/forFind.css" %>
    </style>
</head>
<body>
<table border="2px">
    <thead>
    <tr>
        <th>id</th>
        <th>first name</th>
        <th>last name</th>
        <th>email</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${company.id}</td>
        <td>${company.first_Name}</td>
        <td>${company.last_name}</td>
        <td>${company.email}</td>
    </tr>
    </tbody>
</table>
<button><a href="/teachers">roll-back</a></button>
<button><a href="/c">main</a></button>
</body>
</html>
