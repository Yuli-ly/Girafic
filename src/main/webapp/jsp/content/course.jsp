<%@ page import="by.Girafic.core.contentdata.CourseViewData" %>
<%@ page import="by.Girafic.core.contentdata.SectionViewData" %>
<%@ page import="by.Girafic.core.contentdata.ContentLinkData" %>
<%@ page import="by.Girafic.core.contentdata.ContentViewData" %>
<%@ page import="by.Girafic.core.userdata.UserLinkData" %>
<%@ page import="by.Girafic.controllers.util.JspRequestParser" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="Course" type="by.Girafic.core.contentdata.CourseViewData"--%>
<%--@elvariable id="LoginData" type="by.Girafic.core.commonds.LoginData"--%>
<html>
<head>
    <title>Курс</title>
</head>
<body>
<h1>${Course.title}</h1>
<p>${Course.description}</p>
<%
    JspRequestParser parser = new JspRequestParser(request);
    CourseViewData course = parser.takeCourse();
    for (SectionViewData section : course.sections)
    {
        out.println("<h2>");
        out.println(parser.createLinkToContent(new ContentLinkData(section)));
        out.println("</h2>");
        out.println(section.description);
        out.println("<br>");
        for(ContentViewData content : section.contents)
        {
            out.println(parser.createLinkToContent(new ContentLinkData(content)));
            out.println("<br>");
        }
    }
    out.println("<h2>Users</h2>");
    for(UserLinkData user : course.users)
    {
        out.println(parser.createLinkToProfile(user));
        out.println("<br>");
    }
%>
</body>
</html>
