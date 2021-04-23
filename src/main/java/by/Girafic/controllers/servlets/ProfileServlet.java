package by.Girafic.controllers.servlets;

import by.Girafic.controllers.util.GlobalValuesAccess;
import by.Girafic.core.commonds.LoginData;
import by.Girafic.core.interactors.InteractorAccess;
import by.Girafic.webpresenters.AdminPresenter;
import by.Girafic.webpresenters.StudentPresenter;
import by.Girafic.webpresenters.TeacherPresenter;
import by.Girafic.webview.AdminView;
import by.Girafic.webview.DefaultView;
import by.Girafic.webview.StudentView;
import by.Girafic.webview.TeacherView;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "profileServlet",value = "/profile")
public class ProfileServlet extends HttpServlet
{
    final InteractorAccess interactorAccess = GlobalValuesAccess.getValues().interactorAccess;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        response.setContentType("text/html");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        int id = Integer.parseInt(request.getParameter("id"));

        LoginData ld = new LoginData(login,password);

        request.setAttribute("login",login);
        request.setAttribute("password",password);

        if(interactorAccess.checkExistence(id) && interactorAccess.checkExistence(ld))
        {
            switch (interactorAccess.getUserType(login))
            {
                case Student -> interactorAccess.studentLogin(ld, new StudentPresenter(new StudentView(request,response,this))).getProfile(id);
                case Teacher -> interactorAccess.teacherLogin(ld, new TeacherPresenter(new TeacherView(request,response,this))).getProfile(id);
                case Admin -> interactorAccess.adminLogin(ld, new AdminPresenter(new AdminView(request,response,this))).getProfile(id);
            }
        }
        else
        {
            new DefaultView(request,response,this).showError("Неверный логин или пароль, или запрашиваемого пользователя не существует");
        }
    }
}
