package by.Girafic.core.interactors;

import by.Girafic.core.commonds.LoginData;
import by.Girafic.core.commonds.UserType;
import by.Girafic.core.contentdata.CourseModifyData;
import by.Girafic.core.contentdata.MaterialModifyData;
import by.Girafic.core.database.ContentDataBase;
import by.Girafic.core.database.UserDataBase;
import by.Girafic.core.presenters.AdminPresenter;
import by.Girafic.core.presenters.StudentPresenter;
import by.Girafic.core.presenters.TeacherPresenter;
import by.Girafic.core.userdata.AdminModifyData;
import by.Girafic.core.userdata.StudentModifyData;
import by.Girafic.core.userdata.StudentViewData;
import by.Girafic.core.userdata.TeacherModifyData;


public class InteractorAccess
{
    private final ContentDataBase contentDataBase;
    private final UserDataBase userDataBase;

    private class AdminInteractorImpl implements AdminInteractor
    {
        private AdminPresenter presenter;
        private LoginData ld;

        public AdminInteractorImpl(AdminPresenter presenter, LoginData ld)
        {
            this.presenter = presenter;
            this.ld = ld;
        }

        @Override
        public boolean getStartPage()
        {
            final UserDataBase udb = InteractorAccess.this.userDataBase;
            int thisUserID = udb.getUserID(ld.login);
            presenter.showProfile(udb.getAdmin(thisUserID),thisUserID);
            return true;
        }

        @Override
        public boolean getMyCourses()
        {
            return false;
        }

        @Override
        public boolean getContent()
        {
            return false;
        }

        @Override
        public boolean getProfile(int userid)
        {
            return false;
        }

        @Override
        public boolean createStudent(StudentModifyData student)
        {
            return false;
        }

        @Override
        public boolean modifyStudent(StudentModifyData student, int userID)
        {
            return false;
        }

        @Override
        public boolean createTeacher(TeacherModifyData teacher)
        {
            return false;
        }

        @Override
        public boolean modifyTeacher(TeacherModifyData teacher, int userID)
        {
            return false;
        }

        @Override
        public boolean createAdmin(AdminModifyData admin)
        {
            return false;
        }

        @Override
        public boolean modifyAdmin(AdminModifyData teacher, int userID)
        {
            return false;
        }

        @Override
        public boolean removeUser(int userID)
        {
            return false;
        }

        @Override
        public boolean createCourse(CourseModifyData course)
        {
            return false;
        }

        @Override
        public boolean createMaterial(MaterialModifyData material)
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
        public boolean addContentToSection(int sectionID, int contentID)
        {
            return false;
        }

        @Override
        public boolean addSectionToCourse(int courseID, int contentID)
        {
            return false;
        }

        @Override
        public boolean removeSectionFromCourse(int courseID, int sectionID)
        {
            return false;
        }

        @Override
        public boolean removeContentFromSection(int sectionID, int contentID)
        {
            return false;
        }

        @Override
        public boolean addUserToCourse(int courseID, int userID)
        {
            return false;
        }

        @Override
        public boolean removeUserFromCourse(int courseID, int userID)
        {
            return false;
        }
    }

    private class TeacherInteractorImpl implements TeacherInteractor
    {
        private TeacherPresenter presenter;
        private LoginData ld;

        public TeacherInteractorImpl(TeacherPresenter presenter, LoginData ld)
        {
            this.presenter = presenter;
            this.ld = ld;
        }

        @Override
        public boolean getStartPage()
        {
            final UserDataBase udb = InteractorAccess.this.userDataBase;
            int thisUserID = udb.getUserID(ld.login);
            presenter.showProfile(udb.getTeacher(thisUserID),thisUserID);
            return true;
        }

        @Override
        public boolean getMyCourses()
        {
            return false;
        }

        @Override
        public boolean getContent()
        {
            return false;
        }

        @Override
        public boolean getProfile(int userid)
        {
            return false;
        }

        @Override
        public boolean createCourse(CourseModifyData course)
        {
            return false;
        }

        @Override
        public boolean createMaterial(MaterialModifyData material)
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
        public boolean addContentToSection(int sectionID, int contentID)
        {
            return false;
        }

        @Override
        public boolean addSectionToCourse(int courseID, int contentID)
        {
            return false;
        }

        @Override
        public boolean removeSectionFromCourse(int courseID, int sectionID)
        {
            return false;
        }

        @Override
        public boolean removeContentFromSection(int sectionID, int contentID)
        {
            return false;
        }

        @Override
        public boolean addUserToCourse(int courseID, int userID)
        {
            return false;
        }

        @Override
        public boolean removeUserFromCourse(int courseID, int userID)
        {
            return false;
        }
    }

    private class StudentInteractorImpl implements StudentInteractor
    {
        private StudentPresenter presenter;
        private LoginData ld;

        public StudentInteractorImpl(StudentPresenter presenter, LoginData ld)
        {
            this.presenter = presenter;
            this.ld = ld;
        }

        @Override
        public boolean getStartPage()
        {
            final UserDataBase udb = InteractorAccess.this.userDataBase;
            int thisUserID = udb.getUserID(ld.login);
            presenter.showProfile(udb.getStudent(thisUserID),thisUserID);
            return true;
        }

        @Override
        public boolean getMyCourses()
        {
            return false;
        }

        @Override
        public boolean getContent()
        {
            return false;
        }

        @Override
        public boolean getProfile(int userid)
        {
            final UserDataBase udb = InteractorAccess.this.userDataBase;
            int thisUserID = udb.getUserID(ld.login);
            switch (udb.getUserType(userid))
            {

                case Student -> presenter.showProfile(udb.getStudent(userid),thisUserID);

                case Teacher -> presenter.showProfile(udb.getTeacher(userid),thisUserID);

                case Admin -> presenter.showProfile(udb.getAdmin(userid),thisUserID);
            }
            return true;
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
        return userDataBase.checkExistence(ld);
    }
    public boolean checkExistence(int userID)
    {
        return userDataBase.checkExistence(userID);
    }
    public UserType getUserType(String login)
    {
        return userDataBase.getUserType(userDataBase.getUserID(login));
    }
}
