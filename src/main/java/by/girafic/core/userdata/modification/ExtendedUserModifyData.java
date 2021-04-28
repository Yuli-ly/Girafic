package by.girafic.core.userdata.modification;

import by.girafic.core.userdata.FullName;
import by.girafic.core.userdata.UserType;

public class ExtendedUserModifyData extends UserModifyData
{
    public final String department;
    public int[] courses;

    public ExtendedUserModifyData(UserType userType,
                                  FullName fullName,
                                  String login,
                                  String password,
                                  String mail,
                                  String faculty,
                                  String department,
                                  int[] courses)
    {
        super(userType, fullName, login, password, mail, faculty);
        this.department = department;
        this.courses = courses;
    }

    public ExtendedUserModifyData(UserModifyData data,
                                  String department,
                                  int[] courses)
    {
        super(data);
        this.department = department;
        this.courses = courses;
    }

    public ExtendedUserModifyData(ExtendedUserModifyData data)
    {
        super(data);
        this.courses = data.courses;
        this.department = data.department;
    }

    public String getDepartment()
    {
        return department;
    }

    public int[] getCourses()
    {
        return courses;
    }
}
