package by.girafic.core.view;

import by.girafic.core.contentdata.CourseViewModifyData;
import by.girafic.core.contentdata.MaterialViewModifyData;
import by.girafic.core.contentdata.SectionViewModifyData;

public interface TeacherView extends StudentView
{
    void showContentAfterModify(CourseViewModifyData course) throws Exception;
    void showContentAfterModify(SectionViewModifyData section) throws Exception;
    void showContentAfterModify(MaterialViewModifyData material) throws Exception;
}
