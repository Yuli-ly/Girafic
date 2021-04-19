package by.Girafic.core.userdata;

import by.Girafic.core.commonds.ModifyConfirmation;
import static by.Girafic.core.commonds.ModifyConfirmation.*;

public class TeacherViewModifyData extends UserViewModifyData
{
    public TeacherViewModifyData(ModifyConfirmation<FullName> fullName, ModifyConfirmation<String> login, ModifyConfirmation<String> password, ModifyConfirmation<String> mail, ModifyConfirmation<String> faculty, ModifyConfirmation<String> department, ModifyConfirmation<String> post)
    {
        super(fullName, login, password, mail, faculty);
        this.department = department;
        this.post = post;
    }
    public TeacherViewModifyData(TeacherModifyData data)
    {
        super(successful(data.fullName), successful(data.login), successful(data.password), successful(data.mail), successful(data.faculty));
        department = successful(data.department);
        post = successful(data.post);
    }
    public ModifyConfirmation<String> department;
    public ModifyConfirmation<String> post;

    public ModifyConfirmation<String> getDepartment()
    {
        return department;
    }

    public ModifyConfirmation<String> getPost()
    {
        return post;
    }

    @Override
    public String toString()
    {
        return "TeacherViewModifyData{" +
                "department=" + department +
                ", post=" + post +
                ", fullName=" + fullName +
                ", login=" + login +
                ", password=" + password +
                ", mail=" + mail +
                ", faculty=" + faculty +
                '}';
    }
}
