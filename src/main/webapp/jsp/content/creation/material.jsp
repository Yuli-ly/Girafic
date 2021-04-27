<%--@elvariable id="login" type="String"--%>
<%--@elvariable id="password" type="String"--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Создание материала</title>
</head>
<body>
<form method="post" action="contentCreation">
    <input type="hidden" name="login" value="${login}">
    <input type="hidden" name="password" value="${password}">
    <input type="hidden" name="Type" value="material">
    <ul>
        <li>
            <label for="title">Название</label>
            <textarea id="title" name="Title"></textarea>
        </li>
        <li>
            <label for="description">Описание</label>
            <textarea id="description" name="Description"></textarea>
        </li>
        <li>
            <label for="filling">Содержание</label>
            <textarea id="filling" name="Filling"></textarea>
        </li>
    </ul>
    <input type="submit" value="Создать">
</form>
</body>
</html>
