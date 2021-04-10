package by.Girafic.core.view;

import by.Girafic.core.userdata.AdminViewModifyData;

public interface AdminView extends TeacherView,ShowStudentAfterModify
{
    boolean showAdminAfterModify(AdminViewModifyData admin);
}
