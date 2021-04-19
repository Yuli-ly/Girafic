package by.Girafic.core.interactors;

import by.Girafic.core.userdata.AdminModifyData;
import by.Girafic.core.userdata.StudentModifyData;
import by.Girafic.core.userdata.TeacherModifyData;

public interface AdminInteractor extends TeacherInteractor
{
    void getStartPage();
    void createStudent(StudentModifyData student);
    void modifyStudent(StudentModifyData student, int userID);
    void createTeacher(TeacherModifyData teacher);
    void modifyTeacher(TeacherModifyData teacher, int userID);
    void createAdmin(AdminModifyData admin);
    void modifyAdmin(AdminModifyData teacher, int userID);
    void removeUser(int userID);
    void showUserForModification(int userID);

}
