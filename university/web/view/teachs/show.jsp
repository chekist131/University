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
    <title>Преподаватели</title>
</head>
<body>
<a href="../index.jsp">Главная страница</a>
<br/>
<table border="1">
    <tr>
        <td>Преподаватель</td>
        <td><a href="/deps/show">Кафедра</a></td>
        <td><a href="/discs/show">Предметы</a></td>
        <td><a href="/teachmails/show">Почта</a></td>
        <td>Удалить</td>
        <td>Редактировать</td>
    </tr>
    <c:forEach items="${teachs}" var="teach" varStatus="status">
        <tr>
            <td>${teach.name}</td>
            <td>${teach.department.name}</td>
            <td>
                <c:if test="${teach.disciplines.size() == 0}">
                    Нет
                </c:if>
                <c:if test="${teach.disciplines.size() > 0}">
                    Да
                </c:if>
            </td>
            <td>
                <c:if test="${teach.mails.size() == 0}">
                    Нет
                </c:if>
                <c:if test="${teach.mails.size() > 0}">
                    Да
                </c:if>
            </td>
            <td>
                <c:if test="${teach.mails.size() == 0 && teach.disciplines.size() == 0}">
                    <form action="/teachs/delete" method="post">
                        <input type="hidden" name="id" value="${teach.id}">
                        <input type="submit" value="Удалить" align="center" >
                    </form>
                </c:if>
            </td>
            <td>
                <form action="/teachs/edit" method="get">
                    <input type="hidden" name="id" value="${teach.id}">
                    <input type="submit" value="Редактировать" align="center" >
                </form>
            </td>
        </tr>
    </c:forEach>
</table><br/>

<form method="post" action="/teachs/add">

    <table>
        <tr>
            <td>ФИО</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>Кафедра</td>
                <td>
                    <select name="department.id">
                        <c:forEach items="${deps}" var="dep">
                            <option value="${dep.id}">${dep.name}</option>
                        </c:forEach>
                    </select>
                </td>
        </tr>
    </table>

    <input type="submit" align="center" value="Добавить">

</form>

</body>
</html>