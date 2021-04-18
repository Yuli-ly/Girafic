package by.Girafic.core.userdata;

import by.Girafic.core.commonds.ModifyConfirmation;

public class TeacherViewModifyData extends UserViewModifyData
{
    public TeacherViewModifyData(ModifyConfirmation<FullName> fullName, ModifyConfirmation<String> login, ModifyConfirmation<String> password, ModifyConfirmation<String> mail, ModifyConfirmation<String> faculty, ModifyConfirmation<String> department, ModifyConfirmation<String> faculty1, ModifyConfirmation<String> post)
    {
        super(fullName, login, password, mail, faculty);
        this.department = department;
        this.faculty = faculty1;
        this.post = post;
    }

    public ModifyConfirmation<String> department;
    public ModifyConfirmation<String> faculty;
    public ModifyConfirmation<String> post;

    @Override
    public String toString()
    {
        return "TeacherViewModifyData{" +
                "department=" + department +
                ", faculty=" + faculty +
                ", post=" + post +
                ", fullName=" + fullName +
                ", login=" + login +
                ", password=" + password +
                ", mail=" + mail +
                ", faculty=" + faculty +
                '}';
    }
}
