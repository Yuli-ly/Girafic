<%@ page import="by.Girafic.core.contentdata.SectionViewData" %>
<%@ page import="by.Girafic.core.contentdata.ContentViewData" %>
<%@ page import="static by.Girafic.controllers.util.JspUtil.createLinkToContent" %>
<%@ page import="by.Girafic.core.contentdata.ContentLinkData" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="Section" type="by.Girafic.core.contentdata.SectionViewData"--%>

<html>
<head>
    <title>Раздел</title>
</head>
<body>
<h1>${Section.title}</h1>
<p>${Section.description}</p>
<%
    SectionViewData section = (SectionViewData) request.getAttribute("Section");
    String path = request.getContextPath();
    String login = (String) request.getAttribute("login");
    String password = (String) request.getAttribute("password");
    for (ContentViewData data : section.contents)
    {
        out.println(createLinkToContent(path, login, password,
                new ContentLinkData(data.title,data.id)));
        out.println("<br>");
        out.println(data.description);
        out.println("<br>");
    }
%>
</body>
</html>
