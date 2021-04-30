package by.girafic.core.commonds;

public record ModifyConfirmation<T>(T value, boolean success, String message)
{

    public static <T> ModifyConfirmation<T> successful(T value)
    {
        return new ModifyConfirmation<>(value, true, "success");
    }

    public static <T> ModifyConfirmation<T> fail(T field, String message)
    {
        return new ModifyConfirmation<>(field, false, message);
    }

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

}
