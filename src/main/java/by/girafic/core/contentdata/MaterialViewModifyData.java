package by.girafic.core.contentdata;

import by.girafic.core.commonds.ModifyConfirmation;
import static by.girafic.core.commonds.ModifyConfirmation.successful;

public class MaterialViewModifyData extends ContentViewModifyData
{
    public final ModifyConfirmation<String> filling;

    public MaterialViewModifyData(int id,
                                  ModifyConfirmation<String> title,
                                  ModifyConfirmation<String> description,
                                  ModifyConfirmation<String> filling)
    {
        super(id,title, description);
        this.filling = filling;
    }

    public MaterialViewModifyData(int id, MaterialModifyData data)
    {
        super(id,data);
        this.filling = successful(data.filling);
    }

    public ModifyConfirmation<String> getFilling()
    {
        return filling;
    }
}
