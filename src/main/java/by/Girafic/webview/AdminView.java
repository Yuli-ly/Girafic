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
    public boolean showAdminAfterModify(AdminViewModifyData admin)
    {
        return false;
    }

    @Override
    public boolean showStudentAfterModify(StudentViewModifyData student)
    {
        return false;
    }

    @Override
    public boolean showTeacherAfterModify(TeacherViewModifyData teacher)
    {
        return false;
    }

    @Override
    public boolean showCourseAfterModify(CourseViewModifyData course)
    {
        return false;
    }

    @Override
    public boolean showSectionAfterModify(SectionViewModifyData section)
    {
        return false;
    }

    @Override
    public boolean showMaterialAfterModify(SectionViewModifyData material)
    {
        return false;
    }

    @Override
    public boolean showStudentProfile(ViewData<StudentViewData> student)
    {
        new DefaultView(request,response,servlet).showProfile(student.field,student.changeability);
        return false;
    }

    @Override
    public boolean showTeacherProfile(ViewData<TeacherViewData> teacher)
    {
        new DefaultView(request,response,servlet).showProfile(teacher.field,teacher.changeability);
        return false;
    }

    @Override
    public boolean showAdminProfile(ViewData<AdminViewData> admin)
    {
        new DefaultView(request,response,servlet).showProfile(admin.field,admin.changeability);
        return true;
    }

    @Override
    public boolean showCourse(ViewData<CourseViewData> course)
    {
        return false;
    }

    @Override
    public boolean showMaterial(ViewData<MaterialViewData> material)
    {
        return false;
    }

    @Override
    public boolean showSection(ViewData<SectionViewData> section)
    {
        return false;
    }
}
