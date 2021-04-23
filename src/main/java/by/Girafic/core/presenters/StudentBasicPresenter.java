package by.Girafic.core.presenters;

import by.Girafic.core.contentdata.CourseViewData;
import by.Girafic.core.contentdata.MaterialViewData;
import by.Girafic.core.contentdata.SectionViewData;
import by.Girafic.core.userdata.AdminViewData;
import by.Girafic.core.userdata.StudentViewData;
import by.Girafic.core.userdata.TeacherViewData;

public interface StudentBasicPresenter
{
    void showError(String message);
    void showProfile(StudentViewData student,int currentUserID);
    void showProfile(TeacherViewData teacher,int currentUserID);
    void showProfile(AdminViewData admin, int currentUserID);
    void showCourse(CourseViewData course,boolean changeability);
    void showSection(SectionViewData section,boolean changeability);
    void showMaterial(MaterialViewData material,boolean changeability);
}
