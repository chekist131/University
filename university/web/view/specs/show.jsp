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
    <title>Специализации</title>
</head>
<body>
<a href="../index.jsp">Главная страница</a>
<br/>
<table border="1">
    <tr>
        <td>Специализация</td>
        <td><a href="/groups/show">Группы</a></td>
        <td>Удалить</td>
        <td>Редактировать</td>
    </tr>
    <c:forEach items="${models}" var="model" varStatus="status">
        <tr>
            <td>${model.getName()}</td>
            <td>
                <c:if test="${model.getGroups().size() == 0}">
                    Нет
                </c:if>
                <c:if test="${model.getGroups().size() > 0}">
                    Да
                </c:if>
            </td>
            <td>
                <c:if test="${model.getGroups().size() == 0}">
                    <form action="/specs/delete" method="post">
                        <input type="hidden" name="id" value="${model.getId()}">
                        <input type="submit" value="Удалить" align="center" >
                    </form>
                </c:if>
            </td>
            <td>
                <form action="/specs/edit" method="get">
                    <input type="hidden" name="id" value="${model.getId()}">
                    <input type="submit" value="Редактировать" align="center" >
                </form>
            </td>
        </tr>
    </c:forEach>
</table><br/>
<form action="/specs/add" method="post">
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