package by.girafic.controllers.request;

import by.girafic.core.userdata.modification.*;
import by.girafic.core.userdata.FullName;
import by.girafic.core.userdata.UserType;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Arrays;

public class UserRequestWrapper extends RequestWrapper
{
    public UserRequestWrapper(HttpServletRequest request,
                              HttpServletResponse response,
                              LoginSetter setter,
                              LoginGetter getter)
    {
        super(request,response, setter, getter);
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
                request.getParameter("Faculty"));
    }
    private ExtendedUserModifyData takeExtendedUserData()
    {
        return new ExtendedUserModifyData(takeUserData(),
                request.getParameter("Department"),
                takeIDs("Courses"));
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
        return new StudentModifyData(takeExtendedUserData(),
                Integer.parseInt(request.getParameter("Course")),
                Double.parseDouble(request.getParameter("GPA")),
                request.getParameter("Group"));
    }
    public TeacherModifyData takeTeacherData()
    {
        return new TeacherModifyData(takeExtendedUserData(),
                request.getParameter("Post"),
                takeIDs("AvailableContent"));
    }
    public AdminModifyData takeAdminData()
    {
        return new AdminModifyData(takeUserData());
    }
}
