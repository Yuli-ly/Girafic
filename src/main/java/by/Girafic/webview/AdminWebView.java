package by.Girafic.webview;

import by.Girafic.core.contentdata.*;
import by.Girafic.core.userdata.*;
import by.Girafic.core.view.AdminView;
import by.Girafic.core.view.ViewData;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class AdminWebView implements AdminView
{
    private HttpServletResponse response;

    public AdminWebView(HttpServletResponse response)
    {
        this.response = response;
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
        return false;
    }

    @Override
    public boolean showTeacherProfile(ViewData<TeacherViewData> teacher)
    {
        return false;
    }

    @Override
    public boolean showAdminProfile(ViewData<AdminViewData> admin)
    {
        try
        {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<p>");
            out.print("Changeable? ");
            out.println(admin.changeability);
            out.println(admin);
            out.println("</p>");
            out.println("</body></html>");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
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
