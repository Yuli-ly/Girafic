package by.girafic.core.userdata;
import by.girafic.core.commonds.ModifyConfirmation;
import static by.girafic.core.commonds.ModifyConfirmation.*;

public class UserViewModifyData
{
    public UserViewModifyData(int id,
                              ModifyConfirmation<FullName> fullName,
                              ModifyConfirmation<String> login,
                              ModifyConfirmation<String> password,
                              ModifyConfirmation<String> mail,
                              ModifyConfirmation<String> faculty)
    {
        this.fullName = fullName;
        this.login = login;
        this.password = password;
        this.mail = mail;
        this.faculty = faculty;
    }

    public ModifyConfirmation<FullName> getFullName()
    {
        return fullName;
    }

    public ModifyConfirmation<String> getLogin()
    {
        return login;
    }

    public ModifyConfirmation<String> getPassword()
    {
        return password;
    }

    public ModifyConfirmation<String> getMail()
    {
        return mail;
    }

    public ModifyConfirmation<String> getFaculty()
    {
        return faculty;
    }

    public int getId()
    {
        return id;
    }

    public UserViewModifyData(int id, UserModifyData data)
    {
        this.id = id;
        fullName = successful(data.fullName);
        login = successful(data.login);
        password = successful(data.password);
        mail = successful(data.mail);
        faculty = successful(data.faculty);
    }
    public int id;
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
