package by.girafic.core.contentdata;

import by.girafic.core.commonds.ModifyConfirmation;
import static by.girafic.core.commonds.ModifyConfirmation.successful;

public class CourseViewModifyData extends ContentViewModifyData
{
    public final ModifyConfirmation<int[]> sections;

    public CourseViewModifyData(int id,
                                ModifyConfirmation<String> title,
                                ModifyConfirmation<String> description,
                                ModifyConfirmation<int[]> sections)
    {
        super(id,title, description);
        this.sections = sections;
    }

    public CourseViewModifyData(int id,CourseModifyData data)
    {
        super(id,data);
        this.sections = successful(data.sections);
    }

    public ModifyConfirmation<int[]> getSections()
    {
        return sections;
    }
}
