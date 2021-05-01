<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="Teacher" type="by.girafic.core.userdata.viewmodification.TeacherViewModifyData"--%>
<input type="hidden" name="Type" value="teacher">
<jsp:include page="user.jsp"/>
<ul>
    <c:set var="id" scope="request" value="post"/>
    <c:set var="name" scope="request" value="Post"/>
    <c:set var="title" scope="request" value="Должность"/>
    <c:set var="modc" scope="request" value="${Teacher.post}"/>
    <jsp:include page="field.jsp"/>
</ul>
<h2>Доступный контент</h2>
<jsp:include page="../../../content/base/contentList.jsp"/>
