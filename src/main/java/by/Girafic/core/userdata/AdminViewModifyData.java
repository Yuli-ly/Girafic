package by.Girafic.core.userdata;

import by.Girafic.core.commonds.ModifyConfirmation;

public class AdminViewModifyData extends UserViewModifyData
{
    public AdminViewModifyData(int id,
                               ModifyConfirmation<FullName> fullName,
                               ModifyConfirmation<String> login,
                               ModifyConfirmation<String> password,
                               ModifyConfirmation<String> mail,
                               ModifyConfirmation<String> faculty)
    {
        super(id,fullName, login, password, mail, faculty);
    }

    public AdminViewModifyData(int id,AdminModifyData data)
    {
        super(id,data);
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
