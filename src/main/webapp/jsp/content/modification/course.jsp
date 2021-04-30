<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Изменение курса</title>
</head>
<body>
<jsp:include page="../../navigation.jsp"/>
<form action="contentModification" method="post">
    <jsp:include page="../base/course.jsp"/>
    <input type="submit" value="Изменить">
</form>
</body>
</html>
