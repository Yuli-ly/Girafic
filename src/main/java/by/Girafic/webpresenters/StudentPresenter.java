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
    private StudentView view;

    public StudentPresenter(StudentView view)
    {
        this.view = view;
    }

    @Override
    public boolean showStudentAfterModify(StudentViewModifyData student)
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
        if(student.id == currentUserID)
            view.showStudentProfile(new ViewData<>(student,true));
        else
            view.showStudentProfile(new ViewData<>(student,false));
        return true;
    }

    @Override
    public boolean showProfile(TeacherViewData teacher, int currentUserID)
    {
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
}
