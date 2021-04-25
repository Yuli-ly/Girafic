package by.girafic.core.userdata;

import by.girafic.core.commonds.ModifyConfirmation;
import static by.girafic.core.commonds.ModifyConfirmation.*;


public class StudentViewModifyData extends UserViewModifyData
{
    public StudentViewModifyData(int id,
                                 ModifyConfirmation<FullName> fullName,
                                 ModifyConfirmation<String> login,
                                 ModifyConfirmation<String> password,
                                 ModifyConfirmation<String> mail,
                                 ModifyConfirmation<String> faculty,
                                 ModifyConfirmation<String> department,
                                 ModifyConfirmation<Integer> course,
                                 ModifyConfirmation<Double> gpa,
                                 ModifyConfirmation<String> group,
                                 ModifyConfirmation<int[]> courses)
    {
        super(id,fullName, login, password, mail, faculty);
        this.course = course;
        this.gpa = gpa;
        this.group = group;
        this.courses = courses;
        this.department = department;
    }

    public StudentViewModifyData(int id,StudentModifyData data)
    {
        super(id,data);
        course = successful(data.course);
        gpa = successful(data.gpa);
        group = successful(data.group);
        department = successful(data.department);
        courses = successful(data.courses);
    }

    public ModifyConfirmation<Integer> course;
    public ModifyConfirmation<Double> gpa;
    public ModifyConfirmation<String> group;
    public ModifyConfirmation<int[]> courses;
    public ModifyConfirmation<String> department;

    public ModifyConfirmation<Integer> getCourse()
    {
        return course;
    }

    public ModifyConfirmation<Double> getGpa()
    {
        return gpa;
    }

    public ModifyConfirmation<String> getGroup()
    {
        return group;
    }

    public ModifyConfirmation<int[]> getCourses()
    {
        return courses;
    }

    public ModifyConfirmation<String> getDepartment()
    {
        return department;
    }

    @Override
    public String toString()
    {
        return "StudentViewModifyData{" +
                "course=" + course +
                ", gpa=" + gpa +
                ", group=" + group +
                ", fullName=" + fullName +
                ", login=" + login +
                ", password=" + password +
                ", mail=" + mail +
                ", faculty=" + faculty +
                '}';
    }
}
