package by.Girafic.core.contentdata;

import by.Girafic.core.commonds.ModifyConfirmation;

public class MaterialViewModifyData extends ContentViewModifyData
{
    public ModifyConfirmation<String> filling;

    public MaterialViewModifyData(ModifyConfirmation<String> title, ModifyConfirmation<String> description, ModifyConfirmation<String> filling)
    {
        super(title, description);
        this.filling = filling;
    }

    public ModifyConfirmation<String> getFilling()
    {
        return filling;
    }
}
