package by.girafic.core.userdata.viewmodification;
import by.girafic.core.commonds.ModifyConfirmation;
import by.girafic.core.userdata.modification.UserModifyData;

import static by.girafic.core.commonds.ModifyConfirmation.*;

public class UserViewModifyData
{
    public int id;
    public final FullName fullName;
    public final ModifyConfirmation<String> login;
    public final ModifyConfirmation<String> password;
    public final ModifyConfirmation<String> mail;
    public final ModifyConfirmation<String> faculty;

    public UserViewModifyData(int id,
                              FullName fullName,
                              ModifyConfirmation<String> login,
                              ModifyConfirmation<String> password,
                              ModifyConfirmation<String> mail,
                              ModifyConfirmation<String> faculty)
    {
        this.id = id;
        this.fullName = fullName;
        this.login = login;
        this.password = password;
        this.mail = mail;
        this.faculty = faculty;
    }

    public FullName getFullName()
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
        fullName = new FullName(data.fullName);
        login = successful(data.login);
        password = successful(data.password);
        mail = successful(data.mail);
        faculty = successful(data.faculty);
    }

}
