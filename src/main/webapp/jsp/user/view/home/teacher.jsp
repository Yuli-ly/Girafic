<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="LinkMaker" type="by.girafic.controllers.request.RequestWrapper.LinkMaker"--%>
<%--@elvariable id="Teacher" type="by.girafic.core.userdata.view.TeacherViewData"--%>
<%--@elvariable id="path" type="java.lang.String"--%>
<html>
<head>
    <title>Домашняя страницы</title>
  <link rel="stylesheet" href="${path}/jsp/styles.css">
</head>
<body>
<jsp:include page="../base/teacher.jsp"/>
Доступный контент:
<ul>
  <c:forEach var="Element" items="${Teacher.availableContent}">
    <li>
      <a href="${LinkMaker.content(Element.id)}">${Element.name}</a>
      <a href="${LinkMaker.contentMod(Element.id)}">Редактировать</a>
    </li>
  </c:forEach>
</ul>
<div>
<button href="${LinkMaker.courseCreation()}" class="btn">Создать курс</button>
<button href="${LinkMaker.sectionCreation()}" class="btn">Создать раздел</button>
<button href="${LinkMaker.materialCreation()}" class="btn">Создать материал</button>
</div>
</body>
</html>
