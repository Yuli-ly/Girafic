<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="Student" type="by.girafic.core.userdata.viewmodification.StudentViewModifyData"--%>
<input type="hidden" name="Type" value="student">
<jsp:include page="user.jsp"/>
<ul>
    <c:set var="id" scope="request" value="gpa"/>
    <c:set var="name" scope="request" value="GPA"/>
    <c:set var="title" scope="request" value="Средний балл"/>
    <c:set var="modc" scope="request" value="${Student.gpa}"/>
    <jsp:include page="field.jsp"/>

    <c:set var="id" scope="request" value="department"/>
    <c:set var="name" scope="request" value="Department"/>
    <c:set var="title" scope="request" value="Кафедра"/>
    <c:set var="modc" scope="request" value="${Student.department}"/>
    <jsp:include page="field.jsp"/>

    <c:set var="id" scope="request" value="course"/>
    <c:set var="name" scope="request" value="Course"/>
    <c:set var="title" scope="request" value="Курс"/>
    <c:set var="modc" scope="request" value="${Student.course}"/>
    <jsp:include page="field.jsp"/>

    <c:set var="id" scope="request" value="group"/>
    <c:set var="name" scope="request" value="Group"/>
    <c:set var="title" scope="request" value="Группа"/>
    <c:set var="modc" scope="request" value="${Student.group}"/>
    <jsp:include page="field.jsp"/>

</ul>

<h2>Курсы</h2>
<jsp:include page="../../../content/base/contentList.jsp"/>
