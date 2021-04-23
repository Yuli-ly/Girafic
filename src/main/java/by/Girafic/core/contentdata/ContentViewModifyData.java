package by.Girafic.core.contentdata;

import by.Girafic.core.commonds.ModifyConfirmation;

public class ContentViewModifyData
{
    public ModifyConfirmation<String> title;
    public ModifyConfirmation<String> description;

    public ContentViewModifyData(ModifyConfirmation<String> title, ModifyConfirmation<String> description)
    {
        this.title = title;
        this.description = description;
    }

    public ModifyConfirmation<String> getTitle()
    {
        return title;
    }

    public ModifyConfirmation<String> getDescription()
    {
        return description;
    }
}
