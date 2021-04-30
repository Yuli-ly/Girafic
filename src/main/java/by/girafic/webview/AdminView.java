package by.girafic.webview;

import by.girafic.controllers.request.RequestWrapper;
import by.girafic.core.contentdata.ContentLinkData;
import by.girafic.core.userdata.view.AdminViewData;
import by.girafic.core.userdata.viewmodification.AdminViewModifyData;
import by.girafic.core.userdata.viewmodification.StudentViewModifyData;
import by.girafic.core.userdata.viewmodification.TeacherViewModifyData;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class AdminView extends TeacherView implements by.girafic.core.view.AdminView
{

    public AdminView(RequestWrapper wrapper)
    {
        super(wrapper);
    }

    @Override
    public void showStartPage(AdminViewData admin) throws Exception
    {
        wrapper.setUser(admin,true);
        wrapper.forward("/jsp/user/view/home/admin.jsp");
    }

    @Override
    public void showStudentForCreation(ContentLinkData[] courses) throws ServletException, IOException
    {
        wrapper.setCurrentContent(new ArrayList<>());
        wrapper.setContent(courses);
        wrapper.forward("/jsp/user/mod/creation/student.jsp");
    }

    @Override
    public void showTeacherForCreation(ContentLinkData[] availableContent) throws ServletException, IOException
    {
        wrapper.setCurrentContent(new ArrayList<>());
        wrapper.setContent(availableContent);
        wrapper.forward("/jsp/user/mod/creation/teacher.jsp");
    }

    @Override
    public void showAdminForCreation() throws ServletException, IOException
    {
        wrapper.forward("/jsp/user/mod/creation/admin.jsp");
    }

    @Override
    public void showUserAfterModify(AdminViewModifyData admin) throws ServletException, IOException
    {
        wrapper.setUser(admin);
        wrapper.forward("/jsp/user/mod/modification/admin.jsp");
    }

    @Override
    public void showUserAfterModify(StudentViewModifyData student,ContentLinkData[] courses) throws ServletException, IOException
    {
        wrapper.setUser(student);
        wrapper.setCurrentContent(Arrays.stream(student.courses).mapToInt(ContentLinkData::getId).boxed().toList());
        wrapper.setContent(courses);
        wrapper.forward("/jsp/user/mod/modification/student.jsp");
    }

    @Override
    public void showUserAfterModify(TeacherViewModifyData teacher,ContentLinkData[] availableContent) throws ServletException, IOException
    {
        wrapper.setUser(teacher);
        wrapper.setCurrentContent(Arrays.stream(teacher.availableContent).mapToInt(ContentLinkData::getId).boxed().toList());
        wrapper.setContent(availableContent);
        wrapper.forward("/jsp/user/mod/modification/teacher.jsp");
    }
}
