<%@ page import="by.Girafic.core.contentdata.SectionViewData" %>
<%@ page import="by.Girafic.core.contentdata.ContentViewData" %>
<%@ page import="by.Girafic.core.contentdata.ContentLinkData" %>
<%@ page import="by.Girafic.controllers.util.JspRequestParser" %>
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
    JspRequestParser parser = new JspRequestParser(request);
    SectionViewData section = parser.takeSection();
    for (ContentViewData data : section.contents)
    {
        out.println(parser.createLinkToContent(new ContentLinkData(data)));
        out.println("<br>");
        out.println(data.description);
        out.println("<br>");
    }
%>
</body>
</html>
