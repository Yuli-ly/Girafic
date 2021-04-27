package by.girafic.core.contentdata;

public class ContentViewData
{
    public final int id;
    public final String title;
    public final String description;

    public ContentViewData(int id, String title, String description)
    {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public ContentViewData(int contentID,ContentModifyData data)
    {
        this.id = contentID;
        this.title = data.title;
        this.description = data.description;
    }

    public int getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public String getDescription()
    {
        return description;
    }
}
