package by.girafic.controllers.util;

import by.girafic.core.commonds.LoginData;
import by.girafic.core.contentdata.ContentLinkData;
import by.girafic.core.contentdata.CourseViewData;
import by.girafic.core.contentdata.SectionViewData;
import by.girafic.core.userdata.AdminViewData;
import by.girafic.core.userdata.StudentViewData;
import by.girafic.core.userdata.TeacherViewData;
import by.girafic.core.userdata.UserLinkData;
import jakarta.servlet.http.HttpServletRequest;

public class JspRequestParser
{
    protected final HttpServletRequest request;
    protected final LoginData ld;
    private final String path;
    private String loginPassword()
    {
        return "?login=" + ld.login +
                "&password=" + ld.password;
    }
    public JspRequestParser(HttpServletRequest request)
    {
        this.request = request;
        ld = new LoginData((String)request.getAttribute("login"),
                (String)request.getAttribute("password"));
        path = request.getServletContext().getContextPath();
    }
    public String takePath()
    {
        return path;
    }
    public AdminViewData takeAdmin()
    {
        return (AdminViewData) request.getAttribute("Admin");
    }
    public StudentViewData takeStudent()
    {
        return (StudentViewData) request.getAttribute("Student");
    }
    public TeacherViewData takeTeacher()
    {
        return (TeacherViewData) request.getAttribute("Teacher");
    }
    public String createLinkToContent(ContentLinkData data)
    {
        return "<a href=\"" +
                path +
                "/content" +
                loginPassword()+
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
        return path + "/jsp/user/creation/registration.jsp" + loginPassword();
    }
    public String courseCreationLink()
    {
        return path + "/jsp/content/creation/course.jsp"+loginPassword();
    }
    public String materialCreationLink()
    {
        return path + "/jsp/content/creation/material.jsp"+loginPassword();
    }
    public String sectionCreationLink()
    {
        return path + "/jsp/content/creation/section.jsp"+loginPassword();
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
