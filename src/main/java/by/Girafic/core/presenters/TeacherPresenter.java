package by.Girafic.core.presenters;

import by.Girafic.core.contentdata.*;
import by.Girafic.core.userdata.AdminViewData;
import by.Girafic.core.userdata.StudentViewData;
import by.Girafic.core.userdata.TeacherViewData;
import by.Girafic.core.userdata.TeacherViewModifyData;

public class TeacherPresenter implements TeacherBasicPresenter,ShowTeacherAfterModify
{

    @Override
    public boolean showTeacherAfterModify(TeacherViewModifyData teacher)
    {
        return false;
    }

    @Override
    public boolean showProfile(StudentViewData student, int currentUserID)
    {
        return false;
    }

    @Override
    public boolean showProfile(TeacherViewData teacher, int currentUserID)
    {
        return false;
    }

    @Override
    public boolean showProfile(AdminViewData admin, int currentUserID)
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
    public boolean showCourseAfterModify(CourseViewModifyData course)
    {
        return false;
    }

    @Override
    public boolean showSectionAfterModify(SectionViewModifyData section)
    {
        return false;
    }

    @Override
    public boolean showMaterialAfterModify(MaterialViewModifyData material)
    {
        return false;
    }
}
