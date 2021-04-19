package by.Girafic.core.commonds;

public class LoginData
{
    public String login;
    public String password;

    public String getLogin()
    {
        return login;
    }

    public String getPassword()
    {
        return password;
    }

    public LoginData(String login, String password)
    {
        this.login = login;
        this.password = password;
    }
}
