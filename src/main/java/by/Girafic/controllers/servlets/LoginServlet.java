package by.Girafic.controllers.servlets;

import by.Girafic.controllers.util.GlobalValuesAccess;
import by.Girafic.controllers.util.ServletRequestParser;
import by.Girafic.core.commonds.LoginData;
import by.Girafic.core.interactors.InteractorAccess;
import by.Girafic.webview.AdminView;
import by.Girafic.webview.DefaultView;
import by.Girafic.webview.StudentView;
import by.Girafic.webview.TeacherView;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
@MultipartConfig(
        fileSizeThreshold = 1024 * 10,  // 10 KB
        maxFileSize = 1024 * 300,       // 300 KB
        maxRequestSize = 1024 * 1024    // 1 MB
)
public class LoginServlet extends HttpServlet
{
    final InteractorAccess interactorAccess = GlobalValuesAccess.getValues().interactorAccess;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        ServletRequestParser parser = new ServletRequestParser(request);
        LoginData ld = parser.takeLoginData();
        parser.setLoginData(ld);
        try
        {
            if (interactorAccess.checkExistence(ld))
            {
                switch (interactorAccess.getUserType(ld.login))
                {
                    case Student -> interactorAccess.studentLogin(ld, new StudentView(request, response)).getStartPage();
                    case Teacher -> interactorAccess.teacherLogin(ld, new TeacherView(request, response)).getStartPage();
                    case Admin -> interactorAccess.adminLogin(ld, new AdminView(request, response)).getStartPage();
                }
            } else
                new DefaultView(request, response).showError("Invalid username or password");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
