package by.girafic.core.view;

import by.girafic.core.contentdata.ContentLinkData;
import by.girafic.core.contentdata.CourseViewModifyData;
import by.girafic.core.contentdata.MaterialViewModifyData;
import by.girafic.core.contentdata.SectionViewModifyData;

public interface TeacherView extends StudentView
{
    void showContentAfterModify(CourseViewModifyData course,ContentLinkData[] sections) throws Exception;
    void showContentAfterModify(SectionViewModifyData section,ContentLinkData[] content) throws Exception;
    void showContentAfterModify(MaterialViewModifyData material) throws Exception;
    void showMaterialForCreation() throws Exception;
    void showSectionForCreation(ContentLinkData[] content) throws Exception;
    void showCourseForCreation(ContentLinkData[] sections) throws Exception;
}
