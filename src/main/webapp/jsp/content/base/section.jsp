<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="login" type="String"--%>
<%--@elvariable id="password" type="String"--%>
<%--@elvariable id="Content" type="by.girafic.core.contentdata.ContentLinkData[]"--%>
<%--@elvariable id="Section" type="by.girafic.core.contentdata.viewmodification.SectionViewModifyData"--%>
<%--@elvariable id="CurrentContent" type="java.util.List"--%>
<input type="hidden" name="login" value="${login}">
<input type="hidden" name="password" value="${password}">
<input type="hidden" name="Type" value="section">
<input type="hidden" name="id" value="${Section.id}">
<ul>
    <li>
        <label for="title">Название</label>
        <textarea id="title" name="Title">${Section.title.value}</textarea>
    </li>
    <li>
        <label for="description">Описание</label>
        <textarea id="description" name="Description">${Section.description.value}</textarea>
    </li>
</ul>
<h2>Содержание раздела</h2>
<jsp:include page="contentList.jsp"/>
