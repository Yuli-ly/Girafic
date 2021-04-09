package by.Girafic.core.validators;
import by.Girafic.core.userdata.FullName;


public class UserValidator
{
    private static CheckResult success = new CheckResult(true,"Успешно");
    public CheckResult checkLogin(String login)
    {
        return success;
    }
    public CheckResult checkFullName(FullName fullName)
    {
        return success;
    }
    public CheckResult checkPassword(String password)
    {
        return success;
    }
    public CheckResult checkMail(String mail)
    {
        return success;
    }
    public CheckResult checkFaculty(String faculty)
    {
        return success;
    }
    public CheckResult checkCourse(int course)
    {
        return success;
    }
    public CheckResult checkGPA(double gpa)
    {
        return success;
    }
    public CheckResult checkGroup(String group)
    {
        return success;
    }
    public CheckResult checkDepartment(String department)
    {
        return success;
    }
}
