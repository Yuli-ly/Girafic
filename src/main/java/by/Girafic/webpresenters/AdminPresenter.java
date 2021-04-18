package by.Girafic.webpresenters;

import by.Girafic.core.contentdata.*;
import by.Girafic.core.userdata.*;
import by.Girafic.core.view.AdminView;
import by.Girafic.core.view.ViewData;

public class AdminPresenter implements by.Girafic.core.presenters.AdminPresenter
{
    private AdminView view;

    public AdminPresenter(AdminView view)
    {
        this.view = view;
    }

    @Override
    public boolean showAdminAfterModify(AdminViewModifyData admin)
    {
        return false;
    }

    @Override
    public boolean showStudentAfterModify(StudentViewModifyData student)
    {
        view.showStudentAfterModify(student);
        return false;
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
        view.showStudentProfile(new ViewData<>(student,true));
        return true;
    }

    @Override
    public boolean showProfile(TeacherViewData teacher, int currentUserID)
    {
        view.showTeacherProfile(new ViewData<>(teacher,true));
        return true;
    }

    @Override
    public boolean showProfile(AdminViewData admin, int currentUserID)
    {
        view.showAdminProfile(new ViewData<>(admin,true));
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
