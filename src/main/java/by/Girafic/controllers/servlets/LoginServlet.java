package by.Girafic.controllers.servlets;

import by.Girafic.controllers.util.GlobalValuesAccess;
import by.Girafic.controllers.util.RequestParser;
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
        RequestParser parser = new RequestParser(request);
        LoginData ld = parser.takeLoginData();
        parser.setLoginData(ld);
        try
        {
            if (interactorAccess.checkExistence(ld))
            {
                switch (interactorAccess.getUserType(ld.login))
                {
                    case Student -> interactorAccess.studentLogin(ld, new StudentView(request, response, this)).getStartPage();
                    case Teacher -> interactorAccess.teacherLogin(ld, new TeacherView(request, response, this)).getStartPage();
                    case Admin -> interactorAccess.adminLogin(ld, new AdminView(request, response, this)).getStartPage();
                }
            } else
                new DefaultView(request, response, this).showError("Invalid username or password");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
