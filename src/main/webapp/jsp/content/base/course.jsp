<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="Course" type="by.girafic.core.contentdata.viewmodification.CourseViewModifyData"--%>
<%--@elvariable id="Content" type="by.girafic.core.contentdata.ContentLinkData[]"--%>
<%--@elvariable id="Users" type="by.girafic.core.userdata.UserLinkData[]"--%>
<%--@elvariable id="CurrentContent" type="java.util.List"--%>
<%--@elvariable id="CurrentUsers" type="java.util.List"--%>
<jsp:include page="content.jsp"/>
<h2>Содержание курса</h2>
<ul>
    <c:forEach var="Element" items="${Content}">
        <li><label>${Element.name}
            <input type="checkbox"
                   name="Content"
                   value="${Element.id}"
            <c:if test="${CurrentContent.contains(Element.id)}">
                   checked
            </c:if>></label>
        </li>
    </c:forEach>
</ul>
<h2>Пользователи</h2>
<ul>
    <c:forEach var="Element" items="${Users}">
        <li><label>${Element.name}
            <input type="checkbox"
                   name="Users"
                   value="${Element.id}"
            <c:if test="${CurrentUsers.contains(Element.id)}">
                   checked
            </c:if>></label>
        </li>
    </c:forEach>
</ul>
