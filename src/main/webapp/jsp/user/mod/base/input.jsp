<%--@elvariable id="login" type="java.lang.String"--%>
<%--@elvariable id="password" type="java.lang.String"--%>
<%--@elvariable id="User" type="by.girafic.core.userdata.viewmodification.UserViewModifyData"--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<input type="hidden" name="ALogin" value="${login}">
<input type="hidden" name="APassword" value="${password}">
<input type="hidden" name="id" value="${User.id}">
