package by.Girafic.core.view;

import by.Girafic.core.contentdata.CourseViewModifyData;
import by.Girafic.core.contentdata.SectionViewModifyData;

public interface TeacherBasicView extends StudentBasicView
{
    boolean showCourseAfterModify(CourseViewModifyData course);
    boolean showSectionAfterModify(SectionViewModifyData section);
    boolean showMaterialAfterModify(SectionViewModifyData material);
}
