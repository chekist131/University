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
    <title>Редактировать студента</title>
</head>
<body>
<a href="../index.jsp">Главная страница</a>
<form action="/studs/edit" method="post">

    <table>
        <tr>
            <td>ФИО</td>
            <td><input type="text" name="name" value="${stud.name}"></td>
        </tr>
        <tr>
            <td>Группа</td>
            <td>
                <select name="group.id">
                    <c:forEach items="${groups}" var="group">
                        <option value="${group.id}" ${stud.group.id == group.id ? "selected" : ""} >${group.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </table>

    <input type="hidden" name="id" value="${stud.id}">
    <input type="submit" value="Изменить" align="center" >

</form>
</body>
</html>
