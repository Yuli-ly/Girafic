package by.girafic.webview;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DefaultView
{
    private final HttpServletRequest request;
    private final HttpServletResponse response;
    public DefaultView(HttpServletRequest request, HttpServletResponse response)
    {
        this.request = request;
        this.response = response;
    }

    public void showError(String message) throws ServletException, IOException
    {
        request.setAttribute("Message",message);
        request.getServletContext().getRequestDispatcher("/error.jsp").forward(request,response);
    }
}
