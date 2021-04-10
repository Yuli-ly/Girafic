package by.Girafic.core.interactors;

import by.Girafic.core.commonds.LoginData;
import by.Girafic.core.database.ContentDataBase;
import by.Girafic.core.database.UserDataBase;
import by.Girafic.core.presenters.AdminPresenter;
import by.Girafic.core.userdata.AdminModifyData;
import by.Girafic.core.userdata.StudentModifyData;
import by.Girafic.core.userdata.TeacherModifyData;

public class AdminInteractor extends TeacherInteractor
{
    private LoginData loginData;
    private ContentDataBase contentDataBase;
    private UserDataBase userDataBase;
    private AdminPresenter adminPresenter;
    @Override
    public boolean getStartPage()
    {
        int userId = userDataBase.getUserID(loginData.login);
        adminPresenter.showProfile(userDataBase.getAdmin(userId),userId);
        return true;
    }

    public AdminInteractor(LoginData loginData, ContentDataBase contentDataBase, UserDataBase userDataBase, AdminPresenter adminPresenter)
    {
        this.loginData = loginData;
        this.contentDataBase = contentDataBase;
        this.userDataBase = userDataBase;
        this.adminPresenter = adminPresenter;
    }

    public boolean createStudent(StudentModifyData student)
    {
        return true;
    }

    public boolean modifyStudent(StudentModifyData student, int userID)
    {
        return true;
    }

    public boolean createTeacher(TeacherModifyData teacher)
    {
        return true;
    }

    public boolean modifyTeacher(TeacherModifyData teacher, int userID)
    {
        return true;
    }

    public boolean createAdmin(AdminModifyData admin)
    {
        return true;
    }

    public boolean modifyAdmin(AdminModifyData teacher, int userID)
    {
        return true;
    }

    public boolean removeUser(int userID)
    {
        return true;
    }
}
