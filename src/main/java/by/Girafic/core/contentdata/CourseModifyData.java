package by.Girafic.core.contentdata;

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

    public int[] getSections()
    {
        return sections;
    }

    public int[] getUsers()
    {
        return users;
    }
}
