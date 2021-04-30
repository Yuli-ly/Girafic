<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="Teacher" type="by.girafic.core.userdata.viewmodification.TeacherViewModifyData"--%>

<input type="hidden" name="Type" value="teacher">
<jsp:include page="user.jsp"/>
<ul>
    <li>
        <label for="post">Должность:</label>
        <input type="text" id="post" name="Post" value="${Teacher.post.value}">
    </li>
</ul>
<h2>Доступный контент</h2>
<jsp:include page="../../content/base/contentList.jsp"/>
