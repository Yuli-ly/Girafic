package by.Girafic.webview;

import by.Girafic.core.contentdata.CourseViewData;
import by.Girafic.core.contentdata.MaterialViewData;
import by.Girafic.core.contentdata.SectionViewData;
import by.Girafic.core.userdata.AdminViewData;
import by.Girafic.core.userdata.StudentViewData;
import by.Girafic.core.userdata.TeacherViewData;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class StudentView implements by.Girafic.core.view.StudentView
{
    protected final HttpServletRequest request;
    protected final HttpServletResponse response;
    protected final HttpServlet servlet;

    public StudentView(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet)
    {
        this.request = request;
        this.response = response;
        this.servlet = servlet;
    }
    @Override
    public void showProfile(StudentViewData student, boolean mutable) throws ServletException, IOException
    {
        request.setAttribute("Student",student);
        request.setAttribute("mutable",mutable);
        servlet.getServletContext().getRequestDispatcher("/jsp/profile/studentProfile.jsp").forward(request,response);
    }

    @Override
    public void showProfile(TeacherViewData teacher,boolean mutable) throws ServletException, IOException
    {
        request.setAttribute("Teacher",teacher);
        request.setAttribute("mutable",mutable);
        servlet.getServletContext().getRequestDispatcher("/jsp/profile/teacherProfile.jsp").forward(request,response);
    }

    @Override
    public void showProfile(AdminViewData admin,boolean mutable) throws ServletException, IOException
    {
        request.setAttribute("Admin",admin);
        request.setAttribute("mutable",mutable);
        servlet.getServletContext().getRequestDispatcher("/jsp/profile/adminProfile.jsp").forward(request,response);
    }
    @Override
    public void showContent(CourseViewData course,boolean mutable) throws ServletException, IOException
    {
        request.setAttribute("Course",course);
        request.setAttribute("mutable",mutable);
        servlet.getServletContext().getRequestDispatcher("/jsp/content/course.jsp").forward(request,response);
    }

    @Override
    public void showContent(MaterialViewData material,boolean mutable) throws ServletException, IOException
    {
        request.setAttribute("Material",material);
        request.setAttribute("mutable",mutable);
        servlet.getServletContext().getRequestDispatcher("/jsp/content/material.jsp").forward(request,response);
    }

    @Override
    public void showContent(SectionViewData section,boolean mutable) throws ServletException, IOException
    {
        request.setAttribute("Section",section);
        request.setAttribute("mutable",mutable);
        servlet.getServletContext().getRequestDispatcher("/jsp/content/section.jsp").forward(request,response);
    }

    public void showError(String message) throws ServletException, IOException
    {
        request.setAttribute("Message",message);
        servlet.getServletContext().getRequestDispatcher("/error.jsp").forward(request,response);
    }
}
