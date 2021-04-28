package by.girafic.core.contentdata.viewmodification;

import by.girafic.core.commonds.ModifyConfirmation;
import by.girafic.core.contentdata.modification.SectionModifyData;

public class SectionViewModifyData extends ContentViewModifyData
{
    public final int[] contents;

    public SectionViewModifyData(int id,
                                 ModifyConfirmation<String> title,
                                 ModifyConfirmation<String> description,
                                 int[] contents)
    {
        super(id,title, description);
        this.contents = contents;
    }
    public SectionViewModifyData(SectionModifyData data, int id)
    {
        super(id,data);
        this.contents = data.contents;
    }
    public int[] getContents()
    {
        return contents;
    }
}
