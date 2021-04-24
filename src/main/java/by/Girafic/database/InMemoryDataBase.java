package by.Girafic.database;

import by.Girafic.core.contentdata.ContentType;
import by.Girafic.core.commonds.LoginData;
import by.Girafic.core.userdata.UserType;
import by.Girafic.core.contentdata.*;
import by.Girafic.core.database.ContentDataBase;
import by.Girafic.core.database.UserDataBase;
import by.Girafic.core.userdata.*;

import java.util.*;


public class InMemoryDataBase implements ContentDataBase, UserDataBase
{

    int userAddIndex = 1;
    int contentAddIndex;
    private final Map<Integer,UserModifyData> users = new HashMap<>();
    private final Map<Integer,ContentModifyData> content = new HashMap<>();
    public InMemoryDataBase()
    {
        AdminModifyData admin = new AdminModifyData(UserType.Admin,
                new FullName("admin", "admin", "admin"),
                "admin",
                "admin",
                "admin@example.com", "RF&CT");
        users.put(userAddIndex++, admin);
        TeacherModifyData teacher = new TeacherModifyData(UserType.Teacher,
                new FullName("teacher", "teacher", "teacher"),
                "teacher", "teacher", "teacher@gmail.com", "RF&CT", "1", "teacher", new int[]{3});
        users.put(userAddIndex++, teacher);
        StudentModifyData student = new StudentModifyData(UserType.Student,
                new FullName("student", "student", "student"),
                "student",
                "student",
                "student@example.com", "RF&CT", 2, 10, "7", "no department", new int[]{3});
        users.put(userAddIndex++, student);

        MaterialModifyData material = new MaterialModifyData("Material 1","First material","bla-bla-bla");
        content.put(1,material);
        SectionModifyData section = new SectionModifyData("Section 1","First section",new int[]{1});
        content.put(2,section);
        CourseModifyData course = new CourseModifyData("Course 1","First course",new int[]{2},new int[]{2,3});
        content.put(3,course);
        contentAddIndex = 4;
    }

    @Override
    public ContentType getContentType(int contentID)
    {
        return content.get(contentID).getContentType();
    }

    private UserViewData getUser(int userID)
    {
        if(users.containsKey(userID))
            return new UserViewData(userID,users.get(userID));
        return null;
    }
    @Override
    public CourseViewData getCourse(int contentID)
    {
        if(content.containsKey(contentID))
        {
            CourseModifyData course = (CourseModifyData) content.get(contentID);
            ArrayList<SectionViewData> sections = new ArrayList<>();
            for(int i : course.sections)
                sections.add(getSection(i));
            ArrayList<UserLinkData> userList = new ArrayList<>();
            for(int i : course.users)
                userList.add(new UserLinkData(getUser(i)));
            return new CourseViewData(contentID,
                    course,
                    sections.toArray(new SectionViewData[]{}),
                    userList.toArray(new UserLinkData[]{}));
        }
        return null;
    }

    @Override
    public SectionViewData getSection(int contentID)
    {
        if(content.containsKey(contentID))
        {
            SectionModifyData section = (SectionModifyData) content.get(contentID);
            ArrayList<ContentViewData> contents = new ArrayList<>();
            for(int i : section.contents)
                contents.add(new ContentViewData(i,content.get(i)));
            return new SectionViewData(contentID,section, contents.toArray(new ContentViewData[]{}));
        }
        return null;
    }

    @Override
    public MaterialViewData getMaterial(int contentID)
    {
        if(content.containsKey(contentID))
        {
            return new MaterialViewData(contentID,(MaterialModifyData) content.get(contentID));
        }
        return null;
    }

    @Override
    public int createCourse(CourseModifyData course)
    {
        content.put(contentAddIndex,course);
        return contentAddIndex++;
    }

    @Override
    public int createSection(SectionModifyData section)
    {
        content.put(contentAddIndex,section);
        return contentAddIndex++;
    }

    @Override
    public int createMaterial(MaterialModifyData material)
    {
        content.put(contentAddIndex,material);
        return contentAddIndex++;
    }

    @Override
    public int modifyCourse(CourseModifyData course, int contentID)
    {
        return -1;
    }

    @Override
    public int modifySection(SectionModifyData section, int contentID)
    {
        return -1;
    }

    @Override
    public int modifyMaterial(MaterialModifyData material, int contentID)
    {
        return -1;
    }

    @Override
    public void removeContent(int contentID)
    {
        content.remove(contentID);
    }

    @Override
    public boolean checkUserExistence(LoginData ld)
    {
        for(Map.Entry<Integer,UserModifyData> user : users.entrySet())
        {
            if(user.getValue().login.equals(ld.login) && user.getValue().password.equals(ld.password))
                return true;
        }
        return false;
    }

    @Override
    public boolean checkUserExistence(int userID)
    {
        return users.containsKey(userID);
    }

    @Override
    public boolean checkContentExistence(int contentID)
    {
        return content.containsKey(contentID);
    }

    @Override
    public boolean checkLoginOriginality(String login)
    {
        return true;
    }

    @Override
    public boolean checkPasswordOriginality(String password)
    {
        return true;
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
        {
            ArrayList<ContentLinkData> courses = new ArrayList<>();
            StudentModifyData student = (StudentModifyData) users.get(userID);
            for (int i : student.courses)
                courses.add(new ContentLinkData(getCourse(i).title,i));
            return new StudentViewData(userID,student,courses.toArray(new ContentLinkData[]{}));
        }
        return null;
    }

    @Override
    public TeacherViewData getTeacher(int userID)
    {
        if(users.containsKey(userID))
        {
            ArrayList<ContentLinkData> courses = new ArrayList<>();
            TeacherModifyData teacher = (TeacherModifyData) users.get(userID);
            for (int i : teacher.courses)
                courses.add(new ContentLinkData(getCourse(i).title,i));
            return new TeacherViewData(userID,teacher,courses.toArray(new ContentLinkData[]{}));
        }
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
    public StudentModifyData getStudentForMod(int userID)
    {
        if(users.containsKey(userID))
            return (StudentModifyData) users.get(userID);
        return null;
    }

    @Override
    public TeacherModifyData getTeacherForMod(int userID)
    {
        if(users.containsKey(userID))
            return (TeacherModifyData) users.get(userID);
        return null;
    }

    @Override
    public AdminModifyData getAdminForMod(int userID)
    {
        if(users.containsKey(userID))
            return (AdminModifyData) users.get(userID);
        return null;
    }

    @Override
    public int createStudent(StudentModifyData student)
    {
        users.put(userAddIndex,student);
        return userAddIndex++;
    }

    @Override
    public int createTeacher(TeacherModifyData teacher)
    {
        users.put(userAddIndex,teacher);
        return userAddIndex++;
    }

    @Override
    public int createAdmin(AdminModifyData admin)
    {
        users.put(userAddIndex,admin);
        return userAddIndex++;
    }

    @Override
    public int modifyStudent(StudentModifyData student, int userID)
    {
        if(users.containsKey(userID))
        {
            users.replace(userID,student);
            return userID;
        }
        return -1;
    }

    @Override
    public int modifyTeacher(TeacherModifyData teacher, int userID)
    {
        if(users.containsKey(userID))
        {
            users.replace(userID,teacher);
            return userID;
        }
        return -1;
    }

    @Override
    public int modifyAdmin(AdminModifyData admin, int userID)
    {
        if(users.containsKey(userID))
        {
            users.replace(userID,admin);
            return userID;
        }
        return -1;
    }

    @Override
    public void removeUser(int userID)
    {
        users.remove(userID);
    }
}
