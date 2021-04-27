package by.girafic.core.userdata;

public class StudentModifyData extends UserModifyData
{
    public final int course;
    public final double gpa;
    public final String group;
    public final String department;
    public final int[] courses;

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
