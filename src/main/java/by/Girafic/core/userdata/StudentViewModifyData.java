package by.Girafic.core.userdata;

import by.Girafic.core.commonds.ModifyConfirmation;

public class StudentViewModifyData extends UserViewModifyData
{
    public StudentViewModifyData(ModifyConfirmation<FullName> fullName, ModifyConfirmation<String> login, ModifyConfirmation<String> password, ModifyConfirmation<String> mail, ModifyConfirmation<String> faculty, ModifyConfirmation<Integer> course, ModifyConfirmation<Double> gpa, ModifyConfirmation<String> group)
    {
        super(fullName, login, password, mail, faculty);
        this.course = course;
        this.gpa = gpa;
        this.group = group;
    }

    public ModifyConfirmation<Integer> course;
    public ModifyConfirmation<Double> gpa;
    public ModifyConfirmation<String> group;

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
