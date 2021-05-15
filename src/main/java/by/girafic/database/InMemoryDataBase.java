package by.girafic.database;

import by.girafic.core.commonds.LoginData;
import by.girafic.core.contentdata.ContentLinkData;
import by.girafic.core.contentdata.ContentType;
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
import by.girafic.core.userdata.FullName;
import by.girafic.core.userdata.UserLinkData;
import by.girafic.core.userdata.UserType;
import by.girafic.core.userdata.modification.*;
import by.girafic.core.userdata.view.AdminViewData;
import by.girafic.core.userdata.view.StudentViewData;
import by.girafic.core.userdata.view.TeacherViewData;

import java.util.*;
import java.util.stream.Collectors;


public class InMemoryDataBase implements ContentDataBase, UserDataBase
{

    int userAddIndex = 1;
    int contentAddIndex;

    private record DataAccess(Map<Integer, UserModifyData> users, Map<Integer, ContentModifyData> content)
    {
    }

    private final DataAccess access = new DataAccess(new HashMap<>(), new HashMap<>());

    public InMemoryDataBase()
    {
        AdminModifyData admin = new AdminModifyData(UserType.Admin,
                new FullName("admin", "admin", "admin"),
                "admin",
                "admin",
                "admin@example.com",
                "RF&CT");
        access.users.put(userAddIndex++, admin);
        TeacherModifyData teacher = new TeacherModifyData(UserType.Teacher,
                new FullName("teacher", "teacher", "teacher"),
                "teacher",
                "teacher",
                "teacher@gmail.com",
                "RF&CT",
                "1",
                new int[]{3},
                "teacher",
                new int[]{1, 2, 3});
        access.users.put(userAddIndex++, teacher);
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
        access.users.put(userAddIndex++, student);

        MaterialModifyData material = new MaterialModifyData("Material 1", "First material", "bla-bla-bla");
        access.content.put(1, material);
        SectionModifyData section = new SectionModifyData("Section 1", "First section", new int[]{1});
        access.content.put(2, section);
        CourseModifyData course = new CourseModifyData("Course 1", "First course", new int[]{2}, new int[]{2, 3});
        access.content.put(3, course);
        contentAddIndex = 4;
    }

    @Override
    public ContentLinkData getLink(int contentID)
    {
        synchronized (access)
        {
            if (access.content.containsKey(contentID))
            {
                ContentModifyData d = access.content.get(contentID);
                return new ContentLinkData(d.title, contentID);
            }
            return null;
        }
    }

    @Override
    public ContentType getContentType(int contentID)
    {
        synchronized (access)
        {
            return access.content.get(contentID).getContentType();
        }
    }

    @Override
    public CourseViewData getCourse(int contentID)
    {
        synchronized (access)
        {
            if (access.content.containsKey(contentID))
            {
                CourseModifyData course = (CourseModifyData) access.content.get(contentID);
                return new CourseViewData(contentID,
                        course,
                        Arrays.stream(course.sections)
                                .mapToObj(this::getSection)
                                .toArray(SectionViewData[]::new),
                        Arrays.stream(course.users)
                                .mapToObj(i -> new UserLinkData(i, access.users.get(i).fullName))
                                .toArray(UserLinkData[]::new));
            }
            return null;
        }
    }

    @Override
    public SectionViewData getSection(int contentID)
    {
        synchronized (access)
        {
            if (access.content.containsKey(contentID))
            {
                SectionModifyData section = (SectionModifyData) access.content.get(contentID);
                return new SectionViewData(contentID,
                        section,
                        Arrays.stream(section.contents)
                                .mapToObj(i -> new ContentViewData(i, access.content.get(i)))
                                .toArray(ContentViewData[]::new));
            }
            return null;
        }
    }

    @Override
    public MaterialViewData getMaterial(int contentID)
    {
        synchronized (access)
        {
            if (access.content.containsKey(contentID))
            {
                return new MaterialViewData(contentID, (MaterialModifyData) access.content.get(contentID));
            }
            return null;
        }
    }

    private int basicAdd(ContentModifyData data, int userID)
    {
        synchronized (access)
        {
            TeacherModifyData teacher = (TeacherModifyData) access.users.get(userID);
            access.content.put(contentAddIndex, data);
            teacher.availableContent = Arrays.copyOf(teacher.availableContent,
                    teacher.availableContent.length + 1);
            teacher.availableContent[teacher.availableContent.length - 1] = contentAddIndex;
            access.users.replace(userID, teacher);
            return contentAddIndex++;
        }
    }

    private int sectionAdd(SectionModifyData data, int userID)
    {
        synchronized (access)
        {
            TeacherModifyData teacher = (TeacherModifyData) access.users.get(userID);
            Set<Integer> current = Arrays.stream(teacher.availableContent).boxed().collect(Collectors.toSet());
            Set<Integer> sect = Arrays.stream(data.contents).boxed().collect(Collectors.toSet());
            current.addAll(sect);
            teacher.availableContent = current.stream().mapToInt(Integer::intValue).toArray();
            access.users.replace(userID, teacher);
            return basicAdd(data, userID);
        }
    }

    private void processCourse(CourseModifyData course, int index)
    {
        synchronized (access)
        {
            Arrays.stream(course.users)
                    .forEach(i ->
                    {
                        ExtendedUserModifyData user = (ExtendedUserModifyData) access.users.get(i);
                        Set<Integer> courses = Arrays.stream(user.courses).boxed().collect(Collectors.toSet());
                        courses.add(index);
                        user.courses = courses.stream().mapToInt(Integer::intValue).toArray();
                        access.users.replace(i, user);
                    });
            Arrays.stream(course.users)
                    .filter(i -> access.users.get(i).userType == UserType.Teacher)
                    .forEach(i ->
                    {
                        TeacherModifyData teacher = (TeacherModifyData) access.users.get(i);
                        Set<Integer> current = Arrays.stream(teacher.availableContent)
                                .boxed()
                                .collect(Collectors.toSet());
                        Arrays.stream(course.sections)
                                .forEach(j ->
                                {
                                    SectionModifyData sect = (SectionModifyData) access.content.get(j);
                                    current.add(j);
                                    current.addAll(Arrays.stream(sect.contents).boxed().toList());
                                });
                        teacher.availableContent = current.stream().mapToInt(Integer::intValue).toArray();
                        access.users.replace(i, teacher);
                    });
        }
    }

    @Override
    public int createContent(CourseModifyData course, int userID)
    {
        synchronized (access)
        {
            processCourse(course, contentAddIndex);
            return basicAdd(course, userID);
        }
    }

    @Override
    public int createContent(SectionModifyData section, int userID)
    {
        synchronized (access)
        {
            return sectionAdd(section, userID);
        }
    }

    @Override
    public int createContent(MaterialModifyData material, int userID)
    {
        synchronized (access)
        {
            return basicAdd(material, userID);
        }
    }

    @Override
    public int modifyContent(CourseModifyData course, int contentID)
    {
        synchronized (access)
        {
            if (access.content.containsKey(contentID))
            {
                processCourse(course, contentID);
                access.content.replace(contentID, course);
                return contentID;
            }
            return -1;
        }
    }

    @Override
    public int modifyContent(SectionModifyData section, int contentID)
    {
        synchronized (access)
        {
            if (access.content.containsKey(contentID))
            {
                access.content.replace(contentID, section);
                return contentID;
            }
            return -1;
        }
    }

    @Override
    public int modifyContent(MaterialModifyData material, int contentID)
    {
        synchronized (access)
        {
            if (access.content.containsKey(contentID))
            {
                access.content.replace(contentID, material);
                return contentID;
            }
            return -1;
        }
    }

    @Override
    public ContentLinkData[] getCourses()
    {
        synchronized (access)
        {
            return access.content.entrySet()
                    .stream()
                    .filter(c -> c.getValue().contentType == ContentType.Course)
                    .map(c -> new ContentLinkData(c.getValue().title, c.getKey()))
                    .toArray(ContentLinkData[]::new);
        }
    }

    @Override
    public ContentLinkData[] getAllContent()
    {
        synchronized (access)
        {
            return access.content.entrySet()
                    .stream()
                    .map(c -> new ContentLinkData(c.getValue().title, c.getKey()))
                    .toArray(ContentLinkData[]::new);
        }
    }

    private void removeFromAv(int contentID)
    {
        synchronized (access)
        {
            access.users.keySet().stream()
                    .filter(i -> access.users.get(i).userType == UserType.Teacher)
                    .forEach(i ->
                            {
                                TeacherModifyData t = (TeacherModifyData) access.users.get(i);
                                t.availableContent =
                                        Arrays.stream(t.availableContent)
                                                .filter(j -> j != contentID).toArray();
                                access.users.replace(i, t);
                            }
                    );
            access.users.keySet().stream()
                    .filter(i ->
                    {
                        UserType type = access.users.get(i).userType;
                        return type == UserType.Teacher || type == UserType.Student;
                    })
                    .forEach(i ->
                            {
                                ExtendedUserModifyData e = (ExtendedUserModifyData) access.users.get(i);
                                e.courses =
                                        Arrays.stream(e.courses)
                                                .filter(j -> j != contentID).toArray();
                                access.users.replace(i, e);
                            }
                    );
        }
    }

    @Override
    public void removeContent(int contentID)
    {
        synchronized (access)
        {
            ContentModifyData cmd = access.content.get(contentID);
            switch (cmd.contentType)
            {

                case Course -> removeFromAv(contentID);
                case Section -> {
                    removeFromAv(contentID);
                    access.content.keySet().stream()
                            .filter(i -> access.content.get(i).contentType == ContentType.Course)
                            .forEach(i ->
                            {
                                CourseModifyData course = (CourseModifyData) access.content.get(i);
                                course.sections = Arrays.stream(course.sections)
                                        .filter(j -> j != contentID).toArray();
                                access.content.replace(i, course);
                            });
                }
                case Material -> {
                    removeFromAv(contentID);
                    access.content.keySet()
                            .stream()
                            .filter(i -> access.content.get(i).contentType == ContentType.Section)
                            .forEach(i ->
                            {
                                SectionModifyData sec = (SectionModifyData) access.content.get(i);
                                sec.contents = Arrays.stream(sec.contents)
                                        .filter(j -> j != contentID).toArray();
                                access.content.replace(i, sec);
                            });
                    access.content.remove(contentID);
                }
            }
        }
    }

    @Override
    public MaterialModifyData getMaterialForMod(int contentID)
    {
        synchronized (access)
        {
            return (MaterialModifyData) access.content.get(contentID);
        }
    }

    @Override
    public SectionModifyData getSectionForMod(int contentID)
    {
        synchronized (access)
        {
            return (SectionModifyData) access.content.get(contentID);
        }
    }

    @Override
    public CourseModifyData getCourseForMod(int contentID)
    {
        synchronized (access)
        {
            return (CourseModifyData) access.content.get(contentID);
        }
    }

    @Override
    public boolean checkUserExistence(LoginData ld)
    {
        synchronized (access)
        {
            for (Map.Entry<Integer, UserModifyData> user : access.users.entrySet())
            {
                if (user.getValue().login.equals(ld.login) && user.getValue().password.equals(ld.password))
                    return true;
            }
            return false;
        }
    }

    @Override
    public boolean checkUserExistence(int userID)
    {
        synchronized (access)
        {
            return access.users.containsKey(userID);
        }
    }

    @Override
    public boolean checkContentExistence(int contentID)
    {
        synchronized (access)
        {
            return access.content.containsKey(contentID);
        }
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
        synchronized (access)
        {
            for (Map.Entry<Integer, UserModifyData> user : access.users.entrySet())
            {
                if (user.getValue().login.equals(login))
                    return user.getKey();
            }
            return -1;
        }
    }

    @Override
    public UserType getUserType(int userID)
    {
        synchronized (access)
        {
            return access.users.get(userID).userType;
        }
    }

    @Override
    public StudentViewData getStudent(int userID)
    {
        synchronized (access)
        {
            if (access.users.containsKey(userID))
            {
                StudentModifyData student = (StudentModifyData) access.users.get(userID);
                return new StudentViewData(userID,
                        student,
                        Arrays.stream(student.courses)
                                .mapToObj(i -> new ContentLinkData(access.content.get(i).title, i))
                                .toArray(ContentLinkData[]::new));
            }
            return null;
        }
    }

    @Override
    public TeacherViewData getTeacher(int userID)
    {
        synchronized (access)
        {
            if (access.users.containsKey(userID))
            {
                TeacherModifyData teacher = (TeacherModifyData) access.users.get(userID);
                return new TeacherViewData(userID,
                        teacher,
                        Arrays.stream(teacher.courses)
                                .mapToObj(i -> new ContentLinkData(access.content.get(i).title, i))
                                .toArray(ContentLinkData[]::new),
                        Arrays.stream(teacher.availableContent)
                                .mapToObj(i -> new ContentLinkData(access.content.get(i).title, i))
                                .toArray(ContentLinkData[]::new));
            }
            return null;
        }
    }

    @Override
    public AdminViewData getAdmin(int userID)
    {
        synchronized (access)
        {
            if (access.users.containsKey(userID))
                return new AdminViewData(userID, (AdminModifyData) access.users.get(userID));
            return null;
        }
    }

    @Override
    public StudentModifyData getStudentForMod(int userID)
    {
        synchronized (access)
        {
            if (access.users.containsKey(userID))
                return (StudentModifyData) access.users.get(userID);
            return null;
        }
    }

    @Override
    public TeacherModifyData getTeacherForMod(int userID)
    {
        synchronized (access)
        {
            if (access.users.containsKey(userID))
                return (TeacherModifyData) access.users.get(userID);
            return null;
        }
    }

    @Override
    public AdminModifyData getAdminForMod(int userID)
    {
        synchronized (access)
        {
            if (access.users.containsKey(userID))
                return (AdminModifyData) access.users.get(userID);
            return null;
        }
    }

    private void addToCourses(ExtendedUserModifyData user, int userID)
    {
        synchronized (access)
        {
            Arrays.stream(user.courses).forEach(i ->
                    {
                        CourseModifyData course = (CourseModifyData) access.content.get(i);
                        Set<Integer> users = Arrays.stream(course.users).boxed().collect(Collectors.toSet());
                        users.add(userID);
                        course.users = users.stream().mapToInt(Integer::intValue).toArray();
                        access.content.replace(i, course);
                    }
            );
        }
    }

    @Override
    public int createUser(StudentModifyData student)
    {
        synchronized (access)
        {
            access.users.put(userAddIndex, student);
            addToCourses(student, userAddIndex);
            return userAddIndex++;
        }
    }

    @Override
    public int createUser(TeacherModifyData teacher)
    {
        access.users.put(userAddIndex, teacher);
        addToCourses(teacher, userAddIndex);
        return userAddIndex++;
    }

    @Override
    public int createUser(AdminModifyData admin)
    {
        synchronized (access)
        {
            access.users.put(userAddIndex, admin);
            return userAddIndex++;
        }
    }

    private void extendedUserMod(ExtendedUserModifyData user, int userID)
    {
        synchronized (access)
        {
            List<Integer> current = Arrays.stream(user.courses).boxed().toList();
            access.content.keySet().stream()
                    .filter(i -> access.content.get(i).contentType == ContentType.Course)
                    .filter(i ->
                            Arrays.stream(((CourseModifyData) access.content.get(i)).users)
                                    .boxed().toList().contains(userID))
                    .forEach(i ->
                    {
                        if (!current.contains(i))
                        {
                            CourseModifyData course = (CourseModifyData) access.content.get(i);
                            Set<Integer> set = Arrays.stream(course.users).boxed().collect(Collectors.toSet());
                            set.remove(userID);
                            course.users = set.stream().mapToInt(Integer::intValue).toArray();
                            access.content.replace(i, course);
                        }
                    });
            addToCourses(user, userID);
        }
    }

    @Override
    public int modifyUser(StudentModifyData student, int userID)
    {
        synchronized (access)
        {
            if (access.users.containsKey(userID))
            {
                extendedUserMod(student, userID);
                access.users.replace(userID, student);
                return userID;
            }
            return -1;
        }
    }

    @Override
    public int modifyUser(TeacherModifyData teacher, int userID)
    {
        synchronized (access)
        {
            if (access.users.containsKey(userID))
            {
                extendedUserMod(teacher, userID);
                access.users.replace(userID, teacher);
                return userID;
            }
            return -1;
        }
    }

    @Override
    public int modifyUser(AdminModifyData admin, int userID)
    {
        synchronized (access)
        {
            if (access.users.containsKey(userID))
            {
                access.users.replace(userID, admin);
                return userID;
            }
            return -1;
        }
    }

    @Override
    public void removeUser(int userID)
    {
        synchronized (access)
        {
            UserModifyData user = access.users.get(userID);
            switch (user.userType)
            {
                case Student, Teacher -> access.content.values()
                        .stream()
                        .filter(c -> c.contentType == ContentType.Course)
                        .forEach(c ->
                        {
                            CourseModifyData course = (CourseModifyData) c;
                            course.users = Arrays.stream(course.users)
                                    .filter(i -> i != userID).toArray();
                        });
                default -> {
                }
            }
            access.users.remove(userID);
        }
    }

    @Override
    public ContentLinkData[] getAvailableSectionContent(int userID)
    {
        synchronized (access)
        {
            if (access.users.containsKey(userID))
            {
                UserModifyData user = access.users.get(userID);
                return (user instanceof TeacherModifyData teacher
                        ? Arrays.stream(teacher.availableContent).boxed()
                        : access.content.keySet().stream())
                        .filter(i -> getContentType(i) == ContentType.Material)
                        .map(i -> new ContentLinkData(access.content.get(i).title, i))
                        .toArray(ContentLinkData[]::new);
            }
            return null;
        }
    }

    @Override
    public ContentLinkData[] getAvailableSections(int userID)
    {
        synchronized (access)
        {
            return Arrays.stream(
                    ((TeacherModifyData) access.users.get(userID)).availableContent)
                    .filter(i -> access.content.get(i).contentType == ContentType.Section)
                    .mapToObj(i -> new ContentLinkData(access.content.get(i).title, i))
                    .toArray(ContentLinkData[]::new);
        }
    }

    @Override
    public UserLinkData[] getAvailableUsers(int userID)
    {
        synchronized (access)
        {
            return access.users.entrySet().stream()
                    .filter(u -> switch (u.getValue().userType)
                            {
                                case Teacher, Student -> true;
                                default -> false;
                            })
                    .map(u -> new UserLinkData(u.getKey(), u.getValue().fullName))
                    .toArray(UserLinkData[]::new);
        }
    }

    @Override
    public UserLinkData[] getAllUsers()
    {
        synchronized (access)
        {
            return access.users.entrySet()
                    .stream()
                    .map(e -> new UserLinkData(e.getKey(), e.getValue().fullName))
                    .toArray(UserLinkData[]::new);
        }
    }
}
