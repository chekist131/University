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
    <title>Редактировать почту преподавателя</title>
</head>
<body>
<a href="../index.jsp">Главная страница</a>
<form action="/teachmails/edit" method="post">

    <table>
        <tr>
            <td>Почта</td>
            <td><input type="text" name="value" value="${teachmail.value}"></td>
        </tr>
        <tr>
            <td>Преподаватель</td>
            <td>
                <select name="teacher.id">
                    <c:forEach items="${teachs}" var="teach">
                        <option value="${teach.id}" ${teachmail.teacher.id == teach.id ? "selected" : ""} >${teach.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </table>

    <input type="hidden" name="id" value="${teachmail.id}">
    <input type="submit" value="Изменить" align="center" >

</form>
</body>
</html>
