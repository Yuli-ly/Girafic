package by.Girafic.core.view;

import by.Girafic.core.contentdata.CourseViewData;
import by.Girafic.core.contentdata.MaterialViewData;
import by.Girafic.core.contentdata.SectionViewData;
import by.Girafic.core.userdata.AdminViewData;
import by.Girafic.core.userdata.StudentViewData;
import by.Girafic.core.userdata.TeacherViewData;

public interface StudentBasicView
{
    boolean showStudentProfile(ViewData<StudentViewData> student);
    boolean showTeacherProfile(ViewData<TeacherViewData> teacher);
    boolean showAdminProfile(ViewData<AdminViewData> admin);
    boolean showCourse(ViewData<CourseViewData> course);
    boolean showMaterial(ViewData<MaterialViewData> material);
    boolean showSection(ViewData<SectionViewData> section);
}
