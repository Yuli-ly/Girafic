package by.Girafic.core.database;

import by.Girafic.core.commonds.LoginData;
import by.Girafic.core.commonds.UserType;
import by.Girafic.core.userdata.*;

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
    boolean createStudent(StudentModifyData student);
    boolean createTeacher(TeacherModifyData teacher);
    boolean createAdmin(AdminModifyData admin);
    boolean modifyStudent(StudentModifyData student,int userID);
    boolean modifyTeacher(TeacherModifyData teacher,int userID);
    boolean modifyAdmin(AdminModifyData admin,int id);
    boolean removeUser(int userID);
}
