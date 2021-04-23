package by.Girafic.core.userdata;

import by.Girafic.core.commonds.UserType;

public class AdminModifyData extends UserModifyData
{

    public AdminModifyData(UserType userType, FullName fullName, String login, String password, String mail, String faculty)
    {
        super(userType, fullName, login, password, mail, faculty);
    }
    public AdminModifyData(UserModifyData data)
    {
        super(data);
    }
}
