package by.Girafic.core.userdata;
import by.Girafic.core.commonds.ModifyConfirmation;

public class UserViewModifyData
{
    public UserViewModifyData(ModifyConfirmation<FullName> fullName, ModifyConfirmation<String> login, ModifyConfirmation<String> password, ModifyConfirmation<String> mail, ModifyConfirmation<String> faculty)
    {
        this.fullName = fullName;
        this.login = login;
        this.password = password;
        this.mail = mail;
        this.faculty = faculty;
    }

    public ModifyConfirmation<FullName> fullName;
    public ModifyConfirmation<String> login;
    public ModifyConfirmation<String> password;
    public ModifyConfirmation<String> mail;
    public ModifyConfirmation<String> faculty;

    @Override
    public String toString()
    {
        return "UserViewModifyData{" +
                "fullName=" + fullName +
                ", login=" + login +
                ", password=" + password +
                ", mail=" + mail +
                ", faculty=" + faculty +
                '}';
    }
}
