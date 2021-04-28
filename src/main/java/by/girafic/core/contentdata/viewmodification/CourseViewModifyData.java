package by.girafic.core.contentdata.viewmodification;

import by.girafic.core.commonds.ModifyConfirmation;
import by.girafic.core.contentdata.modification.CourseModifyData;

public class CourseViewModifyData extends ContentViewModifyData
{
    public final int[] sections;
    public final int[] users;

    public CourseViewModifyData(int id,
                                ModifyConfirmation<String> title,
                                ModifyConfirmation<String> description,
                                int[] sections, int[] users)
    {
        super(id,title, description);
        this.sections = sections;
        this.users = users;
    }

    public CourseViewModifyData(int id, CourseModifyData data)
    {
        super(id,data);
        this.sections = data.sections;
        this.users = data.users;
    }

    public int[] getSections()
    {
        return sections;
    }
}
