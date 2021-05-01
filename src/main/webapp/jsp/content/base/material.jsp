<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="Material" type="by.girafic.core.contentdata.viewmodification.MaterialViewModifyData"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="content.jsp"/>
<ul>
    <c:set var="id" scope="request" value="filling"/>
    <c:set var="name" scope="request" value="Filling"/>
    <c:set var="title" scope="request" value="Содержание"/>
    <c:set var="modc" scope="request" value="${Material.filling}"/>
    <jsp:include page="field.jsp"/>
</ul>