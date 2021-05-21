<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="path" type="java.lang.String"--%>
<html>
<head>
    <title>Создание админа</title>
    <link rel="stylesheet" href="${path}/jsp/styles.css">
</head>
<body>
<jsp:include page="../../../navigation.jsp"/>
<form action="registration" method="post">
    <jsp:include page="../base/admin.jsp"/>
    <input type="submit" class="btn" value="Создать">
</form>
</body>
</html>
