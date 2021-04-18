package by.Girafic.database;

import by.Girafic.core.commonds.ContentType;
import by.Girafic.core.commonds.LoginData;
import by.Girafic.core.commonds.UserType;
import by.Girafic.core.contentdata.*;
import by.Girafic.core.database.ContentDataBase;
import by.Girafic.core.database.UserDataBase;
import by.Girafic.core.userdata.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class InMemoryDataBase implements ContentDataBase, UserDataBase
{
    final private AdminModifyData admin = new AdminModifyData(UserType.Admin,
            new FullName("admin","admin","admin"),
            "admin",
            "admin",
            "admin@example.com","RF&CT");
    final private StudentModifyData student = new StudentModifyData(UserType.Student,
            new FullName("student","student","student"),
            "student",
            "student",
            "student@example.com","RF&CT",2,10,"7","нет кафедры",new int[]{1,2,3});
    final private TeacherModifyData teacher = new TeacherModifyData(UserType.Teacher,
            new FullName("teacher","teacher","teacher"),
            "teacher","teacher","teacher@gmail.com","RF&CT","1","teacher",new int[]{1,2,3});

    private final Map<Integer,UserModifyData> users = new LinkedHashMap<>();
    public InMemoryDataBase()
    {
        users.put(1,admin);
        users.put(2,teacher);
        users.put(3,student);
    }

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
    public boolean checkExistence(LoginData ld)
    {
        for(Map.Entry<Integer,UserModifyData> user : users.entrySet())
        {
            if(user.getValue().login.equals(ld.login) && user.getValue().password.equals(ld.password))
                return true;
        }
        return false;
    }

    @Override
    public boolean checkExistence(int userID)
    {
        return users.containsKey(userID);
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
        for(Map.Entry<Integer,UserModifyData> user : users.entrySet())
        {
            if(user.getValue().login.equals(login))
                return user.getKey();
        }
        return -1;
    }

    @Override
    public UserType getUserType(int userID)
    {
        return users.get(userID).userType;
    }

    @Override
    public StudentViewData getStudent(int userID)
    {
        if(users.containsKey(userID))
            return new StudentViewData(userID,(StudentModifyData) users.get(userID));
        return null;
    }

    @Override
    public TeacherViewData getTeacher(int userID)
    {
        if(users.containsKey(userID))
            return new TeacherViewData(userID,(TeacherModifyData) users.get(userID));
        return null;
    }

    @Override
    public AdminViewData getAdmin(int userID)
    {
        if(users.containsKey(userID))
            return new AdminViewData(userID,(AdminModifyData) users.get(userID) );
        return null;
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
