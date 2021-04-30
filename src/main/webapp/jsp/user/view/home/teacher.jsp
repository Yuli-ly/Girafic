<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="LinkMaker" type="by.girafic.controllers.request.RequestWrapper.LinkMaker"--%>
<%--@elvariable id="Teacher" type="by.girafic.core.userdata.view.TeacherViewData"--%>

<html>
<head>
    <title>Домашняя страницы</title>
</head>
<body>
<jsp:include page="../base/teacher.jsp"/>
Доступный контент:
<ul>
  <c:forEach var="Element" items="${Teacher.availableContent}">
    <li>
      <a href="${LinkMaker.content(Element.id)}">${Element.name}</a>
    </li>
  </c:forEach>
</ul>
<a href="${LinkMaker.courseCreation()}">Создать курс</a>
<br>
<a href="${LinkMaker.sectionCreation()}">Создать раздел</a>
<br>
<a href="${LinkMaker.materialCreation()}">Создать материал</a>
</body>
</html>
