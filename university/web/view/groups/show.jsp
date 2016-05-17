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
    <title>Группы</title>
</head>
<body>
<a href="../index.jsp">Главная страница</a>
<br/>
<table border="1">
    <tr>
        <td>Группа</td>
        <td><a href="/courses/show">Курс</a></td>
        <td><a href="/specs/show">Специализация</a></td>
        <td><a href="/studs/show">Студенты</a></td>
        <td>Удалить</td>
        <td>Редактировать</td>
    </tr>
    <c:forEach items="${groups}" var="group" varStatus="status">
        <tr>
            <td>${group.getName()}</td>
            <td>${group.course.getName()}</td>
            <td>${group.specialization.getName()}</td>
            <td>
                <c:if test="${group.students.size() == 0}">
                    Нет
                </c:if>
                <c:if test="${group.students.size() > 0}">
                    Да
                </c:if>
            </td>
            <td>
                <c:if test="${group.students.size() == 0}">
                    <form action="/groups/delete" method="post">
                        <input type="hidden" name="id" value="${group.getId()}">
                        <input type="submit" value="Удалить" align="center" >
                    </form>
                </c:if>
            </td>
            <td>
                <form action="/groups/edit" method="get">
                    <input type="hidden" name="id" value="${group.getId()}">
                    <input type="submit" value="Редактировать" align="center" >
                </form>
            </td>
        </tr>
    </c:forEach>
</table><br/>

<form method="post" action="/groups/add">

    <table>
        <tr>
            <td>Название</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>Курс</td>
                <td>
                    <select name="course.id">
                        <c:forEach items="${courses}" var="course">
                            <option value="${course.id}">${course.name}</option>
                        </c:forEach>
                    </select>
                </td>
        </tr>
        <tr>
            <td>Специализация</td>
            <td>
                <select name="specialization.id">
                    <c:forEach items="${specs}" var="spec">
                        <option value="${spec.id}">${spec.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </table>

    <input type="submit" align="center" value="Добавить">

</form>

</body>
</html>