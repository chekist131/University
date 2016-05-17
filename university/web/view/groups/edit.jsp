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
    <title>Редактировать группу</title>
</head>
<body>
<a href="../index.jsp">Главная страница</a>
<form action="/groups/edit" method="post">

    <table>
        <tr>
            <td>Название</td>
            <td><input type="text" name="name" value="${group.name}"></td>
        </tr>
        <tr>
            <td>Курс</td>
            <td>
                <select name="course.id">
                    <c:forEach items="${courses}" var="course">
                        <option value="${course.id}" ${group.course.id == course.id ? "selected" : ""} >${course.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Специализация</td>
            <td>
                <select name="specialization.id">
                    <c:forEach items="${specs}" var="spec">
                        <option value="${spec.id}" ${group.specialization.id == spec.id ? "selected" : ""} >${spec.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </table>

    <input type="hidden" name="id" value="${group.id}">
    <input type="submit" value="Изменить" align="center" >

</form>
</body>
</html>
