package by.girafic.core.contentdata;

import by.girafic.core.commonds.ModifyConfirmation;
import static by.girafic.core.commonds.ModifyConfirmation.successful;

public class SectionViewModifyData extends ContentViewModifyData
{
    public final ModifyConfirmation<int[]> contents;

    public SectionViewModifyData(int id,
                                 ModifyConfirmation<String> title,
                                 ModifyConfirmation<String> description,
                                 ModifyConfirmation<int[]> contents)
    {
        super(id,title, description);
        this.contents = contents;
    }
    public SectionViewModifyData(SectionModifyData data,int id)
    {
        super(id,data);
        this.contents = successful(data.contents);
    }
    public ModifyConfirmation<int[]> getContents()
    {
        return contents;
    }
}
