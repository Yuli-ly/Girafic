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

    public int course;
    public double gpa;
    public String group;
    public String department;
}
