package by.girafic.core.interactors;

import by.girafic.core.contentdata.modification.CourseModifyData;
import by.girafic.core.contentdata.modification.MaterialModifyData;
import by.girafic.core.contentdata.modification.SectionModifyData;

public interface TeacherInteractor extends StudentInteractor
{
    void createContent(CourseModifyData course) throws Exception;

    void createContent(MaterialModifyData material) throws Exception;

    void createContent(SectionModifyData section) throws Exception;

    void modifyContent(MaterialModifyData material, int contentID) throws Exception;

    void modifyContent(SectionModifyData material, int contentID) throws Exception;

    void modifyContent(CourseModifyData material, int contentID) throws Exception;

    void removeContent(int contentID) throws Exception;

    void showMaterialForCreation() throws Exception;
    void showSectionForCreation() throws Exception;
    void showCourseForCreation() throws Exception;
}
