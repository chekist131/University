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
    <title>Почта студентов</title>
</head>
<body>
<a href="../index.jsp">Главная страница</a>
<br/>
<table border="1">
    <tr>
        <td>Почта</td>
        <td><a href="/studs/show">Студент</a></td>
        <td>Удалить</td>
        <td>Редактировать</td>
    </tr>
    <c:forEach items="${studmails}" var="studmail" varStatus="status">
        <tr>
            <td>${studmail.value}</td>
            <td>${studmail.student.name}</td>
            <td>
                <form action="/studmails/delete" method="post">
                    <input type="hidden" name="id" value="${studmail.id}">
                    <input type="submit" value="Удалить" align="center" >
                </form>
            </td>
            <td>
                <form action="/studmails/edit" method="get">
                    <input type="hidden" name="id" value="${studmail.id}">
                    <input type="submit" value="Редактировать" align="center" >
                </form>
            </td>
        </tr>
    </c:forEach>
</table><br/>

<form method="post" action="/studmails/add">

    <table>
        <tr>
            <td>Почта</td>
            <td><input type="text" name="value"/></td>
        </tr>
        <tr>
            <td>Студент</td>
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