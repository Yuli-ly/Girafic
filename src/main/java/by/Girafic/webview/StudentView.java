package by.Girafic.webview;

import by.Girafic.core.commonds.UserType;
import by.Girafic.core.contentdata.CourseViewData;
import by.Girafic.core.contentdata.MaterialViewData;
import by.Girafic.core.contentdata.SectionViewData;
import by.Girafic.core.userdata.AdminViewData;
import by.Girafic.core.userdata.StudentViewData;
import by.Girafic.core.userdata.StudentViewModifyData;
import by.Girafic.core.userdata.TeacherViewData;
import by.Girafic.core.view.ViewData;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class StudentView implements by.Girafic.core.view.StudentView
{
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpServlet servlet;

    public StudentView(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet)
    {
        this.request = request;
        this.response = response;
        this.servlet = servlet;
    }

    @Override
    public void showStudentAfterModify(StudentViewModifyData student)
    {
    }

    @Override
    public void showStudentProfile(ViewData<StudentViewData> student)
    {
        new DefaultView(request,response,servlet).showProfile(student.field,student.changeability);
    }

    @Override
    public void showTeacherProfile(ViewData<TeacherViewData> teacher)
    {
        new DefaultView(request,response,servlet).showProfile(teacher.field,teacher.changeability);
    }

    @Override
    public void showAdminProfile(ViewData<AdminViewData> admin)
    {
        new DefaultView(request,response,servlet).showProfile(admin.field,admin.changeability);
    }

    @Override
    public void showCourse(ViewData<CourseViewData> course)
    {
        new DefaultView(request,response,servlet).showCourse(course);
    }

    @Override
    public void showMaterial(ViewData<MaterialViewData> material)
    {
        new DefaultView(request,response,servlet).showMaterial(material);
    }

    @Override
    public void showSection(ViewData<SectionViewData> section)
    {
        new DefaultView(request,response,servlet).showSection(section);
    }

    @Override
    public void showError(String message)
    {
        new DefaultView(request,response,servlet).showError(message);
    }
}
