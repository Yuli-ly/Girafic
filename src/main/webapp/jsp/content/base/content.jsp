<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="BasicContent" type="by.girafic.core.contentdata.viewmodification.ContentViewModifyData"--%>
<%--@elvariable id="Modification" type="bolean"--%>
<%--@elvariable id="type" type="java.lang.String"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="input.jsp"/>
<input type="hidden" name="Type" value="${type}">
<ul>
    <c:set var="id" scope="request" value="title"/>
    <c:set var="name" scope="request" value="Title"/>
    <c:set var="title" scope="request" value="Название"/>
    <c:set var="modc" scope="request" value="${BasicContent.title}"/>
    <jsp:include page="field.jsp"/>

    <c:set var="id" scope="request" value="description"/>
    <c:set var="name" scope="request" value="Description"/>
    <c:set var="title" scope="request" value="Описание"/>
    <c:set var="modc" scope="request" value="${BasicContent.description}"/>
    <jsp:include page="field.jsp"/>
</ul>