package by.Girafic.webpresenters;

import by.Girafic.core.contentdata.*;
import by.Girafic.core.presenters.AdminPresenter;
import by.Girafic.core.userdata.*;
import by.Girafic.core.view.AdminView;
import by.Girafic.core.view.ViewData;

public class AdminWebPresenter implements AdminPresenter
{
    private AdminView adminView;

    public AdminWebPresenter(AdminView adminView)
    {
        this.adminView = adminView;
    }

    @Override
    public boolean showAdminAfterModify(AdminViewModifyData admin)
    {
        return false;
    }

    @Override
    public boolean showStudentAfterModify(StudentViewModifyData student)
    {
        return false;
    }

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
        if(admin.id == currentUserID)
            adminView.showAdminProfile(new ViewData<>(admin,true));
        else
            adminView.showAdminProfile(new ViewData<>(admin,false));
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
