package by.girafic.core.contentdata;

public class MaterialViewData extends ContentViewData
{
    public String filling;

    public MaterialViewData(int id, String title, String description, String filling)
    {
        super(id, title, description);
        this.filling = filling;
    }
    public MaterialViewData(int contentID,MaterialModifyData data)
    {
        super(contentID,data.title,data.description);
        this.filling = data.filling;
    }
    public String getFilling()
    {
        return filling;
    }
}
