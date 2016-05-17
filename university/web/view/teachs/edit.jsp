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
    <title>Редактировать преподавателя</title>
</head>
<body>
<a href="../index.jsp">Главная страница</a>
<form action="/teachs/edit" method="post">

    <table>
        <tr>
            <td>ФИО</td>
            <td><input type="text" name="name" value="${teach.name}"/></td>
        </tr>
        <tr>
            <td>Кафедра</td>
            <td>
                <select name="department.id">
                    <c:forEach items="${deps}" var="dep">
                        <option value="${dep.id}" ${teach.department.id == dep.id ? "selected" : ""} >${dep.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </table>

    <input type="hidden" name="id" value="${teach.id}">
    <input type="submit" value="Изменить" align="center" >

</form>
</body>
</html>
