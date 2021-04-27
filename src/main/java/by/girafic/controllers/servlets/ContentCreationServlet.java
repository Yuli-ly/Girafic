package by.girafic.controllers.servlets;

import by.girafic.controllers.request.ContentRequestWrapper;
import by.girafic.controllers.request.DefaultLoginGetter;
import by.girafic.controllers.request.DefaultLoginSetter;
import by.girafic.controllers.util.GlobalValuesAccess;
import by.girafic.core.commonds.LoginData;
import by.girafic.core.interactors.InteractorAccess;
import by.girafic.core.interactors.TeacherInteractor;
import by.girafic.webview.AdminView;
import by.girafic.webview.DefaultView;
import by.girafic.webview.TeacherView;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/contentCreation")
@MultipartConfig(
        fileSizeThreshold = 1024 * 10,  // 10 KB
        maxFileSize = 1024 * 300,       // 300 KB
        maxRequestSize = 1024 * 1024    // 1 MB
)
public class ContentCreationServlet extends HttpServlet
{
    private final InteractorAccess interactorAccess = GlobalValuesAccess.getValues().interactorAccess;
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ContentRequestWrapper wrapper = new ContentRequestWrapper(request,response,
                DefaultLoginSetter.instance, DefaultLoginGetter.instance);
        LoginData ld = wrapper.takeLogin();
        if(interactorAccess.checkUserExistence(ld))
        {
            try
            {
                TeacherInteractor interactor =
                        switch (interactorAccess.getUserType(ld.login))
                                {
                                    case Teacher -> interactorAccess.teacherLogin(ld, new TeacherView(wrapper));
                                    case Admin -> interactorAccess.adminLogin(ld, new AdminView(wrapper));
                                    default -> throw new IllegalArgumentException();
                                };
                switch (wrapper.takeContentType())
                {
                    case Course -> interactor.createContent(wrapper.takeCourse());
                    case Section -> interactor.createContent(wrapper.takeSection());
                    case Material -> interactor.createContent(wrapper.takeMaterial());
                }
            }
            catch (Exception e)
            {
                new DefaultView(wrapper)
                        .showError("You do not have permission to create content and " + e.getMessage());
            }
        }
        else
        {
            new DefaultView(wrapper).showError("Invalid username or password");
        }
    }
}
