<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Изменение админа</title>
</head>
<body>
<jsp:include page="../../../navigation.jsp"/>
<form action="userModification" method="post">
    <jsp:include page="../base/admin.jsp"/>
    <input type="submit" value="Подтвердить">
</form>
</body>
</html>
