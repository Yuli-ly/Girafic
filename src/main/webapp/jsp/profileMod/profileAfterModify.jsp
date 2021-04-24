<%--@elvariable id="Student" type="by.Girafic.core.userdata.StudentViewModifyData"--%>
<%--@elvariable id="UserType" type="by.Girafic.core.userdata.UserType"--%>
<%--@elvariable id="login" type="java.lang.String"--%>
<%--@elvariable id="password" type="java.lang.String"--%>
<%--@elvariable id="id" type="java.lang.Integer"--%>
<%--
  Created by IntelliJ IDEA.
  User: anato
  Date: 18.04.2021
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>${UserType}</p>
<form action="usermodification" method="post">
    <input name="ALogin" value="${login}">
    <input name="APassword" value="${password}">
    <ul>
        <li>
            <input type="text" name="id" value="${id}">
        </li>
        <li>
            <label for="login">Логин:</label>
            <input type="text" id="login" name="Login" value="${Student.login.field}">
        </li>

        <li>
            <label for="password">Пароль:</label>
            <input type="text" id="password" name="Password" value="${Student.password.field}">
        </li>
        <li>
            <label for="name">Имя:</label>
            <input type="text" id="name" name="Name" value="${Student.fullName.field.name}">
        </li>
        <li>
            <label for="surname">Фамилия:</label>
            <input type="text" id="surname" name="Surname" value="${Student.fullName.field.surname}">
        </li>
        <li>
            <label for="patronymic">Отчество:</label>
            <input type="text" id="patronymic" name="Patronymic" value="${Student.fullName.field.patronymic}">
        </li>
        <li>
            <label for="mail">Почта:</label>
            <input type="email" id="mail" name="Mail" value="${Student.mail.field}">
        </li>
        <li>
            <label for="faculty">Факультет:</label>
            <input type="text" id="faculty" name="Faculty" value="${Student.faculty.field}">
        </li>
        <li>
            <label for="gpa">Средний балл:</label>
            <input type="text" id="gpa" name="GPA" value="${Student.gpa.field}">
        </li>
        <li>
            <label for="department">Кафедра:</label>
            <input type="text" id="department" name="Department">
        </li>
        <li>
            <label for="course">Курс:</label>
            <input type="text" id="course" name="Course" value="${Student.course.field}">
        </li>
        <li>
            <label for="group">Группа:</label>
            <input type="text" id="group" name="Group" value="${Student.group.field}">
        </li>
        <li>
            <label for="post">Должность:</label>
            <input type="text" id="post" name="Post">
        </li>
        <li>
            <input name="Type" type="text" value="student">
        </li>
        <li>
            <input type="submit" value="Подтвердить изменение">
        </li>
    </ul>
</form>
</body>
</html>
