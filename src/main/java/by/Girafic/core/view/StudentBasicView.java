package by.Girafic.core.view;

import by.Girafic.core.contentdata.CourseViewData;
import by.Girafic.core.contentdata.MaterialViewData;
import by.Girafic.core.contentdata.SectionViewData;
import by.Girafic.core.userdata.AdminViewData;
import by.Girafic.core.userdata.StudentViewData;
import by.Girafic.core.userdata.TeacherViewData;

public interface StudentBasicView
{
    void showStudentProfile(ViewData<StudentViewData> student);
    void showTeacherProfile(ViewData<TeacherViewData> teacher);
    void showAdminProfile(ViewData<AdminViewData> admin);
    void showCourse(ViewData<CourseViewData> course);
    void showMaterial(ViewData<MaterialViewData> material);
    void showSection(ViewData<SectionViewData> section);
    void showError(String message);
}
