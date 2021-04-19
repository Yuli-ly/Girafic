package by.Girafic.core.userdata;

import by.Girafic.core.commonds.ModifyConfirmation;

import static by.Girafic.core.commonds.ModifyConfirmation.successful;

public class AdminViewModifyData extends UserViewModifyData
{
    public AdminViewModifyData(ModifyConfirmation<FullName> fullName, ModifyConfirmation<String> login, ModifyConfirmation<String> password, ModifyConfirmation<String> mail, ModifyConfirmation<String> faculty)
    {
        super(fullName, login, password, mail, faculty);
    }

    public AdminViewModifyData(AdminModifyData data)
    {
        super(successful(data.fullName), successful(data.login), successful(data.password), successful(data.mail), successful(data.faculty));
    }

    @Override
    public String toString()
    {
        return "AdminViewModifyData{" +
                "fullName=" + fullName +
                ", login=" + login +
                ", password=" + password +
                ", mail=" + mail +
                ", faculty=" + faculty +
                '}';
    }
}
