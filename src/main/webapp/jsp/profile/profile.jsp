<%@ page import="by.Girafic.core.commonds.UserType" %>
<%@ page import="by.Girafic.core.userdata.StudentViewData" %>
<%@ page import="static by.Girafic.controllers.util.JspUtil.createLinkToContent" %>
<%@ page import="by.Girafic.core.userdata.TeacherViewData" %>

<%--@elvariable id="UserType" type="by.Girafic.core.commonds.UserType"--%>
<%--@elvariable id="Student" type="by.Girafic.core.userdata.StudentViewData"--%>
<%--@elvariable id="Teacher" type="by.Girafic.core.userdata.TeacherViewData"--%>
<%--@elvariable id="Admin" type="by.Girafic.core.userdata.AdminViewData"--%>
<%--@elvariable id="user" type="by.Girafic.core.userdata.UserViewData"--%>
<%--@elvariable id="login" type="java.lang.String"--%>
<%--@elvariable id="password" type="java.lang.String"--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%
    String path = request.getContextPath();

    switch ((UserType) request.getAttribute("UserType"))
    {
        case Student:
            request.setAttribute("user",request.getAttribute("Student"));
            break;
        case Teacher:
            request.setAttribute("user",request.getAttribute("Teacher"));
            break;
        case Admin:
            request.setAttribute("user",request.getAttribute("Admin"));
            break;
    }
    String login = (String) request.getAttribute("login");
    String password = (String) request.getAttribute("password");
%>


<!DOCTYPE html>
<html>
<head>
	<title>Профиль</title>
	
	<link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div class="info">
        <p>${UserType}</p>
        <p>${user.mail}</p>
        <p>${user.fullName}</p>
        <p>${user.faculty}</p>
        <p>${user.id}</p>
    </div>
</body>
</html>
