<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="User" type="by.Girafic.core.userdata.UserViewData"--%>
Имя: ${User.fullName.name}<br>
Фамилия: ${User.fullName.surname}<br>
Отчество: ${User.fullName.patronymic}<br>
Факультет: ${User.faculty}<br>
Почта: ${User.mail}<br>