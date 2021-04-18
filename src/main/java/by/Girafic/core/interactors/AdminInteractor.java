package by.Girafic.core.interactors;

import by.Girafic.core.userdata.AdminModifyData;
import by.Girafic.core.userdata.StudentModifyData;
import by.Girafic.core.userdata.TeacherModifyData;

public interface AdminInteractor extends TeacherInteractor
{
    boolean getStartPage();
    boolean createStudent(StudentModifyData student);
    boolean modifyStudent(StudentModifyData student, int userID);
    boolean createTeacher(TeacherModifyData teacher);
    boolean modifyTeacher(TeacherModifyData teacher, int userID);
    boolean createAdmin(AdminModifyData admin);
    boolean modifyAdmin(AdminModifyData teacher, int userID);
    boolean removeUser(int userID);
}
