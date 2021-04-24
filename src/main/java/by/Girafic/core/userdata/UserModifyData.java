package by.Girafic.core.userdata;

public class UserModifyData
{
    public UserType userType;
    public FullName fullName;
    public String login;
    public String password;
    public String mail;
    public String faculty;

    public UserType getUserType()
    {
        return userType;
    }

    public FullName getFullName()
    {
        return fullName;
    }

    public String getLogin()
    {
        return login;
    }

    public String getPassword()
    {
        return password;
    }

    public String getMail()
    {
        return mail;
    }

    public String getFaculty()
    {
        return faculty;
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
    public UserModifyData(UserModifyData data)
    {
        this.userType = data.userType;
        this.fullName = data.fullName;
        this.login = data.login;
        this.password = data.password;
        this.mail = data.mail;
        this.faculty = data.faculty;
    }
}
