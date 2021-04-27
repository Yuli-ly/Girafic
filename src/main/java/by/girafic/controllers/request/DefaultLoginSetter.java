package by.girafic.controllers.request;

import by.girafic.core.commonds.LoginData;
import jakarta.servlet.http.HttpServletRequest;

public class DefaultLoginSetter implements LoginSetter
{
    public static final DefaultLoginSetter instance = new DefaultLoginSetter();
    private DefaultLoginSetter()
    {}
    @Override
    public void setLoginData(HttpServletRequest request, LoginData data)
    {
        request.setAttribute("login",data.login);
        request.setAttribute("password",data.password);
    }
}
