package by.Girafic.core.userdata;

import by.Girafic.core.commonds.ModifyConfirmation;

public class AdminViewModifyData extends UserViewModifyData
{
    public AdminViewModifyData(ModifyConfirmation<FullName> fullName, ModifyConfirmation<String> login, ModifyConfirmation<String> password, ModifyConfirmation<String> mail, ModifyConfirmation<String> faculty)
    {
        super(fullName, login, password, mail, faculty);
    }

    @Override
    public String toString()
    {
        return "AdminViewModifyData{" +
                "fullName=" + fullName +
                ", login=" + login +
                ", password=" + password +
                ", mail=" + mail +
                ", faculty=" + faculty +
                '}';
    }
}
