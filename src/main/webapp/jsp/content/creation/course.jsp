<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Создание курса</title>
</head>
<body>
<jsp:include page="../../navigation.jsp"/>
<form action="contentCreation" method="post">
    <jsp:include page="../base/course.jsp"/>
    <input type="submit" value="Создать">
</form>
</body>
</html>
