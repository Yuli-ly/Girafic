package by.girafic.controllers.servlets;

import by.girafic.controllers.util.GlobalValuesAccess;
import by.girafic.controllers.request.DefaultLoginGetter;
import by.girafic.controllers.request.DefaultLoginSetter;
import by.girafic.controllers.request.RequestWrapper;
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
        RequestWrapper wrapper = new RequestWrapper(request,response,
                DefaultLoginSetter.instance,
                DefaultLoginGetter.instance);
        LoginData ld = wrapper.takeLogin();
        try
        {
            if (interactorAccess.checkExistence(ld))
            {
                switch (interactorAccess.getUserType(ld.login))
                {
                    case Student -> interactorAccess.studentLogin(ld, new StudentView(wrapper)).getStartPage();
                    case Teacher -> interactorAccess.teacherLogin(ld, new TeacherView(wrapper)).getStartPage();
                    case Admin -> interactorAccess.adminLogin(ld, new AdminView(wrapper)).getStartPage();
                }
            } else
                new DefaultView(request, response).showError("Invalid username or password");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
