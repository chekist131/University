<%--
  Created by IntelliJ IDEA.
  User: Антон
  Date: 15.05.2016
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Редактировать почту студента</title>
</head>
<body>
<a href="../index.jsp">Главная страница</a>
<form action="/studmails/edit" method="post">

    <table>
        <tr>
            <td>Почта</td>
            <td><input type="text" name="value" value="${studmail.value}"></td>
        </tr>
        <tr>
            <td>Студент</td>
            <td>
                <select name="student.id">
                    <c:forEach items="${studs}" var="stud">
                        <option value="${stud.id}" ${studmail.student.id == stud.id ? "selected" : ""} >${stud.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </table>

    <input type="hidden" name="id" value="${studmail.id}">
    <input type="submit" value="Изменить" align="center" >

</form>
</body>
</html>
