package by.girafic.webview;

import by.girafic.core.contentdata.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TeacherView extends StudentView implements by.girafic.core.view.TeacherView
{
    public TeacherView(HttpServletRequest request, HttpServletResponse response)
    {
        super(request,response);
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
