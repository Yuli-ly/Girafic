<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="Student" type="by.girafic.core.userdata.view.StudentViewData"--%>
<%--@elvariable id="LinkMaker" type="by.girafic.controllers.request.RequestWrapper.LinkMaker"--%>
<%--@elvariable id="path" type="java.lang.String"--%>
<jsp:include page="../../../navigation.jsp"/>
  <jsp:include page="user.jsp"/>
<div class="container">
  <div class class="info">
    <p>Группа: ${Student.group}</p>
    <p>Курс: ${Student.course}</p>
    <p>Средний балл: ${Student.gpa}</p>
    <p>Кафедра: ${Student.department}</p>

  </div>
</div>
<div class="courses">
  <div class="cards">
  <c:forEach var="Element" items="${Student.courses}">
    <div class="card">
      <img src="${path}/jsp/img/course.png"/>
      <a href="${LinkMaker.content(Element.id)}">${Element.name}</a>
    </div>
  </c:forEach>
  </div>
</div>