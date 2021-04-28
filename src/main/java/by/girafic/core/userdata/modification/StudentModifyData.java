package by.girafic.core.userdata.modification;

import by.girafic.core.userdata.FullName;
import by.girafic.core.userdata.UserType;

public class StudentModifyData extends ExtendedUserModifyData
{
    public final int course;
    public final double gpa;
    public final String group;

    public StudentModifyData(UserType userType,
                             FullName fullName,
                             String login,
                             String password,
                             String mail,
                             String faculty,
                             String department,
                             int[] courses,
                             int course,
                             double gpa,
                             String group)
    {
        super(userType,
                fullName,
                login,
                password,
                mail,
                faculty,
                department,
                courses);
        this.course = course;
        this.gpa = gpa;
        this.group = group;
    }

    public StudentModifyData(ExtendedUserModifyData data,
                             int course,
                             double gpa,
                             String group)
    {
        super(data);
        this.course = course;
        this.gpa = gpa;
        this.group = group;
    }


    public int getCourse()
    {
        return course;
    }

    public double getGpa()
    {
        return gpa;
    }

    public String getGroup()
    {
        return group;
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
