package by.Girafic.core.presenters;

import by.Girafic.core.contentdata.CourseViewModifyData;
import by.Girafic.core.contentdata.MaterialViewModifyData;
import by.Girafic.core.contentdata.SectionViewModifyData;

public interface TeacherBasicPresenter extends StudentBasicPresenter
{
    void showCourseAfterModify(CourseViewModifyData course);
    void showSectionAfterModify(SectionViewModifyData section);
    void showMaterialAfterModify(MaterialViewModifyData material);
}
