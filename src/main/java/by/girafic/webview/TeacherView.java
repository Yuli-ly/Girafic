package by.girafic.webview;

import by.girafic.controllers.request.RequestWrapper;
import by.girafic.core.contentdata.ContentLinkData;
import by.girafic.core.contentdata.viewmodification.CourseViewModifyData;
import by.girafic.core.contentdata.viewmodification.MaterialViewModifyData;
import by.girafic.core.contentdata.viewmodification.SectionViewModifyData;
import by.girafic.core.userdata.UserLinkData;
import by.girafic.core.userdata.view.TeacherViewData;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.Arrays;

public class TeacherView extends StudentView implements by.girafic.core.view.TeacherView
{
    public TeacherView(RequestWrapper wrapper)
    {
        super(wrapper);
    }

    @Override
    public void showStartPage(TeacherViewData teacher) throws Exception
    {
        wrapper.setUser(teacher,false);
        wrapper.forward("/jsp/user/view/home/teacher.jsp");
    }

    @Override
    public void showContentAfterModify(CourseViewModifyData course,
                                       ContentLinkData[] sections,
                                       UserLinkData[] users) throws ServletException, IOException
    {
        wrapper.setContent(course);
        wrapper.setModification(true);
        wrapper.setContent(sections);
        wrapper.setCurrentContent(Arrays.stream(course.sections).boxed().toList());
        wrapper.setCurrentUsers(Arrays.stream(course.users).boxed().toList());
        wrapper.setUsers(users);
        wrapper.forward("/jsp/content/modification/course.jsp");
    }

    @Override
    public void showContentAfterModify(SectionViewModifyData section, ContentLinkData[] content) throws ServletException, IOException
    {
        wrapper.setModification(true);
        wrapper.setContent(section);
        wrapper.setCurrentContent(Arrays.stream(section.contents).boxed().toList());
        wrapper.setContent(content);
        wrapper.forward("/jsp/content/modification/section.jsp");
    }

    @Override
    public void showContentAfterModify(MaterialViewModifyData material) throws ServletException, IOException
    {
        wrapper.setModification(true);
        wrapper.setContent(material);
        wrapper.forward("/jsp/content/modification/material.jsp");
    }

    @Override
    public void showMaterialForCreation() throws ServletException, IOException
    {
        wrapper.setModification(false);
        wrapper.getRequest().setAttribute("type","material");
        wrapper.forward("/jsp/content/creation/material.jsp");
    }

    @Override
    public void showSectionForCreation(ContentLinkData[] content) throws ServletException, IOException
    {
        wrapper.setModification(false);
        wrapper.setContent(content);
        wrapper.getRequest().setAttribute("type","section");
        wrapper.forward("/jsp/content/creation/section.jsp");
    }

    @Override
    public void showCourseForCreation(ContentLinkData[] sections,
                                      UserLinkData[] users) throws ServletException, IOException
    {
        wrapper.setModification(false);
        wrapper.setContent(sections);
        wrapper.setUsers(users);
        wrapper.getRequest().setAttribute("type","course");
        wrapper.forward("/jsp/content/creation/course.jsp");
    }
}
