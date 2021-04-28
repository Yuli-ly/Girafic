package by.girafic.core.userdata.view;

import by.girafic.core.contentdata.ContentLinkData;
import by.girafic.core.userdata.FullName;
import by.girafic.core.userdata.modification.UserModifyData;

public class ExtendedUserViewData extends UserViewData
{
    public final String department;
    public final ContentLinkData[] courses;

    public ExtendedUserViewData(int id,
                                FullName fullName,
                                String mail,
                                String faculty,
                                String department,
                                ContentLinkData[] courses)
    {
        super(id, fullName, mail, faculty);
        this.department = department;
        this.courses = courses;
    }

    public ExtendedUserViewData(int id,
                                UserModifyData data,
                                String department,
                                ContentLinkData[] courses)
    {
        super(id, data);
        this.department = department;
        this.courses = courses;
    }

    public String getDepartment()
    {
        return department;
    }

    public ContentLinkData[] getCourses()
    {
        return courses;
    }
}
