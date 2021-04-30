package by.girafic.core.view;

import by.girafic.core.contentdata.ContentLinkData;
import by.girafic.core.contentdata.viewmodification.CourseViewModifyData;
import by.girafic.core.contentdata.viewmodification.MaterialViewModifyData;
import by.girafic.core.contentdata.viewmodification.SectionViewModifyData;
import by.girafic.core.userdata.UserLinkData;
import by.girafic.core.userdata.view.StudentViewData;
import by.girafic.core.userdata.view.TeacherViewData;

public interface TeacherView extends StudentView
{
    void showStartPage(TeacherViewData teacher) throws Exception;
    void showContentAfterModify(CourseViewModifyData course, ContentLinkData[] sections, UserLinkData[] users) throws Exception;
    void showContentAfterModify(SectionViewModifyData section,ContentLinkData[] content) throws Exception;
    void showContentAfterModify(MaterialViewModifyData material) throws Exception;
    void showMaterialForCreation() throws Exception;
    void showSectionForCreation(ContentLinkData[] content) throws Exception;
    void showCourseForCreation(ContentLinkData[] sections) throws Exception;
}
