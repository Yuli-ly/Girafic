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

@WebServlet("/content")
@MultipartConfig(
        fileSizeThreshold = 1024 * 10,  // 10 KB
        maxFileSize = 1024 * 300,       // 300 KB
        maxRequestSize = 1024 * 1024    // 1 MB
)
public class ContentServlet extends HttpServlet
{
    InteractorAccess interactorAccess = GlobalValuesAccess.getValues().interactorAccess;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        ServletRequestParser parser = new ServletRequestParser(request);
        int id = parser.takeID();
        LoginData ld = parser.takeLoginData();
        parser.setLoginData(ld);
        try
        {
            if(interactorAccess.checkExistence(ld))
            {
                switch (interactorAccess.getUserType(ld.login))
                {
                    case Student -> interactorAccess.studentLogin(ld, new StudentView(request, response)).getContent(id);
                    case Teacher -> interactorAccess.teacherLogin(ld, new TeacherView(request, response)).getContent(id);
                    case Admin -> interactorAccess.adminLogin(ld, new AdminView(request, response)).getContent(id);
                }
            }
            else
                new DefaultView(request, response).showError("Incorrect Login or Password");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
