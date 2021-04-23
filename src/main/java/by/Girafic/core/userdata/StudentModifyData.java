package by.Girafic.core.userdata;

import by.Girafic.core.commonds.UserType;

public class StudentModifyData extends UserModifyData
{
    public int course;
    public double gpa;
    public String group;
    public String department;
    public int[] courses;

    public StudentModifyData(UserType userType, FullName fullName, String login, String password, String mail, String faculty, int course, double gpa, String group, String department, int[] courses)
    {
        super(userType, fullName, login, password, mail, faculty);
        this.course = course;
        this.gpa = gpa;
        this.group = group;
        this.department = department;
        this.courses = courses;
    }

    public StudentModifyData(UserModifyData data,int course,double gpa,String group,String department, int[] courses)
    {
        super(data);
        this.course = course;
        this.gpa = gpa;
        this.group = group;
        this.department = department;
        this.courses = courses;
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
