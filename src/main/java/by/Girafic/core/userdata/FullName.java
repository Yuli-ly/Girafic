package by.Girafic.core.userdata;

public class FullName
{
    public String surname;

    @Override
    public String toString()
    {
        return "FullName{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                '}';
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
