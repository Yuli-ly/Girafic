package by.Girafic;

import java.io.*;

import by.Girafic.core.commonds.LoginData;
import by.Girafic.core.database.ContentDataBase;
import by.Girafic.core.database.UserDataBase;
import by.Girafic.core.interactors.AdminInteractor;
import by.Girafic.core.interactors.InteractorAccess;
import by.Girafic.core.presenters.AdminPresenter;
import by.Girafic.database.InMemoryDataBase;
import by.Girafic.webpresenters.AdminPresenterImpl;
import by.Girafic.webview.AdminViewImpl;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet
{
    private InteractorAccess interactorAccess;
    private ContentDataBase contentDataBase;
    private UserDataBase userDataBase;
    private AdminInteractor adminInteractor;
    private AdminPresenter adminPresenter;
    private AdminViewImpl adminView;

    public void init()
    {
        adminView = new AdminViewImpl();
        adminPresenter = new AdminPresenterImpl(adminView);
        InMemoryDataBase db = new InMemoryDataBase();
        contentDataBase = db;
        userDataBase = db;
        interactorAccess = new InteractorAccess(contentDataBase,userDataBase,adminPresenter);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html");
        adminInteractor = interactorAccess.adminLogin(new LoginData("login","password"));
        adminView.setResponse(response);
        adminInteractor.getStartPage();

    }

    public void destroy()
    {
    }
}