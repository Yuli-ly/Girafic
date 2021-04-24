package by.Girafic.core.userdata;

public class FullName
{
    public String surname;

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

    public FullName(String surname, String name, String patronymic)
    {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public String name;
    public String patronymic;
}
