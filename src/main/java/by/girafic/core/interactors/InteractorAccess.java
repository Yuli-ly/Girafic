package by.girafic.core.interactors;

import by.girafic.core.commonds.LoginData;
import by.girafic.core.contentdata.ContentLinkData;
import by.girafic.core.contentdata.ContentType;
import by.girafic.core.contentdata.modification.CourseModifyData;
import by.girafic.core.contentdata.viewmodification.CourseViewModifyData;
import by.girafic.core.contentdata.modification.MaterialModifyData;
import by.girafic.core.contentdata.viewmodification.MaterialViewModifyData;
import by.girafic.core.contentdata.modification.SectionModifyData;
import by.girafic.core.contentdata.viewmodification.SectionViewModifyData;
import by.girafic.core.database.ContentDataBase;
import by.girafic.core.database.UserDataBase;
import by.girafic.core.userdata.modification.AdminModifyData;
import by.girafic.core.userdata.viewmodification.AdminViewModifyData;
import by.girafic.core.userdata.modification.StudentModifyData;
import by.girafic.core.userdata.viewmodification.StudentViewModifyData;
import by.girafic.core.userdata.modification.TeacherModifyData;
import by.girafic.core.userdata.viewmodification.TeacherViewModifyData;
import by.girafic.core.userdata.UserType;
import by.girafic.webview.AdminView;
import by.girafic.webview.StudentView;
import by.girafic.webview.TeacherView;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.Arrays;
public class InteractorAccess
{
    private final ContentDataBase contentDataBase;
    private final UserDataBase userDataBase;
    private final DefaultInteractor defaultInteractor = new DefaultInteractor();
    private class DefaultInteractor
    {
        public void showContent(StudentView view, int contentID, String login) throws ServletException, IOException
        {
            if (contentDataBase.checkContentExistence(contentID))
            {
                switch (userDataBase.getUserType(userDataBase.getUserID(login)))
                {

                    case Student -> {
                        switch (contentDataBase.getContentType(contentID))
                        {
                            case Course -> view.showContent(contentDataBase.getCourse(contentID),false);
                            case Section -> view.showContent(contentDataBase.getSection(contentID),false);
                            case Material -> view.showContent(contentDataBase.getMaterial(contentID),false);
                        }
                    }
                    case Teacher, Admin -> {
                        // должна быть проверка на доступность изменения конента для Преподователя и
                        // последующее разделение switch
                        switch (contentDataBase.getContentType(contentID))
                        {
                            case Course -> view.showContent(contentDataBase.getCourse(contentID),true);
                            case Section -> view.showContent(contentDataBase.getSection(contentID),true);
                            case Material -> view.showContent(contentDataBase.getMaterial(contentID),true);
                        }
                    }
                }

            } else
                view.showError("No content " + contentID);
        }

        public void showProfile(StudentView view, int userID, String login) throws ServletException, IOException
        {
            int thisUserID = userDataBase.getUserID(login);
            if (userDataBase.checkUserExistence(userID))
            {
                switch (userDataBase.getUserType(userID))
                {
                    case Student -> view.showProfile(userDataBase.getStudent(userID), thisUserID==userID);
                    case Teacher -> view.showProfile(userDataBase.getTeacher(userID), thisUserID==userID);
                    case Admin -> view.showProfile(userDataBase.getAdmin(userID), thisUserID==userID);
                }
            } else
                view.showError("No user " + userID);
        }
    }

    private class AdminInteractorImpl extends TeacherInteractorImpl implements AdminInteractor
    {
        private final AdminView view;

        public AdminInteractorImpl(AdminView view, LoginData ld)
        {
            super(view,ld);
            this.view = view;
        }

        @Override
        public void getStartPage() throws Exception
        {
            view.showStartPage(
                    userDataBase.getAdmin(userDataBase.getUserID(ld.login())),
                    userDataBase.getAllUsers());
        }

        @Override
        public void getContent(int contentID) throws ServletException, IOException
        {
            defaultInteractor.showContent(view,contentID, ld.login());
        }

        @Override
        public void getProfile(int userid) throws ServletException, IOException
        {
            defaultInteractor.showProfile(view,userid, ld.login());
        }

        private ContentLinkData[] getLinks(int[] content)
        {
            return Arrays.stream(content)
                    .mapToObj(contentDataBase::getLink)
                    .toArray(ContentLinkData[]::new);
        }
        @Override
        public void createUser(StudentModifyData student) throws Exception
        {
            // проверка каждого поля
            final int id = userDataBase.createUser(student);
            view.showUserAfterModify(new StudentViewModifyData(id,
                    student,
                    getLinks(student.courses)),
                    contentDataBase.getCourses());
        }

        @Override
        public void modifyUser(StudentModifyData student, int userID) throws Exception
        {
            //проверить все поля
            final int id = userDataBase.modifyUser(student,userID);
            view.showUserAfterModify(new StudentViewModifyData(id,
                    student,
                    getLinks(student.courses)),
                    contentDataBase.getCourses());
        }
        @Override
        public void createUser(TeacherModifyData teacher) throws Exception
        {
            // проверка каждого поля
            teacher.availableContent = teacher.courses;
            teacher.courses = Arrays.stream(teacher.availableContent)
                    .filter(i->contentDataBase.getContentType(i)== ContentType.Course)
                    .toArray();
            final int id = userDataBase.createUser(teacher);
            view.showUserAfterModify(new TeacherViewModifyData(id,
                    teacher,
                    getLinks(teacher.courses),
                    getLinks(teacher.availableContent)),
                    contentDataBase.getAllContent());
        }

        @Override
        public void modifyUser(TeacherModifyData teacher, int userID) throws Exception
        {
            //проверить все поля
            teacher.availableContent = teacher.courses;
            teacher.courses = Arrays.stream(teacher.availableContent)
                    .filter(i->contentDataBase.getContentType(i)== ContentType.Course)
                    .toArray();
            final int id = userDataBase.modifyUser(teacher,userID);
            view.showUserAfterModify(new TeacherViewModifyData(id,
                    teacher,
                    getLinks(teacher.courses),
                    getLinks(teacher.availableContent)),
                    contentDataBase.getAllContent());
        }

        @Override
        public void createUser(AdminModifyData admin) throws Exception
        {
            // проверка каждого поля
            final int id = userDataBase.createUser(admin);
            view.showUserAfterModify(new AdminViewModifyData(id,admin));
        }

        @Override
        public void modifyUser(AdminModifyData admin, int userID) throws Exception
        {
            // проверить все поля
            final int id = userDataBase.modifyUser(admin,userID);
            view.showUserAfterModify(new AdminViewModifyData(id,admin));
        }

        @Override
        public void removeUser(int userID) throws Exception
        {
            userDataBase.removeUser(userID);
            getStartPage();
        }

        @Override
        public void showUserForModification(int userID) throws Exception
        {
            final UserDataBase udb = InteractorAccess.this.userDataBase;
            switch (udb.getUserType(userID))
            {
                case Student ->
                        {
                            StudentModifyData student = udb.getStudentForMod(userID);
                            view.showUserAfterModify(
                                    new StudentViewModifyData(userID,
                                            student,
                                            getLinks(student.courses)),
                                    contentDataBase.getCourses());
                        }
                case Teacher ->
                        {
                            TeacherModifyData teacher = udb.getTeacherForMod(userID);
                            view.showUserAfterModify(new TeacherViewModifyData(userID,
                                    teacher,
                                    getLinks(teacher.courses),
                                    getLinks(teacher.availableContent)),
                                    contentDataBase.getAllContent());
                        }
                case Admin ->
                            view.showUserAfterModify(new AdminViewModifyData(userID,udb.getAdminForMod(userID)));
            }
        }

        @Override
        public void showStudentForCreation() throws Exception
        {
            view.showStudentForCreation(contentDataBase.getCourses());
        }

        @Override
        public void showTeacherForCreation() throws Exception
        {
            view.showTeacherForCreation(contentDataBase.getAllContent());
        }

        @Override
        public void showAdminForCreation() throws Exception
        {
            view.showAdminForCreation();
        }

    }

    private class TeacherInteractorImpl extends StudentInteractorImpl implements TeacherInteractor
    {
        private final TeacherView view;

        public TeacherInteractorImpl(TeacherView view, LoginData ld)
        {
            super(view,ld);
            this.view = view;
        }

        @Override
        public void getStartPage() throws Exception
        {
            view.showStartPage(userDataBase.getTeacher(userDataBase.getUserID(ld.login())));
        }

        @Override
        final public void createContent(CourseModifyData course) throws Exception
        {
            int userID = userDataBase.getUserID(ld.login());
            int contentID = contentDataBase.createContent(course,userID);
            view.showContentAfterModify(
                    new CourseViewModifyData(contentID, course),
                    userDataBase.getAvailableSections(userID),
                    userDataBase.getAvailableUsers(userID));
        }

        @Override
        final public void createContent(MaterialModifyData material) throws Exception
        {
            int userID = userDataBase.getUserID(ld.login());
            int contentID = contentDataBase.createContent(material,userID);
            view.showContentAfterModify(new MaterialViewModifyData(contentID,material));
        }
        @Override
        final public void createContent(SectionModifyData section) throws Exception
        {
            final int userID = userDataBase.getUserID(ld.login());
            int contentID = contentDataBase.createContent(section,userID);
            view.showContentAfterModify(new SectionViewModifyData(section,contentID),
                    userDataBase.getAvailableSectionContent(userID));
        }

        @Override
        final public void modifyContent(MaterialModifyData material, int contentID) throws Exception
        {
            contentDataBase.modifyContent(material, contentID);
            view.showContentAfterModify(new MaterialViewModifyData(contentID,material));
        }

        @Override
        final public void modifyContent(SectionModifyData section, int contentID) throws Exception
        {
            contentDataBase.modifyContent(section,contentID);
            view.showContentAfterModify(
                    new SectionViewModifyData(section,contentID),
                    userDataBase.getAvailableSectionContent(
                            userDataBase.getUserID(ld.login())));
        }

        @Override
        final public void modifyContent(CourseModifyData course, int contentID) throws Exception
        {
            contentDataBase.modifyContent(course,contentID);
            int userID = userDataBase.getUserID(ld.login());
            view.showContentAfterModify(
                    new CourseViewModifyData(contentID, course),
                    userDataBase.getAvailableSections(userID),
                    userDataBase.getAvailableUsers(userID));
        }

        @Override
        final public void removeContent(int contentID) throws Exception
        {
            contentDataBase.removeContent(contentID);
            getStartPage();
        }


        @Override
        final public void showMaterialForCreation() throws Exception
        {
            view.showMaterialForCreation();
        }

        @Override
        final public void showSectionForCreation() throws Exception
        {
            view.showSectionForCreation(
                    userDataBase.getAvailableSectionContent(
                    userDataBase.getUserID(ld.login())));
        }

        @Override
        final public void showCourseForCreation() throws Exception
        {
            int userID = userDataBase.getUserID(ld.login());
            view.showCourseForCreation(
                    userDataBase.getAvailableSections(userID),
                    userDataBase.getAvailableUsers(userID));
        }

        @Override
        final public void showContentForModification(int id) throws Exception
        {
            switch (contentDataBase.getContentType(id))
            {

                case Course -> {
                    int userID = userDataBase.getUserID(ld.login());
                    view.showContentAfterModify(
                            new CourseViewModifyData(id,contentDataBase.getCourseForMod(id)),
                            userDataBase.getAvailableSections(userID),
                            userDataBase.getAvailableUsers(userID));
                }
                case Section -> view.showContentAfterModify(
                        new SectionViewModifyData(contentDataBase.getSectionForMod(id),id),
                        userDataBase.getAvailableSectionContent(
                                userDataBase.getUserID(ld.login())));

                case Material -> view.showContentAfterModify(
                        new MaterialViewModifyData(id,contentDataBase.getMaterialForMod(id)));
            }
        }
    }

    private class StudentInteractorImpl implements StudentInteractor
    {
        private final StudentView view;
        protected final LoginData ld;

        public StudentInteractorImpl(StudentView view, LoginData ld)
        {
            this.view = view;
            this.ld = ld;
        }

        @Override
        public void getStartPage() throws Exception
        {
            view.showStartPage(
                    userDataBase.getStudent(userDataBase.getUserID(ld.login())));
        }

        @Override
        public void getContent(int contentID) throws ServletException, IOException
        {
            defaultInteractor.showContent(view,contentID, ld.login());
        }

        @Override
        public void getProfile(int userid) throws ServletException, IOException
        {
            defaultInteractor.showProfile(view,userid, ld.login());
        }
    }

    private InteractorAccess(ContentDataBase contentDataBase, UserDataBase userDataBase)
    {
        this.contentDataBase = contentDataBase;
        this.userDataBase = userDataBase;
    }
    private static InteractorAccess instance;
    public static InteractorAccess getInstance(ContentDataBase contentDataBase, UserDataBase userDataBase)
    {
        if(instance==null)
            instance = new InteractorAccess(contentDataBase, userDataBase);
        return instance;
    }
    public StudentInteractor studentLogin(LoginData ld,StudentView presenter)
    {
        return new StudentInteractorImpl(presenter,ld);
    }
    public TeacherInteractor teacherLogin(LoginData ld,TeacherView presenter)
    {
        return new TeacherInteractorImpl(presenter,ld);
    }
    public AdminInteractor adminLogin(LoginData ld,AdminView presenter)
    {
        return new AdminInteractorImpl(presenter,ld);
    }
    public boolean checkUserExistence(LoginData ld)
    {
        return userDataBase.checkUserExistence(ld);
    }
    public boolean checkUserExistence(int userID)
    {
        return userDataBase.checkUserExistence(userID);
    }
    public boolean checkContentExistence(int contentID)
    {
        return contentDataBase.checkContentExistence(contentID);
    }
    public UserType getUserType(String login)
    {
        return userDataBase.getUserType(userDataBase.getUserID(login));
    }
}
