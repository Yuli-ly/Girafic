<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag pageEncoding="UTF-8" %>
<%@ attribute name="id" required="true" rtexprvalue="false" type="java.lang.String" %>
<%@ attribute name="name" required="true" rtexprvalue="false" type="java.lang.String"%>
<%@ attribute name="title" required="true" rtexprvalue="false" type="java.lang.String" %>
<%@ attribute name="modc" required="true" rtexprvalue="true" type="by.girafic.core.commonds.ModifyConfirmation" %>
<%@ attribute name="modification" required="true" rtexprvalue="true" type="java.lang.Boolean" %>
<%--@elvariable id="id" type="java.lang.String"--%>
<%--@elvariable id="name" type="java.lang.String"--%>
<%--@elvariable id="title" type="java.lang.String"--%>
<%--@elvariable id="Modification" type="java.lang.Boolean"--%>
<%--@elvariable id="style" type="java.lang.String"--%>
<%--@elvariable id="modc" type="by.girafic.core.commonds.ModifyConfirmation"--%>
<li>
    <c:choose>
        <c:when test="${Modification && modc.success}">
            <c:set var="style" scope="page" value="color:green"/>
        </c:when>
        <c:when test="${Modification && !modc.success}">
            <c:set var="style" scope="page" value="color:red"/>
        </c:when>
        <c:otherwise>
            <c:set var="style" scope="page" value="color:black"/>
        </c:otherwise>
    </c:choose>
    <label for="${id}">${title}</label>
    <textarea id="${id}" name="${name}" style="${style}">${modc.value}</textarea>
    <c:if test="${Modification && !modc.success}">
        <p>${modc.message}</p>
    </c:if>
</li>
