<%@ page import="by.girafic.core.userdata.view.TeacherViewData" %>
<%@ page import="by.girafic.core.contentdata.ContentLinkData" %>
<%@ page import="by.girafic.controllers.util.JspRequestParser" %>

<%--@elvariable id="Teacher" type="by.girafic.core.userdata.view.TeacherViewData"--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    JspRequestParser parser = new JspRequestParser(request);
    TeacherViewData teacher = parser.takeTeacher();
%>

<html>
<head>
    <title>Профиль</title>
</head>
<body>
<p>
    <jsp:include page="user.jsp"/>
    Кафедра: ${Teacher.department}<br>
    Должность: ${Teacher.post}<br>
    Курсы:
    <br>
    <%
        for (ContentLinkData data : teacher.courses)
        {
            out.println(parser.createLinkToContent(data));
            out.println("<br>");
        }
    %>

    Доступный контент:
    <br>
    <%
        for (ContentLinkData data : teacher.availableContent)
        {
            out.println(parser.createLinkToContent(data));
            out.println("<br>");
        }
    %>
</p>
<a href="<%=parser.courseCreationLink()%>">Создать курс</a>
<br>
<a href="<%=parser.sectionCreationLink()%>">Создать раздел</a>
<br>
<a href="<%=parser.materialCreationLink()%>">Создать материал</a>
</body>
</html>
