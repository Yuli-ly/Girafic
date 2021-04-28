<%@ page import="by.girafic.core.contentdata.viewmodification.SectionViewModifyData" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="login" type="String"--%>
<%--@elvariable id="password" type="String"--%>
<%--@elvariable id="Content" type="by.girafic.core.contentdata.ContentLinkData[]"--%>
<%--@elvariable id="Section" type="by.girafic.core.contentdata.viewmodification.SectionViewModifyData"--%>
<%--@elvariable id="CurrentContent" type="java.util.List"--%>
<input type="hidden" name="login" value="${login}">
<input type="hidden" name="password" value="${password}">
<input type="hidden" name="Type" value="section">
<input type="hidden" name="id" value="${Section.id}">
<ul>
    <li>
        <label for="title">Название</label>
        <textarea id="title" name="Title">${Section.title.value}</textarea>
    </li>
    <li>
        <label for="description">Описание</label>
        <textarea id="description" name="Description">${Section.description.value}</textarea>
    </li>
</ul>
<h2>Содержание раздела</h2>
<ul>
    <%
        SectionViewModifyData section = (SectionViewModifyData) request.getAttribute("Section");
        if(section!=null)
            request.setAttribute("CurrentContent",
                    Arrays.stream(section.contents)
                            .boxed()
                            .collect(Collectors.toList()));
        else
            request.setAttribute("CurrentContent",new ArrayList<Integer>());


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
