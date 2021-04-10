package by.Girafic.core.presenters;

import by.Girafic.core.contentdata.CourseViewData;
import by.Girafic.core.contentdata.MaterialViewData;
import by.Girafic.core.contentdata.SectionViewData;
import by.Girafic.core.userdata.AdminViewData;
import by.Girafic.core.userdata.StudentViewData;
import by.Girafic.core.userdata.StudentViewModifyData;
import by.Girafic.core.userdata.TeacherViewData;

public class StudentPresenter implements StudentBasicPresenter, ShowStudentAfterModify
{
    @Override
    public boolean showProfile(StudentViewData student, int currentUserId)
    {
        return false;
    }

    @Override
    public boolean showProfile(TeacherViewData teacher, int currentUserId)
    {
        return false;
    }

    @Override
    public boolean showProfile(AdminViewData admin, int currentUserId)
    {
        return false;
    }

    @Override
    public boolean showCourse(CourseViewData course)
    {
        return false;
    }

    @Override
    public boolean showSection(SectionViewData section)
    {
        return false;
    }

    @Override
    public boolean showMaterial(MaterialViewData material)
    {
        return false;
    }

    @Override
    public boolean showStudentAfterModify(StudentViewModifyData student)
    {
        return false;
    }
}
