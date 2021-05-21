<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%--@elvariable id="User" type="by.girafic.core.userdata.viewmodification.UserViewModifyData"--%>
<%--@elvariable id="Modification" type="java.lang.Boolean"--%>
<%--@elvariable id="path" type="java.lang.String"--%>
<jsp:include page="input.jsp"/>
<div class="container">
    <t:ufield id="login" name="login" title="Логин" modc="${User.login}" modification="${Modification}"/>
    <t:ufield id="password" name="password" title="Пароль" modc="${User.password}" modification="${Modification}"/>
    <t:ufield id="name" name="Name" title="Имя" modc="${User.fullName.name}" modification="${Modification}"/>
    <t:ufield id="surname" name="Surname" title="Фамилия" modc="${User.fullName.surname}" modification="${Modification}"/>
    <t:ufield id="patronymic" name="Patronymic" title="Отчество" modc="${User.fullName.patronymic}" modification="${Modification}"/>
    <t:ufield id="mail" name="Mail" title="Почта" modc="${User.mail}" modification="${Modification}"/>
    <t:ufield id="faculty" name="Faculty" title="Факультет" modc="${User.faculty}" modification="${Modification}"/>
</div>