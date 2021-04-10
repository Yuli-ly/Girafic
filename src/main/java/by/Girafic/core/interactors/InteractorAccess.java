package by.Girafic.core.interactors;

import by.Girafic.core.commonds.LoginData;
import by.Girafic.core.database.ContentDataBase;
import by.Girafic.core.database.UserDataBase;
import by.Girafic.core.presenters.AdminPresenter;

public class InteractorAccess
{
    private ContentDataBase contentDataBase;
    private UserDataBase userDataBase;
    private AdminPresenter adminPresenter;

    public InteractorAccess(ContentDataBase contentDataBase, UserDataBase userDataBase, AdminPresenter adminPresenter)
    {
        this.contentDataBase = contentDataBase;
        this.userDataBase = userDataBase;
        this.adminPresenter = adminPresenter;
    }

    public StudentInteractor studentLogin(LoginData ld)
    {
        return null;
    }
    public TeacherInteractor teacherLogin(LoginData ld)
    {
        return null;
    }
    public AdminInteractor adminLogin(LoginData ld)
    {
        return new AdminInteractor(ld,contentDataBase,userDataBase,adminPresenter);
    }
}
