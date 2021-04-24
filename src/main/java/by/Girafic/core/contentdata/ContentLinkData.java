package by.Girafic.core.contentdata;

public class ContentLinkData
{
    public ContentLinkData(String name, int id)
    {
        this.name = name;
        this.id = id;
    }

    public ContentLinkData(ContentViewData content)
    {
        this.name = content.title;
        this.id = content.id;
    }

    public String getName()
    {
        return name;
    }

    public int getId()
    {
        return id;
    }

    public String name;
    public int id;
}
