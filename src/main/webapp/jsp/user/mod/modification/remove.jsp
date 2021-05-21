<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="path" type="java.lang.String"--%>
<form method="post" action="userModification">
    <jsp:include page="../base/input.jsp"/>
    <input type="hidden" name="action" value="del">
    <input type="submit" class="btn" value="Удалить">
</form>
