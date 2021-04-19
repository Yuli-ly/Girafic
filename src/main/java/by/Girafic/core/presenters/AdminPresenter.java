package by.Girafic.core.presenters;

import by.Girafic.core.userdata.AdminViewData;
import by.Girafic.core.userdata.AdminViewModifyData;
import by.Girafic.core.userdata.StudentViewModifyData;

public interface AdminPresenter extends TeacherPresenter, ShowStudentAfterModify
{
    void showAdminAfterModify(AdminViewModifyData admin);
}
