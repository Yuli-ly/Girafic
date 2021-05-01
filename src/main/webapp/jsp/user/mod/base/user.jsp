<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="User" type="by.girafic.core.userdata.viewmodification.UserViewModifyData"--%>
<jsp:include page="input.jsp"/>
<ul>
    <c:set var="id" scope="request" value="login"/>
    <c:set var="name" scope="request" value="login"/>
    <c:set var="title" scope="request" value="Логин"/>
    <c:set var="modc" scope="request" value="${User.login}"/>
    <jsp:include page="field.jsp"/>

    <c:set var="id" scope="request" value="password"/>
    <c:set var="name" scope="request" value="password"/>
    <c:set var="title" scope="request" value="Пароль"/>
    <c:set var="modc" scope="request" value="${User.password}"/>
    <jsp:include page="field.jsp"/>

    <c:set var="id" scope="request" value="name"/>
    <c:set var="name" scope="request" value="Name"/>
    <c:set var="title" scope="request" value="Имя"/>
    <c:set var="modc" scope="request" value="${User.fullName.name}"/>
    <jsp:include page="field.jsp"/>

    <c:set var="id" scope="request" value="surname"/>
    <c:set var="name" scope="request" value="Surname"/>
    <c:set var="title" scope="request" value="Фамилия"/>
    <c:set var="modc" scope="request" value="${User.fullName.surname}"/>
    <jsp:include page="field.jsp"/>

    <c:set var="id" scope="request" value="patronymic"/>
    <c:set var="name" scope="request" value="Patronymic"/>
    <c:set var="title" scope="request" value="Отчество"/>
    <c:set var="modc" scope="request" value="${User.fullName.patronymic}"/>
    <jsp:include page="field.jsp"/>

    <c:set var="id" scope="request" value="mail"/>
    <c:set var="name" scope="request" value="Mail"/>
    <c:set var="title" scope="request" value="Почта"/>
    <c:set var="modc" scope="request" value="${User.mail}"/>
    <jsp:include page="field.jsp"/>

    <c:set var="id" scope="request" value="faculty"/>
    <c:set var="name" scope="request" value="Faculty"/>
    <c:set var="title" scope="request" value="Факультет"/>
    <c:set var="modc" scope="request" value="${User.faculty}"/>
    <jsp:include page="field.jsp"/>
</ul>