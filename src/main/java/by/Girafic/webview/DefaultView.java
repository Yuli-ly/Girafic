package by.Girafic.webview;

import by.Girafic.core.commonds.UserType;
import by.Girafic.core.contentdata.CourseViewData;
import by.Girafic.core.contentdata.MaterialViewData;
import by.Girafic.core.contentdata.SectionViewData;
import by.Girafic.core.userdata.*;
import by.Girafic.core.view.ViewData;
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

    public void showProfile(StudentViewData student, boolean mutable)
    {
        request.setAttribute("UserType", UserType.Student);
        request.setAttribute("Student",student);
        try
        {
            servlet.getServletContext().getRequestDispatcher("/profile.jsp").forward(request,response);
        } catch (ServletException | IOException e)
        {
            e.printStackTrace();
        }
    }

    public void showProfileAfterModify(StudentViewModifyData student)
    {
        request.setAttribute("UserType",UserType.Student);
        request.setAttribute("Student",student);
        try
        {
            servlet.getServletContext().getRequestDispatcher("/profileAfterModify.jsp").forward(request,response);
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
            servlet.getServletContext().getRequestDispatcher("/profileAfterModify.jsp").forward(request,response);
        } catch (ServletException | IOException e)
        {
            e.printStackTrace();
        }
    }

    public void showProfileAfterModify(AdminViewModifyData admin)
    {
        request.setAttribute("UserType",UserType.Admin);
        request.setAttribute("Admin",admin);
        try
        {
            servlet.getServletContext().getRequestDispatcher("/profileAfterModify.jsp").forward(request,response);
        } catch (ServletException | IOException e)
        {
            e.printStackTrace();
        }
    }


    public void showProfile(TeacherViewData teacher, boolean mutable)
    {
        request.setAttribute("UserType", UserType.Teacher);
        request.setAttribute("Teacher",teacher);
        try
        {
            servlet.getServletContext().getRequestDispatcher("/profile.jsp").forward(request,response);
        } catch (ServletException | IOException e)
        {
            e.printStackTrace();
        }
    }
    public void showProfile(AdminViewData admin,boolean mutable)
    {
        request.setAttribute("UserType", UserType.Admin);
        request.setAttribute("Admin",admin);
        try
        {
            servlet.getServletContext().getRequestDispatcher("/profile.jsp").forward(request,response);
        } catch (ServletException | IOException e)
        {
            e.printStackTrace();
        }
    }
    public void showError(String message)
    {
        request.setAttribute("Message",message);
        try
        {
            servlet.getServletContext().getRequestDispatcher("/error.jsp").forward(request,response);
        } catch (ServletException | IOException e)
        {
            e.printStackTrace();
        }
    }
    public void showCourse(ViewData<CourseViewData> course)
    {

    }

    public void showMaterial(ViewData<MaterialViewData> material)
    {

    }

    public void showSection(ViewData<SectionViewData> section)
    {
    }
}
