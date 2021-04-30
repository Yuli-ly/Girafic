<%@ page import="by.girafic.controllers.util.JspRequestParser" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    JspRequestParser parser = new JspRequestParser(request);
    parser.takeAdmin();
%>
<%--@elvariable id="Admin" type="by.girafic.core.userdata.view.AdminViewData"--%>
<%--@elvariable id="login" type="String"--%>
<%--@elvariable id="password" type="String"--%>
<html>
<head>
    <title>Профиль</title>
</head>
<body>
<p><jsp:include page="user.jsp"/></p>

<form action="userModification" method="get">
    <input type="text" name="login" value="${login}">
    <input type="text" name="password" value="${password}">
    <input type="text" name="id">
    <input type="submit" name="Изменить пользователя">
</form>

<a href="<%=parser.studentCreationLink()%>">Зарегестрировать студента</a>
<a href="<%=parser.teacherCreationLink()%>">Зарегестрировать преподавателя</a>
<a href="<%=parser.adminCreationLink()%>">Зарегестрировать админа</a>


</body>
</html>
