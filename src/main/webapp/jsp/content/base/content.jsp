<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="BasicContent" type="by.girafic.core.contentdata.viewmodification.ContentViewModifyData"--%>
<%--@elvariable id="Modification" type="java.lang.Boolean"--%>
<%--@elvariable id="type" type="java.lang.String"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<jsp:include page="input.jsp"/>
<input type="hidden" name="Type" value="${type}">
<ul>
    <t:cfield id="title" name="Title" title="Название" modc="${BasicContent.title}" modification="${Modification}"/>
    <t:cfield id="description" name="Description" title="Описание" modc="${BasicContent.description}" modification="${Modification}"/>
</ul>