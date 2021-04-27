package by.girafic.core.userdata;

import by.girafic.core.contentdata.ContentLinkData;

public class TeacherViewData extends UserViewData
{
    public final String department;
    public final String post;
    public final ContentLinkData[] courses;
    public final ContentLinkData[] availableContent;
    public String getDepartment()
    {
        return department;
    }

    public TeacherViewData(int id,
                           FullName fullName,
                           String mail,
                           String faculty,
                           String department,
                           String post,
                           ContentLinkData[] courses,
                           ContentLinkData[] availableContent)
    {
        super(id, fullName, mail, faculty);
        this.department = department;
        this.post = post;
        this.courses = courses;
        this.availableContent = availableContent;
    }

    public String getPost()
    {
        return post;
    }


    public TeacherViewData(int id,
                           TeacherModifyData t,
                           ContentLinkData[] courses,
                           ContentLinkData[] availableContent)
    {
        super(id,t.fullName,t.mail,t.faculty);
        this.department = t.department;
        this.post = t.post;
        this.courses = courses;
        this.availableContent = availableContent;
    }


}
