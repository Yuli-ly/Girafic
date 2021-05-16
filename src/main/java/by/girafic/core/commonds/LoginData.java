package by.girafic.core.commonds;

public record LoginData(String login, String password)
{
    public String getLogin()
    {
        return login;
    }

    public String getPassword()
    {
        return password;
    }
}
