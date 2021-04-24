<%@page import="by.Girafic.core.userdata.AdminViewData" %>
<%@ page import="by.Girafic.controllers.util.JspRequestParser" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    JspRequestParser parser = new JspRequestParser(request);
    AdminViewData admin = parser.takeAdmin();
%>
<%--@elvariable id="Admin" type="by.Girafic.core.userdata.AdminViewData"--%>
<%--@elvariable id="LoginData" type="by.Girafic.core.commonds.LoginData"--%>
<html>
<head>
    <title>Профиль</title>
</head>
<body>
<p><jsp:include page="userData.jsp"></jsp:include></p>

<a href="<%=parser.registrationLink()%>">Регистрация</a>
<form action="userModification" method="get">
    <input type="text" name="login" value="${LoginData.login}">
    <input type="text" name="password" value="${LoginData.login}">
    <input type="text" name="id">
    <input type="submit" name="Изменить пользователя">
</form>

</body>
</html>
