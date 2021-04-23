package by.Girafic.webview;

import by.Girafic.core.userdata.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AdminView extends TeacherView implements by.Girafic.core.view.AdminView
{

    public AdminView(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet)
    {
        super(request,response,servlet);
    }

    @Override
    public void showUserAfterModify(AdminViewModifyData admin) throws ServletException, IOException
    {
        new DefaultView(request,response,servlet).showProfileAfterModify(admin);
    }

    @Override
    public void showUserAfterModify(StudentViewModifyData student)
    {
        new DefaultView(request,response,servlet).showProfileAfterModify(student);
    }

    @Override
    public void showUserAfterModify(TeacherViewModifyData teacher)
    {
        new DefaultView(request,response,servlet).showProfileAfterModify(teacher);
    }
}
