package by.girafic.core.contentdata;

import by.girafic.core.commonds.ModifyConfirmation;
import static by.girafic.core.commonds.ModifyConfirmation.successful;

public class ContentViewModifyData
{
    public final int id;
    public final ModifyConfirmation<String> title;
    public final ModifyConfirmation<String> description;

    public ContentViewModifyData(int id,ModifyConfirmation<String> title, ModifyConfirmation<String> description)
    {
        this.id = id;
        this.title = title;
        this.description = description;
    }
    public ContentViewModifyData(int id,ContentModifyData data)
    {
        this.title = successful(data.title);
        this.description = successful(data.description);
        this.id = id;
    }

    public int getId()
    {
        return id;
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
