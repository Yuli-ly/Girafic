package by.Girafic.webview;

import by.Girafic.core.userdata.UserType;
import by.Girafic.core.userdata.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DefaultView
{
    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final HttpServlet servlet;

    public DefaultView(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet)
    {
        this.request = request;
        this.response = response;
        this.servlet = servlet;
    }

    public void showProfileAfterModify(StudentViewModifyData student)
    {
        request.setAttribute("UserType",UserType.Student);
        request.setAttribute("Student",student);
        try
        {
            servlet.getServletContext().getRequestDispatcher("/jsp/profileMod/profileAfterModify.jsp").forward(request,response);
        } catch (ServletException | IOException e)
        {
            e.printStackTrace();
        }
    }

    public void showProfileAfterModify(TeacherViewModifyData teacher)
    {
        request.setAttribute("UserType",UserType.Teacher);
        request.setAttribute("Teacher",teacher);
        try
        {
            servlet.getServletContext().getRequestDispatcher("/jsp/profileMod/profileAfterModify.jsp").forward(request,response);
        } catch (ServletException | IOException e)
        {
            e.printStackTrace();
        }
    }

    public void showProfileAfterModify(AdminViewModifyData admin) throws ServletException, IOException
    {
        request.setAttribute("UserType",UserType.Admin);
        request.setAttribute("Admin",admin);
        servlet.getServletContext().getRequestDispatcher("/jsp/profileMod/profileAfterModify.jsp").forward(request,response);
    }
    public void showError(String message) throws ServletException, IOException
    {
        request.setAttribute("Message",message);
        servlet.getServletContext().getRequestDispatcher("/error.jsp").forward(request,response);
    }
}
