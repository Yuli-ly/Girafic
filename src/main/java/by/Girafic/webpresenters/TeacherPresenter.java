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
    public void showTeacherAfterModify(TeacherViewModifyData teacher)
    {
    }

    @Override
    public void showError(String message)
    {
    }

    @Override
    public void showProfile(StudentViewData student, int currentUserID)
    {
        view.showStudentProfile(new ViewData<>(student,false));
    }

    @Override
    public void showProfile(TeacherViewData teacher, int currentUserID)
    {
        if(teacher.id == currentUserID)
            view.showTeacherProfile(new ViewData<>(teacher,true));
        else
            view.showTeacherProfile(new ViewData<>(teacher,false));
    }

    @Override
    public void showProfile(AdminViewData admin, int currentUserID)
    {
        view.showAdminProfile(new ViewData<>(admin,false));
    }

    @Override
    public void showCourse(CourseViewData course)
    {
    }

    @Override
    public void showSection(SectionViewData section)
    {
    }

    @Override
    public void showMaterial(MaterialViewData material)
    {
    }

    @Override
    public void showCourseAfterModify(CourseViewModifyData course)
    {
    }

    @Override
    public void showSectionAfterModify(SectionViewModifyData section)
    {
    }

    @Override
    public void showMaterialAfterModify(MaterialViewModifyData material)
    {
    }
}
