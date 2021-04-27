package by.girafic.controllers.request;

import by.girafic.core.userdata.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
                new int[]{},new int[]{});
    }
    public AdminModifyData takeAdminData()
    {
        return new AdminModifyData(takeUserData());
    }
}
