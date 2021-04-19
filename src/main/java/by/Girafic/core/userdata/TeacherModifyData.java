package by.Girafic.core.userdata;

import by.Girafic.core.commonds.UserType;

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
        return courses;
    }

    public TeacherModifyData(UserType userType, FullName fullName, String login, String password, String mail, String faculty, String department, String post, int[] courses)
    {
        super(userType, fullName, login, password, mail, faculty);
        this.department = department;
        this.post = post;
        this.courses = courses;
    }

    public String department;
    public String post;
    public int[] courses;
}
