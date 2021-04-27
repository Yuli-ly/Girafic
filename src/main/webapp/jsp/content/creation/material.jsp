<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="login" type="String"--%>
<%--@elvariable id="password" type="String"--%>
<%--@elvariable id="path" type="String"--%>
<%
    String path = request.getServletContext().getContextPath();
    request.setAttribute("path",path);
%>
<html>
<head>
    <title>Создание материала</title>
</head>
<body>
<form action="${path}/contentCreation" method="post">
    <jsp:include page="baseMaterial.jsp"/>
    <input type="submit" value="Создать">
</form>
</body>
</html>
