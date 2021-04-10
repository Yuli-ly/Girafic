package by.Girafic.core.userdata;

import by.Girafic.core.commonds.UserType;

public class StudentModifyData extends UserModifyData
{
    public int course;
    public double gpa;

    public StudentModifyData(UserType userType, FullName fullName, String login, String password, String mail, String faculty, int course, double gpa, String group, String department, int[] courses)
    {
        super(userType, fullName, login, password, mail, faculty);
        this.course = course;
        this.gpa = gpa;
        this.group = group;
        this.department = department;
        this.courses = courses;
    }

    public String group;
    public String department;
    public int[] courses;
}
