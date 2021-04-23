package by.Girafic.core.interactors;

import by.Girafic.core.commonds.LoginData;
import by.Girafic.core.commonds.UserType;
import by.Girafic.core.contentdata.CourseModifyData;
import by.Girafic.core.contentdata.MaterialModifyData;
import by.Girafic.core.database.ContentDataBase;
import by.Girafic.core.database.UserDataBase;
import by.Girafic.core.presenters.AdminPresenter;
import by.Girafic.core.presenters.StudentBasicPresenter;
import by.Girafic.core.presenters.StudentPresenter;
import by.Girafic.core.presenters.TeacherPresenter;
import by.Girafic.core.userdata.*;

public class InteractorAccess
{
    private final ContentDataBase contentDataBase;
    private final UserDataBase userDataBase;
    private final DefaultInteractor defaultInteractor = new DefaultInteractor();
    private class DefaultInteractor
    {
        public void showContent(StudentBasicPresenter presenter, int contentID, String login)
        {
            if (contentDataBase.checkContentExistence(contentID))
            {
                switch (userDataBase.getUserType(userDataBase.getUserID(login)))
                {

                    case Student -> {
                        switch (contentDataBase.getContentType(contentID))
                        {
                            case Course -> presenter.showCourse(contentDataBase.getCourse(contentID),false);
                            case Section -> presenter.showSection(contentDataBase.getSection(contentID),false);
                            case Material -> presenter.showMaterial(contentDataBase.getMaterial(contentID),false);
                        }
                    }
                    case Teacher, Admin -> {
                        // должна быть проверка на доступность изменения конента для Преподователя и
                        // последующее разделение switch
                        switch (contentDataBase.getContentType(contentID))
                        {
                            case Course -> presenter.showCourse(contentDataBase.getCourse(contentID),true);
                            case Section -> presenter.showSection(contentDataBase.getSection(contentID),true);
                            case Material -> presenter.showMaterial(contentDataBase.getMaterial(contentID),true);
                        }
                    }
                }

            } else
                presenter.showError("No content " + contentID);
        }

        public void showProfile(StudentBasicPresenter presenter, int userID, String login)
        {
            int thisUserID = userDataBase.getUserID(login);
            if (userDataBase.checkUserExistence(userID))
            {
                switch (userDataBase.getUserType(userID))
                {

                    case Student -> presenter.showProfile(userDataBase.getStudent(userID), thisUserID);

                    case Teacher -> presenter.showProfile(userDataBase.getTeacher(userID), thisUserID);

                    case Admin -> presenter.showProfile(userDataBase.getAdmin(userID), thisUserID);
                }
            } else
                presenter.showError("No user " + userID);
        }
    }


    private class AdminInteractorImpl implements AdminInteractor
    {
        private final AdminPresenter presenter;
        private final LoginData ld;

        public AdminInteractorImpl(AdminPresenter presenter, LoginData ld)
        {
            this.presenter = presenter;
            this.ld = ld;
        }

        @Override
        public void getStartPage()
        {
            int thisUserID = userDataBase.getUserID(ld.login);
            presenter.showProfile(userDataBase.getAdmin(thisUserID),thisUserID);
        }

        @Override
        public void getMyCourses()
        {
        }

        @Override
        public void getContent(int contentID)
        {
            defaultInteractor.showContent(presenter,contentID, ld.login);
        }

        @Override
        public void getProfile(int userid)
        {
            defaultInteractor.showProfile(presenter,userid, ld.login);
        }

        @Override
        public void createStudent(StudentModifyData student)
        {
            // проверка каждого поля
            userDataBase.createStudent(student);
            presenter.showStudentAfterModify(new StudentViewModifyData(student));
        }

        @Override
        public void modifyStudent(StudentModifyData student, int userID)
        {
            //проверить все поля
            userDataBase.modifyStudent(student,userID);
            presenter.showStudentAfterModify(new StudentViewModifyData(student));
        }

        @Override
        public void createTeacher(TeacherModifyData teacher)
        {
            // проверка каждого поля
            userDataBase.createTeacher(teacher);
            presenter.showTeacherAfterModify(new TeacherViewModifyData(teacher));
        }

        @Override
        public void modifyTeacher(TeacherModifyData teacher, int userID)
        {
            //проверить все поля
            userDataBase.modifyTeacher(teacher,userID);
            presenter.showTeacherAfterModify(new TeacherViewModifyData(teacher));
        }

        @Override
        public void createAdmin(AdminModifyData admin)
        {
            // проверка каждого поля
            userDataBase.createAdmin(admin);
            presenter.showAdminAfterModify(new AdminViewModifyData(admin));
        }

        @Override
        public void modifyAdmin(AdminModifyData admin, int userID)
        {
            // проверить все поля
            userDataBase.modifyAdmin(admin,userID);
            presenter.showAdminAfterModify(new AdminViewModifyData(admin));
        }

        @Override
        public void removeUser(int userID)
        {
        }

        @Override
        public void showUserForModification(int userID)
        {
            final UserDataBase udb = InteractorAccess.this.userDataBase;
            switch (udb.getUserType(userID))
            {
                case Student ->presenter.showStudentAfterModify(new StudentViewModifyData(udb.getStudentForMod(userID)));
                case Teacher -> presenter.showTeacherAfterModify(new TeacherViewModifyData(udb.getTeacherForMod(userID)));
                case Admin -> presenter.showAdminAfterModify(new AdminViewModifyData(udb.getAdminForMod(userID)));
            }
        }

        @Override
        public void createCourse(CourseModifyData course)
        {
        }

        @Override
        public void createMaterial(MaterialModifyData material)
        {
        }

        @Override
        public void modifyMaterial(MaterialModifyData material, int contentID)
        {
        }

        @Override
        public void removeContent(int contentID)
        {
        }

        @Override
        public void addContentToSection(int sectionID, int contentID)
        {
        }

        @Override
        public void addSectionToCourse(int courseID, int contentID)
        {
        }

        @Override
        public void removeSectionFromCourse(int courseID, int sectionID)
        {
        }

        @Override
        public void removeContentFromSection(int sectionID, int contentID)
        {
        }

        @Override
        public void addUserToCourse(int courseID, int userID)
        {
        }

        @Override
        public void removeUserFromCourse(int courseID, int userID)
        {
        }
    }

    private class TeacherInteractorImpl implements TeacherInteractor
    {
        private final TeacherPresenter presenter;
        private final LoginData ld;

        public TeacherInteractorImpl(TeacherPresenter presenter, LoginData ld)
        {
            this.presenter = presenter;
            this.ld = ld;
        }

        @Override
        public void getStartPage()
        {
            int thisUserID = userDataBase.getUserID(ld.login);
            presenter.showProfile(userDataBase.getTeacher(thisUserID),thisUserID);
        }

        @Override
        public void getMyCourses()
        {
        }

        @Override
        public void getContent(int contentID)
        {
            defaultInteractor.showContent(presenter,contentID, ld.login);
        }

        @Override
        public void getProfile(int userid)
        {
            defaultInteractor.showProfile(presenter,userid,ld.login);
        }

        @Override
        public void createCourse(CourseModifyData course)
        {
        }

        @Override
        public void createMaterial(MaterialModifyData material)
        {
        }

        @Override
        public void modifyMaterial(MaterialModifyData material, int contentID)
        {
        }

        @Override
        public void removeContent(int contentID)
        {
        }

        @Override
        public void addContentToSection(int sectionID, int contentID)
        {
        }

        @Override
        public void addSectionToCourse(int courseID, int contentID)
        {
        }

        @Override
        public void removeSectionFromCourse(int courseID, int sectionID)
        {
        }

        @Override
        public void removeContentFromSection(int sectionID, int contentID)
        {
        }

        @Override
        public void addUserToCourse(int courseID, int userID)
        {
        }

        @Override
        public void removeUserFromCourse(int courseID, int userID)
        {
        }
    }

    private class StudentInteractorImpl implements StudentInteractor
    {
        private final StudentPresenter presenter;
        private final LoginData ld;

        public StudentInteractorImpl(StudentPresenter presenter, LoginData ld)
        {
            this.presenter = presenter;
            this.ld = ld;
        }

        @Override
        public void getStartPage()
        {
            int thisUserID = userDataBase.getUserID(ld.login);
            presenter.showProfile(userDataBase.getStudent(thisUserID),thisUserID);
        }

        @Override
        public void getMyCourses()
        {
        }

        @Override
        public void getContent(int contentID)
        {
            defaultInteractor.showContent(presenter,contentID, ld.login);
        }

        @Override
        public void getProfile(int userid)
        {
            defaultInteractor.showProfile(presenter,userid, ld.login);
        }
    }

    public InteractorAccess(ContentDataBase contentDataBase, UserDataBase userDataBase)
    {
        this.contentDataBase = contentDataBase;
        this.userDataBase = userDataBase;
    }
    public StudentInteractor studentLogin(LoginData ld,StudentPresenter presenter)
    {
        return new StudentInteractorImpl(presenter,ld);
    }
    public TeacherInteractor teacherLogin(LoginData ld,TeacherPresenter presenter)
    {
        return new TeacherInteractorImpl(presenter,ld);
    }
    public AdminInteractor adminLogin(LoginData ld,AdminPresenter presenter)
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
