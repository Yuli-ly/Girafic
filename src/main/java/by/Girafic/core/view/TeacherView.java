package by.Girafic.core.view;

import by.Girafic.core.contentdata.CourseViewModifyData;
import by.Girafic.core.contentdata.MaterialViewModifyData;
import by.Girafic.core.contentdata.SectionViewModifyData;

public interface TeacherView extends StudentView
{
    void showContentAfterModify(CourseViewModifyData course) throws Exception;
    void showContentAfterModify(SectionViewModifyData section) throws Exception;
    void showContentAfterModify(MaterialViewModifyData material) throws Exception;
}
