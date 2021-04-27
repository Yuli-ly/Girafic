package by.girafic.core.commonds;

public class LoginData
{
    public final String login;
    public final String password;

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
