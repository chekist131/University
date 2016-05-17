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
    <title>Оценки</title>
</head>
<body>
<a href="../index.jsp">Главная страница</a>
<br/>
<table border="1">
    <tr>
        <td><a href="/discs/show">Предмет</a></td>
        <td>Оценка</td>
        <td><a href="/studs/show">Студент</a></td>
        <td>Удалить</td>
    </tr>
    <c:forEach items="${grades}" var="grade" varStatus="status">
        <tr>
            <td>${grade.discipline.name}</td>
            <td>${grade.value}</td>
            <td>${grade.student.name}</td>
            <td>
                <form action="/grades/delete" method="post">
                    <input type="hidden" name="id" value="${grade.id}">
                    <input type="submit" value="Удалить" align="center" >
                </form>
            </td>
        </tr>
    </c:forEach>
</table><br/>

<form method="post" action="/grades/add">

    <table>
        <tr>
            <td>Предмет</td>
            <td>
                <select name="discipline.id">
                    <c:forEach items="${discs}" var="disc">
                        <option value="${disc.id}">${disc.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Оценка</td>
            <td>
                <select name="value">
                    <c:forEach items="${gradePul}" var="grade">
                        <option value="${grade}">${grade}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Оценка</td>
            <td>
                <select name="student.id">
                    <c:forEach items="${studs}" var="stud">
                        <option value="${stud.id}">${stud.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </table>

    <input type="submit" align="center" value="Добавить">

</form>

</body>
</html>