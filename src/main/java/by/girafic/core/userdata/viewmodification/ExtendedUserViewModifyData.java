package by.girafic.core.userdata.viewmodification;

import by.girafic.core.commonds.ModifyConfirmation;
import static by.girafic.core.commonds.ModifyConfirmation.successful;

import by.girafic.core.contentdata.ContentLinkData;
import by.girafic.core.userdata.modification.ExtendedUserModifyData;

public class ExtendedUserViewModifyData extends UserViewModifyData
{
    public final ContentLinkData[] courses;
    public final ModifyConfirmation<String> department;

    public ExtendedUserViewModifyData(int id,
                                      FullName fullName,
                                      ModifyConfirmation<String> login,
                                      ModifyConfirmation<String> password,
                                      ModifyConfirmation<String> mail,
                                      ModifyConfirmation<String> faculty,
                                      ContentLinkData[] courses,
                                      ModifyConfirmation<String> department)
    {
        super(id, fullName, login, password, mail, faculty);
        this.courses = courses;
        this.department = department;
    }

    public ExtendedUserViewModifyData(int id,
                                      ExtendedUserModifyData data,
                                      ContentLinkData[] courses)
    {
        super(id, data);
        this.courses = courses;
        this.department = successful(data.department);
    }

    public ModifyConfirmation<String> getDepartment()
    {
        return department;
    }

    public ContentLinkData[] getCourses()
    {
        return courses;
    }
}
