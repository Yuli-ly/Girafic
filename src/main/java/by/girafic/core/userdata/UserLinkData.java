package by.girafic.core.userdata;

public class UserLinkData
{
    public int id;
    public FullName name;

    public UserLinkData(int id, FullName name)
    {
        this.id = id;
        this.name = name;
    }

    public UserLinkData(UserViewData data)
    {
        this.id = data.id;
        this.name = data.fullName;
    }

    public int getId()
    {
        return id;
    }

    public FullName getName()
    {
        return name;
    }
}
