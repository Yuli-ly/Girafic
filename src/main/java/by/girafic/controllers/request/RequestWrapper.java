package by.girafic.controllers.request;

import by.girafic.core.commonds.LoginData;
import by.girafic.core.contentdata.ContentLinkData;
import by.girafic.core.contentdata.view.CourseViewData;
import by.girafic.core.contentdata.viewmodification.CourseViewModifyData;
import by.girafic.core.contentdata.view.MaterialViewData;
import by.girafic.core.contentdata.viewmodification.MaterialViewModifyData;
import by.girafic.core.contentdata.view.SectionViewData;
import by.girafic.core.contentdata.viewmodification.SectionViewModifyData;
import by.girafic.core.userdata.view.AdminViewData;
import by.girafic.core.userdata.viewmodification.AdminViewModifyData;
import by.girafic.core.userdata.view.StudentViewData;
import by.girafic.core.userdata.viewmodification.StudentViewModifyData;
import by.girafic.core.userdata.view.TeacherViewData;
import by.girafic.core.userdata.viewmodification.TeacherViewModifyData;
import by.girafic.core.userdata.UserLinkData;
import by.girafic.core.userdata.view.UserViewData;
import by.girafic.core.userdata.viewmodification.UserViewModifyData;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RequestWrapper
{
    protected final HttpServletRequest request;
    protected final HttpServletResponse response;
    private final LoginData login;

    public RequestWrapper(HttpServletRequest request,
                          HttpServletResponse response,
                          LoginSetter setter,
                          LoginGetter getter)
    {
        this.request = request;
        this.response = response;
        login = getter.getLoginData(request);
        setter.setLoginData(request,login);
        request.setAttribute("path",getPath());
    }

    public LoginData takeLogin()
    {
        return login;
    }
    public String getPath()
    {
        return request.getServletContext().getContextPath();
    }
    public HttpServletRequest getRequest()
    {
        return request;
    }

    private void setBasicUser(UserViewData user, boolean mutable)
    {
        request.setAttribute("User",user);
        request.setAttribute("mutable",mutable);
    }
    private void setStudent(Object o)
    {
        request.setAttribute("Student",o);
    }
    private void setTeacher(Object o)
    {
        request.setAttribute("Teacher",o);
    }
    private void setAdmin(Object o)
    {
        request.setAttribute("Admin",o);
    }
    private void setMaterial(Object o)
    {
        request.setAttribute("Material",o);
    }
    private void setSection(Object o)
    {
        request.setAttribute("Section",o);
    }
    private void setCourse(Object o)
    {
        request.setAttribute("Course",o);
    }

    private void setBasicUser(UserViewModifyData user)
    {
        request.setAttribute("User",user);
    }
    public void setUser(StudentViewData student, boolean mutable)
    {
        setBasicUser(student,mutable);
        setStudent(student);
    }
    public void setUser(TeacherViewData teacher, boolean mutable)
    {
        setBasicUser(teacher,mutable);
        setTeacher(teacher);
    }
    public void setUser(AdminViewData admin, boolean mutable)
    {
        setBasicUser(admin,mutable);
        setAdmin(admin);
    }

    public void setUser(StudentViewModifyData student)
    {
        setStudent(student);
        setBasicUser(student);
    }

    public void setUser(TeacherViewModifyData teacher)
    {
        setTeacher(teacher);
        setBasicUser(teacher);
    }
    public void setUser(AdminViewModifyData admin)
    {
        setAdmin(admin);
        setBasicUser(admin);
    }
    public void setContent(MaterialViewData material, boolean mutable)
    {
        setMaterial(material);
        request.setAttribute("mutable",mutable);
    }
    public void setContent(SectionViewData section, boolean mutable)
    {
        setSection(section);
        request.setAttribute("mutable",mutable);
    }
    public void setContent(CourseViewData course, boolean mutable)
    {
        setCourse(course);
        request.setAttribute("mutable",mutable);
    }
    public void setContent(MaterialViewModifyData material)
    {
        setMaterial(material);
    }
    public void setContent(SectionViewModifyData section)
    {
        setSection(section);
    }
    public void setContent(CourseViewModifyData course)
    {
        setCourse(course);
    }
    public void setID(int id)
    {
        request.setAttribute("id",id);
    }
    public int takeID()
    {
        return Integer.parseInt(request.getParameter("id"));
    }
    public void forward(String path) throws ServletException, IOException
    {
        request.getServletContext()
                .getRequestDispatcher(path)
                .forward(request, response);
    }
    public void setMessage(String message)
    {
        request.setAttribute("Message",message);
    }
    public void setContent(ContentLinkData[] content)
    {
        request.setAttribute("Content",content);
    }

    public void setUsers(UserLinkData[] users)
    {
        request.setAttribute("Users",users);
    }
}
