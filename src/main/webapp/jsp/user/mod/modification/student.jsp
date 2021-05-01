<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Изменение студента</title>
</head>
<body>
<jsp:include page="../../../navigation.jsp"/>
<form action="userModification" method="post">
    <input type="hidden" name="Type" value="student">
    <jsp:include page="../base/student.jsp"/>
    <input type="submit" value="Изменить">
</form>
<jsp:include page="remove.jsp"/>
</body>
</html>
