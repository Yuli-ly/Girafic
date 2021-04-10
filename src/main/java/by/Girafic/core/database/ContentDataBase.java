package by.Girafic.core.database;

import by.Girafic.core.commonds.ContentType;
import by.Girafic.core.contentdata.*;

public interface ContentDataBase
{
    ContentType getType(int contentID);
    CourseViewData getCourse(int contentID);
    SectionViewData getSection(int contentID);
    MaterialViewData getMaterial(int contentID);
    boolean createCourse(CourseModifyData course);
    boolean createSection(SectionModifyData section);
    boolean createMaterial(MaterialModifyData material);
    boolean modifyCourse(CourseModifyData course,int contentID);
    boolean modifySection(SectionModifyData section,int contentID);
    boolean modifyMaterial(MaterialModifyData material,int contentID);
    boolean removeContent(int contentID);
}
