<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="Material" type="by.girafic.core.contentdata.viewmodification.MaterialViewModifyData"--%>
<%--@elvariable id="Modification" type="java.lang.Boolean"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<jsp:include page="content.jsp"/>
<ul>
    <t:cfield id="filling" name="Filling" title="Содержание" modc="${Material.filling}" modification="${Modification}"/>
</ul>