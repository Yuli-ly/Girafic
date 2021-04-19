package by.Girafic.core.commonds;

public class ModifyConfirmation<T>
{
    public ModifyConfirmation(T field, boolean success, String message)
    {
        this.field = field;
        this.success = success;
        this.message = message;
    }
    public static <T> ModifyConfirmation<T> successful(T field)
    {
        return new ModifyConfirmation<>(field,true,"success");
    }
    public static <T> ModifyConfirmation<T> fail(T field,String message)
    {
        return new ModifyConfirmation<>(field,false,message);
    }
    public T field;
    public boolean success;
    public String message;

    public T getField()
    {
        return field;
    }

    public boolean isSuccess()
    {
        return success;
    }

    public String getMessage()
    {
        return message;
    }

    @Override
    public String toString()
    {
        return "ModifyConfirmation{" +
                "field=" + field +
                ", success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
