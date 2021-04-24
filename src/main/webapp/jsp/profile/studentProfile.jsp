<%@ page import="by.Girafic.core.userdata.StudentViewData" %>
<%@ page import="static by.Girafic.controllers.util.JspUtil.*" %>
<%@ page import="by.Girafic.core.contentdata.ContentLinkData" %>
<%--
  Created by IntelliJ IDEA.
  User: anato
  Date: 23.04.2021
  Time: 8:44
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="Student" type="by.Girafic.core.userdata.StudentViewData"--%>
<%
    StudentViewData student = (StudentViewData) request.getAttribute("Student");
    String path = request.getContextPath();
    String login = (String) request.getAttribute("login");
    String password = (String) request.getAttribute("password");
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Профиль</title>
</head>
<body>
<p>
    Имя: ${Student.fullName.name}<br>
    Фамилия: ${Student.fullName.surname}<br>
    Отчество: ${Student.fullName.patronymic}<br>
    Факультет: ${Student.faculty}<br>
    Почта: ${Student.mail}<br>
    Группа: ${Student.group}<br>
    Курс: ${Student.course}<br>
    Средний балл: ${Student.gpa}<br>
    Кафедра: ${Student.department}<br>
    Курсы:
    <%
        for (ContentLinkData data : student.courses)
        {
            out.println(createLinkToContent(path, login, password, data));
            out.println("<br>");
        }
    %>
</p>
</body>
</html>
