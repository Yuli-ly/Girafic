package by.Girafic.core.view;

import by.Girafic.core.userdata.AdminViewModifyData;
import by.Girafic.core.userdata.StudentViewModifyData;
import by.Girafic.core.userdata.TeacherViewModifyData;

public interface AdminView extends TeacherView
{
    void showUserAfterModify(AdminViewModifyData admin) throws Exception;
    void showUserAfterModify(StudentViewModifyData student) throws Exception;
    void showUserAfterModify(TeacherViewModifyData teacher) throws Exception;
}
