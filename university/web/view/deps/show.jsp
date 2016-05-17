<%--
  Created by IntelliJ IDEA.
  User: Антон
  Date: 12.05.2016
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Кафедры</title>
</head>
<body>
<a href="../index.jsp">Главная страница</a>
<br/>
<table border="1">
    <tr>
        <td>Кафедра</td>
        <td><a href="/teachs/show">Преподаватели</a></td>
        <td>Удалить</td>
        <td>Редактировать</td>
    </tr>
    <c:forEach items="${deps}" var="dep" varStatus="status">
        <tr>
            <td>${dep.name}</td>
            <td>
                <c:if test="${dep.teachers.size() == 0}">
                    Нет
                </c:if>
                <c:if test="${dep.teachers.size() > 0}">
                    Да
                </c:if>
            </td>
            <td>
                <c:if test="${dep.teachers.size() == 0}">
                    <form action="/deps/delete" method="post">
                        <input type="hidden" name="id" value="${dep.id}">
                        <input type="submit" value="Удалить" align="center" >
                    </form>
                </c:if>
            </td>
            <td>
                <form action="/deps/edit" method="get">
                    <input type="hidden" name="id" value="${dep.id}">
                    <input type="submit" value="Редактировать" align="center" >
                </form>
            </td>
        </tr>
    </c:forEach>
</table><br/>
<form action="/deps/add" method="post">
    <table>
        <tr>
            <td>Название</td>
            <td><input type="text" name="name"></td>
        </tr>
    </table>

    <input type="submit" align="center" value="Добавить">
</form>
</body>
</html>