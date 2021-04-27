package by.girafic.controllers.request;

import by.girafic.core.commonds.LoginData;
import jakarta.servlet.http.HttpServletRequest;

public class DefaultLoginGetter implements LoginGetter
{
    public static final DefaultLoginGetter instance = new DefaultLoginGetter();
    private DefaultLoginGetter()
    {}
    @Override
    public LoginData getLoginData(HttpServletRequest request)
    {
        return new LoginData(request.getParameter("login"),
                request.getParameter("password"));
    }
}
