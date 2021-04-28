package by.girafic.core.interactors;

import by.girafic.core.commonds.LoginData;
import by.girafic.core.contentdata.*;
import by.girafic.core.database.ContentDataBase;
import by.girafic.core.database.UserDataBase;
import by.girafic.core.userdata.*;
import by.girafic.webview.AdminView;
import by.girafic.webview.StudentView;
import by.girafic.webview.TeacherView;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
        public void createUser(StudentModifyData student) throws Exception
        {
            // проверка каждого поля
            final int id = userDataBase.createStudent(student);
            view.showUserAfterModify(new StudentViewModifyData(id,student));
        }

        @Override
        public void modifyUser(StudentModifyData student, int userID) throws Exception
        {
            //проверить все поля
            final int id = userDataBase.modifyStudent(student,userID);
            view.showUserAfterModify(new StudentViewModifyData(id,student));
        }

        @Override
        public void createUser(TeacherModifyData teacher) throws Exception
        {
            // проверка каждого поля
            final int id = userDataBase.createTeacher(teacher);
            view.showUserAfterModify(new TeacherViewModifyData(id,teacher));
        }

        @Override
        public void modifyUser(TeacherModifyData teacher, int userID) throws Exception
        {
            //проверить все поля
            final int id = userDataBase.modifyTeacher(teacher,userID);
            view.showUserAfterModify(new TeacherViewModifyData(id,teacher));
        }

        @Override
        public void createUser(AdminModifyData admin) throws Exception
        {
            // проверка каждого поля
            final int id = userDataBase.createAdmin(admin);
            view.showUserAfterModify(new AdminViewModifyData(id,admin));
        }

        @Override
        public void modifyUser(AdminModifyData admin, int userID) throws Exception
        {
            // проверить все поля
            final int id = userDataBase.modifyAdmin(admin,userID);
            view.showUserAfterModify(new AdminViewModifyData(id,admin));
        }

        @Override
        public void removeUser(int userID)
        {
            userDataBase.removeUser(userID);
        }

        @Override
        public void showUserForModification(int userID) throws Exception
        {
            final UserDataBase udb = InteractorAccess.this.userDataBase;
            switch (udb.getUserType(userID))
            {
                case Student ->view.showUserAfterModify(new StudentViewModifyData(userID,udb.getStudentForMod(userID)));
                case Teacher -> view.showUserAfterModify(new TeacherViewModifyData(userID,udb.getTeacherForMod(userID)));
                case Admin -> view.showUserAfterModify(new AdminViewModifyData(userID,udb.getAdminForMod(userID)));
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
            int userID = userDataBase.getUserID(ld.login);
            TeacherModifyData teacher = userDataBase.getTeacherForMod(userID);
            int contentID = contentDataBase.createMaterial(material);
            userDataBase.modifyTeacher(addContent(teacher,contentID),userID);
            view.showContentAfterModify(new MaterialViewModifyData(contentID,material));
        }
        private TeacherModifyData addContent(TeacherModifyData teacher,int id)
        {
            int[] oldContent = teacher.availableContent;
            int[] newContent = Arrays.copyOf(oldContent,oldContent.length+1);
            newContent[oldContent.length] = id;
            teacher.availableContent = newContent;
            return teacher;
        }
        @Override
        public void createContent(SectionModifyData section) throws Exception
        {
            final int userID = userDataBase.getUserID(ld.login);
            TeacherModifyData teacher = userDataBase.getTeacherForMod(userID);
            int contentID = contentDataBase.createSection(section);
            TeacherModifyData newTeacher = addContent(teacher,contentID);
            userDataBase.modifyTeacher(newTeacher,userID);

            view.showContentAfterModify(new SectionViewModifyData(section,contentID),
                    userDataBase.getAvailableSectionContent(userID));
        }

        @Override
        public void modifyContent(MaterialModifyData material, int contentID) throws Exception
        {
            contentDataBase.modifyMaterial(material, contentID);
            view.showContentAfterModify(new MaterialViewModifyData(contentID,material));
        }

        @Override
        public void modifyContent(SectionModifyData section, int contentID) throws Exception
        {
            contentDataBase.modifySection(section,contentID);
            view.showContentAfterModify(
                    new SectionViewModifyData(section,contentID),
                    userDataBase.getAvailableSectionContent(
                            userDataBase.getUserID(ld.login))
            );
        }

        @Override
        public void modifyContent(CourseModifyData material, int contentID) throws Exception
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

        @Override
        public void showMaterialForCreation() throws Exception
        {
            view.showMaterialForCreation();
        }

        @Override
        public void showSectionForCreation() throws Exception
        {
            view.showSectionForCreation(
                    userDataBase.getAvailableSectionContent(
                    userDataBase.getUserID(ld.login)));
        }

        @Override
        public void showCourseForCreation() throws Exception
        {
            view.showCourseForCreation(
                    userDataBase.getAvailableSections(
                    userDataBase.getUserID(ld.login)));
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
