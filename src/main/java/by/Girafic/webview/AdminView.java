package by.Girafic.webview;

import by.Girafic.core.contentdata.*;
import by.Girafic.core.userdata.*;
import by.Girafic.core.view.ViewData;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminView implements by.Girafic.core.view.AdminView
{
    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final HttpServlet servlet;

    public AdminView(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet)
    {
        this.request = request;
        this.response = response;
        this.servlet = servlet;
    }

    @Override
    public void showAdminAfterModify(AdminViewModifyData admin)
    {
        new DefaultView(request,response,servlet).showProfileAfterModify(admin);
    }

    @Override
    public void showStudentAfterModify(StudentViewModifyData student)
    {
        new DefaultView(request,response,servlet).showProfileAfterModify(student);
    }

    @Override
    public void showTeacherAfterModify(TeacherViewModifyData teacher)
    {
        new DefaultView(request,response,servlet).showProfileAfterModify(teacher);
    }

    @Override
    public void showCourseAfterModify(CourseViewModifyData course)
    {
    }

    @Override
    public void showSectionAfterModify(SectionViewModifyData section)
    {
    }

    @Override
    public void showMaterialAfterModify(SectionViewModifyData material)
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
