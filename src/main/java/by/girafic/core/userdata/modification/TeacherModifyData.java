package by.girafic.core.userdata.modification;

import by.girafic.core.userdata.FullName;
import by.girafic.core.userdata.UserType;

public class TeacherModifyData extends ExtendedUserModifyData
{
    public final String post;
    public int[] availableContent;

    public TeacherModifyData(UserType userType,
                             FullName fullName,
                             String login,
                             String password,
                             String mail,
                             String faculty,
                             String department,
                             int[] courses,
                             String post,
                             int[] availableContent)
    {
        super(userType,
                fullName,
                login,
                password,
                mail,
                faculty,
                department,
                courses);
        this.post = post;
        this.availableContent = availableContent;
    }

    public TeacherModifyData(ExtendedUserModifyData data,
                             String post,
                             int[] availableContent)
    {
        super(data);
        this.post = post;
        this.availableContent = availableContent;
    }


    public String getPost()
    {
        return post;
    }
}
