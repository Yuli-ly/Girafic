package by.Girafic.core.interactors;

import by.Girafic.core.userdata.AdminModifyData;
import by.Girafic.core.userdata.StudentModifyData;
import by.Girafic.core.userdata.TeacherModifyData;

public interface AdminInteractor extends TeacherInteractor
{
    void createUser(StudentModifyData student) throws Exception;
    void modifyUser(StudentModifyData student, int userID) throws Exception;
    void createUser(TeacherModifyData teacher) throws Exception;
    void modifyUser(TeacherModifyData teacher, int userID) throws Exception;
    void createUser(AdminModifyData admin) throws Exception;
    void modifyUser(AdminModifyData teacher, int userID) throws Exception;
    void removeUser(int userID) throws Exception;
    void showUserForModification(int userID) throws Exception;

}
