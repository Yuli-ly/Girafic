<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%--@elvariable id="Teacher" type="by.girafic.core.userdata.viewmodification.TeacherViewModifyData"--%>
<%--@elvariable id="Modification" type="java.lang.Boolean"--%>
<input type="hidden" name="Type" value="teacher">
<jsp:include page="user.jsp"/>
<ul>
    <t:ufield id="post" name="Post" title="Должность" modc="${Teacher.post}" modification="${Modification}"/>
</ul>
<h2>Доступный контент</h2>
<jsp:include page="../../../content/base/contentList.jsp"/>
