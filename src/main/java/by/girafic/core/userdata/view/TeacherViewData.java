package by.girafic.core.userdata.view;

import by.girafic.core.contentdata.ContentLinkData;
import by.girafic.core.userdata.modification.TeacherModifyData;
import by.girafic.core.userdata.FullName;

public class TeacherViewData extends ExtendedUserViewData
{
    public final String post;
    public final ContentLinkData[] availableContent;

    public TeacherViewData(int id,
                           FullName fullName,
                           String mail,
                           String faculty,
                           String department,
                           ContentLinkData[] courses,
                           String post,
                           ContentLinkData[] availableContent)
    {
        super(id, fullName, mail, faculty, department, courses);
        this.post = post;
        this.availableContent = availableContent;
    }

    public TeacherViewData(int id,
                           TeacherModifyData data,
                           ContentLinkData[] courses,
                           ContentLinkData[] availableContent)
    {
        super(id, data, data.department, courses);
        this.post = data.post;
        this.availableContent = availableContent;
    }
    public String getDepartment()
    {
        return department;
    }
    public String getPost()
    {
        return post;
    }

    public ContentLinkData[] getAvailableContent()
    {
        return availableContent;
    }
}
