<%--@elvariable id="UserType" type="java.lang.String"--%>
<%--@elvariable id="FullName" type="by.Girafic.core.userdata.FullName"--%>
<%--@elvariable id="Mail" type="java.lang.String"--%>
<%--@elvariable id="login" type="java.lang.String"--%>
<%--@elvariable id="password" type="java.lang.String"--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="https://java.sun.com/jsp/jstl/core" %>


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
        <p>${FullName}</p>
        <p>${Mail}</p>

    </div>
    <div class="btn">
        <button>Выход</button>
        <button>Курсы</button>
    </div>
    <a href="${pageContext.request.contextPath}/registrationTest.html">Регистрация</a>
    <form action="usermodification" method="get">
        <input type="text" name="login" value="${login}">
        <input type="text" name="password" value="${password}">
        <input type="text" name="id">
        <input type="submit" name="Изменить пользователя">

    </form>
</body>
</html>
