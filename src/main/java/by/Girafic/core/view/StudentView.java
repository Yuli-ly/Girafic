package by.Girafic.core.view;

import by.Girafic.core.contentdata.CourseViewData;
import by.Girafic.core.contentdata.MaterialViewData;
import by.Girafic.core.contentdata.SectionViewData;
import by.Girafic.core.userdata.AdminViewData;
import by.Girafic.core.userdata.StudentViewData;
import by.Girafic.core.userdata.TeacherViewData;

public interface StudentView
{
    void showProfile(StudentViewData student,boolean mutable) throws Exception;
    void showProfile(TeacherViewData teacher,boolean mutable) throws Exception;
    void showProfile(AdminViewData admin,boolean mutable) throws Exception;
    void showContent(CourseViewData course,boolean mutable) throws Exception;
    void showContent(MaterialViewData material,boolean mutable) throws Exception;
    void showContent(SectionViewData section,boolean mutable) throws Exception;
    void showError(String message) throws Exception;
}
