<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="login" type="java.lang.String"--%>
<%--@elvariable id="password" type="java.lang.String"--%>
<%--@elvariable id="User" type="by.Girafic.core.userdata.UserViewModifyData"--%>

<input type="hidden" name="ALogin" value="${login}">
<input type="hidden" name="APassword" value="${password}">
<input type="hidden" name="id" value="${User.id}">
<li>
    <label for="login">Логин:</label>
    <input type="text" id="login" name="login" value="${User.login.field}">
</li>

<li>
    <label for="password">Пароль:</label>
    <input type="text" id="password" name="password" value="${User.password.field}">
</li>
<li>
    <label for="name">Имя:</label>
    <input type="text" id="name" name="Name" value="${User.fullName.field.name}">
</li>
<li>
    <label for="surname">Фамилия:</label>
    <input type="text" id="surname" name="Surname" value="${User.fullName.field.surname}">
</li>
<li>
    <label for="patronymic">Отчество:</label>
    <input type="text" id="patronymic" name="Patronymic" value="${User.fullName.field.patronymic}">
</li>
<li>
    <label for="mail">Почта:</label>
    <input type="email" id="mail" name="Mail" value="${User.mail.field}">
</li>
<li>
    <label for="faculty">Факультет:</label>
    <input type="text" id="faculty" name="Faculty" value="${User.faculty.field}">
</li>