package by.Girafic.core.contentdata;

public class CourseViewData extends ContentViewData
{
    public SectionViewData[] sections;
    public int[] users;

    public CourseViewData(int id, String title, String description, SectionViewData[] sections, int[] users)
    {
        super(id, title, description);
        this.sections = sections;
        this.users = users;
    }
    public CourseViewData(int contentID,CourseModifyData data,SectionViewData[] sections)
    {
        super(contentID,data.title,data.description);
        this.sections = sections;
        this.users = data.users;
    }
    public SectionViewData[] getSections()
    {
        return sections;
    }

    public int[] getUsers()
    {
        return users;
    }
}
