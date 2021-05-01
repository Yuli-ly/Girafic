package by.girafic.controllers.servlets;

import by.girafic.controllers.util.GlobalValuesAccess;
import by.girafic.controllers.request.AdminLoginGetter;
import by.girafic.controllers.request.DefaultLoginSetter;
import by.girafic.controllers.request.RequestWrapper;
import by.girafic.controllers.request.UserRequestWrapper;
import by.girafic.core.commonds.LoginData;
import by.girafic.core.interactors.AdminInteractor;
import by.girafic.core.interactors.InteractorAccess;
import by.girafic.webview.AdminView;
import by.girafic.webview.DefaultView;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/userModification")
@MultipartConfig(
        fileSizeThreshold = 1024 * 10,  // 10 KB
        maxFileSize = 1024 * 300,       // 300 KB
        maxRequestSize = 1024 * 1024    // 1 MB
)
public class UserModificationServlet extends HttpServlet
{
    private final InteractorAccess interactorAccess = GlobalValuesAccess.getValues().interactorAccess;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        RequestWrapper wrapper = new RequestWrapper(request,response,
                DefaultLoginSetter.instance,AdminLoginGetter.instance);
        LoginData ld = wrapper.takeLogin();
        int userModID = wrapper.takeID();
        wrapper.setID(userModID);
        try
        {
            if (interactorAccess.checkUserExistence(ld))
                interactorAccess.adminLogin(ld, new AdminView(wrapper)).showUserForModification(userModID);
             else
                new DefaultView(wrapper).showError("Incorrect Login or Password");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        UserRequestWrapper wrapper = new UserRequestWrapper(request,response,
                DefaultLoginSetter.instance, AdminLoginGetter.instance);
        LoginData ld = wrapper.takeLogin();
        int id = wrapper.takeID();
        wrapper.setID(id);
        try
        {
            if (wrapper.deleteAction())
            {
                interactorAccess.adminLogin(ld,new AdminView(wrapper)).removeUser(id);
            } else
            {
                if (interactorAccess.checkUserExistence(ld))
                {
                    AdminInteractor interactor = interactorAccess.adminLogin(ld, new AdminView(wrapper));

                    switch (wrapper.takeUserType())
                    {
                        case Student -> interactor.modifyUser(wrapper.takeStudentData(), id);
                        case Teacher -> interactor.modifyUser(wrapper.takeTeacherData(), id);
                        case Admin -> interactor.modifyUser(wrapper.takeAdminData(), id);
                    }

                } else
                    new DefaultView(wrapper).showError("Invalid username or password");
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
