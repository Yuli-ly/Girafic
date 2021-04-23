package by.Girafic.core.interactors;

import by.Girafic.core.commonds.LoginData;
import by.Girafic.core.commonds.UserType;
import by.Girafic.core.contentdata.CourseModifyData;
import by.Girafic.core.contentdata.MaterialModifyData;
import by.Girafic.core.contentdata.SectionModifyData;
import by.Girafic.core.database.ContentDataBase;
import by.Girafic.core.database.UserDataBase;
import by.Girafic.core.userdata.*;
import by.Girafic.webview.AdminView;
import by.Girafic.webview.StudentView;
import by.Girafic.webview.TeacherView;
import jakarta.servlet.ServletException;

import java.io.IOException;

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
        public void getStartPage() throws ServletException, IOException
        {
            int thisUserID = userDataBase.getUserID(ld.login);
            view.showProfile(userDataBase.getAdmin(thisUserID),true);
        }

        @Override
        public void getContent(int contentID) throws ServletException, IOException
        {
            defaultInteractor.showContent(view,contentID, ld.login);
        }

        @Override
        public void getProfile(int userid) throws ServletException, IOException
        {
            defaultInteractor.showProfile(view,userid, ld.login);
        }

        @Override
        public void createUser(StudentModifyData student)
        {
            // проверка каждого поля
            userDataBase.createStudent(student);
            view.showUserAfterModify(new StudentViewModifyData(student));
        }

        @Override
        public void modifyUser(StudentModifyData student, int userID)
        {
            //проверить все поля
            userDataBase.modifyStudent(student,userID);
            view.showUserAfterModify(new StudentViewModifyData(student));
        }

        @Override
        public void createUser(TeacherModifyData teacher)
        {
            // проверка каждого поля
            userDataBase.createTeacher(teacher);
            view.showUserAfterModify(new TeacherViewModifyData(teacher));
        }

        @Override
        public void modifyUser(TeacherModifyData teacher, int userID)
        {
            //проверить все поля
            userDataBase.modifyTeacher(teacher,userID);
            view.showUserAfterModify(new TeacherViewModifyData(teacher));
        }

        @Override
        public void createUser(AdminModifyData admin) throws ServletException, IOException
        {
            // проверка каждого поля
            userDataBase.createAdmin(admin);
            view.showUserAfterModify(new AdminViewModifyData(admin));
        }

        @Override
        public void modifyUser(AdminModifyData admin, int userID) throws ServletException, IOException
        {
            // проверить все поля
            userDataBase.modifyAdmin(admin,userID);
            view.showUserAfterModify(new AdminViewModifyData(admin));
        }

        @Override
        public void removeUser(int userID)
        {
            userDataBase.removeUser(userID);
        }

        @Override
        public void showUserForModification(int userID) throws ServletException, IOException
        {
            final UserDataBase udb = InteractorAccess.this.userDataBase;
            switch (udb.getUserType(userID))
            {
                case Student ->view.showUserAfterModify(new StudentViewModifyData(udb.getStudentForMod(userID)));
                case Teacher -> view.showUserAfterModify(new TeacherViewModifyData(udb.getTeacherForMod(userID)));
                case Admin -> view.showUserAfterModify(new AdminViewModifyData(udb.getAdminForMod(userID)));
            }
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
        public void getStartPage() throws ServletException, IOException
        {
            int thisUserID = userDataBase.getUserID(ld.login);
            view.showProfile(userDataBase.getTeacher(thisUserID),false);
        }

        @Override
        public void createContent(CourseModifyData course) throws Exception
        {

        }

        @Override
        public void createContent(MaterialModifyData material) throws Exception
        {

        }

        @Override
        public void createContent(SectionModifyData section) throws Exception
        {

        }

        @Override
        public void modifyContent(MaterialModifyData material, int contentID) throws Exception
        {

        }

        @Override
        public void removeContent(int contentID) throws Exception
        {

        }

        @Override
        public void addContentToSection(int sectionID, int contentID) throws Exception
        {

        }

        @Override
        public void addSectionToCourse(int courseID, int contentID) throws Exception
        {

        }

        @Override
        public void removeSectionFromCourse(int courseID, int sectionID) throws Exception
        {

        }

        @Override
        public void removeContentFromSection(int sectionID, int contentID) throws Exception
        {

        }

        @Override
        public void addUserToCourse(int courseID, int userID) throws Exception
        {

        }

        @Override
        public void removeUserFromCourse(int courseID, int userID) throws Exception
        {

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
        public void getStartPage() throws ServletException, IOException
        {
            int thisUserID = userDataBase.getUserID(ld.login);
            view.showProfile(userDataBase.getStudent(thisUserID),false);
        }

        @Override
        public void getContent(int contentID) throws ServletException, IOException
        {
            defaultInteractor.showContent(view,contentID, ld.login);
        }

        @Override
        public void getProfile(int userid) throws ServletException, IOException
        {
            defaultInteractor.showProfile(view,userid, ld.login);
        }
    }

    public InteractorAccess(ContentDataBase contentDataBase, UserDataBase userDataBase)
    {
        this.contentDataBase = contentDataBase;
        this.userDataBase = userDataBase;
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
    public boolean checkExistence(LoginData ld)
    {
        return userDataBase.checkUserExistence(ld);
    }
    public boolean checkExistence(int userID)
    {
        return userDataBase.checkUserExistence(userID);
    }
    public UserType getUserType(String login)
    {
        return userDataBase.getUserType(userDataBase.getUserID(login));
    }
}
