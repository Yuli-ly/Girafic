package by.girafic.core.contentdata;

import by.girafic.core.commonds.ModifyConfirmation;

public class CourseViewModifyData extends ContentViewModifyData
{
    public ModifyConfirmation<int[]> sections;

    public CourseViewModifyData(ModifyConfirmation<String> title, ModifyConfirmation<String> description, ModifyConfirmation<int[]> sections)
    {
        super(title, description);
        this.sections = sections;
    }

    public ModifyConfirmation<int[]> getSections()
    {
        return sections;
    }
}
