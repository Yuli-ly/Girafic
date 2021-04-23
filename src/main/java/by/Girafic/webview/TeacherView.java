package by.Girafic.webview;

import by.Girafic.core.contentdata.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TeacherView extends StudentView implements by.Girafic.core.view.TeacherView
{
    public TeacherView(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet)
    {
        super(request,response,servlet);
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
