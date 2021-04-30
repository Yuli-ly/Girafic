<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="LinkMaker" type="by.girafic.controllers.request.RequestWrapper.LinkMaker"--%>
<%--@elvariable id="Teacher" type="by.girafic.core.userdata.view.TeacherViewData"--%>

<jsp:include page="../../../navigation.jsp"/>
<p>
  <jsp:include page="user.jsp"/>
  Кафедра: ${Teacher.department}<br>
  Должность: ${Teacher.post}<br>
</p>
Курсы:
<ul>
  <c:forEach var="Element" items="${Teacher.courses}">
    <li>
      <a href="${LinkMaker.content(Element.id)}">${Element.name}</a>
    </li>
  </c:forEach>
</ul>