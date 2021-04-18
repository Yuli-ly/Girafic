<%--@elvariable id="UserType" type="java.lang.String"--%>
<%--@elvariable id="FullName" type="by.Girafic.core.userdata.FullName"--%>
<%--@elvariable id="Mail" type="java.lang.String"--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

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
</body>
</html>
