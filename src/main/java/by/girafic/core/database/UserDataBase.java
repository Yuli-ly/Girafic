package by.girafic.core.database;

import by.girafic.core.commonds.LoginData;
import by.girafic.core.userdata.*;

public interface UserDataBase
{
    boolean checkUserExistence(LoginData ld);
    boolean checkUserExistence(int userID);
    boolean checkLoginOriginality(String login);
    boolean checkPasswordOriginality(String password);
    int  getUserID(String login);
    UserType getUserType(int userID);
    StudentViewData getStudent(int userID);
    TeacherViewData getTeacher(int userID);
    AdminViewData getAdmin(int userID);
    StudentModifyData getStudentForMod(int userID);
    TeacherModifyData getTeacherForMod(int userID);
    AdminModifyData getAdminForMod(int userID);
    int createStudent(StudentModifyData student);
    int createTeacher(TeacherModifyData teacher);
    int createAdmin(AdminModifyData admin);
    int modifyStudent(StudentModifyData student,int userID);
    int modifyTeacher(TeacherModifyData teacher,int userID);
    int modifyAdmin(AdminModifyData admin,int id);
    void removeUser(int userID);
}
