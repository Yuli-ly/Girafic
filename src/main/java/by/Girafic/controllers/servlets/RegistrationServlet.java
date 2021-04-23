package by.Girafic.controllers.servlets;

import by.Girafic.controllers.util.GlobalValuesAccess;
import by.Girafic.core.commonds.LoginData;
import by.Girafic.core.commonds.UserType;
import by.Girafic.core.interactors.InteractorAccess;
import by.Girafic.core.userdata.FullName;
import by.Girafic.core.userdata.StudentModifyData;
import by.Girafic.webview.AdminView;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "registrationServlet", value = "/registration")
public class RegistrationServlet extends HttpServlet
{
    private final InteractorAccess interactorAccess = GlobalValuesAccess.getValues().interactorAccess;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        response.setContentType("text/html");
        String adminLogin = request.getParameter("ALogin");
        String adminPassword = request.getParameter("APassword");
        String login = request.getParameter("Login");
        String password = request.getParameter("Password");
        String name = request.getParameter("Name");
        String surname = request.getParameter("Surname");
        String mail = request.getParameter("Mail");
        String patronymic = request.getParameter("Patronymic");
        String faculty = request.getParameter("Faculty");
        try
        {
            switch (request.getParameter("Type"))
            {
                case "student" -> {
                    double gpa = Double.parseDouble(request.getParameter("GPA"));
                    int course = Integer.parseInt(request.getParameter("Course"));
                    String group = request.getParameter("Group");
                    String department = request.getParameter("Department");

                    interactorAccess.adminLogin(new LoginData(adminLogin, adminPassword),
                            new AdminView(request, response, this))
                            .createUser(new StudentModifyData(
                                    UserType.Student,
                                    new FullName(name, surname, patronymic), login, password, mail,
                                    faculty, course, gpa, group, department, new int[]{}));
                }

                case "teacher" -> {
                }
                case "admin" -> {
                }
                default -> {
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
