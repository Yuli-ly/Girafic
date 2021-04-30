<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Создание преподавателя</title>
</head>
<body>
<jsp:include page="../../../navigation.jsp"/>
<form action="registration" method="post">
    <jsp:include page="../base/teacher.jsp"/>
    <input type="submit" value="Создать">
</form>
</body>
</html>
