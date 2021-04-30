<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="Student" type="by.girafic.core.userdata.viewmodification.StudentViewModifyData"--%>

<input type="hidden" name="Type" value="student">
<jsp:include page="user.jsp"/>
<ul>
    <li>
        <label for="gpa">Средний балл:</label>
        <input type="text" id="gpa" name="GPA" value="${Student.gpa.value}">
    </li>
    <li>
        <label for="department">Кафедра:</label>
        <input type="text" id="department" name="Department" value="${Student.department.value}">
    </li>
    <li>
        <label for="course">Курс:</label>
        <input type="text" id="course" name="Course" value="${Student.course.value}">
    </li>
    <li>
        <label for="group">Группа:</label>
        <input type="text" id="group" name="Group" value="${Student.group.value}">
    </li>
</ul>

<h2>Курсы</h2>
<jsp:include page="../../content/base/contentList.jsp"/>
