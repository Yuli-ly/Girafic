package by.Girafic.core.contentdata;

import by.Girafic.core.commonds.ContentType;

public class ContentModifyData
{
    public String title;
    public String description;
    public ContentType contentType;

    public String getTitle()
    {
        return title;
    }

    public String getDescription()
    {
        return description;
    }

    public ContentType getContentType()
    {
        return contentType;
    }

    public ContentModifyData(String title, String description, ContentType contentType)
    {
        this.title = title;
        this.description = description;
        this.contentType = contentType;
    }
}
