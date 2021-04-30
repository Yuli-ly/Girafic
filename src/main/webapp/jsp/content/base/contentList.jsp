<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="Content" type="by.girafic.core.contentdata.ContentLinkData[]"--%>
<%--@elvariable id="CurrentContent" type="java.util.List"--%>

<ul>
    <c:forEach var="Element" items="${Content}">
        <li>
            <label>${Element.name}
            <input type="checkbox"
                   name="Content"
                   value="${Element.id}"
            <c:if test="${CurrentContent.contains(Element.id)}">
                   checked
            </c:if>></label>
        </li>
    </c:forEach>
</ul>
