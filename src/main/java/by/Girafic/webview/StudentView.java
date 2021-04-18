package by.Girafic.webview;

import by.Girafic.core.contentdata.CourseViewData;
import by.Girafic.core.contentdata.MaterialViewData;
import by.Girafic.core.contentdata.SectionViewData;
import by.Girafic.core.userdata.AdminViewData;
import by.Girafic.core.userdata.StudentViewData;
import by.Girafic.core.userdata.StudentViewModifyData;
import by.Girafic.core.userdata.TeacherViewData;
import by.Girafic.core.view.ViewData;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
    public boolean showStudentAfterModify(StudentViewModifyData student)
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
        return false;
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
