package by.girafic.core.contentdata.view;

import by.girafic.core.contentdata.modification.MaterialModifyData;

public class MaterialViewData extends ContentViewData
{
    public final String filling;

    public MaterialViewData(int id,
                            String title,
                            String description,
                            String filling)
    {
        super(id, title, description);
        this.filling = filling;
    }
    public MaterialViewData(int contentID, MaterialModifyData data)
    {
        super(contentID,data.title,data.description);
        this.filling = data.filling;
    }
    public String getFilling()
    {
        return filling;
    }
}
