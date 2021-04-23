package by.Girafic.core.userdata;

import by.Girafic.core.contentdata.ContentLinkData;

public class TeacherViewData extends UserViewData
{
    public String department;
    public String post;
    public ContentLinkData[] courses;
    public String getDepartment()
    {
        return department;
    }

    public TeacherViewData(int id, FullName fullName, String mail, String faculty, String department, String post, ContentLinkData[] courses)
    {
        super(id, fullName, mail, faculty);
        this.department = department;
        this.post = post;
        this.courses = courses;
    }

    public String getPost()
    {
        return post;
    }


    public TeacherViewData(int id,TeacherModifyData t,ContentLinkData[] courses)
    {
        super(id,t.fullName,t.mail,t.faculty);
        this.department = t.department;
        this.post = t.post;
        this.courses = courses;
    }


}
