package by.Girafic.webpresenters;

import by.Girafic.core.contentdata.*;
import by.Girafic.core.userdata.*;
import by.Girafic.core.view.AdminView;
import by.Girafic.core.view.ViewData;

public class AdminPresenter implements by.Girafic.core.presenters.AdminPresenter
{
    private final AdminView view;

    public AdminPresenter(AdminView view)
    {
        this.view = view;
    }

    @Override
    public void showAdminAfterModify(AdminViewModifyData admin)
    {
    }

    @Override
    public void showStudentAfterModify(StudentViewModifyData student)
    {
        view.showStudentAfterModify(student);
    }

    @Override
    public void showTeacherAfterModify(TeacherViewModifyData teacher)
    {
        view.showTeacherAfterModify(teacher);
    }

    @Override
    public void showError(String message)
    {

    }

    @Override
    public void showProfile(StudentViewData student, int currentUserID)
    {
        view.showStudentProfile(new ViewData<>(student,true));
    }

    @Override
    public void showProfile(TeacherViewData teacher, int currentUserID)
    {
        view.showTeacherProfile(new ViewData<>(teacher,true));
    }

    @Override
    public void showProfile(AdminViewData admin, int currentUserID)
    {
        view.showAdminProfile(new ViewData<>(admin,true));
    }

    @Override
    public void showCourse(CourseViewData course,boolean changeability)
    {
        view.showCourse(new ViewData<>(course,false));
    }

    @Override
    public void showSection(SectionViewData section, boolean changeability)
    {
        view.showSection(new ViewData<>(section,changeability));
    }

    @Override
    public void showMaterial(MaterialViewData material, boolean changeability)
    {
        view.showMaterial(new ViewData<>(material,changeability));
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
