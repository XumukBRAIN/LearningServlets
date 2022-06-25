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
    <title>Appliances Brand</title>
</head>
<body>
<center>
    <h1>Brand Management</h1>
    <h2>
        <a href="/new">Add New Brand</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/list">List All Brand</a>

    </h2>
</center>
<div align="center">
        <c:if test="${brand == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${brand != null}">
                            Edit brand
                        </c:if>
                        <c:if test="${brand == null}">
                            Add New brand
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${brand != null}">
                    <input type="hidden" name="id" value="<c:out value='${brand.id}' />" />
                </c:if>
                <tr>
                    <th>Name: </th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${brand.name}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Description: </th>
                    <td>
                        <input type="text" name="description" size="45"
                               value="<c:out value='${brand.description}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Location: </th>
                    <td>
                        <input type="text" name="location" size="45"
                               value="<c:out value='${brand.location}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Established: </th>
                    <td>
                        <input type="text" name="established" size="45"
                               value="<c:out value='${brand.established}' />"
                        />
                    </td>
                </tr>

                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>
