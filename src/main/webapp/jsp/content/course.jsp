<%@ page import="by.Girafic.core.contentdata.CourseViewData" %>
<%@ page import="by.Girafic.core.contentdata.SectionViewData" %>
<%@ page import="static by.Girafic.controllers.util.JspUtil.createLinkToContent" %>
<%@ page import="by.Girafic.core.contentdata.ContentLinkData" %>
<%@ page import="by.Girafic.core.contentdata.ContentViewData" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="Course" type="by.Girafic.core.contentdata.CourseViewData"--%>

<html>
<head>
    <title>Курс</title>
</head>
<body>
<h1>${Course.title}</h1>
<p>${Course.description}</p>
<%
    CourseViewData course = (CourseViewData) request.getAttribute("Course");
    String path = request.getContextPath();
    String login = (String) request.getAttribute("login");
    String password = (String) request.getAttribute("password");
    for (SectionViewData section : course.sections)
    {
        out.println("<h2>");
        out.println(createLinkToContent(path, login, password,
                new ContentLinkData(section.title,section.id)));
        out.println("</h2>");
        out.println(section.description);
        out.println("<br>");
        for(ContentViewData content : section.contents)
        {
            out.println(createLinkToContent(path,login,password,
                    new ContentLinkData(content.title, content.id)));
            out.println("<br>");
        }
    }
%>
</body>
</html>
