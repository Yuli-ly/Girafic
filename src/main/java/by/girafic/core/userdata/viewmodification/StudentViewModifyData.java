package by.girafic.core.userdata.viewmodification;

import by.girafic.core.commonds.ModifyConfirmation;
import static by.girafic.core.commonds.ModifyConfirmation.successful;

import by.girafic.core.contentdata.ContentLinkData;
import by.girafic.core.userdata.modification.StudentModifyData;


public class StudentViewModifyData extends ExtendedUserViewModifyData
{
    public final ModifyConfirmation<Integer> course;
    public final ModifyConfirmation<Double> gpa;
    public final ModifyConfirmation<String> group;

    public StudentViewModifyData(int id,
                                 FullName fullName,
                                 ModifyConfirmation<String> login,
                                 ModifyConfirmation<String> password,
                                 ModifyConfirmation<String> mail,
                                 ModifyConfirmation<String> faculty,
                                 ContentLinkData[] courses,
                                 ModifyConfirmation<String> department,
                                 ModifyConfirmation<Integer> course,
                                 ModifyConfirmation<Double> gpa,
                                 ModifyConfirmation<String> group)
    {
        super(id, fullName, login, password, mail, faculty, courses, department);
        this.course = course;
        this.gpa = gpa;
        this.group = group;
    }

    public StudentViewModifyData(int id,
                                 StudentModifyData data,
                                 ContentLinkData[] courses)
    {
        super(id,data,courses);
        this.course = successful(data.course);
        this.gpa = successful(data.gpa);
        this.group = successful(data.group);
    }

    public ModifyConfirmation<Integer> getCourse()
    {
        return course;
    }

    public ModifyConfirmation<Double> getGpa()
    {
        return gpa;
    }

    public ModifyConfirmation<String> getGroup()
    {
        return group;
    }

}
