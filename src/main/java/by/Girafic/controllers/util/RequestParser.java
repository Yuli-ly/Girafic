package by.Girafic.controllers.util;

import by.Girafic.core.commonds.LoginData;
import by.Girafic.core.commonds.UserType;
import by.Girafic.core.userdata.*;
import jakarta.servlet.http.HttpServletRequest;

public class RequestParser
{
    private HttpServletRequest request;
    public RequestParser(HttpServletRequest request)
    {
        this.request = request;
    }
    public void setLoginData(LoginData ld)
    {
        request.setAttribute("login",ld.login);
        request.setAttribute("password",ld.password);
    }
    public void setAdminLoginData(LoginData ld)
    {
        request.setAttribute("alogin",ld.login);
        request.setAttribute("apassword",ld.password);
    }
    public void setID(int id)
    {
        request.setAttribute("id",id);
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
    public LoginData takeAdminLoginData()
    {
        return new LoginData(request.getParameter("alogin"),
                request.getParameter("apassword"));
    }
    private UserModifyData takeUserData()
    {
        return new UserModifyData(takeUserType(),
                new FullName(
                        request.getParameter("name"),
                        request.getParameter("surname"),
                        request.getParameter("patronymic")),
                request.getParameter("login"),
                request.getParameter("password"),
                request.getParameter("mail"),
                request.getParameter("faculty")
        );
    }
    public UserType takeUserType()
    {
        return switch (request.getParameter("type"))
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
                 Integer.parseInt(request.getParameter("course")),
                Double.parseDouble(request.getParameter("gpa")),
                request.getParameter("group"),
                request.getParameter("department"),
                new int[]{});
    }
    public TeacherModifyData takeTeacherData()
    {
        return new TeacherModifyData(takeUserData(),
                request.getParameter("department"),
                request.getParameter("post"),
                new int[]{});
    }
    public AdminModifyData takeAdminData()
    {
        return new AdminModifyData(takeUserData());
    }
}
