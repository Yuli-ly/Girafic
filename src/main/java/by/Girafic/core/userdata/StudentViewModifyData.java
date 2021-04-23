package by.Girafic.core.userdata;

import by.Girafic.core.commonds.ModifyConfirmation;
import static by.Girafic.core.commonds.ModifyConfirmation.*;


public class StudentViewModifyData extends UserViewModifyData
{
    public StudentViewModifyData(ModifyConfirmation<FullName> fullName, ModifyConfirmation<String> login, ModifyConfirmation<String> password, ModifyConfirmation<String> mail, ModifyConfirmation<String> faculty, ModifyConfirmation<Integer> course, ModifyConfirmation<Double> gpa, ModifyConfirmation<String> group, ModifyConfirmation<int[]> courses)
    {
        super(fullName, login, password, mail, faculty);
        this.course = course;
        this.gpa = gpa;
        this.group = group;
        this.courses = courses;
    }

    public StudentViewModifyData(StudentModifyData data)
    {
        super(successful(data.fullName),successful(data.login),successful(data.password),successful(data.mail),successful(data.faculty));
        course = successful(data.course);
        gpa = successful(data.gpa);
        group = successful(data.group);
        courses = successful(data.courses);
    }

    public ModifyConfirmation<Integer> course;
    public ModifyConfirmation<Double> gpa;
    public ModifyConfirmation<String> group;
    public ModifyConfirmation<int[]> courses;

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
