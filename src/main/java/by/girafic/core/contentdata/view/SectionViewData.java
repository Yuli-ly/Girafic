package by.girafic.core.contentdata.view;

import by.girafic.core.contentdata.modification.SectionModifyData;

public class SectionViewData extends ContentViewData
{
    public final ContentViewData[] contents;

    public SectionViewData(int id,
                           String title,
                           String description,
                           ContentViewData[] contents)
    {
        super(id, title, description);
        this.contents = contents;
    }
    public SectionViewData(int contentID,
                           SectionModifyData data,
                           ContentViewData[] contents)
    {
        super(contentID, data.title, data.description);

        this.contents = contents;
    }
    public ContentViewData[] getContents()
    {
        return contents;
    }
}
