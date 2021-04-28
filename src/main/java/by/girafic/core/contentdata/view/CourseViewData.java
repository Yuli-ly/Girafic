package by.girafic.core.contentdata.view;

import by.girafic.core.contentdata.modification.CourseModifyData;
import by.girafic.core.userdata.UserLinkData;

public class CourseViewData extends ContentViewData
{
    public final SectionViewData[] sections;
    public final UserLinkData[] users;

    public CourseViewData(int id, String title, String description, SectionViewData[] sections, UserLinkData[] users)
    {
        super(id, title, description);
        this.sections = sections;
        this.users = users;
    }
    public CourseViewData(int contentID, CourseModifyData data, SectionViewData[] sections, UserLinkData[] users)
    {
        super(contentID,data.title,data.description);
        this.sections = sections;
        this.users = users;
    }
    public SectionViewData[] getSections()
    {
        return sections;
    }

    public UserLinkData[] getUsers()
    {
        return users;
    }
}
