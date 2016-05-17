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
    <title>Дисциплины</title>
</head>
<body>
<a href="../index.jsp">Главная страница</a>
<br/>
<table border="1">
    <tr>
        <td>Предмет</td>
        <td><a href="/teachs/show">Преподаватель</a></td>
        <td><a href="/grades/show">Оценки</a></td>
        <td>Удалить</td>
        <td>Редактировать</td>
    </tr>
    <c:forEach items="${discs}" var="disc" varStatus="status">
        <tr>
            <td>${disc.name}</td>
            <td>${disc.teacher.name}</td>
            <td>
                <c:if test="${disc.grades.size() == 0}">
                    Нет
                </c:if>
                <c:if test="${disc.grades.size() > 0}">
                    Да
                </c:if>
            </td>
            <td>
                <c:if test="${disc.grades.size() == 0}">
                    <form action="/discs/delete" method="post">
                        <input type="hidden" name="id" value="${disc.id}">
                        <input type="submit" value="Удалить" align="center" >
                    </form>
                </c:if>
            </td>
            <td>
                <form action="/discs/edit" method="get">
                    <input type="hidden" name="id" value="${disc.id}">
                    <input type="submit" value="Редактировать" align="center" >
                </form>
            </td>
        </tr>
    </c:forEach>
</table><br/>

<form method="post" action="/discs/add">

    <table>
        <tr>
            <td>Название</td>
            <td><input type="text" name="name"/></td>
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