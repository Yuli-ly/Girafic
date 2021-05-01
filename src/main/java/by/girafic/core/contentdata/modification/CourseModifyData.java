package by.girafic.core.contentdata.modification;

import by.girafic.core.contentdata.ContentType;

public class CourseModifyData extends ContentModifyData
{
    public int[] sections;
    public int[] users;

    public CourseModifyData(String title, String description, int[] sections, int[] users)
    {
        super(title, description, ContentType.Course);
        this.sections = sections;
        this.users = users;
    }

    public CourseModifyData(ContentModifyData data, int[] sections, int[] users)
    {
        super(data);
        this.sections = sections;
        this.users = users;
    }

    public int[] getSections()
    {
        return sections;
    }

    public int[] getUsers()
    {
        return users;
    }
}
