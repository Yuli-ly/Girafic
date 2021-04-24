package by.Girafic.controllers.util;

import by.Girafic.core.commonds.LoginData;
import jakarta.servlet.http.HttpServletRequest;

public class JspModifyRequestParser
{
    private HttpServletRequest request;
    private LoginData ld;
    private String path;

    public JspModifyRequestParser(HttpServletRequest request)
    {
        this.request = request;
        this.ld = ld;
        this.path = path;
    }

}
