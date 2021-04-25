package by.girafic.core.view;

import by.girafic.core.userdata.AdminViewModifyData;
import by.girafic.core.userdata.StudentViewModifyData;
import by.girafic.core.userdata.TeacherViewModifyData;

public interface AdminView extends TeacherView
{
    void showUserAfterModify(AdminViewModifyData admin) throws Exception;
    void showUserAfterModify(StudentViewModifyData student) throws Exception;
    void showUserAfterModify(TeacherViewModifyData teacher) throws Exception;
}
