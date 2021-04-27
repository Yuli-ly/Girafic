package by.girafic.controllers.servlets;

import by.girafic.controllers.util.GlobalValuesAccess;
import by.girafic.controllers.request.AdminLoginGetter;
import by.girafic.controllers.request.DefaultLoginSetter;
import by.girafic.controllers.request.UserRequestWrapper;
import by.girafic.core.commonds.LoginData;
import by.girafic.core.interactors.AdminInteractor;
import by.girafic.core.interactors.InteractorAccess;
import by.girafic.webview.AdminView;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registration")
@MultipartConfig(
        fileSizeThreshold = 1024 * 10,  // 10 KB
        maxFileSize = 1024 * 300,       // 300 KB
        maxRequestSize = 1024 * 1024    // 1 MB
)
public class RegistrationServlet extends HttpServlet
{
    private final InteractorAccess interactorAccess = GlobalValuesAccess.getValues().interactorAccess;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        UserRequestWrapper wrapper = new UserRequestWrapper(request,response,
                DefaultLoginSetter.instance, AdminLoginGetter.instance);
        LoginData ld = wrapper.takeLogin();
        try
        {
            AdminInteractor interactor = interactorAccess.adminLogin(ld,new AdminView(wrapper));
            switch (wrapper.takeUserType())
            {
                case Student -> interactor.createUser(wrapper.takeStudentData());
                case Teacher -> interactor.createUser(wrapper.takeTeacherData());
                case Admin -> interactor.createUser(wrapper.takeAdminData());
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
