package by.Girafic.core.userdata;

public class UserViewData
{
    public int id;
    public FullName fullName;
    public String mail;
    public String faculty;

    @Override
    public String toString()
    {
        return "UserViewData{" +
                "id=" + id +
                ", fullName=" + fullName +
                ", mail='" + mail + '\'' +
                ", faculty='" + faculty + '\'' +
                '}';
    }

    public UserViewData(int id, FullName fullName, String mail, String faculty)
    {
        this.id = id;
        this.fullName = fullName;
        this.mail = mail;
        this.faculty = faculty;
    }

}
