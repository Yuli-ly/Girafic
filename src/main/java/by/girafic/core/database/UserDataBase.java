package by.girafic.core.database;

import by.girafic.core.commonds.LoginData;
import by.girafic.core.contentdata.ContentLinkData;
import by.girafic.core.userdata.modification.AdminModifyData;
import by.girafic.core.userdata.view.AdminViewData;
import by.girafic.core.userdata.modification.StudentModifyData;
import by.girafic.core.userdata.view.StudentViewData;
import by.girafic.core.userdata.modification.TeacherModifyData;
import by.girafic.core.userdata.view.TeacherViewData;
import by.girafic.core.userdata.UserLinkData;
import by.girafic.core.userdata.UserType;

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
    int createUser(StudentModifyData student);
    int createUser(TeacherModifyData teacher);
    int createUser(AdminModifyData admin);
    int modifyUser(StudentModifyData student, int userID);
    int modifyUser(TeacherModifyData teacher, int userID);
    int modifyUser(AdminModifyData admin, int id);
    void removeUser(int userID);
    ContentLinkData[] getAvailableSectionContent(int userID);
    ContentLinkData[] getAvailableSections(int userID);
    UserLinkData[] getAvailableUsers(int userID);
}
