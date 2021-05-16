package by.girafic.controllers.servlets;

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

@WebServlet("/profile")
@MultipartConfig(
        fileSizeThreshold = 1024 * 10,  // 10 KB
        maxFileSize = 1024 * 300,       // 300 KB
        maxRequestSize = 1024 * 1024    // 1 MB
)
public class ProfileServlet extends HttpServlet
{
    final InteractorAccess interactorAccess = InteractorAccessFactory.getInteractorAccess();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        RequestWrapper wrapper = new RequestWrapper(request,response,
                DefaultLoginSetter.instance,
                DefaultLoginGetter.instance);
        LoginData ld = wrapper.takeLogin();
        int id = wrapper.takeID();
        try
        {
            if (interactorAccess.checkUserExistence(id) && interactorAccess.checkUserExistence(ld))
            {
                switch (interactorAccess.getUserType(ld.login()))
                {
                    case Student -> interactorAccess.studentLogin(ld, new StudentView(wrapper)).getProfile(id);
                    case Teacher -> interactorAccess.teacherLogin(ld, new TeacherView(wrapper)).getProfile(id);
                    case Admin -> interactorAccess.adminLogin(ld, new AdminView(wrapper)).getProfile(id);
                }
            } else
            {
                new DefaultView(wrapper).showError("Invalid username or password, or the requested user does not exist");
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
