package by.Girafic.core.interactors;

import by.Girafic.core.contentdata.CourseModifyData;
import by.Girafic.core.contentdata.MaterialModifyData;

public class TeacherInteractor extends StudentInteractor
{
    public boolean createCourse(CourseModifyData course)
    {
        return true;
    }
    public boolean createMaterial(MaterialModifyData material)
    {
        return true;
    }
    public boolean modifyMaterial(MaterialModifyData material, int contentID)
    {
        return true;
    }
    public boolean removeContent(int contentID)
    {
        return true;
    }
    public boolean addContentToSection(int sectionID,int contentID)
    {
        return true;
    }
    public boolean addSectionToCourse(int courseID,int contentID)
    {
        return true;
    }
    public boolean removeSectionFromCourse(int courseID, int sectionID)
    {
        return true;
    }
    public boolean removeContentFromSection(int sectionID, int contentID)
    {
        return true;
    }
    public boolean addUserToCourse(int courseID,int userID)
    {
        return true;
    }
    public boolean removeUserFromCourse(int courseID, int userID)
    {
        return true;
    }
}
