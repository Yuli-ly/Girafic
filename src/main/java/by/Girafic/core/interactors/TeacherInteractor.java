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
    public boolean modifyMaterial(MaterialModifyData material, int contentId)
    {
        return true;
    }
    public boolean removeContent(int contentId)
    {
        return true;
    }
    public boolean addContentToSection(int sectionId,int contentId)
    {
        return true;
    }
    public boolean addSectionToCourse(int courseId,int contentId)
    {
        return true;
    }
    public boolean removeSectionFromCourse(int courseId, int sectionId)
    {
        return true;
    }
    public boolean removeContentFromSection(int sectionId, int contentId)
    {
        return true;
    }
    public boolean addUserToCourse(int courseID,int userId)
    {
        return true;
    }
    public boolean removeUserFromCourse(int courseID, int userId)
    {
        return true;
    }
}
