package by.Girafic.core.contentdata;

public class ContentLinkData
{
    public ContentLinkData(String name, int id)
    {
        this.name = name;
        this.id = id;
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
