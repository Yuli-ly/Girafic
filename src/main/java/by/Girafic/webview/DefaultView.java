package by.Girafic.webview;

import by.Girafic.core.commonds.UserType;
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

    public void showProfile(StudentViewData student, boolean mutable)
    {
        request.setAttribute("UserType", UserType.Student);
        request.setAttribute("Mutable", mutable);
        request.setAttribute("FullName", student.fullName);
        request.setAttribute("Course", student.course);
        request.setAttribute("Faculty", student.faculty);
        request.setAttribute("Group", student.group);
        request.setAttribute("Mail", student.mail);
        request.setAttribute("Department", student.department);
        request.setAttribute("GPA", student.gpa);
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
        request.setAttribute("Mutable", mutable);
        request.setAttribute("FullName", teacher.fullName);
        request.setAttribute("Faculty", teacher.faculty);
        request.setAttribute("Mail", teacher.mail);
        request.setAttribute("Department", teacher.department);
        request.setAttribute("Post",teacher.post);
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
        request.setAttribute("Mutable", mutable);
        request.setAttribute("FullName", admin.fullName);
        request.setAttribute("Faculty", admin.faculty);
        request.setAttribute("Mail", admin.mail);
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
}
