package by.girafic.core.view;

import by.girafic.core.contentdata.view.CourseViewData;
import by.girafic.core.contentdata.view.MaterialViewData;
import by.girafic.core.contentdata.view.SectionViewData;
import by.girafic.core.userdata.view.AdminViewData;
import by.girafic.core.userdata.view.StudentViewData;
import by.girafic.core.userdata.view.TeacherViewData;

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
