package by.Girafic.core.interactors;

import by.Girafic.core.commonds.LoginData;
import by.Girafic.core.database.ContentDataBase;
import by.Girafic.core.database.UserDataBase;
import by.Girafic.core.presenters.StudentPresenter;

public interface StudentInteractor
{
    boolean getStartPage();
    boolean getMyCourses();
    boolean getContent();
    boolean getProfile(int userid);
}
