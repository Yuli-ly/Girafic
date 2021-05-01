package by.girafic.core.userdata.viewmodification;

import by.girafic.core.commonds.ModifyConfirmation;
import static by.girafic.core.commonds.ModifyConfirmation.successful;

public class FullName
{
    public ModifyConfirmation<String> name;
    public ModifyConfirmation<String> surname;
    public ModifyConfirmation<String> patronymic;

    public FullName(ModifyConfirmation<String> name,
                    ModifyConfirmation<String> surname,
                    ModifyConfirmation<String> patronymic)
    {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public FullName(by.girafic.core.userdata.FullName name)
    {
        this.name = successful(name.name());
        this.surname = successful(name.surname());
        this.patronymic = successful(name.patronymic());
    }

    public ModifyConfirmation<String> getName()
    {
        return name;
    }

    public ModifyConfirmation<String> getSurname()
    {
        return surname;
    }

    public ModifyConfirmation<String> getPatronymic()
    {
        return patronymic;
    }
}
