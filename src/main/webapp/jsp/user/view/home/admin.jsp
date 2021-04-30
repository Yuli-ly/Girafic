<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="Admin" type="by.girafic.core.userdata.view.AdminViewData"--%>
<%--@elvariable id="login" type="String"--%>
<%--@elvariable id="password" type="String"--%>
<%--@elvariable id="LinkMaker" type="by.girafic.controllers.request.RequestWrapper.LinkMaker"--%>
<html>
<head>
    <title>Домашняя страницы</title>
</head>
<body>
<jsp:include page="../base/admin.jsp"/>

<form action="userModification" method="get">
  <input type="text" name="login" value="${login}">
  <input type="text" name="password" value="${password}">
  <input type="text" name="id">
  <input type="submit" name="Изменить пользователя">
</form>

<a href="${LinkMaker.studentCreation()}">Зарегестрировать студента</a>
<a href="${LinkMaker.teacherCreation()}">Зарегестрировать преподавателя</a>
<a href="${LinkMaker.adminCreation()}">Зарегестрировать админа</a>
</body>
</html>
