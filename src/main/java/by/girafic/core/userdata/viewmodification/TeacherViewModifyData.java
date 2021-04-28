package by.girafic.core.userdata.viewmodification;

import by.girafic.core.commonds.ModifyConfirmation;
import static by.girafic.core.commonds.ModifyConfirmation.successful;
import by.girafic.core.contentdata.ContentLinkData;
import by.girafic.core.userdata.FullName;
import by.girafic.core.userdata.modification.TeacherModifyData;

public class TeacherViewModifyData extends ExtendedUserViewModifyData
{
    public final ModifyConfirmation<String> post;
    public final ContentLinkData[] availableContent;

    public TeacherViewModifyData(int id,
                                 ModifyConfirmation<FullName> fullName,
                                 ModifyConfirmation<String> login,
                                 ModifyConfirmation<String> password,
                                 ModifyConfirmation<String> mail,
                                 ModifyConfirmation<String> faculty,
                                 ContentLinkData[] courses,
                                 ModifyConfirmation<String> department,
                                 ModifyConfirmation<String> post,
                                 ContentLinkData[] availableContent)
    {
        super(id, fullName, login, password, mail, faculty, courses, department);
        this.post = post;
        this.availableContent = availableContent;
    }

    public TeacherViewModifyData(int id,
                                 TeacherModifyData data,
                                 ContentLinkData[] courses,
                                 ContentLinkData[] availableContent)
    {
        super(id,data,courses);
        this.post = successful(data.post);
        this.availableContent = availableContent;
    }

    public ModifyConfirmation<String> getPost()
    {
        return post;
    }

    public ContentLinkData[] getAvailableContent()
    {
        return availableContent;
    }
}
