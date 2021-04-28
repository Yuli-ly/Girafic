package by.girafic.core.userdata.view;

import by.girafic.core.userdata.modification.AdminModifyData;
import by.girafic.core.userdata.FullName;

public class AdminViewData extends UserViewData
{
    @Override
    public String toString()
    {
        return "AdminViewData{" +
                "id=" + id +
                ", fullName=" + fullName +
                ", mail='" + mail + '\'' +
                ", faculty='" + faculty + '\'' +
                '}';
    }

    public AdminViewData(int id, FullName fullName, String mail, String faculty)
    {
        super(id, fullName, mail, faculty);
    }

    public AdminViewData(int id, AdminModifyData a)
    {
        super(id, a.fullName, a.mail, a.faculty);
    }
}
