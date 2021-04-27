package by.girafic.controllers.request;

import by.girafic.core.commonds.LoginData;
import jakarta.servlet.http.HttpServletRequest;

public class AdminLoginGetter implements LoginGetter
{
    public static final AdminLoginGetter instance = new AdminLoginGetter();
    private AdminLoginGetter()
    {}
    @Override
    public LoginData getLoginData(HttpServletRequest request)
    {
        return new LoginData(request.getParameter("ALogin"),
                request.getParameter("APassword"));
    }
}
