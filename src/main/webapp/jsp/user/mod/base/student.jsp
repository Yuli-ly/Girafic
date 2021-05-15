<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%--@elvariable id="Student" type="by.girafic.core.userdata.viewmodification.StudentViewModifyData"--%>
<%--@elvariable id="Modification" type="java.lang.Boolean"--%>
<input type="hidden" name="Type" value="student">
<jsp:include page="user.jsp"/>
<ul>
    <t:ufield id="gpa" name="GPA" title="Средний балл" modc="${Student.gpa}" modification="${Modification}"/>
    <t:ufield id="department" name="Department" title="Кафедра" modc="${Student.department}" modification="${Modification}"/>
    <t:ufield id="course" name="Course" title="Курс" modc="${Student.course}" modification="${Modification}"/>
    <t:ufield id="group" name="Group" title="Группа" modc="${Student.group}" modification="${Modification}"/>
</ul>

<h2>Курсы</h2>
<jsp:include page="../../../content/base/contentList.jsp"/>
