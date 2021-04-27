<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="path" type="String"--%>
<%
    request.setAttribute("path",request.getServletContext().getContextPath());
    request.setAttribute("login",request.getParameter("login"));
    request.setAttribute("password",request.getParameter("password"));
%>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<form action="${path}/registration" method="post">
    <jsp:include page="userInputForm.jsp"></jsp:include>
    <li>
        <label for="gpa">Средний балл:</label>
        <input type="text" id="gpa" name="GPA">
    </li>
    <li>
        <label for="department">Кафедра:</label>
        <input type="text" id="department" name="Department">
    </li>
    <li>
        <label for="course">Курс:</label>
        <input type="text" id="course" name="Course">
    </li>
    <li>
        <label for="group">Группа:</label>
        <input type="text" id="group" name="Group">
    </li>
    <li>
        <label for="post">Должность:</label>
        <input type="text" id="post" name="Post">
    </li>
    <li>
        <p><input name="Type" type="radio" value="student">Студент</p>
        <p><input name="Type" type="radio" value="teacher">Преподаватель</p>
        <p><input name="Type" type="radio" value="admin">Админ</p>
    </li>
    <li>
        <input type="submit" value="Регистрация">
    </li>
    </ul>
</form>
</body>
</html>
