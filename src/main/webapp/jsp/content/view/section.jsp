<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="Section" type="by.girafic.core.contentdata.view.SectionViewData"--%>
<html>
<head>
    <title>Раздел</title>
</head>
<body>
<jsp:include page="../../navigation.jsp"/>
<h1>${Section.title}</h1>
<p>${Section.description}</p>
<ul>
    <c:forEach var="Element" items="${Section.contents}">
        <li>
            <a href="${LinkMaker.content(Element.id)}">${Element.title}</a>
            <p>${Element.description}</p>
        </li>
    </c:forEach>
</ul>
</body>
</html>
