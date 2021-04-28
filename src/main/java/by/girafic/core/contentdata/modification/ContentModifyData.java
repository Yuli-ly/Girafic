package by.girafic.core.contentdata.modification;

import by.girafic.core.contentdata.ContentType;

public class ContentModifyData
{
    public final String title;
    public final String description;
    public final ContentType contentType;

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
    public ContentModifyData(ContentModifyData data)
    {
        this.title = data.title;
        this.description = data.description;
        this.contentType = data.contentType;
    }
}
