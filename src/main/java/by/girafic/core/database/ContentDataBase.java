package by.girafic.core.database;

import by.girafic.core.contentdata.ContentLinkData;
import by.girafic.core.contentdata.ContentType;
import by.girafic.core.contentdata.modification.CourseModifyData;
import by.girafic.core.contentdata.view.CourseViewData;
import by.girafic.core.contentdata.modification.MaterialModifyData;
import by.girafic.core.contentdata.view.MaterialViewData;
import by.girafic.core.contentdata.modification.SectionModifyData;
import by.girafic.core.contentdata.view.SectionViewData;

public interface ContentDataBase
{
    ContentLinkData getLink(int contentID);
    ContentType getContentType(int contentID);
    CourseViewData getCourse(int contentID);
    SectionViewData getSection(int contentID);
    MaterialViewData getMaterial(int contentID);
    boolean checkContentExistence(int contentID);
    int createContent(CourseModifyData course);
    int createContent(SectionModifyData section);
    int createContent(MaterialModifyData material);
    int modifyContent(CourseModifyData course, int contentID);
    int modifyContent(SectionModifyData section, int contentID);
    int modifyContent(MaterialModifyData material, int contentID);
    ContentLinkData[] getCourses();
    ContentLinkData[] getAllContent();
    void removeContent(int contentID);
}
