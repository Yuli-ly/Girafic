package by.girafic.core.userdata;

import by.girafic.core.contentdata.ContentLinkData;

public class StudentViewData extends UserViewData
{
    public StudentViewData(int id, FullName fullName, String mail, String faculty, int course, double gpa, String group, String department, ContentLinkData[] courses)
    {
        super(id, fullName, mail, faculty);
        this.course = course;
        this.gpa = gpa;
        this.group = group;
        this.department = department;
        this.courses = courses;
    }

    public StudentViewData(int userID, StudentModifyData s,ContentLinkData[] courses)
    {
        super(userID,s.fullName, s.mail, s.faculty);
        this.course = s.course;
        this.group = s.group;
        this.gpa = s.gpa;
        this.department = s.department;
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

    public int course;
    public double gpa;
    public String group;
    public String department;
    public ContentLinkData[] courses;
}
