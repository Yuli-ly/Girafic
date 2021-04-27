package by.girafic.core.userdata;

public class UserViewData
{
    public final int id;
    public final FullName fullName;
    public final String mail;
    public final String faculty;

    public int getId()
    {
        return id;
    }

    public FullName getFullName()
    {
        return fullName;
    }

    public String getMail()
    {
        return mail;
    }

    public String getFaculty()
    {
        return faculty;
    }

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
    public UserViewData(int id,UserModifyData data)
    {
        this.id = id;
        this.fullName = data.fullName;
        this.mail = data.mail;
        this.faculty = data.faculty;
    }
}
