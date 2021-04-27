<%@ page import="by.girafic.core.contentdata.SectionViewData" %>
<%@ page import="by.girafic.core.contentdata.ContentViewData" %>
<%@ page import="by.girafic.core.contentdata.ContentLinkData" %>
<%@ page import="by.girafic.controllers.util.JspRequestParser" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="Section" type="by.girafic.core.contentdata.SectionViewData"--%>

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
