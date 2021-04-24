<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="Admin" type="by.Girafic.core.userdata.AdminViewModifyData"--%>
<%--@elvariable id="path" type="String"--%>
<html>
<head>
    <title>Изменение админа</title>
</head>
<body>
<form action="${path}/userModification" method="post">
    <input type="hidden" name="Type" value="admin">
    <ul>
        <jsp:include page="userInputForm.jsp"></jsp:include>
    </ul>
    <input type="submit" value="Подтвердить">
</form>
</body>
</html>
