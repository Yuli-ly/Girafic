package by.Girafic.database;

import by.Girafic.core.commonds.ContentType;
import by.Girafic.core.commonds.UserType;
import by.Girafic.core.contentdata.*;
import by.Girafic.core.database.ContentDataBase;
import by.Girafic.core.database.UserDataBase;
import by.Girafic.core.userdata.*;

public class InMemoryDataBase implements ContentDataBase, UserDataBase
{
    private AdminModifyData admin = new AdminModifyData(UserType.Admin,
            new FullName("admin","admin","admin"),
            "login",
            "password",
            "mail@example.com","RF&CT");
    @Override
    public ContentType getType(int contentID)
    {
        return null;
    }

    @Override
    public CourseViewData getCourse(int contentID)
    {
        return null;
    }

    @Override
    public SectionViewData getSection(int contentID)
    {
        return null;
    }

    @Override
    public MaterialViewData getMaterial(int contentID)
    {
        return null;
    }

    @Override
    public boolean createCourse(CourseModifyData course)
    {
        return false;
    }

    @Override
    public boolean createSection(SectionModifyData section)
    {
        return false;
    }

    @Override
    public boolean createMaterial(MaterialModifyData material)
    {
        return false;
    }

    @Override
    public boolean modifyCourse(CourseModifyData course, int contentID)
    {
        return false;
    }

    @Override
    public boolean modifySection(SectionModifyData section, int contentID)
    {
        return false;
    }

    @Override
    public boolean modifyMaterial(MaterialModifyData material, int contentID)
    {
        return false;
    }

    @Override
    public boolean removeContent(int contentID)
    {
        return false;
    }

    @Override
    public boolean checkLoginOriginality(String login)
    {
        return false;
    }

    @Override
    public boolean checkPasswordOriginality(String password)
    {
        return false;
    }

    @Override
    public int getUserID(String login)
    {
        return 0;
    }

    @Override
    public UserType getUserType(int userID)
    {
        return null;
    }

    @Override
    public StudentViewData getStudent(int userID)
    {
        return null;
    }

    @Override
    public TeacherViewData getTeacher(int userID)
    {
        return null;
    }

    @Override
    public AdminViewData getAdmin(int userID)
    {
        return new AdminViewData(0,admin.fullName,admin.mail,admin.faculty);
    }

    @Override
    public boolean createStudent(StudentModifyData student)
    {
        return false;
    }

    @Override
    public boolean createTeacher(TeacherModifyData teacher)
    {
        return false;
    }

    @Override
    public boolean createAdmin(AdminModifyData admin)
    {
        return false;
    }

    @Override
    public boolean modifyStudent(StudentModifyData student, int userID)
    {
        return false;
    }

    @Override
    public boolean modifyTeacher(TeacherModifyData teacher, int userID)
    {
        return false;
    }

    @Override
    public boolean modifyAdmin(AdminModifyData admin, int id)
    {
        return false;
    }

    @Override
    public boolean removeUser(int userID)
    {
        return false;
    }
}
