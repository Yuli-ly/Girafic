package by.girafic.core.view;

import by.girafic.core.contentdata.ContentLinkData;
import by.girafic.core.userdata.viewmodification.AdminViewModifyData;
import by.girafic.core.userdata.viewmodification.StudentViewModifyData;
import by.girafic.core.userdata.viewmodification.TeacherViewModifyData;

public interface AdminView extends TeacherView
{
    void showStudentForCreation(ContentLinkData[] courses) throws Exception;
    void showTeacherForCreation(ContentLinkData[] availableContent) throws Exception;
    void showAdminForCreation() throws Exception;
    void showUserAfterModify(AdminViewModifyData admin) throws Exception;
    void showUserAfterModify(StudentViewModifyData student, ContentLinkData[] courses) throws Exception;
    void showUserAfterModify(TeacherViewModifyData teacher,ContentLinkData[] availableContent) throws Exception;
}
