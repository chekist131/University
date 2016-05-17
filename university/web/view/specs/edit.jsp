<%--
  Created by IntelliJ IDEA.
  User: Антон
  Date: 15.05.2016
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактировать специализацию</title>
</head>
<body>
<a href="../index.jsp">Главная страница</a>
<form action="/specs/edit" method="post">
    <table>
        <tr>
            <td>Название</td>
            <td><input type="text" name="name" value="${model.getName()}"></td>
        </tr>
    </table>
    <input type="hidden" name="id" value="${model.id}">
    <input type="submit" value="Изменить" align="center" >
</form>
</body>
</html>
