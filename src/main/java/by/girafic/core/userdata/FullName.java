package by.girafic.core.userdata;

public class FullName
{
    public final String name;
    public final String surname;
    public final String patronymic;
    @Override
    public String toString()
    {
        return name + " " + surname + " " + patronymic;
    }

    public String getSurname()
    {
        return surname;
    }

    public String getName()
    {
        return name;
    }

    public String getPatronymic()
    {
        return patronymic;
    }

    public FullName(String name, String surname, String patronymic)
    {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }


}
