<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="Course" type="by.girafic.core.contentdata.view.CourseViewData"--%>
<%--@elvariable id="LoginData" type="by.girafic.core.commonds.LoginData"--%>
<%--@elvariable id="LinkMaker" type="by.girafic.controllers.request.RequestWrapper.LinkMaker"--%>
<html>
<head>
    <title>Курс</title>
</head>
<body>
<jsp:include page="../../navigation.jsp"/>
<h1>${Course.title}</h1>
<p>${Course.description}</p>
<h2>Содержание</h2>
<ul>
    <c:forEach var="Element" items="${Course.sections}">
        <li>
            <h3>
                <a href="${LinkMaker.content(Element.id)}">${Element.title}</a>
            </h3>
            <p>${Element.description}</p>
            <ul>
                <c:forEach var="C" items="${Element.contents}">
                    <a href="${LinkMaker.content(C.id)}">${C.title}</a>
                    <p>${C.description}</p>
                </c:forEach>
            </ul>
        </li>
    </c:forEach>
</ul>
<h2>Пользователи</h2>
<ul>
    <c:forEach var="U" items="${Course.users}">
        <li>
            <a href="${LinkMaker.user(U.id)}">${U.name}</a>
        </li>
    </c:forEach>
</ul>
</body>
</html>
