<%@ page import="by.Girafic.core.userdata.TeacherViewData" %>
<%@ page import="static by.Girafic.controllers.util.JspUtil.*" %>
<%@ page import="by.Girafic.core.contentdata.ContentLinkData" %>
<%--
  Created by IntelliJ IDEA.
  User: anato
  Date: 23.04.2021
  Time: 8:44
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="Teacher" type="by.Girafic.core.userdata.TeacherViewData"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    TeacherViewData teacher = (TeacherViewData) request.getAttribute("Teacher");
    String path = request.getContextPath();
    String login = (String) request.getAttribute("login");
    String password = (String) request.getAttribute("password");
%>

<html>
<head>
    <title>Профиль</title>
</head>
<body>
<p>
    Имя: ${Teacher.fullName.name}<br>
    Фамилия: ${Teacher.fullName.surname}<br>
    Отчество: ${Teacher.fullName.patronymic}<br>
    Факультет: ${Teacher.faculty}<br>
    Почта: ${Teacher.mail}<br>
    Кафедра: ${Teacher.department}<br>
    Должность: ${Teacher.post}<br>
    Курсы:
    <%
        for (ContentLinkData data : teacher.courses)
        {
            out.println(createLinkToContent(path, login, password, data));
            out.println("<br>");
        }
    %>
</p>
</body>
</html>
