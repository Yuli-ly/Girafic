package by.girafic.webview;

import by.girafic.controllers.request.RequestWrapper;
import by.girafic.core.userdata.*;
import jakarta.servlet.ServletException;

import java.io.IOException;

public class AdminView extends TeacherView implements by.girafic.core.view.AdminView
{

    public AdminView(RequestWrapper wrapper)
    {
        super(wrapper);
    }

    @Override
    public void showUserAfterModify(AdminViewModifyData admin) throws ServletException, IOException
    {
        wrapper.setUser(admin);
        wrapper.forward("/jsp/user/modification/admin.jsp");
    }

    @Override
    public void showUserAfterModify(StudentViewModifyData student) throws ServletException, IOException
    {
        wrapper.setUser(student);
        wrapper.forward("/jsp/user/modification/student.jsp");
    }

    @Override
    public void showUserAfterModify(TeacherViewModifyData teacher) throws ServletException, IOException
    {
        wrapper.setUser(teacher);
        wrapper.forward("/jsp/user/modification/teacher.jsp");
    }
}
