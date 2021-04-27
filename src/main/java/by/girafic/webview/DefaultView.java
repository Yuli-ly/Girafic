package by.girafic.webview;

import by.girafic.controllers.request.RequestWrapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DefaultView
{
    private final RequestWrapper wrapper;
    public DefaultView(RequestWrapper wrapper)
    {
        this.wrapper = wrapper;
    }

    public void showError(String message) throws ServletException, IOException
    {
        wrapper.setMessage(message);
        wrapper.forward("/jsp/error.jsp");
    }
}
