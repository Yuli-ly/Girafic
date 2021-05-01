package by.girafic.core.userdata.viewmodification;

import by.girafic.core.commonds.ModifyConfirmation;
import by.girafic.core.userdata.modification.AdminModifyData;

public class AdminViewModifyData extends UserViewModifyData
{
    public AdminViewModifyData(int id,
                               FullName fullName,
                               ModifyConfirmation<String> login,
                               ModifyConfirmation<String> password,
                               ModifyConfirmation<String> mail,
                               ModifyConfirmation<String> faculty)
    {
        super(id,fullName, login, password, mail, faculty);
    }

    public AdminViewModifyData(int id, AdminModifyData data)
    {
        super(id,data);
    }

}
