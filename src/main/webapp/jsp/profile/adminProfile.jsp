<%@page import="by.Girafic.core.userdata.AdminViewData" %>
<%@ page import="static by.Girafic.controllers.util.JspUtil.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String path = request.getContextPath();
%>
<%--@elvariable id="Admin" type="by.Girafic.core.userdata.AdminViewData"--%>

<html>
<head>
    <title>Профиль</title>
</head>
<body>

<a href="<%=registrationLink(path)%>">Регистрация</a>
<form action="usermodification" method="get">
    <input type="text" name="login" value="${login}">
    <input type="text" name="password" value="${password}">
    <input type="text" name="id">
    <input type="submit" name="Изменить пользователя">
</form>

</body>
</html>
