package by.Girafic.core.presenters;

import by.Girafic.core.contentdata.CourseViewModifyData;
import by.Girafic.core.contentdata.MaterialViewModifyData;
import by.Girafic.core.contentdata.SectionViewModifyData;

public interface TeacherBasicPresenter extends StudentBasicPresenter
{
    boolean showCourseAfterModify(CourseViewModifyData course);
    boolean showSectionAfterModify(SectionViewModifyData section);
    boolean showMaterialAfterModify(MaterialViewModifyData material);
}
