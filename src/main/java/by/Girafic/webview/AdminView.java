package by.Girafic.webview;

import by.Girafic.core.userdata.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AdminView extends TeacherView implements by.Girafic.core.view.AdminView
{

    public AdminView(HttpServletRequest request, HttpServletResponse response)
    {
        super(request,response);
    }

    @Override
    public void showUserAfterModify(AdminViewModifyData admin) throws ServletException, IOException
    {
        request.setAttribute("Admin",admin);
        request.setAttribute("User",admin);
        request.getServletContext()
                .getRequestDispatcher("/jsp/profileMod/adminProfileAfterModify.jsp")
                .forward(request,response);
    }

    @Override
    public void showUserAfterModify(StudentViewModifyData student) throws ServletException, IOException
    {
        request.setAttribute("Student",student);
        request.setAttribute("User",student);
        request.getServletContext()
                .getRequestDispatcher("/jsp/profileMod/studentProfileAfterModify.jsp")
                .forward(request,response);
    }

    @Override
    public void showUserAfterModify(TeacherViewModifyData teacher) throws ServletException, IOException
    {
        request.setAttribute("Teacher",teacher);
        request.setAttribute("User",teacher);
        request.getServletContext()
                .getRequestDispatcher("/jsp/profileMod/teacherProfileAfterModify.jsp")
                .forward(request,response);
    }
}
