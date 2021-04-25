package by.girafic.controllers.util;

import by.girafic.core.commonds.LoginData;
import by.girafic.core.userdata.UserType;
import by.girafic.core.userdata.*;
import jakarta.servlet.http.HttpServletRequest;

public class ServletRequestParser
{
    private final HttpServletRequest request;
    public ServletRequestParser(HttpServletRequest request)
    {
        this.request = request;
        request.setAttribute("path",request.getServletContext().getContextPath());
    }
    public void setLoginData(LoginData ld)
    {
        request.setAttribute("login",ld.login);
        request.setAttribute("password",ld.password);
    }
    public void setID(int id)
    {
        request.setAttribute("id",id);
    }
    public LoginData takeAdminLoginData()
    {
        return new LoginData(request.getParameter("ALogin"),
                request.getParameter("APassword"));
    }
    public LoginData takeLoginData()
    {
        return new LoginData(request.getParameter("login"),
                request.getParameter("password"));
    }
    public int takeID()
    {
        return Integer.parseInt(request.getParameter("id"));
    }

    private UserModifyData takeUserData()
    {
        return new UserModifyData(takeUserType(),
                new FullName(
                        request.getParameter("Name"),
                        request.getParameter("Surname"),
                        request.getParameter("Patronymic")),
                request.getParameter("login"),
                request.getParameter("password"),
                request.getParameter("Mail"),
                request.getParameter("Faculty")
        );
    }
    public UserType takeUserType()
    {
        return switch (request.getParameter("Type"))
        {
            case "student" -> UserType.Student;
            case "teacher" -> UserType.Teacher;
            case "admin" -> UserType.Admin;
            default -> throw new IllegalArgumentException("Invalid user type");
        };
    }
    public StudentModifyData takeStudentData()
    {
        return new StudentModifyData(takeUserData(),
                 Integer.parseInt(request.getParameter("Course")),
                Double.parseDouble(request.getParameter("GPA")),
                request.getParameter("Group"),
                request.getParameter("Department"),
                new int[]{});
    }
    public TeacherModifyData takeTeacherData()
    {
        return new TeacherModifyData(takeUserData(),
                request.getParameter("Department"),
                request.getParameter("Post"),
                new int[]{});
    }
    public AdminModifyData takeAdminData()
    {
        return new AdminModifyData(takeUserData());
    }
}
