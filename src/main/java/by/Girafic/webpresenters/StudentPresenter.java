package by.Girafic.webpresenters;

import by.Girafic.core.contentdata.CourseViewData;
import by.Girafic.core.contentdata.MaterialViewData;
import by.Girafic.core.contentdata.SectionViewData;
import by.Girafic.core.userdata.AdminViewData;
import by.Girafic.core.userdata.StudentViewData;
import by.Girafic.core.userdata.StudentViewModifyData;
import by.Girafic.core.userdata.TeacherViewData;
import by.Girafic.core.view.StudentView;
import by.Girafic.core.view.ViewData;

public class StudentPresenter implements by.Girafic.core.presenters.StudentPresenter
{
    private final StudentView view;

    public StudentPresenter(StudentView view)
    {
        this.view = view;
    }

    @Override
    public void showStudentAfterModify(StudentViewModifyData student)
    {
    }

    @Override
    public void showError(String message)
    {
        view.showError(message);
    }

    @Override
    public void showProfile(StudentViewData student, int currentUserID)
    {
        if(student.id == currentUserID)
            view.showStudentProfile(new ViewData<>(student,true));
        else
            view.showStudentProfile(new ViewData<>(student,false));
    }

    @Override
    public void showProfile(TeacherViewData teacher, int currentUserID)
    {
        view.showTeacherProfile(new ViewData<>(teacher,false));
    }

    @Override
    public void showProfile(AdminViewData admin, int currentUserID)
    {
        view.showAdminProfile(new ViewData<>(admin,false));
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


}
