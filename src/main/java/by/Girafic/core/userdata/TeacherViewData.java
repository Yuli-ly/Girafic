package by.Girafic.core.userdata;

public class TeacherViewData extends UserViewData
{
    public String department;
    public String faculty;

    public TeacherViewData(int id, FullName fullName, String mail, String faculty, String department, String faculty1, String post)
    {
        super(id, fullName, mail, faculty);
        this.department = department;
        this.faculty = faculty1;
        this.post = post;
    }

    public String post;
}
