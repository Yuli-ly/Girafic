package by.Girafic.core.presenters;

import by.Girafic.core.userdata.AdminViewModifyData;
import by.Girafic.core.userdata.StudentViewModifyData;

public class AdminPresenter extends TeacherPresenter implements ShowStudentAfterModify
{
    public boolean showAdminAfterModify(AdminViewModifyData admin)
    {
        return false;
    }

    @Override
    public boolean showStudentAfterModify(StudentViewModifyData student)
    {
        return false;
    }
}
