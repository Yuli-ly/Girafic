package by.girafic.core.commonds;

public class ModifyConfirmation<T>
{
    public ModifyConfirmation(T value, boolean success, String message)
    {
        this.value = value;
        this.success = success;
        this.message = message;
    }
    public static <T> ModifyConfirmation<T> successful(T value)
    {
        return new ModifyConfirmation<>(value,true,"success");
    }
    public static <T> ModifyConfirmation<T> fail(T field,String message)
    {
        return new ModifyConfirmation<>(field,false,message);
    }
    public final T value;
    public final boolean success;
    public final String message;

    public T getValue()
    {
        return value;
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
                "field=" + value +
                ", success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
