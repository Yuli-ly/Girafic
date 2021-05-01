<%@ page contentType="text/html;charset=UTF-8" %>
<form method="post" action="userModification">
    <jsp:include page="../base/input.jsp"/>
    <input type="hidden" name="action" value="del">
    <input type="submit" value="Удалить">
</form>
