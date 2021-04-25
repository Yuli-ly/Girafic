package by.girafic.core.userdata;

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

    public AdminViewData(int id,AdminModifyData a)
    {
        super(id, a.fullName, a.mail, a.faculty);
    }
}
