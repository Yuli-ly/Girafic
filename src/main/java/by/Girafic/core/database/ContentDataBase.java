package by.Girafic.core.database;

import by.Girafic.core.contentdata.ContentType;
import by.Girafic.core.contentdata.*;

public interface ContentDataBase
{
    ContentType getContentType(int contentID);
    CourseViewData getCourse(int contentID);
    SectionViewData getSection(int contentID);
    MaterialViewData getMaterial(int contentID);
    boolean checkContentExistence(int contentID);
    int createCourse(CourseModifyData course);
    int createSection(SectionModifyData section);
    int createMaterial(MaterialModifyData material);
    int modifyCourse(CourseModifyData course,int contentID);
    int modifySection(SectionModifyData section,int contentID);
    int modifyMaterial(MaterialModifyData material,int contentID);
    void removeContent(int contentID);
}
