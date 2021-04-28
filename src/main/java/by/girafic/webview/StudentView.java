package by.girafic.webview;

import by.girafic.controllers.request.RequestWrapper;
import by.girafic.core.contentdata.view.CourseViewData;
import by.girafic.core.contentdata.view.MaterialViewData;
import by.girafic.core.contentdata.view.SectionViewData;
import by.girafic.core.userdata.view.AdminViewData;
import by.girafic.core.userdata.view.StudentViewData;
import by.girafic.core.userdata.view.TeacherViewData;
import jakarta.servlet.ServletException;

import java.io.IOException;


public class StudentView implements by.girafic.core.view.StudentView
{
    protected final RequestWrapper wrapper;

    public StudentView(RequestWrapper requestWrapper)
    {
        this.wrapper = requestWrapper;
    }
    @Override
    public void showProfile(StudentViewData student, boolean mutable) throws ServletException, IOException
    {
        wrapper.setUser(student,mutable);
        wrapper.forward("/jsp/user/view/student.jsp");
    }

    @Override
    public void showProfile(TeacherViewData teacher,boolean mutable) throws ServletException, IOException
    {
        wrapper.setUser(teacher,mutable);
        wrapper.forward("/jsp/user/view/teacher.jsp");
    }

    @Override
    public void showProfile(AdminViewData admin,boolean mutable) throws ServletException, IOException
    {
        wrapper.setUser(admin, mutable);
        wrapper.forward("/jsp/user/view/admin.jsp");
    }
    @Override
    public void showContent(CourseViewData course,boolean mutable) throws ServletException, IOException
    {
        wrapper.setContent(course,mutable);
        wrapper.forward("/jsp/content/view/course.jsp");
    }

    @Override
    public void showContent(MaterialViewData material,boolean mutable) throws ServletException, IOException
    {
        wrapper.setContent(material,mutable);
        wrapper.forward("/jsp/content/view/material.jsp");
    }

    @Override
    public void showContent(SectionViewData section,boolean mutable) throws ServletException, IOException
    {
        wrapper.setContent(section,mutable);
        wrapper.forward("/jsp/content/view/section.jsp");
    }

    public void showError(String message) throws ServletException, IOException
    {
        wrapper.setMessage(message);
        wrapper.forward("/jsp/error.jsp");
    }
}
