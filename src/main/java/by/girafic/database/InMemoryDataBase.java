package by.girafic.database;

import by.girafic.core.commonds.LoginData;
import by.girafic.core.contentdata.*;
import by.girafic.core.contentdata.modification.ContentModifyData;
import by.girafic.core.contentdata.modification.CourseModifyData;
import by.girafic.core.contentdata.modification.MaterialModifyData;
import by.girafic.core.contentdata.modification.SectionModifyData;
import by.girafic.core.contentdata.view.ContentViewData;
import by.girafic.core.contentdata.view.CourseViewData;
import by.girafic.core.contentdata.view.MaterialViewData;
import by.girafic.core.contentdata.view.SectionViewData;
import by.girafic.core.database.ContentDataBase;
import by.girafic.core.database.UserDataBase;
import by.girafic.core.userdata.*;
import by.girafic.core.userdata.modification.*;
import by.girafic.core.userdata.view.AdminViewData;
import by.girafic.core.userdata.view.StudentViewData;
import by.girafic.core.userdata.view.TeacherViewData;
import by.girafic.core.userdata.view.UserViewData;

import java.util.*;
import java.util.stream.Collectors;


public class InMemoryDataBase implements ContentDataBase, UserDataBase
{

    int userAddIndex = 1;
    int contentAddIndex;
    private final Map<Integer, UserModifyData> users = new HashMap<>();
    private final Map<Integer, ContentModifyData> content = new HashMap<>();
    public InMemoryDataBase()
    {
        AdminModifyData admin = new AdminModifyData(UserType.Admin,
                new FullName("admin", "admin", "admin"),
                "admin",
                "admin",
                "admin@example.com",
                "RF&CT");
        users.put(userAddIndex++, admin);
        TeacherModifyData teacher = new TeacherModifyData(UserType.Teacher,
                new FullName("teacher", "teacher", "teacher"),
                "teacher",
                "teacher",
                "teacher@gmail.com",
                "RF&CT",
                "1",
                new int[]{3},
                "teacher",
                new int[]{1,2,3});
        users.put(userAddIndex++, teacher);
        StudentModifyData student = new StudentModifyData(UserType.Student,
                new FullName("student", "student", "student"),
                "student",
                "student",
                "student@example.com",
                "RF&CT",
                "no department",
                new int[]{3},
                2,
                10,
                "7");
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
    public ContentLinkData getLink(int contentID)
    {
        if(content.containsKey(contentID))
        {
            ContentModifyData d = content.get(contentID);
            return new ContentLinkData(d.title,contentID);
        }
        return null;
    }

    @Override
    public ContentType getContentType(int contentID)
    {
        return content.get(contentID).getContentType();
    }

    @Override
    public CourseViewData getCourse(int contentID)
    {
        if(content.containsKey(contentID))
        {
            CourseModifyData course = (CourseModifyData) content.get(contentID);
            return new CourseViewData(contentID,
                    course,
                    Arrays.stream(course.sections)
                            .mapToObj(this::getSection)
                            .toArray(SectionViewData[]::new),
                    Arrays.stream(course.users)
                            .mapToObj(i->new UserLinkData(i,users.get(i).fullName))
                            .toArray(UserLinkData[]::new));
        }
        return null;
    }

    @Override
    public SectionViewData getSection(int contentID)
    {
        if(content.containsKey(contentID))
        {
            SectionModifyData section = (SectionModifyData) content.get(contentID);
            return new SectionViewData(contentID,
                    section,
                    Arrays.stream(section.contents)
                            .mapToObj(i->new ContentViewData(i,content.get(i)))
                            .toArray(ContentViewData[]::new));
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

    private int basicAdd(ContentModifyData data,int userID)
    {
        TeacherModifyData teacher = (TeacherModifyData) users.get(userID);
        content.put(contentAddIndex,data);
        teacher.availableContent = Arrays.copyOf(teacher.availableContent,
                teacher.availableContent.length+1);
        teacher.availableContent[teacher.availableContent.length-1] = contentAddIndex;
        users.replace(userID,teacher);
        return contentAddIndex++;
    }
    private int sectionAdd(SectionModifyData data,int userID)
    {
        TeacherModifyData teacher = (TeacherModifyData) users.get(userID);
        Set<Integer> current = Arrays.stream(teacher.availableContent).boxed().collect(Collectors.toSet());
        Set<Integer> sect = Arrays.stream(data.contents).boxed().collect(Collectors.toSet());
        current.addAll(sect);
        teacher.availableContent = current.stream().mapToInt(Integer::intValue).toArray();
        users.replace(userID,teacher);
        return basicAdd(data,userID);
    }
    private void processCourse(CourseModifyData course,int userID,int index)
    {
        Arrays.stream(course.users)
                .forEach(i -> {
                    ExtendedUserModifyData user = (ExtendedUserModifyData) users.get(i);
                    Set<Integer> courses = Arrays.stream(user.courses).boxed().collect(Collectors.toSet());
                    courses.add(index);
                    user.courses = courses.stream().mapToInt(Integer::intValue).toArray();
                    users.replace(i,user); });
        Arrays.stream(course.users)
                .filter(i->users.get(i).userType==UserType.Teacher)
                .forEach(i->{
                    TeacherModifyData teacher = (TeacherModifyData) users.get(i);
                    Set<Integer> current = Arrays.stream(teacher.availableContent)
                            .boxed()
                            .collect(Collectors.toSet());
                    Arrays.stream(course.sections)
                            .forEach(j->{
                                SectionModifyData sect = (SectionModifyData) content.get(j);
                                current.add(j);
                                current.addAll(Arrays.stream(sect.contents).boxed().toList());
                            });
                    teacher.availableContent=current.stream().mapToInt(Integer::intValue).toArray();
                    users.replace(i,teacher);
                });
    }
    @Override
    public int createContent(CourseModifyData course,int userID)
    {
        processCourse(course,userID,contentAddIndex);
        return basicAdd(course,userID);
    }

    @Override
    public int createContent(SectionModifyData section, int userID)
    {
        return sectionAdd(section,userID);
    }

    @Override
    public int createContent(MaterialModifyData material, int userID)
    {
        return basicAdd(material,userID);
    }

    @Override
    public int modifyContent(CourseModifyData course, int contentID)
    {
        if(content.containsKey(contentID))
        {
            processCourse(course,contentID,contentID);
            content.replace(contentID,course);
            return contentID;
        }
        return -1;
    }

    @Override
    public int modifyContent(SectionModifyData section, int contentID)
    {
        if(content.containsKey(contentID))
        {
            content.replace(contentID,section);
            return contentID;
        }
        return -1;
    }

    @Override
    public int modifyContent(MaterialModifyData material, int contentID)
    {

        if(content.containsKey(contentID))
        {
            content.replace(contentID,material);
            return contentID;
        }
        return -1;
    }

    @Override
    public ContentLinkData[] getCourses()
    {
        return content.entrySet()
                .stream()
                .filter(c->c.getValue().contentType==ContentType.Course)
                .map(c->new ContentLinkData(c.getValue().title,c.getKey()))
                .toArray(ContentLinkData[]::new);
    }

    @Override
    public ContentLinkData[] getAllContent()
    {
        return content.entrySet()
                .stream()
                .map(c-> new ContentLinkData(c.getValue().title,c.getKey()))
                .toArray(ContentLinkData[]::new);
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
            StudentModifyData student = (StudentModifyData) users.get(userID);
            return new StudentViewData(userID,
                    student,
                    Arrays.stream(student.courses)
                            .mapToObj(i->new ContentLinkData(content.get(i).title,i))
                            .toArray(ContentLinkData[]::new));
        }
        return null;
    }

    @Override
    public TeacherViewData getTeacher(int userID)
    {
        if(users.containsKey(userID))
        {
            TeacherModifyData teacher = (TeacherModifyData) users.get(userID);
            return new TeacherViewData(userID,
                    teacher,
                    Arrays.stream(teacher.courses)
                            .mapToObj(i->new ContentLinkData(content.get(i).title,i))
                            .toArray(ContentLinkData[]::new),
                    Arrays.stream(teacher.availableContent)
                            .mapToObj(i->new ContentLinkData(content.get(i).title,i))
                            .toArray(ContentLinkData[]::new));
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
    public int createUser(StudentModifyData student)
    {
        users.put(userAddIndex,student);
        return userAddIndex++;
    }

    @Override
    public int createUser(TeacherModifyData teacher)
    {
        users.put(userAddIndex,teacher);
        return userAddIndex++;
    }

    @Override
    public int createUser(AdminModifyData admin)
    {
        users.put(userAddIndex,admin);
        return userAddIndex++;
    }

    @Override
    public int modifyUser(StudentModifyData student, int userID)
    {
        if(users.containsKey(userID))
        {
            users.replace(userID,student);
            return userID;
        }
        return -1;
    }

    @Override
    public int modifyUser(TeacherModifyData teacher, int userID)
    {
        if(users.containsKey(userID))
        {
            users.replace(userID,teacher);
            return userID;
        }
        return -1;
    }

    @Override
    public int modifyUser(AdminModifyData admin, int userID)
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

    @Override
    public ContentLinkData[] getAvailableSectionContent(int userID)
    {
        if(users.containsKey(userID))
        {
            UserModifyData user = users.get(userID);
            return (user instanceof TeacherModifyData teacher
                    ? Arrays.stream(teacher.availableContent).boxed()
                    : content.keySet().stream())
                    .filter(i->getContentType(i)==ContentType.Material)
                    .map(i->new ContentLinkData(content.get(i).title,i))
                    .toArray(ContentLinkData[]::new);
        }
        return null;
    }

    @Override
    public ContentLinkData[] getAvailableSections(int userID)
    {
        return Arrays.stream(
                ((TeacherModifyData) users.get(userID)).availableContent)
                .filter(i->content.get(i).contentType==ContentType.Section)
                .mapToObj(i->new ContentLinkData(content.get(i).title,i))
                .toArray(ContentLinkData[]::new);
    }

    @Override
    public UserLinkData[] getAvailableUsers(int userID)
    {
        return users.entrySet().stream()
                .filter(u->switch (u.getValue().userType)
                        {case Teacher,Student->true;
                            default -> false;})
                .map(u->new UserLinkData(u.getKey(),u.getValue().fullName))
                .toArray(UserLinkData[]::new);
    }
}
