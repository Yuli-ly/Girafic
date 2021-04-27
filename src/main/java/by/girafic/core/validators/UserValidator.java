package by.girafic.core.validators;
import by.girafic.core.userdata.FullName;


public class UserValidator
{
    private static final CheckResult success = new CheckResult(true,"Успешно");
    public static CheckResult checkLogin(String login)
    {
        return success;
    }
    public static CheckResult checkFullName(FullName fullName)
    {
        return success;
    }
    public static CheckResult checkPassword(String password)
    {
        return success;
    }
    public static CheckResult checkMail(String mail)
    {
        return success;
    }
    public static CheckResult checkFaculty(String faculty)
    {
        return success;
    }
    public static CheckResult checkCourse(int course)
    {
        return success;
    }
    public static CheckResult checkGPA(double gpa)
    {
        return success;
    }
    public static CheckResult checkGroup(String group)
    {
        return success;
    }
    public static CheckResult checkDepartment(String department)
    {
        return success;
    }
}
