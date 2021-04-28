package by.girafic.core.contentdata.modification;

import by.girafic.core.contentdata.ContentType;

public class MaterialModifyData extends ContentModifyData
{
    public final String filling;

    public MaterialModifyData(String title, String description, String filling)
    {
        super(title, description, ContentType.Material);
        this.filling = filling;
    }
    public MaterialModifyData(ContentModifyData data,String filling)
    {
        super(data.title,data.description,data.contentType);
        this.filling = filling;
    }
    public String getFilling()
    {
        return filling;
    }
}
