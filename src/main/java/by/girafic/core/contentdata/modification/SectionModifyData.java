package by.girafic.core.contentdata.modification;

import by.girafic.core.contentdata.ContentType;

public class SectionModifyData extends ContentModifyData
{
    public final int[] contents;

    public SectionModifyData(String title,
                             String description,
                             int[] contents)
    {
        super(title, description, ContentType.Section);
        this.contents = contents;
    }

    public SectionModifyData(ContentModifyData data, int[] contents)
    {
        super(data);
        this.contents = contents;
    }

    public int[] getContents()
    {
        return contents;
    }
}
