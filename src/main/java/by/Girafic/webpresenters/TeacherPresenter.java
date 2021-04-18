package by.Girafic.webpresenters;

import by.Girafic.core.contentdata.*;
import by.Girafic.core.userdata.AdminViewData;
import by.Girafic.core.userdata.StudentViewData;
import by.Girafic.core.userdata.TeacherViewData;
import by.Girafic.core.userdata.TeacherViewModifyData;
import by.Girafic.core.view.TeacherView;
import by.Girafic.core.view.ViewData;

public class TeacherPresenter implements by.Girafic.core.presenters.TeacherPresenter
{
    private TeacherView view;

    public TeacherPresenter(TeacherView view)
    {
        this.view = view;
    }

    @Override
    public boolean showTeacherAfterModify(TeacherViewModifyData teacher)
    {
         return false;
    }

    @Override
    public boolean showError(String message)
    {
        return false;
    }

    @Override
    public boolean showProfile(StudentViewData student, int currentUserID)
    {
        view.showStudentProfile(new ViewData<>(student,false));
        return true;
    }

    @Override
    public boolean showProfile(TeacherViewData teacher, int currentUserID)
    {
        if(teacher.id == currentUserID)
            view.showTeacherProfile(new ViewData<>(teacher,true));
        else
            view.showTeacherProfile(new ViewData<>(teacher,false));
        return true;
    }

    @Override
    public boolean showProfile(AdminViewData admin, int currentUserID)
    {
        view.showAdminProfile(new ViewData<>(admin,false));
        return true;
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
