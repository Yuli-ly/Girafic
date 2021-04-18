package by.Girafic;

import by.Girafic.core.commonds.LoginData;
import by.Girafic.core.interactors.InteractorAccess;
import by.Girafic.database.InMemoryDataBase;
import by.Girafic.webpresenters.AdminWebPresenter;
import by.Girafic.webpresenters.StudentWebPresenter;
import by.Girafic.webpresenters.TeacherWebPresenter;
import by.Girafic.webview.AdminWebView;
import by.Girafic.webview.StudentWebView;
import by.Girafic.webview.TeacherWebView;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet
{
    InteractorAccess interactorAccess;
    public void init()
    {
        InMemoryDataBase db = new InMemoryDataBase();
        interactorAccess = new InteractorAccess(db,db);
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        response.setContentType("text/html");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        LoginData ld = new LoginData(login,password);
        switch (interactorAccess.getUserType(login))
        {
            case Student -> interactorAccess.studentLogin(ld,new StudentWebPresenter(new StudentWebView(response))).getStartPage();
            case Teacher -> interactorAccess.teacherLogin(ld,new TeacherWebPresenter(new TeacherWebView(response))).getStartPage();
            case Admin -> interactorAccess.adminLogin(ld,new AdminWebPresenter(new AdminWebView(response))).getStartPage();
        }
    }
}
