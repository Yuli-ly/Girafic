<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Изменение преподавателя</title>
</head>
<body>
<jsp:include page="../../../navigation.jsp"/>
<form action="userModification" method="post">
    <jsp:include page="../base/teacher.jsp"/>
    <input type="submit" value="Подтвердить">
</form>
<jsp:include page="remove.jsp"/>
</body>
</html>
