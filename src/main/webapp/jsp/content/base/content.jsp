<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="login" type="java.lang.String"--%>
<%--@elvariable id="password" type="java.lang.String"--%>
<%--@elvariable id="BasicContent" type="by.girafic.core.contentdata.viewmodification.ContentViewModifyData"--%>
<%--@elvariable id="Modification" type="bolean"--%>
<%--@elvariable id="type" type="java.lang.String"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<input type="hidden" name="login" value="${login}">
<input type="hidden" name="password" value="${password}">
<input type="hidden" name="Type" value="${type}">
<input type="hidden" name="id" value="${BasicContent.id}">
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