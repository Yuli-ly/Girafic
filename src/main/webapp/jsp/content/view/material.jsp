<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="Material" type="by.girafic.core.contentdata.view.MaterialViewData"--%>
<html>
<head>
    <title>Материал</title>
</head>
<body>
<jsp:include page="../../navigation.jsp"/>
<h1>${Material.title}</h1>
<p>${Material.description}</p>
<p>${Material.filling}</p>
</body>
</html>
