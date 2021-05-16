package by.girafic.webview;

import by.girafic.controllers.request.RequestWrapper;
import jakarta.servlet.ServletException;

import java.io.IOException;

public record DefaultView(RequestWrapper wrapper)
{
    public void showError(String message) throws ServletException, IOException
    {
        wrapper.setMessage(message);
        wrapper.forward("/jsp/error.jsp");
    }
}
