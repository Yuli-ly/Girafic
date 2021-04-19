package by.Girafic.core.interactors;

import by.Girafic.core.commonds.LoginData;
import by.Girafic.core.contentdata.CourseModifyData;
import by.Girafic.core.contentdata.MaterialModifyData;
import by.Girafic.core.database.ContentDataBase;
import by.Girafic.core.database.UserDataBase;
import by.Girafic.core.presenters.StudentPresenter;
import by.Girafic.core.presenters.TeacherPresenter;

public interface TeacherInteractor extends StudentInteractor
{
    void createCourse(CourseModifyData course);
    void createMaterial(MaterialModifyData material);
    void modifyMaterial(MaterialModifyData material, int contentID);
    void removeContent(int contentID);
    void addContentToSection(int sectionID,int contentID);
    void addSectionToCourse(int courseID,int contentID);
    void removeSectionFromCourse(int courseID, int sectionID);
    void removeContentFromSection(int sectionID, int contentID);
    void addUserToCourse(int courseID,int userID);
    void removeUserFromCourse(int courseID, int userID);
}
