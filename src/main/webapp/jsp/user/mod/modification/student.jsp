<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="path" type="java.lang.String"--%>
<html>
<head>
    <title>Изменение студента</title>
    <link rel="stylesheet" href="${path}/jsp/styles.css">
</head>
<body>
<jsp:include page="../../../navigation.jsp"/>
<form action="userModification" method="post">
    <input type="hidden" name="Type" value="student">
    <jsp:include page="../base/student.jsp"/>
    <input type="submit" class="btn" value="Изменить">
</form>
<jsp:include page="remove.jsp"/>
</body>
</html>
