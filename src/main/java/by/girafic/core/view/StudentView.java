package by.girafic.core.view;

import by.girafic.core.contentdata.CourseViewData;
import by.girafic.core.contentdata.MaterialViewData;
import by.girafic.core.contentdata.SectionViewData;
import by.girafic.core.userdata.AdminViewData;
import by.girafic.core.userdata.StudentViewData;
import by.girafic.core.userdata.TeacherViewData;

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
