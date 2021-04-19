package by.Girafic.controllers;

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
import jakarta.servlet.http.Cookie;
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
        LoginData ld = new LoginData(login,password);

        request.setAttribute("login",login);
        request.setAttribute("password",password);
        if(interactorAccess.checkExistence(ld))
        {
            switch (interactorAccess.getUserType(login))
            {
                case Student -> interactorAccess.studentLogin(ld, new StudentPresenter(new StudentView(request,response,this))).getStartPage();
                case Teacher -> interactorAccess.teacherLogin(ld, new TeacherPresenter(new TeacherView(request,response,this))).getStartPage();
                case Admin -> interactorAccess.adminLogin(ld, new AdminPresenter(new AdminView(request,response,this))).getStartPage();
            }
        }
        else
        {
            new DefaultView(request,response,this).showError("Неверный логин или пароль Login or Password");
        }
    }
}
