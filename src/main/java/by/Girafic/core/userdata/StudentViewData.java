package by.Girafic.core.userdata;

public class StudentViewData extends UserViewData
{
    public StudentViewData(int id, FullName fullName, String mail, String faculty, int course, double gpa, String group, String department)
    {
        super(id, fullName, mail, faculty);
        this.course = course;
        this.gpa = gpa;
        this.group = group;
        this.department = department;
    }

    public StudentViewData(int userID,StudentModifyData s)
    {
        super(userID,s.fullName, s.mail, s.faculty);
        this.course = s.course;
        this.group = s.group;
        this.gpa = s.gpa;
        this.department = s.department;
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

    public int course;
    public double gpa;
    public String group;
    public String department;
}
