<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="path" type="String"--%>
<html>
<head>
    <title>Изменение материала</title>
</head>
<body>
<jsp:include page="../../navigation.jsp"/>
<form method="post" action="contentModification">
    <jsp:include page="../base/material.jsp"/>
    <input type="submit" value="Изменить">
</form>
</body>
</html>
