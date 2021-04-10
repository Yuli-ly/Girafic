package by.Girafic.core.presenters;

import by.Girafic.core.contentdata.CourseViewData;
import by.Girafic.core.contentdata.MaterialViewData;
import by.Girafic.core.contentdata.SectionViewData;
import by.Girafic.core.userdata.AdminViewData;
import by.Girafic.core.userdata.StudentViewData;
import by.Girafic.core.userdata.TeacherViewData;

public interface StudentBasicPresenter
{
    boolean showProfile(StudentViewData student,int currentUserID);
    boolean showProfile(TeacherViewData teacher,int currentUserID);
    boolean showProfile(AdminViewData admin, int currentUserID);
    boolean showCourse(CourseViewData course);
    boolean showSection(SectionViewData section);
    boolean showMaterial(MaterialViewData material);
}
