<%--
  Created by IntelliJ IDEA.
  User: Антон
  Date: 15.05.2016
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Редактировать дисциплину</title>
</head>
<body>
<a href="../index.jsp">Главная страница</a>
<form action="/discs/edit" method="post">

    <table>
        <tr>
            <td>ФИО</td>
            <td><input type="text" name="name" value="${disc.name}"></td>
        </tr>
        <tr>
            <td>Группа</td>
            <td>
                <select name="teacher.id">
                    <c:forEach items="${teachs}" var="teach">
                        <option value="${teach.id}" ${disc.teacher.id == teach.id ? "selected" : ""} >${teach.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </table>

    <input type="hidden" name="id" value="${disc.id}">
    <input type="submit" value="Изменить" align="center" >

</form>
</body>
</html>
