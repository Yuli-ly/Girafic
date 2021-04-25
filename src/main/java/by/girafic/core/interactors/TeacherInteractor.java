package by.girafic.core.interactors;

import by.girafic.core.contentdata.CourseModifyData;
import by.girafic.core.contentdata.MaterialModifyData;
import by.girafic.core.contentdata.SectionModifyData;

public interface TeacherInteractor extends StudentInteractor
{
    void createContent(CourseModifyData course) throws Exception;

    void createContent(MaterialModifyData material) throws Exception;

    void createContent(SectionModifyData section) throws Exception;

    void modifyContent(MaterialModifyData material, int contentID) throws Exception;

    void removeContent(int contentID) throws Exception;

    void addContentToSection(int sectionID, int contentID) throws Exception;

    void addSectionToCourse(int courseID, int contentID) throws Exception;

    void removeSectionFromCourse(int courseID, int sectionID) throws Exception;

    void removeContentFromSection(int sectionID, int contentID) throws Exception;

    void addUserToCourse(int courseID, int userID) throws Exception;

    void removeUserFromCourse(int courseID, int userID) throws Exception;
}
