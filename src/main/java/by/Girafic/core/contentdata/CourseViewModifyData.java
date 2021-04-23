package by.Girafic.core.contentdata;

import by.Girafic.core.commonds.ModifyConfirmation;

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
