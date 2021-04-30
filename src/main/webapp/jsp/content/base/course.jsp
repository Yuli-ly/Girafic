<%@ page import="by.girafic.core.contentdata.viewmodification.CourseViewModifyData" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="login" type="String"--%>
<%--@elvariable id="password" type="String"--%>
<%--@elvariable id="Course" type="by.girafic.core.contentdata.viewmodification.CourseViewModifyData"--%>
<%--@elvariable id="Content" type="by.girafic.core.contentdata.ContentLinkData[]"--%>
<%--@elvariable id="Users" type="by.girafic.core.userdata.UserLinkData[]"--%>
<%--@elvariable id="CurrentContent" type="java.util.List"--%>
<%--@elvariable id="CurrentUsers" type="java.util.List"--%>

<input type="hidden" name="login" value="${login}">
<input type="hidden" name="password" value="${password}">
<input type="hidden" name="Type" value="material">
<input type="hidden" name="id" value="${Course.id}">
<ul>
    <li>
        <label for="title">Название</label>
        <textarea id="title" name="Title">${Course.title.value}</textarea>
    </li>
    <li>
        <label for="description">Описание</label>
        <textarea id="description" name="Description">${Course.description.value}</textarea>
    </li>
</ul>
<h2>Содержание курса</h2>
<ul>
    <%
        CourseViewModifyData course = (CourseViewModifyData) request.getAttribute("Course");

        if(course!=null)
        {
            request.setAttribute("CurrentContent",
                    Arrays.stream(course.sections)
                            .boxed()
                            .collect(Collectors.toList()));
            request.setAttribute("CurrentUsers",
                    Arrays.stream(course.users)
                            .boxed()
                            .collect(Collectors.toList()));
        }
        else
        {
            request.setAttribute("CurrentContent", new ArrayList<Integer>());
            request.setAttribute("CurrentUsers",new ArrayList<Integer>());
        }
    %>
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
                   name="Content"
                   value="${Element.id}"
            <c:if test="${CurrentUsers.contains(Element.id)}">
                   checked
            </c:if>></label>
        </li>
    </c:forEach>
</ul>
