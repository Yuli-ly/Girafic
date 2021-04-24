package by.Girafic.controllers.util;

import by.Girafic.core.commonds.LoginData;
import by.Girafic.core.contentdata.ContentLinkData;
import by.Girafic.core.contentdata.CourseViewData;
import by.Girafic.core.contentdata.SectionViewData;
import by.Girafic.core.userdata.AdminViewData;
import by.Girafic.core.userdata.StudentViewData;
import by.Girafic.core.userdata.TeacherViewData;
import by.Girafic.core.userdata.UserLinkData;
import jakarta.servlet.http.HttpServletRequest;

public class JspRequestParser
{
    private HttpServletRequest request;
    private LoginData ld;
    private String path;
    public JspRequestParser(HttpServletRequest request)
    {
        this.request = request;
        ld = (LoginData) request.getAttribute("LoginData");
        path = request.getContextPath();
    }
    public String takePath()
    {
        return path;
    }
    public AdminViewData takeAdmin()
    {
        AdminViewData admin = (AdminViewData) request.getAttribute("Admin");
        request.setAttribute("User",admin);
        return admin;
    }
    public StudentViewData takeStudent()
    {
        StudentViewData student = (StudentViewData) request.getAttribute("Student");
        request.setAttribute("User",student);
        return student;
    }
    public TeacherViewData takeTeacher()
    {
        TeacherViewData teacher = (TeacherViewData) request.getAttribute("Teacher");
        request.setAttribute("User",teacher);
        return teacher;
    }
    public String createLinkToContent(ContentLinkData data)
    {
        return "<a href=\"" +
                path +
                "/content" +
                "?" +
                "login=" + ld.login +
                "&password=" + ld.password +
                "&id=" + data.id +
                "\">" + data.name + "</a>";
    }
    public String createLinkToProfile(UserLinkData user)
    {
        return "<a href=\"" +
                path +
                "/profile" +
                "?" +
                "login=" + ld.login +
                "&password=" + ld.password +
                "&id=" + user.id +
                "\">" + user.name + "</a>";
    }
    public String registrationLink()
    {
        return path + "/registrationTest.html";
    }

    public CourseViewData takeCourse()
    {
        return (CourseViewData) request.getAttribute("Course");
    }
    public SectionViewData takeSection()
    {
       return (SectionViewData) request.getAttribute("Section");
    }

}
