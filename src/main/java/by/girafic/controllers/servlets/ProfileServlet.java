package by.girafic.controllers.servlets;

import by.girafic.controllers.util.GlobalValuesAccess;
import by.girafic.controllers.util.ServletRequestParser;
import by.girafic.core.commonds.LoginData;
import by.girafic.core.interactors.InteractorAccess;
import by.girafic.webview.AdminView;
import by.girafic.webview.DefaultView;
import by.girafic.webview.StudentView;
import by.girafic.webview.TeacherView;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/profile")
@MultipartConfig(
        fileSizeThreshold = 1024 * 10,  // 10 KB
        maxFileSize = 1024 * 300,       // 300 KB
        maxRequestSize = 1024 * 1024    // 1 MB
)
public class ProfileServlet extends HttpServlet
{
    final InteractorAccess interactorAccess = GlobalValuesAccess.getValues().interactorAccess;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        ServletRequestParser parser = new ServletRequestParser(request);
        int id = parser.takeID();
        LoginData ld = parser.takeLoginData();
        parser.setLoginData(ld);
        try
        {
            if (interactorAccess.checkExistence(id) && interactorAccess.checkExistence(ld))
            {
                switch (interactorAccess.getUserType(ld.login))
                {
                    case Student -> interactorAccess.studentLogin(ld, new StudentView(request, response)).getProfile(id);
                    case Teacher -> interactorAccess.teacherLogin(ld, new TeacherView(request, response)).getProfile(id);
                    case Admin -> interactorAccess.adminLogin(ld, new AdminView(request, response)).getProfile(id);
                }
            } else
            {
                new DefaultView(request, response).showError("Invalid username or password, or the requested user does not exist");
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
