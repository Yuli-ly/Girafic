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
    boolean createCourse(CourseModifyData course);
    boolean createMaterial(MaterialModifyData material);
    boolean modifyMaterial(MaterialModifyData material, int contentID);
    boolean removeContent(int contentID);
    boolean addContentToSection(int sectionID,int contentID);
    boolean addSectionToCourse(int courseID,int contentID);
    boolean removeSectionFromCourse(int courseID, int sectionID);
    boolean removeContentFromSection(int sectionID, int contentID);
    boolean addUserToCourse(int courseID,int userID);
    boolean removeUserFromCourse(int courseID, int userID);
}
