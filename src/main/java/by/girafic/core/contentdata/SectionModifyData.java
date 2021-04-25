package by.girafic.core.contentdata;

public class SectionModifyData extends ContentModifyData
{
    public int[] contents;

    public SectionModifyData(String title, String description, int[] contents)
    {
        super(title, description, ContentType.Section);
        this.contents = contents;
    }

    public int[] getContents()
    {
        return contents;
    }
}
