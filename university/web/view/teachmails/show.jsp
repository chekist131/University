<%--
  Created by IntelliJ IDEA.
  User: Антон
  Date: 12.05.2016
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Почта преподавателей</title>
</head>
<body>
<a href="../index.jsp">Главная страница</a>
<br/>
<table border="1">
    <tr>
        <td>Почта</td>
        <td><a href="/teachs/show">Преподаватель</a></td>
        <td>Удалить</td>
        <td>Редактировать</td>
    </tr>
    <c:forEach items="${teachmails}" var="teachmail" varStatus="status">
        <tr>
            <td>${teachmail.value}</td>
            <td>${teachmail.teacher.name}</td>
            <td>
                <form action="/teachmails/delete" method="post">
                    <input type="hidden" name="id" value="${teachmail.id}">
                    <input type="submit" value="Удалить" align="center" >
                </form>
            </td>
            <td>
                <form action="/teachmails/edit" method="get">
                    <input type="hidden" name="id" value="${teachmail.id}">
                    <input type="submit" value="Редактировать" align="center" >
                </form>
            </td>
        </tr>
    </c:forEach>
</table><br/>

<form method="post" action="/teachmails/add">

    <table>
        <tr>
            <td>Почта</td>
            <td><input type="text" name="value"/></td>
        </tr>
        <tr>
            <td>Преподаватель</td>
            <td>
                <select name="teacher.id">
                    <c:forEach items="${teachs}" var="teach">
                        <option value="${teach.id}">${teach.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </table>

    <input type="submit" align="center" value="Добавить">

</form>

</body>
</html>