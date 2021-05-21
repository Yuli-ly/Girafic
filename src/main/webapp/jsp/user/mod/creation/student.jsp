<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="path" type="java.lang.String"--%>
<html>
<head>
    <title>Создание студента</title>
    <link rel="stylesheet" href="${path}/jsp/styles.css">
</head>
<body>
<jsp:include page="../../../navigation.jsp"/>
<form action="registration" method="post">
    <jsp:include page="../base/student.jsp"/>
    <input type="submit" class="btn" value="Создать">
</form>
</body>
</html>
