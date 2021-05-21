<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="User" type="by.girafic.core.userdata.view.UserViewData"--%>

<div class="container">
    <div class="img">
        <img src="${path}/jsp/img/pic.png">
    </div>
    <div class class="info">
        <p>Имя: ${User.fullName.name}</p>
        <p>Фамилия: ${User.fullName.surname}</p>
        <p>Отчество: ${User.fullName.patronymic}</p>
        <p>Факультет: ${User.faculty}</p>
        <p>Почта: ${User.mail}</p>
    </div>
</div>