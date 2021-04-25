package by.girafic.core.contentdata;

import by.girafic.core.commonds.ModifyConfirmation;

public class SectionViewModifyData extends ContentViewModifyData
{
    public ModifyConfirmation<int[]> contents;

    public SectionViewModifyData(ModifyConfirmation<String> title, ModifyConfirmation<String> description, ModifyConfirmation<int[]> contents)
    {
        super(title, description);
        this.contents = contents;
    }

    public ModifyConfirmation<int[]> getContents()
    {
        return contents;
    }
}
