package by.Girafic.core.userdata;

public class TeacherViewData extends UserViewData
{
    public String department;
    public String post;

    public TeacherViewData(int id, FullName fullName, String mail, String faculty, String department, String post)
    {
        super(id, fullName, mail, faculty);
        this.department = department;
        this.post = post;
    }

    public TeacherViewData(int id,TeacherModifyData t)
    {
        super(id,t.fullName,t.mail,t.faculty);
        this.department = t.department;
        this.post = t.post;
    }


}
