package by.Girafic.controllers.servlets;

import by.Girafic.controllers.util.GlobalValuesAccess;
import by.Girafic.core.commonds.LoginData;
import by.Girafic.core.interactors.InteractorAccess;
import by.Girafic.webview.AdminView;
import by.Girafic.webview.DefaultView;
import by.Girafic.webview.StudentView;
import by.Girafic.webview.TeacherView;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet
{
    final InteractorAccess interactorAccess = GlobalValuesAccess.getValues().interactorAccess;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        response.setContentType("text/html");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        LoginData ld = new LoginData(login, password);

        request.setAttribute("login", login);
        request.setAttribute("password", password);
        try
        {

            if (interactorAccess.checkExistence(ld))
            {
                switch (interactorAccess.getUserType(login))
                {
                    case Student -> interactorAccess.studentLogin(ld, new StudentView(request, response, this)).getStartPage();
                    case Teacher -> interactorAccess.teacherLogin(ld, new TeacherView(request, response, this)).getStartPage();
                    case Admin -> interactorAccess.adminLogin(ld, new AdminView(request, response, this)).getStartPage();
                }
            } else
            {
                new DefaultView(request, response, this).showError("Неверный логин или пароль Login or Password");
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
