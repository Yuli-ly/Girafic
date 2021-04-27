package by.girafic.controllers.request;

import by.girafic.core.commonds.LoginData;
import jakarta.servlet.http.HttpServletRequest;

public interface LoginGetter
{
    LoginData getLoginData(HttpServletRequest request);
}
