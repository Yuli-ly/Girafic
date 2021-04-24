<%@ page import="by.Girafic.core.userdata.TeacherViewData" %>
<%@ page import="by.Girafic.core.contentdata.ContentLinkData" %>
<%@ page import="by.Girafic.controllers.util.JspRequestParser" %>

<%--@elvariable id="Teacher" type="by.Girafic.core.userdata.TeacherViewData"--%>
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
    <jsp:include page="userData.jsp"></jsp:include>
    Кафедра: ${Teacher.department}<br>
    Должность: ${Teacher.post}<br>
    Курсы:
    <%
        for (ContentLinkData data : teacher.courses)
        {
            out.println(parser.createLinkToContent(data));
            out.println("<br>");
        }
    %>
</p>
</body>
</html>
