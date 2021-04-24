package by.Girafic.core.userdata;

public class FullName
{
    public String name;
    public String surname;
    public String patronymic;
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
