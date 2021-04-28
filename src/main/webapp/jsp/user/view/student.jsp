<%@ page import="by.girafic.core.userdata.view.StudentViewData" %>
<%@ page import="by.girafic.core.contentdata.ContentLinkData" %>
<%@ page import="by.girafic.controllers.util.JspRequestParser" %>
<%--@elvariable id="Student" type="by.girafic.core.userdata.view.StudentViewData"--%>

<%
    JspRequestParser parser = new JspRequestParser(request);
    StudentViewData student = parser.takeStudent();
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Профиль</title>
</head>
<body>
<p>
    <jsp:include page="user.jsp"/>
    Группа: ${Student.group}<br>
    Курс: ${Student.course}<br>
    Средний балл: ${Student.gpa}<br>
    Кафедра: ${Student.department}<br>
    Курсы:
    <%
        for (ContentLinkData data : student.courses)
        {
            out.println(parser.createLinkToContent(data));
            out.println("<br>");
        }
    %>
</p>
</body>
</html>
