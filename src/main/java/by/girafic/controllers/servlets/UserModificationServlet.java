package by.girafic.controllers.servlets;

import by.girafic.controllers.util.GlobalValuesAccess;
import by.girafic.controllers.util.ServletRequestParser;
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
        ServletRequestParser parser = new ServletRequestParser(request);
        LoginData ld = parser.takeAdminLoginData();
        int userModID = parser.takeID();
        parser.setLoginData(ld);
        parser.setID(userModID);
        try
        {
            if (interactorAccess.checkExistence(ld))
                interactorAccess.adminLogin(ld, new AdminView(request, response)).showUserForModification(userModID);
             else
                new DefaultView(request, response).showError("Incorrect Login or Password");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        ServletRequestParser parser = new ServletRequestParser(request);
        LoginData ld = parser.takeAdminLoginData();
        int id = parser.takeID();
        parser.setLoginData(ld);
        parser.setID(id);
        try
        {
        if(interactorAccess.checkExistence(ld))
        {
            AdminInteractor interactor = interactorAccess.adminLogin(ld, new AdminView(request, response));

                switch (parser.takeUserType())
                {
                    case Student -> interactor.modifyUser(parser.takeStudentData(), id);
                    case Teacher -> interactor.modifyUser(parser.takeTeacherData(), id);
                    case Admin -> interactor.modifyUser(parser.takeAdminData(), id);
                }

        }
        else
            new DefaultView(request,response).showError("Invalid username or password");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
