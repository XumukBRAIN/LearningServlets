<%--
  Created by IntelliJ IDEA.
  User: Иван-ПК
  Date: 24.06.2022
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BrandList</title>
</head>
<body>
<h1 align="center">List of Brands</h1>
<h2 align="center">
    <a href="/new">Add new brand</a>
    &nbsp;&nbsp;&nbsp;
    <a href="list">List all brand</a>
</h2>
<div align="center">
    <table border="1" cellpadding="5">
        <caption>
            <h2>List of brands</h2>
        </caption>
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Location</th>
            <th>Established</th>
            <th>Actions</th>
        </tr>

        <c:forEach var="brand" items="${listBrand}">
            <tr align="center">
                <td><c:out value="${brand.name}"/></td>
                <td><c:out value="${brand.description}"/></td>
                <td><c:out value="${brand.location}"/></td>
                <td><c:out value="${brand.established}"/></td>
                <td>
                    <a href="/edit?id=<c:out value="${brand.id}"/> ">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/delete?id=<c:out value="${brand.id}"/> ">Delete</a>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>

</body>
</html>
