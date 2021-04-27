<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="login" type="String"--%>
<%--@elvariable id="password" type="String"--%>
<%--@elvariable id="Material" type="by.girafic.core.contentdata.MaterialViewModifyData"--%>
<%
request.setAttribute("login",request.getParameter("login"));
request.setAttribute("password",request.getParameter("password"));
%>
<input type="hidden" name="login" value="${login}">
<input type="hidden" name="password" value="${password}">
<input type="hidden" name="Type" value="material">
<input type="hidden" name="id" value="${Material.id}">
<ul>
    <li>
        <label for="title">Название</label>
        <textarea id="title" name="Title">${Material.title.value}</textarea>
    </li>
    <li>
        <label for="description">Описание</label>
        <textarea id="description" name="Description">${Material.description.value}</textarea>
    </li>
    <li>
        <label for="filling">Содержание</label>
        <textarea id="filling" name="Filling">${Material.filling.value}</textarea>
    </li>
</ul>