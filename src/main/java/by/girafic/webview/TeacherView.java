package by.girafic.webview;

import by.girafic.controllers.request.RequestWrapper;
import by.girafic.core.contentdata.*;

public class TeacherView extends StudentView implements by.girafic.core.view.TeacherView
{
    public TeacherView(RequestWrapper wrapper)
    {
        super(wrapper);
    }

    @Override
    public void showContentAfterModify(CourseViewModifyData course)
    {
    }

    @Override
    public void showContentAfterModify(SectionViewModifyData section)
    {
    }

    @Override
    public void showContentAfterModify(MaterialViewModifyData material)
    {
    }
}
