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

@WebServlet(name = "contentServlet", value = "/content")
public class ContentServlet extends HttpServlet
{
    InteractorAccess interactorAccess = GlobalValuesAccess.getValues().interactorAccess;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        RequestParser parser = new RequestParser(request);
        int id = parser.takeID();
        LoginData ld = parser.takeLoginData();
        parser.setLoginData(ld);
        try
        {
            if(interactorAccess.checkExistence(ld))
            {
                switch (interactorAccess.getUserType(ld.login))
                {
                    case Student -> interactorAccess.studentLogin(ld, new StudentView(request, response, this)).getContent(id);
                    case Teacher -> interactorAccess.teacherLogin(ld, new TeacherView(request, response, this)).getContent(id);
                    case Admin -> interactorAccess.adminLogin(ld, new AdminView(request, response, this)).getContent(id);
                }
            }
            else
                new DefaultView(request, response, this).showError("Incorrect Login or Password");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
