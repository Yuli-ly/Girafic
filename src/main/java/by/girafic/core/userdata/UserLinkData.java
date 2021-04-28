package by.girafic.core.userdata;

import by.girafic.core.userdata.view.UserViewData;

public class UserLinkData
{
    public final int id;
    public final FullName name;

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
