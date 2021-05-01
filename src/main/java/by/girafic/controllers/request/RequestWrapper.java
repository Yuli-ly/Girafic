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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
        request.setAttribute("LinkMaker", new LinkMaker());
    }

    public class LinkMaker
    {
        private final String path;
        private final String lp = "?login=" + login.login + "&password=" + login.password;
        LinkMaker()
        {
            path = getPath();
        }

        public String home()
        {
            return path +"/login"+lp;
        }
        public String content(int id)
        {
            return path+"/content"+lp+"&id="+id;
        }
        public String adminCreation()
        {
            return path + "/registration"+lp+"&Type=admin";
        }
        public String courseCreation()
        {
            return path + "/contentCreation"+lp+"&Type=course";
        }
        public String materialCreation()
        {
            return path + "/contentCreation"+lp+"&Type=material";
        }
        public String sectionCreation()
        {
            return path + "/contentCreation"+lp+"&Type=section";
        }
        public String studentCreation()
        {
            return path + "/registration"+lp+"&Type=student";
        }
        public String teacherCreation()
        {
            return path + "/registration"+lp+"&Type=teacher";
        }
        public String user(int id)
        {
            return path + "/profile" + lp + "&id="+id;
        }
        public String userMod(int id)
        {
            return path+"/userModification?ALogin="+login.login+"&APassword="+login.password+"&id="+id;
        }
        public String contentMod(int id)
        {
            return path+"/contentModification"+lp+"&id="+id;
        }
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
    private void setBasicContent(Object o)
    {
        request.setAttribute("BasicContent",o);
    }
    private void setMaterial(Object o)
    {
        setBasicContent(o);
        request.setAttribute("Material",o);
        request.setAttribute("type","material");
    }
    private void setSection(Object o)
    {
        setBasicContent(o);
        request.setAttribute("Section",o);
        request.setAttribute("type","section");
    }
    private void setCourse(Object o)
    {
        setBasicContent(o);
        request.setAttribute("Course",o);
        request.setAttribute("type","course");
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
    protected int[] takeIDs(String name)
    {
        return Arrays.stream(
                Optional.ofNullable(request.getParameterValues(name))
                        .orElse(new String[0]))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
    public void setCurrentContent(List<Integer> list)
    {
        request.setAttribute("CurrentContent",list);
    }
    public void setCurrentUsers(List<Integer> list)
    {
        request.setAttribute("CurrentUsers",list);
    }
    public void setModification(boolean creation)
    {
        request.setAttribute("Modification",creation);
    }
}
