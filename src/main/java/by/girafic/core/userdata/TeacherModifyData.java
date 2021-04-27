package by.girafic.core.userdata;

public class TeacherModifyData extends UserModifyData
{
    public String getDepartment()
    {
        return department;
    }

    public String getPost()
    {
        return post;
    }

    public int[] getCourses()
    {
        return availableContent;
    }

    public TeacherModifyData(UserType userType,
                             FullName fullName,
                             String login,
                             String password,
                             String mail,
                             String faculty,
                             String department,
                             String post,
                             int[] courses,
                             int[] availableContent)
    {
        super(userType, fullName, login, password, mail, faculty);
        this.department = department;
        this.post = post;
        this.courses = courses;
        this.availableContent = availableContent;
    }

    public TeacherModifyData(UserModifyData data,
                             String department,
                             String post,
                             int[] courses,
                             int[] availableContent)
    {
        super(data);
        this.department = department;
        this.post = post;
        this.courses = courses;
        this.availableContent = availableContent;
    }

    public final String department;
    public final String post;
    public int[] availableContent;
    public final int[] courses;
}
