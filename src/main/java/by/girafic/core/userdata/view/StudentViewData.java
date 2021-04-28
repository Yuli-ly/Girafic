package by.girafic.core.userdata.view;

import by.girafic.core.contentdata.ContentLinkData;
import by.girafic.core.userdata.FullName;
import by.girafic.core.userdata.modification.StudentModifyData;
import by.girafic.core.userdata.modification.UserModifyData;

public class StudentViewData extends ExtendedUserViewData
{
    public final int course;
    public final double gpa;
    public final String group;

    public StudentViewData(int id,
                           FullName fullName,
                           String mail,
                           String faculty,
                           String department,
                           ContentLinkData[] courses,
                           int course,
                           double gpa,
                           String group)
    {
        super(id, fullName, mail, faculty, department, courses);
        this.course = course;
        this.gpa = gpa;
        this.group = group;
    }

    public StudentViewData(int id,StudentModifyData data,ContentLinkData[] courses)
    {
        super(id,data, data.department, courses);
        this.course = data.course;
        this.gpa = data.gpa;
        this.group = data.group;
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

}
