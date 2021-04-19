package by.Girafic.core.view;

import by.Girafic.core.contentdata.CourseViewModifyData;
import by.Girafic.core.contentdata.SectionViewModifyData;

public interface TeacherBasicView extends StudentBasicView
{
    void showCourseAfterModify(CourseViewModifyData course);
    void showSectionAfterModify(SectionViewModifyData section);
    void showMaterialAfterModify(SectionViewModifyData material);
}
