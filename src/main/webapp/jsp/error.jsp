<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="Message" type="java.lang.String"--%>
<% request.setCharacterEncoding("UTF-8");%>

<html>
<head>
    <meta charset="utf-8">
    <title>Error</title>
</head>
<body>
<h1>Ошибка</h1>
<c:out value="${Message}"/>
</body>
</html>
