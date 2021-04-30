<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="Student" type="by.girafic.core.userdata.view.StudentViewData"--%>
<%--@elvariable id="LinkMaker" type="by.girafic.controllers.request.RequestWrapper.LinkMaker"--%>

<jsp:include page="../../../navigation.jsp"/>
<p>
  <jsp:include page="user.jsp"/>
  Группа: ${Student.group}<br>
  Курс: ${Student.course}<br>
  Средний балл: ${Student.gpa}<br>
  Кафедра: ${Student.department}<br>
  Курсы:
<ul>
  <c:forEach var="Element" items="${Student.courses}">
    <li>
      <a href="${LinkMaker.content(Element.id)}">${Element.name}</a>
    </li>
  </c:forEach>
</ul>
</p>