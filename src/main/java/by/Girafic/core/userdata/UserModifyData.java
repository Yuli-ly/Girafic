package by.Girafic.core.userdata;

import by.Girafic.core.commonds.UserType;

public class UserModifyData
{
    public UserType userType;
    public FullName fullName;
    public String login;
    public String password;
    public String mail;
    public String faculty;

    public UserModifyData()
    {
    }

    public UserModifyData(UserType userType, FullName fullName, String login, String password, String mail, String faculty)
    {
        this.userType = userType;
        this.fullName = fullName;
        this.login = login;
        this.password = password;
        this.mail = mail;
        this.faculty = faculty;
    }
}
