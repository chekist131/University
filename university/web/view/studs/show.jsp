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
    <title>Студенты</title>
</head>
<body>
<a href="../index.jsp">Главная страница</a>
<br/>
<table border="1">
    <tr>
        <td>Студент</td>
        <td><a href="/groups/show">Группа</a></td>
        <td><a href="/grades/show">Оценки</a></td>
        <td><a href="/studmails/show">Почта</a></td>
        <td>Удалить</td>
        <td>Редактировать</td>
    </tr>
    <c:forEach items="${studs}" var="stud" varStatus="status">
        <tr>
            <td>${stud.getName()}</td>
            <td>${stud.group.getName()}</td>
            <td>
                <c:if test="${stud.grades.size() == 0}">
                    Нет
                </c:if>
                <c:if test="${stud.grades.size() > 0}">
                    Да
                </c:if>
            </td>
            <td>
                <c:if test="${stud.mails.size() == 0}">
                    Нет
                </c:if>
                <c:if test="${stud.mails.size() > 0}">
                    Да
                </c:if>
            </td>
            <td>
                <c:if test="${stud.grades.size() == 0 && stud.mails.size() == 0}">
                    <form action="/studs/delete" method="post">
                        <input type="hidden" name="id" value="${stud.getId()}">
                        <input type="submit" value="Удалить" align="center" >
                    </form>
                </c:if>
            </td>
            <td>
                <form action="/studs/edit" method="get">
                    <input type="hidden" name="id" value="${stud.getId()}">
                    <input type="submit" value="Редактировать" align="center" >
                </form>
            </td>
        </tr>
    </c:forEach>
</table><br/>

<form method="post" action="/studs/add">

    <table>
        <tr>
            <td>ФИО</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>Группа</td>
                <td>
                    <select name="group.id">
                        <c:forEach items="${groups}" var="group">
                            <option value="${group.id}">${group.name}</option>
                        </c:forEach>
                    </select>
                </td>
        </tr>
    </table>

    <input type="submit" align="center" value="Добавить">

</form>

</body>
</html>