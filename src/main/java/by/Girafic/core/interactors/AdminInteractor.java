package by.Girafic.core.interactors;

import by.Girafic.core.userdata.AdminModifyData;
import by.Girafic.core.userdata.StudentModifyData;
import by.Girafic.core.userdata.TeacherModifyData;

public class AdminInteractor extends TeacherInteractor
{
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
