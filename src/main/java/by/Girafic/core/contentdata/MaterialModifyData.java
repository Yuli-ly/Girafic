package by.Girafic.core.contentdata;

import by.Girafic.core.commonds.ContentType;

public class MaterialModifyData extends ContentModifyData
{
    public String filling;

    public MaterialModifyData(String title, String description, String filling)
    {
        super(title, description, ContentType.Material);
        this.filling = filling;
    }

    public String getFilling()
    {
        return filling;
    }
}
