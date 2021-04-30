package by.girafic.core.userdata;

public record FullName(String name, String surname, String patronymic)
{
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


}
