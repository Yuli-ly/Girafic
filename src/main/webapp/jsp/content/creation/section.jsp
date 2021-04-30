<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="path" type="String"--%>

<html>
<head>
    <title>Создание раздела</title>
</head>
<body>
<form action="contentCreation" method="post">
    <jsp:include page="../base/section.jsp"/>
    <input type="submit" value="Создать">
</form>
</body>
</html>
