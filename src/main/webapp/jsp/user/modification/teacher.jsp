<%@ page import="by.girafic.controllers.util.JspRequestParser" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="Teacher" type="by.girafic.core.userdata.TeacherViewModifyData"--%>
<%--@elvariable id="path" type="String"--%>
<%
    JspRequestParser parser = new JspRequestParser(request);
%>
<html>
<head>
    <title>Изменение преподавателья</title>
</head>
<body>
<form action="${path}/userModification" method="post">
    <input type="hidden" name="Type" value="teacher">
    <ul>
        <jsp:include page="../creation/userInputForm.jsp"></jsp:include>
        <li>
            <label for="department">Кафедра:</label>
            <input type="text" id="department" name="Department" value="${Teacher.department.value}">
        </li>
        <li>
            <label for="post">Должность:</label>
            <input type="text" id="post" name="Post" value="${Teacher.post.success}">
        </li>
    </ul>
    <input type="submit" value="Подтвердить">
</form>
</body>
</html>
